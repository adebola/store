package io.factorialsystems.store.business.report;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import io.factorialsystems.store.business.sms.SMSSender;
import io.factorialsystems.store.config.ApplicationContextProvider;
import io.factorialsystems.store.domain.order.Order;
import io.factorialsystems.store.domain.order.OrderItem;
import io.factorialsystems.store.domain.user.User;
import io.factorialsystems.store.mapper.order.OrderMapper;
import io.factorialsystems.store.mapper.user.UserMapper;
import io.factorialsystems.store.util.NumberToWordConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;

@Slf4j
@RequiredArgsConstructor
public class InvoicePDF  {

    public String generateInvoice(int orderId, String tenantId, String logo_url, boolean sendSMS) {

        // Load Orders From Database
        OrderMapper orderMapper = ApplicationContextProvider.getBean(OrderMapper.class);
        Order order = orderMapper.findOrderById(orderId, tenantId);
        java.util.List<OrderItem> orderItems = order.getOrderItems();

        // Load User From Database
        UserMapper userMapper = ApplicationContextProvider.getBean(UserMapper.class);
        User user = userMapper.findById(order.getUser_id(), tenantId);

        if (order == null || user == null) {
            throw new RuntimeException(String.format("Unable to load Order %d or Corresponding User from the database while generating receipt", orderId));
        }

        try {
            PdfFont fontHelveticaBold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
            PdfFont fontHelevitca = PdfFontFactory.createFont(FontConstants.HELVETICA);
            PdfFont fontCourierBold = PdfFontFactory.createFont(FontConstants.COURIER_BOLD);
            PdfFont fontCourier = PdfFontFactory.createFont(FontConstants.COURIER);

            File tempFile = File.createTempFile("receipt-", ".pdf");
            log.info(String.format("Receipt Generated: %s", tempFile.getAbsolutePath()));

            PdfDocument pdfDocument = new PdfDocument(new PdfWriter(tempFile));

            Document document = new Document(pdfDocument, PageSize.A4);

            // Logo
            Image logo = new Image(ImageDataFactory.create(logo_url));
            logo.setFixedPosition(250, 750);
            document.add(logo);

            // Company Name
            Style titleStyle = new Style()
                    .setFont(fontHelveticaBold)
                    .setFontSize(16);

            Paragraph p = new Paragraph("DeliFrost Caterers Nigeria Limited")
                    .addStyle(titleStyle)
                    .setFixedPosition(150,720, 500);
            document.add(p);

            // Sales Invoice
            Style smallTitleStyle = new Style()
                    .setFont(fontHelveticaBold)
                    .setFontSize(14);

            p = new Paragraph("Sales Invoice")
                    .addStyle(smallTitleStyle)
                    .setFixedPosition(240,700, 200);
            document.add(p);

            // Deliver To
            Style boldNormal = new Style()
                    .setFont(fontHelveticaBold)
                    .setFontSize(12);

            p = new Paragraph("Deliver To,")
                    .addStyle(boldNormal)
                    .setFixedPosition(30, 670, 200);
            document.add(p);

            Style normal = new Style()
                    .setFont(fontHelevitca)
                    .setFontSize(10);

            // Customer Name
            p = new Paragraph("Customer Name:")
                    .addStyle(normal)
                    .setFixedPosition(30, 650, 100);
            document.add(p);

            p = new Paragraph(user.getFullName())
                    .addStyle(normal)
                    .setFixedPosition(120, 650, 400);
            document.add(p);

            // Customer Address
            p = new Paragraph("Customer Address:")
                    .addStyle(normal)
                    .setFixedPosition(30, 610, 120);
            document.add(p);

            int nLines = 1;

            if (order.getAddress() == null) {
                p = new Paragraph("")
                        .addStyle(normal)
                        .setFixedPosition(120, 610, 400);
            } else {
                nLines = countLines(order.getAddress());
                p = new Paragraph(order.getAddress())
                        .addStyle(normal)
                        .setFixedPosition(120, 610, 400);
            }

            document.add(p);

            // Generated PIN
            p = new Paragraph("PIN:")
                    .addStyle(normal)
                    .setFixedPosition(30, 590, 100);
            document.add(p);

            p = new Paragraph(order.getPin())
                    .addStyle(normal)
                    .setFixedPosition(120, 590, 100);
            document.add(p);

            // Invoice Number
            p = new Paragraph("Invoice No:")
                    .addStyle(normal)
                    .setFixedPosition(30, 550, 100);
            document.add(p);

            p = new Paragraph(String.format("%d",order.getId()))
                    .addStyle(normal)
                    .setFixedPosition(120, 550, 100);
            document.add(p);

            // Order Date
            p = new Paragraph("Order Date:")
                    .addStyle(normal)
                    .setFixedPosition(30, 530, 100);
            document.add(p);

            Format f = new SimpleDateFormat("dd, MMMM yyyy");

            p = new Paragraph(f.format(order.getOrderedAt()))
                    .addStyle(normal)
                    .setFixedPosition(120, 530, 100);
            document.add(p);

            // Invoice Date
            p = new Paragraph("Invoice Date:")
                    .addStyle(normal)
                    .setFixedPosition(30, 510, 100);
            document.add(p);

            p = new Paragraph(f.format(order.getOrderedAt()))
                    .addStyle(normal)
                    .setFixedPosition(120, 510, 100);
            document.add(p);

            // Invoice Date
            p = new Paragraph("Payment Status:")
                    .addStyle(normal)
                    .setFixedPosition(30, 490, 100);
            document.add(p);

            p = new Paragraph("Paid")
                    .addStyle(normal)
                    .setFixedPosition(120, 490, 100);
            document.add(p);

            // TIN
            p = new Paragraph("TIN No:")
                    .addStyle(normal)
                    .setFixedPosition(400, 650, 100);
            document.add(p);

            // E-Mail
            p = new Paragraph("E-Mail:")
                    .addStyle(normal)
                    .setFixedPosition(400, 610, 100);
            document.add(p);

            p = new Paragraph(user.getEmail())
                    .addStyle(normal)
                    .setFixedPosition(450, 610, 300);
            document.add(p);

            // Telephone
            p = new Paragraph("Phone No:")
                    .addStyle(normal)
                    .setFixedPosition(400, 590, 100);
            document.add(p);

            p = new Paragraph(user.getTelephone())
                    .addStyle(normal)
                    .setFixedPosition(450, 590, 100);
            document.add(p);

            // Location
            p = new Paragraph("Location:")
                    .addStyle(normal)
                    .setFixedPosition(400, 550, 100);
            document.add(p);

            p = new Paragraph("Lagos")
                    .addStyle(normal)
                    .setFixedPosition(450, 550, 100);
            document.add(p);

            // Phone No
            p = new Paragraph("Phone No:")
                    .addStyle(normal)
                    .setFixedPosition(400, 530, 100);
            document.add(p);

            p = new Paragraph("08163999999")
                    .addStyle(normal)
                    .setFixedPosition(450, 530, 100);
            document.add(p);

            // E-Mail
            p = new Paragraph("E-Mail:")
                    .addStyle(normal)
                    .setFixedPosition(400, 510, 100);
            document.add(p);

            p = new Paragraph("TIN No:")
                    .addStyle(normal)
                    .setFixedPosition(400, 490, 100);
            document.add(p);

            DecimalFormat decimalFormat = new DecimalFormat("#,###.00");

            Style tableStyle = new Style();
            tableStyle.setFont(fontCourier)
                    .setFontSize(10);

            int bottom = 440 - ((nLines - 1) * 25);
            int size = orderItems.size();

            bottom -= (size-1) * 25;
            bottom = bottom < 0 ? 10 : bottom;

            Table table = new Table(new float[8])
                    .addStyle(tableStyle)
                    .setFixedPosition(10, bottom, 550);

            log.info(String.format("Table Bottom is %d", bottom));

            // # Column
            Cell cell = new Cell(1, 1).add(new Paragraph("#"));
            cell.setTextAlignment(TextAlignment.CENTER);
            table.addCell(cell);

            // Item Column
            cell = new Cell(1, 1).add(new Paragraph("Item"));
            cell.setTextAlignment(TextAlignment.LEFT);
            table.addCell(cell);

            // Item Description
            cell = new Cell(1, 1).add(new Paragraph("Item Description"));
            cell.setTextAlignment(TextAlignment.LEFT);
            table.addCell(cell);

            // UoM
            cell = new Cell(1, 1).add(new Paragraph("UoM"));
            cell.setTextAlignment(TextAlignment.LEFT);
            table.addCell(cell);

            // Qty
            cell = new Cell(1, 1).add(new Paragraph("Qty"));
            cell.setTextAlignment(TextAlignment.LEFT);
            table.addCell(cell);

            // Unit Price
            cell = new Cell(1, 1).add(new Paragraph("Unit Price"));
            cell.setTextAlignment(TextAlignment.LEFT);
            table.addCell(cell);

            // VAT
            cell = new Cell(1, 1).add(new Paragraph("VAT"));
            cell.setTextAlignment(TextAlignment.LEFT);
            table.addCell(cell);

            // Amount
            cell = new Cell(1, 1).add(new Paragraph("Amount"));
            cell.setTextAlignment(TextAlignment.LEFT);
            table.addCell(cell);

            int i = 1;
            int qty = 0;

            double vat_price = 0.0;
            double amount_price = 0.0;

            for (OrderItem e : orderItems) {

                table.addCell(String.format("%d", i)).setTextAlignment(TextAlignment.CENTER);
                table.addCell(e.getItem_code()).setTextAlignment(TextAlignment.LEFT);
                table.addCell(e.getProduct_name()).setTextAlignment(TextAlignment.LEFT);
                table.addCell(e.getUom()).setTextAlignment(TextAlignment.LEFT);
                table.addCell(String.format("%d", e.getQuantity())).setTextAlignment(TextAlignment.CENTER);
                table.addCell(String.format("%s", decimalFormat.format(e.getTotal_price()))).setTextAlignment(TextAlignment.LEFT);

                String s = "";
                double d = e.getVat_price();

                if (d > 0) {
                    s = String.format("%s", decimalFormat.format(d));
                }

                table.addCell(s).setTextAlignment(TextAlignment.LEFT);
                table.addCell(String.format("%s", decimalFormat.format(e.getTotal_price() + d))).setTextAlignment(TextAlignment.LEFT);

                vat_price += e.getVat_price();
                amount_price += e.getTotal_price();

                qty += e.getQuantity();
                i++;
            }

            bottom -= 30;

            p = new Paragraph(String.format("Total Quantity  %s  Total NGN Excl VAT    %s", qty, decimalFormat.format(amount_price)))
                    .addStyle(normal)
                    .setFixedPosition(300, bottom, 400);
            document.add(p);

            bottom -= 20;

            p = new Paragraph(String.format("VAT Amount    %s", decimalFormat.format(vat_price)))
                    .addStyle(normal)
                    .setFixedPosition(420, bottom, 200);
            document.add(p);

            bottom -= 20;

            p = new Paragraph(String.format("Total NGN incl. VAT    %s", decimalFormat.format(order.getOrderAmount())))
                    .addStyle(normal)
                    .setFixedPosition(370, bottom, 200);
            document.add(p);


            p = new Paragraph("Amount Chargeable in words")
                    .addStyle(normal)
                    .setFixedPosition(10, bottom, 200);
            document.add(p);

            bottom -= 20;
            double amt = order.getOrderAmount();
            int nairaPart = (int) amt;
            String doubleAsString = String.valueOf(amt);
            int indexOfDecimal = doubleAsString.indexOf(".");
            int koboPart = Integer.parseInt(doubleAsString.substring(indexOfDecimal+1));

            String word;

            if (koboPart > 0) {
                word = String.format("%s Naira and %s Kobo Only", NumberToWordConverter.convert(nairaPart), NumberToWordConverter.convert(koboPart));
            } else {
                word = String.format("%s Naira Only", NumberToWordConverter.convert(nairaPart));
            }

            p = new Paragraph(word)
                    .addStyle(normal)
                    .setFixedPosition(10, bottom, 500);
            document.add(p);

            document.add(table);
            document.close();

            if (sendSMS && user.getTelephone() != null) {
                // Send SMS
                SMSSender smsSender = ApplicationContextProvider.getBean(SMSSender.class);
                smsSender.sendMessage(String.format("Dear %s Please note your order has been shipped kindly use PIN %s while receiving the order", user.getFullName(), order.getPin()), user.getTelephone());
            }

            return tempFile.getAbsolutePath();

        } catch (Exception ex) {
            log.info(String.format("Exception thrown: %s", ex.getMessage()));
            throw new RuntimeException(ex.getMessage());
        }
    }

    private static int countLines(String str) {
        String[] lines = str.split("\r\n|\r|\n");
        return  lines.length;
    }
}
