import di.ServiceCreationException;
import di.ServiceCreator;
import entity.User;
import pool.ConnectionPool;
import pool.ConnectionPoolException;
import service.ServiceException;
import service.UserService;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ConnectionPoolException {
        ConnectionPool pool = ConnectionPool.getInstance();
        pool.init("com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/hotel?useUnicode=true&serverTimezone=" + TimeZone.getDefault().getID(),
                "root",
                "6545",
                5,
                100,
                0);
        /*Connection c = pool.getConnection();
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.setConnection(c);
        List<User> users = userDao.readAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
        User user1 = userDao.read(3L);
        System.out.println(user1);
        System.out.println("ok read");
        user1 = new User();
        user1.setLogin("11111" + Math.random());
        user1.setPassword("00000");
        user1.setRole(Role.CLIENT);
        Long id = userDao.create(user1);
        System.out.println("ok create(), id = " + id);
        userDao.delete(5L);
        c.close();*/

        try (ServiceCreator sc = new ServiceCreator()) {
            UserService userService = sc.getUserService();
            List<User> users = userService.findAll();
            for (User user: users) {
                System.out.println(user);
            }
            System.out.println("OK findAll()");
        } catch (ServiceCreationException | ServiceException e){
            System.out.println("ERROR");
        }
    }
}
