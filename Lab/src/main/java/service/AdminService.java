package service;

import entity.Admin;
import java.util.List;

public interface AdminService {

    List<Admin> findAll() throws ServiceException;

    void saveAdmin(Admin admin) throws ServiceException;
}
