package com.tecnosmart.tecnodata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecnosmart.tecnodata.models.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
}


