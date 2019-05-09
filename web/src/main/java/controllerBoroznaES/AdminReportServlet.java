package controllerBoroznaES;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import dtoBoroznaES.OrderDTO;
import serviceBoroznaES.OrderService;
import serviceBoroznaES.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class AdminReportServlet extends HttpServlet {
    private OrderService orderService = OrderServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        try {
            report();
            List<OrderDTO> listAllOrders = orderService.getListAllOrder();
            List<Double> sums = orderService.getSum(listAllOrders);
            List<Double> sums1 = orderService.getSumWaiting(listAllOrders);
            session.setAttribute("sums", sums.toString().replace("[", "").replace("]", ""));
            session.setAttribute("sums1", sums1.toString().replace("[", "").replace("]", ""));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/pages/adminReport.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void report() throws IOException, DocumentException {
        List<OrderDTO> listAllOrders = orderService.getListAllOrder();
        List<Double> sums = orderService.getSum(listAllOrders);
        List<Double> sums1 = orderService.getSumWaiting(listAllOrders);
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("E:\\report.pdf"));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        document.open();
        BaseFont baseFont = BaseFont.createFont("C:\\Users\\Elizaveta Borozna\\Desktop\\book\\web\\src\\main\\webapp\\resources\\ARIALUNI.TTF", "cp1251", BaseFont.EMBEDDED);
        Font font = new Font(baseFont, Font.DEFAULTSIZE, Font.NORMAL);
        Anchor anchorTarget = new Anchor("Отчет для администратора: ", font);
        Anchor anchorTarget1 = new Anchor("MyBook.by ", FontFactory.getFont(FontFactory.COURIER, 24,
                Font.BOLD, new CMYKColor(0, 255, 0, 0)));
        anchorTarget.setName("Отчет");
        Image image2 = null;
        try {
            image2 = Image.getInstance("C:\\Users\\Elizaveta Borozna\\Desktop\\book\\web\\src\\" +
                    "main\\webapp\\resources\\images\\favicon.png");
            image2.setAlignment(Element.ALIGN_RIGHT);
        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        image2.scaleAbsolute(120f, 120f);
        Paragraph paragraph1 = new Paragraph();
        paragraph1.setSpacingBefore(50);
        paragraph1.add(anchorTarget1);
        paragraph1.add(image2);
        paragraph1.setSpacingAfter(50);

        Paragraph paragraph2 = new Paragraph();
        paragraph2.setSpacingAfter(50);
        paragraph2.add(anchorTarget);
        try {
            document.add(paragraph1);
            document.add(paragraph2);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        try {
            document.add(new Paragraph("Выручка с ВЫПОЛНЕНЫХ заказов составляет : " +
                    sums.toString().replace("[", "").replace("]", "") + " BYN",
                    font));
            document.add(new Paragraph("Будущая выручка с заказов со статусов ОЖИДАНИЯ : "
                    + sums1.toString().replace("[", "").replace("]", "") + " BYN",
                    font));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.close();
    }
}
