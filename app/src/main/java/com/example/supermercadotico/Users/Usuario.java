package com.example.supermercadotico.Users;

import com.example.supermercadotico.Controlador;

public class Usuario {
    protected String nombre;
    protected String contrasena;
    protected String direccion;
    protected Controlador controlador;

    public Usuario(String nombre, String contrasena, String direccion) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.direccion = direccion;
    }

    protected Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    protected void setDireccion(String direccion) {
        this.direccion = direccion;
    }


}
