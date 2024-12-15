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
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
public class PDFService {

    public void generarFacturaPDF(Factura factura) {
        try {
            // Crear el archivo PDF
            File pdfFile = new File("factura #" + factura.getId() + ".pdf");
            PdfWriter writer = new PdfWriter(pdfFile);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            // Encabezado: Información de la tienda
            document.add(new Paragraph("TIENDA: TRUMAN").setBold());
            document.add(new Paragraph("Teléfono: 8888-8888"));
            document.add(new Paragraph("Correo: truman@mail.com"));
            document.add(new Paragraph("Cédula: 3485252082059"));
            document.add(new Paragraph("Fax: 8888-888"));
            document.add(new Paragraph(" "));

            // Información del cliente
            document.add(new Paragraph("Cliente: "));
            document.add(new Paragraph("Correo: "));
            document.add(new Paragraph("Teléfono: "));
            //document.add(new Paragraph("Cliente: " + cliente.getNombre()));
            //document.add(new Paragraph("Correo: " + cliente.getCorreo()));
            //document.add(new Paragraph("Teléfono: " + cliente.getTelefono()));
            document.add(new Paragraph(" "));

            // Información de la factura
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            document.add(new Paragraph("Factura #: " + factura.getId()));
            document.add(new Paragraph("Fecha y hora: " + LocalDateTime.now().format(formatter)));
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
            document.add(new Paragraph(" "));

            // Desglose de la factura
            BigDecimal subtotal = factura.getDetalles().stream()
                    .map(DetalleFactura::getSubtotal)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal iva = subtotal.multiply(BigDecimal.valueOf(0.13)); // 13% IVA
            BigDecimal total = subtotal.add(iva);

            document.add(new Paragraph("Subtotal: ₡" + subtotal));
            document.add(new Paragraph("IVA (13%): ₡" + iva));
            document.add(new Paragraph("Total: ₡" + total));

            // Cerrar el documento
            document.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
