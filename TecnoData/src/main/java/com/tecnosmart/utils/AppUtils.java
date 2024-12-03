package com.tecnosmart.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppUtils {
    
    public static String formatearFecha(LocalDateTime fecha) {
        if (fecha == null) return "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return fecha.format(formatter);
    }
    
    public static BigDecimal calcularIVA(BigDecimal subtotal) {
        return subtotal.multiply(BigDecimal.valueOf(AppConstants.IVA))
                      .setScale(2, RoundingMode.HALF_UP);
    }
    
    public static BigDecimal calcularTotal(BigDecimal subtotal) {
        BigDecimal iva = calcularIVA(subtotal);
        return subtotal.add(iva).setScale(2, RoundingMode.HALF_UP);
    }
    
    public static String generarCodigoOrden(Long ordenId) {
        return String.format("ORD-%06d", ordenId);
    }
    
    public static String sanitizarNombreArchivo(String nombreOriginal) {
        return nombreOriginal.replaceAll("[^a-zA-Z0-9.-]", "_")
                           .toLowerCase();
    }
    
    public static boolean esEmailValido(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(regex);
    }
}