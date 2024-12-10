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

    public Categoria(Long id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    public Categoria(String nombre) {
        super();
        this.nombre = nombre;
    }

    public Categoria() {
    }
}
