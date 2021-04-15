package com.example.supermercadotico;


import com.example.supermercadotico.Models.Producto;

/**
 * Interfaz para la comunicación entre fragmentos de la actividad del cliente
 */
public interface IClienteActivity {

    //Acá el fragmento de los productos, le va a mandar un producto a la descripcion para que lo cargue
    //Va a pasar por el activity y el activity va a iniciar la descripción del producto
    void inflateDescripcionProductoFragment(Producto pProducto);
    void initUserView();

}
