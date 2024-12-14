package com.tecnosmart.tecnodata.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tecnosmart.tecnodata.models.Factura;
import com.tecnosmart.tecnodata.repositories.FacturaRepository;

@Service
public class FacturaServiceImpl implements FacturaService{

    private final FacturaRepository facturaRepository;

    public FacturaServiceImpl(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    @Transactional
    public void guardarFactura(Factura factura) {
        facturaRepository.save(factura);
    }
}
