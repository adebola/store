package io.factorialsystems.store.business.report;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Paragraph;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class InvoicePDF {

    public String generateInvoice() {

        try {
            File tempFile = File.createTempFile("invoice-", ".pdf");
            log.info(tempFile.getAbsolutePath());

            PdfDocument pdfDocument = new PdfDocument(new PdfWriter(tempFile));
            Document document = new Document(pdfDocument, PageSize.A4);
            document.setTopMargin(0);

            // Logo
            Image logo = new Image(ImageDataFactory.create("http://localhost:4200/assets/images/icon/logo-7.png"));
            logo.setFixedPosition(10, 695);
            document.add(logo);

            // Company Name
            Style titleStyle = new Style()
                    .setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD))
                    .setFontSize(18);

            Paragraph p = new Paragraph("DELIFROST NIGERIA")
                    .addStyle(titleStyle)
                    .setFixedPosition(100,720, 200);
            document.add(p);

            // Company Address
            PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);

            p = new Paragraph("Delifrost Nigeria Ltd")
                    .setFont(font)
                    .setFixedPosition(400, 750, 200);
            document.add(p);

            p = new Paragraph("25 Adeola Odeku")
                    .setFont(font)
                    .setFixedPosition(400, 730, 200);
            document.add(p);

            p = new Paragraph("Victoria Island, Lagos")
                    .setFont(font)
                    .setFixedPosition(400, 710, 200);
            document.add(p);

            // Centre Receipt Before We Begin
            Style heading = new Style();
            heading.setFont(PdfFontFactory.createFont(FontConstants.COURIER_BOLD))
                    .setFontSize(24);

            p = new Paragraph("RECEIPT")
                    .addStyle(heading)
                    .setFixedPosition(220,660, 200);
            document.add(p);


            // Draw Line
            SolidLine line = new SolidLine(1f);

            LineSeparator lineSeparator = new LineSeparator(line);

            lineSeparator.setFixedPosition(0,200, 500);
            document.add(lineSeparator);
            document.close();

            return tempFile.getAbsolutePath();

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
