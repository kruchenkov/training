package service;

import entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll() throws ServiceException;

    User findById(Long id) throws ServiceException;

    void saveUser(User user) throws ServiceException;

    User login(String login, String password) throws ServiceException;

    void delete(List<Long> ids) throws ServiceException;
}
