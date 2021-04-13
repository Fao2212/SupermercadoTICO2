package com.example.supermercadotico;

import com.example.supermercadotico.Alerts.AlertType;
import com.example.supermercadotico.Alerts.BasicAlert;
import com.example.supermercadotico.Users.Comprador;
import com.example.supermercadotico.Users.Empleado;
import com.example.supermercadotico.Users.Gerente;
import com.example.supermercadotico.Users.TipoDeUsuario;
import com.example.supermercadotico.Users.Usuario;
//Todo: Tiene que ser un singleton?
//Todo: Creo que no hay problema con identidicar que usario hace que, porque los metodos son llamados por el usuario.
public class Controlador {
    //Todo: Metodos de pantalla en main activity
    Usuario usuario;
    Carrito carrito;
    Sucursal sucursal;
    TipoDeUsuario tipoDeUsuario;//Opcional, se puede quitar
    //Inventario inventario;//O cada sucursal tendra su inventario
    //Todo: Conexion con base
    //Todo: Ventana actual

    //region User methods
    //---------------------------------------------------------------------------------------
    public void confirmarCarrito()
    {
//        if(carrito.isEmpty())
//            BasicAlert.alert("Confirmar Orden?", AlertType.QUESTION);//TODO:interfaz de alertas
//        else
//            carrito.confirmar();
    }

    public void nuevoCarrito()
    {
        //If carito then pop up nuevo carrito?
        if(BasicAlert.alert("Crear un nuevo pedido?",AlertType.QUESTION))
            carrito = new Carrito();
    }

    public void setSucursal(Sucursal sucursal)
    {
        this.sucursal = sucursal;
    }

    public void agregarAlCarrito(Producto producto)
    {
//        if(BasicAlert.alert("Agregar producto al carro?",AlertType.QUESTION))
//            carrito.agregarProducto(producto);
    }

    public void cancelarPedido()
    {
//        if(carrito.puedeCancelarse())
//            carrito.cancelarPedido();
//        else
//            BasicAlert.alert("Ya expiro el tiempo de cancelacion",AlertType.OKAY);
    }

    public void quitarProducto(Producto producto)
    {
//        if(BasicAlert.alert("Quitar el producto del carro?",AlertType.QUESTION));
//            carrito.quitarProducto(producto);//TODO: EL METODO hace las modificaiones en memoria, hasta que se hace la factura se actualiza la base de datos
    }

    public void verHistorial()
    {
        //Cambia la pantalla actual, pide a BD el historial de facturas. Las transforma en una lista y las muestra en la pantalla.
    }

    public void logIn(String usuario,String contrasena)
    {
        //Todo: Identificar el tipo de usuario
    }

    public void registrarComprador(Comprador comprador)
    {
        //Agregar a los compradores ya sea como lista o como
        //compradores.add(comprador)
        //sqlConection.addComprador(comprador)
    }

    public void registrarEmpleado(Empleado empleado)
    {
    }

    public void registrarGerente(Gerente gerente)
    {
    }

    public void eliminarEmpleado(Empleado empleado)
    {
        //TODO: Todos los metodos actualizan la base de datos
    }

    public void buscarProducto(String nombre)
    {
        //TODO: Hace una peticion a el buscador del controlador y este cambia la pantalla a la lista de productos haciendo el request a la base de datos
    }

    public void eliminarProductoProducto()
    {
        //Manejo de inventario, luego base
    }

    public void agregarProducto()
    {
    }

    //---------------------------------------------------------------------------------------
    //endregion

}
