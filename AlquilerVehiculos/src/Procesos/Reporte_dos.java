/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Anthonny
 */
public class Reporte_dos {

    private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;

    private Font fuentebold = new Font(Font.FontFamily.COURIER, 10, Font.BOLD);
    private Font fuentenormal = new Font(Font.FontFamily.COURIER, 10, Font.NORMAL);
    private Font fuenteitalic = new Font(Font.FontFamily.COURIER, 10, Font.ITALIC);

    public void creando_PDF_Reporte1(String header, String info, String footer,
            String salida) {
        try {
            Document document = new Document(PageSize.A4, 36, 36, 36, 36);
            PdfWriter pw = PdfWriter.getInstance(document, new FileOutputStream(salida));
            document.open();
            document.add(getHeader(header));
            document.add(getEmpty(" "));
            document.add(getEmpty(" "));
            document.add(getEmpty(" "));
            document.add(getInfo(info));
            document.add(getEmpty(" "));
            document.add(getEmpty(" "));
            document.add(getEmpty(" "));
            document.add(getEmpty(" "));
            document.add(getFooter(footer));
            document.close();
        } catch (Exception e) {
        }

    }

    public Paragraph getHeader(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuentebold);
        p.add(c);
        return p;
    }

    public Paragraph getInfo(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_JUSTIFIED);
        c.append(texto);
        c.setFont(fuentenormal);
        p.add(c);
        return p;
    }

    public Paragraph getEmpty(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuenteitalic);
        p.add(c);
        return p;
    }

    public Paragraph getFooter(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuenteitalic);
        p.add(c);
        return p;
    }
}
