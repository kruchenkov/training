package dao.impl;

import dao.AdminDao;
import dao.DaoException;
import entity.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Admin> findAll() throws DaoException {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM admin";
            resultSet = statement.executeQuery(sql);
            List<Admin> admins = new ArrayList<>();
            while (resultSet.next()) {
                Admin admin = new Admin();
                admin.setId(resultSet.getLong("id"));
                admin.setFirstName(resultSet.getString("firstname"));
                admin.setLastName(resultSet.getString("lastname"));
                admin.setMiddleName(resultSet.getString("middlename"));
                admin.setDate(resultSet.getDate("birth"));
                admins.add(admin);
            }
            return admins;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public Admin findById(Long id) throws DaoException {
        return null;
    }

    @Override
    public Long create(Admin admin) throws DaoException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "INSERT INTO admin (id, firstname, lastname, middlename, birth) VALUES (?, ?, ?, ?, ?)";
        try {
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, admin.getId());
            statement.setString(2, admin.getFirstName());
            statement.setString(3, admin.getLastName());
            statement.setString(4, admin.getMiddleName());
            statement.setDate(5, admin.getDate());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            resultSet.next();
            return resultSet.getLong(1);
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public Admin read(Long id) throws DaoException {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM admin WHERE id = " + id;
            resultSet = statement.executeQuery(sql);
            Admin admin = null;
            if (resultSet.next()) {
                admin = new Admin();
                admin.setId(id);
                admin.setFirstName(resultSet.getString("firstname"));
                admin.setLastName(resultSet.getString("lastname"));
                admin.setMiddleName(resultSet.getString("middlename"));
                admin.setDate(resultSet.getDate("birth"));
            }
            return admin;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void update(Admin admin) throws DaoException {
        PreparedStatement statement = null;
        String sql = "UPDATE admin SET firstname = ?, lastname = ? , middlename = ?, birth = ? WHERE id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, admin.getFirstName());
            statement.setString(2, admin.getLastName());
            statement.setString(3, admin.getMiddleName());
            statement.setDate(4, admin.getDate());
            statement.setLong(5, admin.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void delete(Long id) throws DaoException {
        PreparedStatement statement = null;
        String sql = "DELETE FROM admin WHERE id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
            } catch (Exception e) {
            }
        }
    }
}
