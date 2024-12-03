package com.tecnosmart.models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detalles_orden")
public class DetalleOrden {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orden_id")
    private Orden orden;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    private Producto producto;
    
    @Column(nullable = false)
    private Integer cantidad;
    
    @Column(nullable = false)
    private BigDecimal precio;
    
    @Column(nullable = false)
    private BigDecimal subtotal;

    // Constructor
    public DetalleOrden() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Orden getOrden() { return orden; }
    public void setOrden(Orden orden) { this.orden = orden; }
    
    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }
    
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    
    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
}