package com.example.supermercadotico.Users;

import com.example.supermercadotico.Controlador;

public class Gerente extends Usuario{

    public Gerente(String nombre, String contrasena, String direccion) {
        super(nombre, contrasena, direccion);
    }

    public void registarEmpleado(String nombre, String id, String contrasena, String direccion, String edad)
    {
        Empleado empleado = new Empleado(nombre,contrasena,edad,direccion,id,controlador);
        empleado.crearUsuario();
    }

    public void eliminarEmpleado(Empleado empleado)
    {
        controlador.eliminarEmpleado(empleado); //TODO: PARA todo cambio se necesita accesar la base de datos para actualizar
        empleado.setEstado(EstadoDeEmpleado.DESPEDIDO);
    }


    @Override
    public void crearUsuario() {
        controlador.registrarGerente(this);
    }
}
