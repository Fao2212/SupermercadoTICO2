package com.example.supermercadotico.Users;

import com.example.supermercadotico.Controlador;

public abstract class Usuario {
    protected String nombre;
    protected String contrasena;
    protected String edad;
    protected String direccion;
    protected String identificiacion;
    protected Controlador controlador;

    public Usuario(String nombre, String contrasena, String edad, String direccion, String identificiacion, Controlador controlador) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.edad = edad;
        this.direccion = direccion;
        this.identificiacion = identificiacion;
        this.controlador = controlador;
    }

    public String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    protected void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    protected void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdentificiacion() {
        return identificiacion;
    }

    public void logIn()
    {
        controlador.logIn(identificiacion,contrasena);
    }

    public abstract void crearUsuario();

    public void buscarProducto(String nombre)
    {
        controlador.buscarProducto(nombre);

    }

}
