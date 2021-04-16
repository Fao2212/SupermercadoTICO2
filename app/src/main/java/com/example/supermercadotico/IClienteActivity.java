package com.example.supermercadotico;


import com.example.supermercadotico.Models.Cliente;
import com.example.supermercadotico.Models.Factura;
import com.example.supermercadotico.Models.Producto;
import com.example.supermercadotico.Users.Comprador;

import java.util.ArrayList;

/**
 * Interfaz para la comunicación entre fragmentos de la actividad del cliente
 */
public interface IClienteActivity {

    //Acá el fragmento de los productos, le va a mandar un producto a la descripcion para que lo cargue
    //Va a pasar por el activity y el activity va a iniciar la descripción del producto
    void inflateDescripcion_Producto_Fragment(Producto pProducto);


    //Acá el fragmento de las facturas, le va a mandar una factura a la descripcion para que lo cargue
    //Va a pasar por el activity y el activity va a iniciar la descripción de la factura
    void inflateDescripcion_Factura_Fragment(Factura pFactura);

    //Este metodo lo utiliza el fragmento de registro y se envia el usuario creado a client activity para que se guarde en la base de datos
    void registrarUsuario(Comprador comprador);

    ArrayList<Producto> getListaProductos();

    Cliente getCliente();

    ArrayList<Factura> getListaFacturasAnteriores();
    void initUserView();
    void initSucursalView(String user,String password);//Cambiar el nombre como a logIn Request
    void initAdminView();
    void initRegisterView();
}
