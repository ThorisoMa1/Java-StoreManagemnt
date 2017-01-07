/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.Business_Layer;

import java.io.FileOutputStream;
import java.util.ArrayList;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import org.jdesktop.swingx.JXTable;

/**
 *
 * @author TeezyT
 */

public class CreateReportPdf implements IReport {

     static Background thisPdfB;
    static com.itextpdf.text.Document doc;
    static BorderStroke bs;
    static Border bo;
    static Paragraph p;
    static PdfContentByte cb;
    static PdfWriter writer;
    static Graphics2D g2;
    PdfPTable pdfTable;

    @Override
    public void Createreport(ArrayList<ItemClass> items) {

        try {
            ReporBasket(items);
        } catch (IOException ex) {
            Logger.getLogger(CreateReportPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//not  working yet

    /**
     *
     * @param info
     */
    @Override
    public void ExportInfo(JXTable info, JXTable info2) {
        try {
            Export(info, info2);
        } catch (IOException ex) {
            Logger.getLogger(CreateReportPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Export(JXTable info, JXTable info2) throws IOException {

        p = new Paragraph("\n\n\n\n\n");
        System.out.println("About to export the data");
        try {
            doc = new com.itextpdf.text.Document();

            //writer.getDirectContent();
            pdfTable = poulateTAble(info);

            //adds table headers
            writer = PdfWriter.getInstance(doc, new FileOutputStream("Invintory REPORT.pdf"));
             thisPdfB = new Background();
             writer.setPageEvent(thisPdfB);
            doc.open();

            // doc.add(bo);
            System.out.println("Done wth rec");
            //doc.addTitle("Basket report");
            /// doc.addSubject("Items");
            doc.add(p);
            p = new Paragraph("Books In Stock");
            doc.add(p);

            p = new Paragraph("\n\n\n\n\n");
            doc.add(p);

            doc.add(pdfTable);
            doc.add(p);
            p = new Paragraph("Uniforms");
            doc.add(p);
            pdfTable = poulateTAble(info2);
            doc.add(pdfTable);
            PdfContentByte canvas = writer.getDirectContent();
            canvas.rectangle(5, 5, doc.getPageSize().getWidth() - 50, doc.getPageSize().getHeight());
            canvas.stroke();

            System.out.println("done creating pdf");
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(CreateReportPdf.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            doc.close();
            OpenWindow("Invintory REPORT.pdf");

        }

    }

    private void ReporBasket(ArrayList<ItemClass> items) throws IOException {
        System.out.println("About to export  basket the data");
        doc = new com.itextpdf.text.Document();

        bs = new BorderStroke(null, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.FULL);
        bo = new Border(bs);

        // p = new Paragraph();
        try {

            writer = PdfWriter.getInstance(doc, new FileOutputStream("PurchaseReport.pdf"));
            thisPdfB = new Background();
             writer.setPageEvent(thisPdfB);
            doc.open();
            // doc.add(bo);

            doc.addTitle("Ordered Items");

            for (ItemClass item : items) {

                p = new Paragraph(item.toString() + "\n\n\n\n");
                doc.add(p);

            }

            // doc.add(new bor)
            // doc.add(bo);
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(CreateReportPdf.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            doc.close();
            OpenWindow("PurchaseReport.pdf");
        }

    }

    private PdfPTable poulateTAble(JXTable info) throws DocumentException {

        pdfTable = new PdfPTable(info.getColumnCount());

        //pdfTable.setWidths(new int[]{10,10,10,10,10,10,10,10,10,10});
        for (int i = 0; i < info.getColumnCount(); i++) {
            pdfTable.addCell(info.getColumnName(i));
        }

        for (int rows = 0; rows < info.getRowCount(); rows++) {
            for (int cols = 0; cols < info.getColumnCount(); cols++) {
                pdfTable.addCell(info.getModel().getValueAt(rows, cols).toString());

            }
        }

        return pdfTable;
    }

    private void OpenWindow(String filep) throws IOException {
        Thread th = new Thread(new Runnable() {

            @Override
            public void run() {
                File file = new File(filep);
                if (file.toString().endsWith(".pdf")) {
                    try {
                        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
                    } catch (IOException ex) {
                        Logger.getLogger(CreateReportPdf.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        Desktop desktop = Desktop.getDesktop();
                        desktop.open(file);
                    } catch (IOException ex) {
                        Logger.getLogger(CreateReportPdf.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
        th.start();

    }//starts the window

}
