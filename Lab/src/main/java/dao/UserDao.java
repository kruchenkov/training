package dao;

import entity.User;

import java.util.List;

public interface UserDao extends Dao<User> {

    List<User> readAll() throws DaoException;

    User findByLoginAndPassword(String login, String password) throws DaoException;
}
