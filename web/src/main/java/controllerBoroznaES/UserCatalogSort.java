package controllerBoroznaES;

import dtoBoroznaES.BookDTO;
import serviceBoroznaES.BookService;
import serviceBoroznaES.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserCatalogSort extends HttpServlet {
    private BookService bookService = BookServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookDTO> listAllBooks = bookService.getBooksSort();
        req.setAttribute("listBooksSort", listAllBooks);
        req.getRequestDispatcher("/WEB-INF/pages/userCatalogSort.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
