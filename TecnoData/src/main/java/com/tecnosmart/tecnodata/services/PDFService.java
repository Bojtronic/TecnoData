package com.tecnosmart.tecnodata.services;

import com.tecnosmart.tecnodata.models.Factura;
import com.tecnosmart.tecnodata.models.DetalleFactura;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;


@Service
public class PDFService {

    public void generarFacturaPDF(Factura factura) {
        try {
            // Crear el archivo PDF
            File pdfFile = new File("factura_" + factura.getId() + ".pdf");
            PdfWriter writer = new PdfWriter(pdfFile);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            // Añadir contenido al documento
            document.add(new Paragraph("Factura #" + factura.getId()));
            document.add(new Paragraph("Fecha: " + factura.getFecha()));
            document.add(new Paragraph("Total: ₡" + factura.getTotal()));
            document.add(new Paragraph(" "));

            // Crear tabla para los detalles de la factura
            Table table = new Table(4);
            table.addCell(new Cell().add(new Paragraph("Producto")));
            table.addCell(new Cell().add(new Paragraph("Precio")));
            table.addCell(new Cell().add(new Paragraph("Cantidad")));
            table.addCell(new Cell().add(new Paragraph("Subtotal")));

            // Rellenar la tabla con los detalles
            for (DetalleFactura detalle : factura.getDetalles()) {
                table.addCell(new Cell().add(new Paragraph(detalle.getProducto().getNombre())));
                table.addCell(new Cell().add(new Paragraph("₡" + detalle.getProducto().getPrecio())));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(detalle.getCantidad()))));
                table.addCell(new Cell().add(new Paragraph("₡" + detalle.getSubtotal())));
            }

            document.add(table);
            document.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
