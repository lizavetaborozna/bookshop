package controller;

import dto.BookDTO;
import dto.CardDTO;
import service.BookService;
import service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminBookAddServlet extends HttpServlet {
    private BookService bookService = BookServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/adminBookAdd.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameBook = req.getParameter("nameBook");
        HttpSession session = req.getSession();
        String author = req.getParameter("author");
        String genre = req.getParameter("genre");
        Double price = Double.parseDouble(req.getParameter("price"));
        String image = req.getParameter("image");
        BookDTO infoBook = BookDTO.newBuilder()
                .name(nameBook)
                .author(author)
                .genre(genre)
                .price(price)
                .imageName(image)
                .build();
        bookService.addBook(infoBook);
        resp.sendRedirect("/admin/add");
    }
}
