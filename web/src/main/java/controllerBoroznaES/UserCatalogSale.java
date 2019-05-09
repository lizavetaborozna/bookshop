package controllerBoroznaES;

import converterBoroznaES.BookConverter;
import dtoBoroznaES.BookDTO;
import modelBoroznaES.Book;
import serviceBoroznaES.BookService;
import serviceBoroznaES.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserCatalogSale extends HttpServlet {
    private BookService bookService = BookServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookDTO> listAllBooks = bookService.getBooksSale();
        for (BookDTO book1 : listAllBooks) {
            Double cost = book1.getPrice();
            Double newcost = cost - cost * 0.1;
            book1.setPrice(newcost);
        }

        System.out.println(listAllBooks.toString());
        req.setAttribute("listBooksSale", listAllBooks);
        req.getRequestDispatcher("/WEB-INF/pages/userCatalogSale.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
