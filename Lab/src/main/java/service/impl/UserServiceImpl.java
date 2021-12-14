package service.impl;

import dao.DaoException;
import dao.UserDao;
import entity.User;
import service.ServiceException;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() throws ServiceException {
        try {
            return userDao.readAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User findById(Long id) throws ServiceException {
        try {
            return userDao.read(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void saveUser(User user) throws ServiceException {
        try {
            if (user.getId() != null) {
                userDao.update(user);
            } else {
                userDao.create(user);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User login(String login, String password) throws ServiceException {
        try {
            return userDao.findByLoginAndPassword(login, password);
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(List<Long> ids) throws ServiceException {
        try {
            for (Long id : ids) {
                userDao.delete(id);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
