package controllerBoroznaES;

import modelBoroznaES.UserRole;
import serviceBoroznaES.UserService;
import serviceBoroznaES.UserServiceImpl;
import validatorBoroznaES.UserNameValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AuthorizationServlet extends HttpServlet {
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/pages/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        session.removeAttribute("info");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        List<String> errors = new ArrayList<>();
        UserNameValidator.checkUserName(username, errors);
        if (!errors.isEmpty()) {
            session.setAttribute("info", errors);
            resp.sendRedirect("/");
        }
        else if (userService.isUserValid(username, password)) {
            String role = userService.getUserRole(username);
            switch (role) {
                case UserRole.ADMIN:
                    session.setAttribute("user", username);
                    session.setAttribute("role", role);
                    resp.sendRedirect("/admin");
                    break;
                case UserRole.USER:
                    session.setAttribute("user", username);
                    session.setAttribute("role", role);
                    resp.sendRedirect("/user");
                    break;
                default:
                    resp.sendRedirect("/");
            }
        }   else{
            session.setAttribute("info", "Неверный ввод. Попробуйте зарегистрироваться!");
            resp.sendRedirect("/");
        }
    }
}
