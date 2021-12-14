package servlets.admin;

import di.ServiceCreationException;
import di.ServiceCreator;
import entity.Admin;
import service.AdminService;
import service.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (ServiceCreator sc = new ServiceCreator()) {
            AdminService adminService = sc.getAdminService();
            List<Admin> admins = adminService.findAll(); ;
            req.setAttribute("admins", admins);
            req.getRequestDispatcher("/WEB-INF/jsp/admin/list.jsp").forward(req, resp);
        } catch (ServiceCreationException | ServiceException e) {
            throw new ServletException(e);
        }
    }
}
