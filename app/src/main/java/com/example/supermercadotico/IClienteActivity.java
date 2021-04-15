package com.example.supermercadotico;


import com.example.supermercadotico.Models.Cliente;
import com.example.supermercadotico.Models.Factura;
import com.example.supermercadotico.Models.Producto;

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

    ArrayList<Producto> getListaProductos();

    Cliente getCliente();

    ArrayList<Factura> getListaFacturasAnteriores();

}
