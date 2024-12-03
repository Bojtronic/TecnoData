package com.tecnosmart.utils;

public class AppConstants {
    // Roles
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    
    // Estados de Orden
    public static final String ORDEN_ESTADO_PENDIENTE = "PENDIENTE";
    public static final String ORDEN_ESTADO_CONFIRMADA = "CONFIRMADA";
    public static final String ORDEN_ESTADO_ENVIADA = "ENVIADA";
    public static final String ORDEN_ESTADO_ENTREGADA = "ENTREGADA";
    public static final String ORDEN_ESTADO_CANCELADA = "CANCELADA";
    
    // Mensajes
    public static final String MSG_REGISTRO_EXITOSO = "Registro exitoso";
    public static final String MSG_ACTUALIZACION_EXITOSA = "Actualización exitosa";
    public static final String MSG_ELIMINACION_EXITOSA = "Eliminación exitosa";
    public static final String MSG_NO_ENCONTRADO = "Recurso no encontrado";
    public static final String MSG_ERROR_GENERAL = "Ha ocurrido un error";
    
    // Configuración
    public static final int ITEMS_POR_PAGINA = 10;
    public static final String RUTA_IMAGENES = "/uploads/images/";
    public static final double IVA = 0.13; // 13% de IVA
}