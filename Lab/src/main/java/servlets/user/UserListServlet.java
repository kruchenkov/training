package servlets.user;

import di.ServiceCreationException;
import di.ServiceCreator;
import entity.User;
import service.ServiceException;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (ServiceCreator sc = new ServiceCreator()) {
            UserService userService = sc.getUserService();
            List<User> users = userService.findAll();
            req.setAttribute("users", users);
            req.getRequestDispatcher("/WEB-INF/jsp/user/list.jsp").forward(req, resp);
        } catch (ServiceCreationException | ServiceException e) {
            throw new ServletException(e);
        }
    }
}
