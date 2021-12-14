package service.impl;

import dao.AdminDao;
import dao.DaoException;
import entity.Admin;
import service.AdminService;
import service.ServiceException;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao;

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public List<Admin> findAll() throws ServiceException {
        try {
            return adminDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void saveAdmin(Admin admin) throws ServiceException {
        try {
            if (admin.getId() != null) {
                adminDao.update(admin);
            } else {
                adminDao.create(admin);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
