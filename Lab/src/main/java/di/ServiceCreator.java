package di;

import dao.AdminDao;
import dao.UserDao;
import dao.impl.AdminDaoImpl;
import dao.impl.UserDaoImpl;
import pool.ConnectionPool;
import pool.ConnectionPoolException;
import service.AdminService;
import service.UserService;
import service.impl.AdminServiceImpl;
import service.impl.UserServiceImpl;

import java.sql.Connection;

public class ServiceCreator implements AutoCloseable {
    //Кэшируем Service
    private UserService userService = null;
    private AdminService adminService = null;

    public UserService getUserService() throws ServiceCreationException {
        if (userService == null) {
            UserServiceImpl userServiceImpl = new UserServiceImpl();
            userServiceImpl.setUserDao(getUserDao());
            userService = userServiceImpl;
        }
        return userService;
    }

    //Локально кэшируем Dao внутри объекта serviceCreator
    private UserDao userDao = null;

    private UserDao getUserDao() throws ServiceCreationException {
        if (userDao == null) {
            UserDaoImpl userDaoImpl = new UserDaoImpl();
            userDaoImpl.setConnection(getConnection());
            userDao = userDaoImpl;
        }
        return userDao;
    }

    public AdminService getAdminService() throws ServiceCreationException {
        if (adminService == null) {
            AdminServiceImpl adminServiceImpl = new AdminServiceImpl();
            adminServiceImpl.setAdminDao(getAdminDao());
            adminService = adminServiceImpl;
        }
        return adminService;
    }

    private AdminDao adminDao = null;

    private AdminDao getAdminDao() throws ServiceCreationException {
        if (adminDao == null) {
            AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
            adminDaoImpl.setConnection(getConnection());
            adminDao = adminDaoImpl;
        }
        return adminDao;
    }

    //Локально кэшируем Connection внутри serviceCreator
    private Connection connection = null;

    private Connection getConnection() throws ServiceCreationException {
        if (connection == null) {
            try {
                connection = ConnectionPool.getInstance().getConnection();
            } catch (ConnectionPoolException e) {
                throw new ServiceCreationException(e);
            }
        }
        return connection;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (Exception e) {
        }
    }
}
