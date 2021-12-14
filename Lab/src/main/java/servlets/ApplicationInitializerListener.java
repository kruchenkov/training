package servlets;

import pool.ConnectionPool;
import pool.ConnectionPoolException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.TimeZone;

public class ApplicationInitializerListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionPool pool = ConnectionPool.getInstance();
            pool.init("com.mysql.cj.jdbc.Driver",
                    "jdbc:mysql://localhost:3306/hotel?useUnicode=true&serverTimezone=" + TimeZone.getDefault().getID(),
                    "root",
                    "6545",
                    5,
                    100,
                    0);
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ConnectionPool.getInstance().destroy();
    }
}
