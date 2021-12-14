package servlets.user;

import di.ServiceCreationException;
import di.ServiceCreator;
import entity.Role;
import entity.User;
import service.ServiceException;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Role role = null;
        try {
            role = Role.valueOf(req.getParameter("role"));
        } catch (NullPointerException | IllegalArgumentException e){}
        if (login != null && password != null && role != null) {
            Long id = null;
            try {
                id = Long.parseLong(req.getParameter("id"));
            } catch (NumberFormatException e) {
            }
            User user = new User();
            user.setId(id);
            user.setLogin(login);
            user.setPassword(password);
            user.setRole(role);
            try (ServiceCreator sc = new ServiceCreator()) {
                UserService userService = sc.getUserService();
                userService.saveUser(user);
            } catch (ServiceCreationException | ServiceException e) {
                throw new ServletException(e);
            }
        }
        resp.sendRedirect(req.getContextPath() + "/user/list.jsp");
    }
}
