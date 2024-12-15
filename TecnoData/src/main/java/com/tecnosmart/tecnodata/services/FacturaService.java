package com.tecnosmart.tecnodata.services;

import java.util.List;

import com.tecnosmart.tecnodata.models.Factura;

public interface FacturaService {
    
    public void guardarFactura(Factura factura);

    public List<Factura> obtenerTodasLasFacturas();
}
