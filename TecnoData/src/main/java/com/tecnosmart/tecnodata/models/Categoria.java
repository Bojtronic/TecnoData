package com.tecnosmart.tecnodata.models;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "imagen_url")
    private String imagenUrl;

    @Column(name = "cantidad_ventas")
    private int cantidadVentas;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(int cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    // Constructores
    public Categoria(Long id, String nombre, String imagenUrl, int cantidadVentas) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.imagenUrl = imagenUrl;
        this.cantidadVentas = cantidadVentas;
    }

    public Categoria(String nombre, String imagenUrl, int cantidadVentas) {
        super();
        this.nombre = nombre;
        this.imagenUrl = imagenUrl;
        this.cantidadVentas = cantidadVentas;
    }

    public Categoria() {
    }
}
