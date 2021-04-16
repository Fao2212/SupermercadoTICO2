package com.example.supermercadotico.Users;

import com.example.supermercadotico.Controlador;
import com.example.supermercadotico.Models.Producto;
import com.example.supermercadotico.Sucursal;
//Todo: para ver que sucursal es la favorita, entonces poner un array que tenga las visitas a la sucursal o cuando se cargan las facturas
//Todo: hacer un conteo y un max de las sucursal donde se hizo la compra
public class Comprador extends Usuario{
    private String correoElectronico;
    private String contrasena;

    public Comprador(String nombre, String contrasena, String direccion, String correoElectronico) {
        super(nombre, contrasena, direccion);
        this.correoElectronico = correoElectronico;
    }

}
