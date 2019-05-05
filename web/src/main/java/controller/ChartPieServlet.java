package controller;

import dto.BookDTO;
import service.BookService;
import service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ChartPieServlet extends HttpServlet {
    private BookService bookService = BookServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookDTO> listAllBooks = bookService.getBooks();
        List<Double> sums = bookService.getSum(listAllBooks);
        List<String> categories = bookService.getCategory(listAllBooks);
        req.setAttribute("sums", sums);
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/WEB-INF/pages/adminChartPie.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
