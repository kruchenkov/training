package pool;


import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentSkipListSet;

public final class ConnectionPool {
    private String jdbcUrl;
    private String user;
    private String password;
    private int maxSize;
    private int validationConnectionTimeout;


    private Queue<Connection> freeConnections = new ConcurrentLinkedDeque<>();
    private Set<Connection> usedConnections = new ConcurrentSkipListSet<>((c1, c2) -> Integer.compare(c1.hashCode(), c2.hashCode()));

    private ConnectionPool() {
    }

    public void init(String driverClass, String jdbcUrl, String user, String password, int minSize, int maxSize, int validationConnectionTimeout) throws ConnectionPoolException {
        try {
            destroy();
            Driver driver = (Driver) Class.forName(driverClass).getConstructor().newInstance();
            DriverManager.registerDriver(driver);
            this.jdbcUrl = jdbcUrl;
            this.user = user;
            this.password = password;
            this.maxSize = maxSize;
            this.validationConnectionTimeout = validationConnectionTimeout;
            for (int i = 0; i < minSize; i++) {
                freeConnections.add(newConnection());
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException | SQLException e) {
            throw new ConnectionPoolException(e);
        }
    }

    private static ConnectionPool instance = new ConnectionPool();

    public Connection getConnection() throws ConnectionPoolException {
        Connection connection = null;
        while (connection == null) {
            try {
                connection = freeConnections.poll();
                if (connection != null) {
                    if (!connection.isValid(validationConnectionTimeout)) ;
                    try {
                        connection.close();
                    } catch (SQLException e) {
                    }
                    connection = null;
                } else if (usedConnections.size() < maxSize) {
                    connection = newConnection();
                } else {

                }
            } catch (SQLException e) {
                throw new ConnectionPoolException(e);
            }
        }
        usedConnections.add(connection);
        return new ConnectionWrapper(connection);
    }

    void freeConnection(Connection connection) {
        try {
            connection.clearWarnings();
            usedConnections.remove(connection);
            freeConnections.add(connection);
        } catch (SQLException e) {
            try {
                connection.close();
            } catch (SQLException e1) {
            }
        }
    }

    public void destroy(){
        synchronized (freeConnections) {
            synchronized (usedConnections){
                usedConnections.addAll(freeConnections);
                freeConnections.clear();
                for (Connection connection : usedConnections){
                    try {
                        connection.close();
                    } catch (SQLException throwables) {
                    }
                }
                usedConnections.clear();
            }
        }
    }

    private Connection newConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, user, password);
    }

    public static ConnectionPool getInstance() {
        return instance;
    }
}

