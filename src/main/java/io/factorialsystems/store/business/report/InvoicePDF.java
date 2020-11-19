package io.factorialsystems.store.business.report;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.TextAlignment;
import io.factorialsystems.store.config.ApplicationContextProvider;
import io.factorialsystems.store.domain.order.Order;
import io.factorialsystems.store.domain.order.OrderItem;
import io.factorialsystems.store.mapper.order.OrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;

@Slf4j
@RequiredArgsConstructor
public class InvoicePDF  {

    public String generateInvoice(int orderId, String tenantId) {

        // Load Orders From Database
        OrderMapper orderMapper = ApplicationContextProvider.getBean(OrderMapper.class);
        Order order = orderMapper.findOrderById(orderId, tenantId);

        if (order == null) {
            throw new RuntimeException(String.format("Unable to load Order %d from the database while generating receipt", orderId));
        }

        try {
            PdfFont fontHelveticaBold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
            PdfFont fontHelevitca = PdfFontFactory.createFont(FontConstants.HELVETICA);
            PdfFont fontCourierBold = PdfFontFactory.createFont(FontConstants.COURIER_BOLD);
            PdfFont fontCourier = PdfFontFactory.createFont(FontConstants.COURIER);

            File tempFile = File.createTempFile("invoice-", ".pdf");
            log.info(String.format("Receipt Generated: %s", tempFile.getAbsolutePath()));

            PdfDocument pdfDocument = new PdfDocument(new PdfWriter(tempFile));
            Document document = new Document(pdfDocument, PageSize.A4);

            // Logo
            Image logo = new Image(ImageDataFactory.create("https://delifrost-30582.web.app/assets/images/icon/logo-7.png"));
            // Image logo = new Image(ImageDataFactory.create("http://localhost:4200/assets/images/icon/logo-7.png"));
            logo.setFixedPosition(10, 695);
            document.add(logo);

            // Company Name
            Style titleStyle = new Style()
                    .setFont(fontHelveticaBold)
                    .setFontSize(18);

            Paragraph p = new Paragraph("DELIFROST NIGERIA")
                    .addStyle(titleStyle)
                    .setFixedPosition(100,720, 200);
            document.add(p);

            // Company Address

            p = new Paragraph("Delifrost Nigeria Ltd")
                    .setFont(fontHelevitca)
                    .setFixedPosition(400, 750, 200);
            document.add(p);

            p = new Paragraph("25 Adeola Odeku")
                    .setFont(fontHelevitca)
                    .setFixedPosition(400, 730, 200);
            document.add(p);

            p = new Paragraph("Victoria Island, Lagos")
                    .setFont(fontHelevitca)
                    .setFixedPosition(400, 710, 200);
            document.add(p);

            // Centre Receipt Before We Begin
            Style heading = new Style();
            heading.setFont(fontCourierBold)
                    .setFontSize(24);

            p = new Paragraph("RECEIPT")
                    .addStyle(heading)
                    .setFixedPosition(220,660, 200);
            document.add(p);

            LineSeparator lineSeparator = new LineSeparator(new SolidLine(1f))
                    .setFixedPosition(10, 660, 500);
            document.add(lineSeparator);

            Style narrativeStyle = new Style();
            narrativeStyle.setFont(fontHelevitca)
                    .setFontSize(12);

            p = new Paragraph(String.format("Order Number: %d", order.getId()))
                    .setFixedPosition(10, 640, 200)
                    .addStyle(narrativeStyle);
            document.add(p);

            Format f = new SimpleDateFormat("dd/MM/yy hh:mm");
            p = new Paragraph(String.format("Order Date: %s", f.format(order.getOrderedAt())))
                    .setFixedPosition(10, 620, 200)
                    .addStyle(narrativeStyle);
            document.add(p);

            DecimalFormat decimalFormat = new DecimalFormat("#,###.00");

            p = new Paragraph(String.format("Order Value: N%s", decimalFormat.format(order.getOrderAmount())))
                    .setFixedPosition(10, 600, 200)
                    .addStyle(narrativeStyle);
            document.add(p);

            p = new Paragraph(order.getFull_name())
                    .setFixedPosition(350, 640, 300)
                    .addStyle(narrativeStyle);
            document.add(p);

            p = new Paragraph(order.getAddress())
                    .setFixedPosition(350, 600, 500)
                    .addStyle(narrativeStyle);
            document.add(p);

            Style tableStyle = new Style();
            tableStyle.setFont(fontCourier)
                    .setFontSize(14);

            Table table = new Table(new float[5])
                    .addStyle(tableStyle)
                    .setFixedPosition(10, 520, 500);

            // # Column
            Cell cell = new Cell(1, 1).add(new Paragraph("#"));
            cell.setTextAlignment(TextAlignment.CENTER);
            cell.setBackgroundColor(new DeviceRgb(252, 140, 3));
            table.addCell(cell);

            // Item Column
            cell = new Cell(1, 1).add(new Paragraph("Item"));
            cell.setTextAlignment(TextAlignment.LEFT);
            cell.setBackgroundColor(new DeviceRgb(252, 140, 3));
            table.addCell(cell);

            // # Unit Cost Column
            cell = new Cell(1, 1).add(new Paragraph("Unit Cost"));
            cell.setTextAlignment(TextAlignment.LEFT);
            cell.setBackgroundColor(new DeviceRgb(252, 140, 3));
            table.addCell(cell);

            // # Qty Column
            cell = new Cell(1, 1).add(new Paragraph("Qty"));
            cell.setTextAlignment(TextAlignment.CENTER);
            cell.setBackgroundColor(new DeviceRgb(252, 140, 3));
            table.addCell(cell);

            // # Line Total Column
            cell = new Cell(1, 1).add(new Paragraph("Line Total"));
            cell.setTextAlignment(TextAlignment.LEFT);
            cell.setBackgroundColor(new DeviceRgb(252, 140, 3));
            table.addCell(cell);

            int i = 1;

            for (OrderItem e : order.getOrderItems()) {

                Cell c = new Cell(1,1).add(new Paragraph(String.format("%d", i)));
                c.setTextAlignment(TextAlignment.CENTER);
                table.addCell(c);

                table.addCell(e.getProduct_name());
                table.addCell(String.format("N%s", decimalFormat.format(e.getTotal_price() / e.getQuantity() )));

                c = new Cell(1,1).add(new Paragraph(String.format("%d", e.getQuantity())));
                c.setTextAlignment(TextAlignment.CENTER);
                table.addCell(c);

                table.addCell(String.format("N%s", decimalFormat.format(e.getTotal_price())));
                i++;
            }

            table.addCell("");
            table.addCell("");
            table.addCell("Total");
            table.addCell("");
            table.addCell(String.format("N%s", decimalFormat.format(order.getOrderAmount())));

            document.add(table);
            document.close();

            return tempFile.getAbsolutePath();

        } catch (Exception ex) {
            log.info(String.format("Exception thrown: %s", ex.getMessage()));
            throw new RuntimeException(ex.getMessage());
        }
    }
}
