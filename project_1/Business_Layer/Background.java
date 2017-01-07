/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.Business_Layer;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 *
 * @author TeezyT
 */
public class Background extends PdfPageEventHelper{

    /**
     */
    @Override
        public void onEndPage(PdfWriter writer, Document document) {
            int pagenumber = writer.getPageNumber();
            if (pagenumber % 2 == 1 && pagenumber != 1)
                return;
            PdfContentByte canvas = writer.getDirectContentUnder();
            Rectangle rect = document.getPageSize();
            canvas.setColorFill(pagenumber < 3 ? BaseColor.LIGHT_GRAY : BaseColor.LIGHT_GRAY);
            canvas.rectangle(rect.getLeft(), rect.getBottom(), rect.getWidth(), rect.getHeight());
            canvas.fill();
        }
    
}
