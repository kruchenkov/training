package servlets;

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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Role role = null;
        if (login != null && password != null) {
            try (ServiceCreator sc = new ServiceCreator()) {
                UserService userService = sc.getUserService();
                User user = userService.login(login, password);
                if (user != null) {
                    HttpSession session = req.getSession();
                    session.setAttribute("session_user", user);
                    resp.sendRedirect(req.getContextPath() + "/index.jsp");
                    return;
                }
            } catch (ServiceCreationException | ServiceException e) {
                throw new ServletException(e);
            }
        }
        resp.sendRedirect(req.getContextPath() + "/login.jsp?message=" + URLEncoder.encode("Логин или пароль не опознаны ", "UTF-8"));
    }
}
