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

public class UserEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            try (ServiceCreator sc = new ServiceCreator()) {
                UserService userService = sc.getUserService();
                User user = userService.findById(Long.parseLong(id));
                if (user != null) {
                    req.setAttribute("user", user);
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (ServiceCreationException | ServiceException e) {
                throw new ServletException(e);
            } catch (IllegalArgumentException e) {
                resp.sendError(404);
                return;
            }
        }
        req.setAttribute("roles", Role.values());
        req.getRequestDispatcher("/WEB-INF/jsp/user/edit.jsp").forward(req, resp);
    }
}
