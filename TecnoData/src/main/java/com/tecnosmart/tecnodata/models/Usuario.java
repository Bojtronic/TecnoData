package com.tecnosmart.tecnodata.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Mapeado con el campo `id` de la tabla

    @Column(nullable = false)
    private String apellido;  // Mapeado con el campo `apellido`

    @Column(nullable = false)
    private String nombre;    // Mapeado con el campo `nombre`

    @Column(nullable = false, unique = true)
    private String email;     // Mapeado con el campo `email`

    @Column(nullable = false)
    private String password;  // Mapeado con el campo `password`

    @Column(nullable = false)
    private String rol;       // Mapeado con el campo `rol`

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", email='" + email + "', rol='" + rol + "'}";
    }
}
