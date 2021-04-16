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

    public String getCorreoElectronico()
    {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico)
    {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena()
    {
        return contrasena;
    }

    public void setContrasena(String contrasena)
    {
        this.contrasena = contrasena;
    }

    //El controlador tendra una referencia del pedido actual, al llamar esta funcion, el controlador empezara con la cuenta regresiva.
    public void confirmarCarrito()
    {
        //Si el controlador tiene un pedido entonces, se confrma
        controlador.confirmarCarrito();
        //Else el controlador dara el mensaje a la pantalla actual de que, no hay ningun pedido para confirmar
    }

    public void crearUnNuevoCarrito()
    {
        controlador.nuevoCarrito();
    }

    public void seleccionarSucursal(Sucursal sucursal)
    {
        controlador.setSucursal(sucursal);
    }

    public void agregarAlCarrito(Producto producto)
    {
        //El controlador tendra el carrito y no lo tendra el usuario, de esa manera se simplifica la comunicacion
        controlador.agregarAlCarrito(producto);
    }

    public void cancelarPedido()
    {
        controlador.cancelarPedido();
    }

    public void quitarProducto(Producto producto)
    {
        //En la pantalla actual el controlador llamara el metodo del usuario que llamara el metodo del controlador?
        //El controlador quitara el producto del carrito
        controlador.quitarProducto(producto);
    }

    public void verHistorial()
    {
        //El controlador cargara el historial de facturas del usuario en la pantalla actual
        controlador.verHistorial();
    }

    public void crearUsuario()
    {
        //Despues de setear los valores, el usuario envia
        //if nada es nulo then
        controlador.registrarComprador(this);
    }

}
