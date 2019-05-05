package controller;

import service.UserService;
import service.UserServiceImpl;
import validator.UserNameValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationServlet extends HttpServlet {
    private UserService userService = UserServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/registration.jsp").forward(req, resp);
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
            resp.sendRedirect("/registration");
        }
        else if (userService.addUser(username, password)) {
            session.setAttribute("info","Вы зарегистрированы");
            resp.sendRedirect("/");
        }   else{
            session.setAttribute("info", "Такой пользователь уже существует!");
            resp.sendRedirect("/registration");
        }
    }
}

