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
import java.sql.Date;

public class AdminSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String middleName = req.getParameter("middlename");
        Date date = Date.valueOf(req.getParameter("birth"));
        if (id != null && firstName != null && lastName != null && date != null) {
            Admin admin = new Admin();
            admin.setId(id);
            admin.setFirstName(firstName);
            admin.setLastName(lastName);
            admin.setMiddleName(middleName);
            admin.setDate(date);
            try (ServiceCreator sc = new ServiceCreator()) {
                AdminService adminService = sc.getAdminService();
                adminService.saveAdmin(admin);
            } catch (ServiceCreationException | ServiceException e) {
                throw new ServletException(e);
            }
        }
        resp.sendRedirect(req.getContextPath() + "/admin/list.jsp");
    }
}
