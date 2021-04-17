package com.example.supermercadotico.Users;

import com.example.supermercadotico.Controlador;
import com.example.supermercadotico.Models.Producto;

public class Empleado extends Usuario{

    EstadoDeEmpleado estado;

    public Empleado(String nombre, String contrasena, String edad, String direccion, String identificiacion, Controlador controlador) {
        super(nombre, contrasena, direccion);
    }


    public void setEstado(EstadoDeEmpleado estado) {
        this.estado = estado;
    }

    public void agregarProducto(Producto producto)
    {
        controlador.agregarProducto();
    }

    public void eliminarProducto(Producto producto)
    {
        controlador.eliminarProductoProducto();
    }
}
