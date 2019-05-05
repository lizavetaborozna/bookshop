package controllerBoroznaES;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import dtoBoroznaES.OrderDTO;
import serviceBoroznaES.OrderService;
import serviceBoroznaES.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class AdminReportServlet extends HttpServlet {
    private OrderService orderService = OrderServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        report();
        req.getRequestDispatcher("/WEB-INF/pages/adminReport.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void report() {
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
        Anchor anchorTarget1 = new Anchor("MyBook.by ", FontFactory.getFont(FontFactory.COURIER, 24,
                Font.BOLD, new CMYKColor(0, 255, 0, 0)));
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

        Anchor anchorTarget = new Anchor("Report for administrator: ", FontFactory.getFont(FontFactory.COURIER,
                20, Font.BOLD));
        anchorTarget.setName("Report");
        Paragraph paragraph1 = new Paragraph();

        paragraph1.setSpacingBefore(50);
        paragraph1.add(anchorTarget1);
        paragraph1.add(image2);

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
            document.add(new Paragraph("Revenue from COMPLETED orders is : " +
                    sums.toString().replace("[", "").replace("]", "") + " BYN",
                    FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD,
                            new CMYKColor(0, 255, 0, 0))));
            document.add(new Paragraph("Future revenue from WAITING orders is : "
                    + sums1.toString().replace("[", "").replace("]", "") + " BYN",
                    FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD,
                            new CMYKColor(0, 255, 0, 0))));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.close();
    }
}
