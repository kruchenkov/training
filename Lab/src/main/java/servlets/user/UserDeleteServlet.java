package servlets.user;

import javax.servlet.http.HttpServlet;

public class UserDeleteServlet extends HttpServlet {
    /*@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] idsStr = req.getParameterValues("id");
        List<Long> ids = new ArrayList<>(idsStr.length);
        try (ServiceCreator sc = new ServiceCreator()) {
            for (String id : idsStr){
                ids.add(Long.valueOf(id));
            }
            UserService userService = sc.getUserService();
            userService.delete(ids);
        } catch (ServiceCreationException | ServiceException | NumberFormatException e) {
            throw new ServletException(e);
        }
        resp.sendRedirect(req.getContextPath() + "/user/list.jsp");
    }*/
}
