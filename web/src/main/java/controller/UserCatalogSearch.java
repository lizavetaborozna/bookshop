package controller;

import dto.BookDTO;
import service.BookService;
import service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserCatalogSearch extends HttpServlet {
    private BookService bookService = BookServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookDTO> listAllBooks = bookService.getBooks();
        req.setAttribute("listBooksSearch", listAllBooks);
        req.getRequestDispatcher("/WEB-INF/pages/userCatalogSearch.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        BookDTO bookName = bookService.getBooksSearch(req.getParameter("search"));
      //  session.setAttribute("listBooksSearch", bookName);
        doGet(req, resp);
    }
}