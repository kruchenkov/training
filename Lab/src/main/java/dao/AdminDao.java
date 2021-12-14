package dao;

import entity.Admin;

import java.util.List;

public interface AdminDao extends Dao<Admin> {

    List<Admin> findAll() throws DaoException;

    Admin findById(Long id) throws DaoException;
}
