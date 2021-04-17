package com.example.supermercadotico;


import android.view.View;

import androidx.fragment.app.Fragment;

import com.example.supermercadotico.Models.Categoria;
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

    ArrayList<Categoria> getListaCategorias();

    //Infla productos de una categoria específica
    void inflateProductos_Categoria(String pIDCategoria);

    void inflateProductos_BarraBusqueda(String pNombre);

    //Busca una lista de una categoría específica
    ArrayList<Producto> getListaProductos_deCategoria(String pIDCategoria);

    ArrayList<Producto> getListaProductos_Barra_Busqueda(String pName);
    //Este metodo lo utiliza el fragmento de registro y se envia el usuario creado a client activity para que se guarde en la base de datos
    void registrarUsuario(Cliente cliente);



    Cliente getCliente();

    ArrayList<Factura> getListaFacturasAnteriores();
    void initUserView();
    void initSucursalView(String user,String password);//Cambiar el nombre como a logIn Request
    void initRegisterView();


    ArrayList<Producto> getListaItemsCarrito();

    void agregarAlCarrito(Producto mProducto);

    void cerrarVentana();

    void initAdminView();
}
