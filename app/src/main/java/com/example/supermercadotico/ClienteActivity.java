package com.example.supermercadotico;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.supermercadotico.FragmentsAdministrador.PerfilUsuarioFragment;
import com.example.supermercadotico.FragmentsCliente.Busqueda_Productos.BusquedaProductosFragment;
import com.example.supermercadotico.FragmentsCliente.CarritoCompras.CarritoFragment;
import com.example.supermercadotico.FragmentsCliente.FacturaDescripcionFragment;
import com.example.supermercadotico.FragmentsCliente.FacturasFragment;
import com.example.supermercadotico.FragmentsCliente.PerfilAdministradorFragment;
import com.example.supermercadotico.FragmentsCliente.PerfilClienteFragment;
import com.example.supermercadotico.FragmentsCliente.ProductoDescripcionFragment;
import com.example.supermercadotico.FragmentsCliente.ProductosFragment;
import com.example.supermercadotico.FragmentsAdministrador.RegistrarAdministradorFragment;
import com.example.supermercadotico.FragmentsCliente.RegistrarUsuarioFragment;
import com.example.supermercadotico.FragmentsCliente.SucursalFragment;
import com.example.supermercadotico.Models.Categoria;
import com.example.supermercadotico.Models.Cliente;
import com.example.supermercadotico.Models.Factura;
import com.example.supermercadotico.FragmentsCliente.LogInFragment;
import com.example.supermercadotico.Models.Producto;
import com.example.supermercadotico.Users.Comprador;
import com.example.supermercadotico.Users.Empleado;
import com.example.supermercadotico.Users.Gerente;
import com.example.supermercadotico.Users.TipoDeUsuario;
import com.example.supermercadotico.Utils.Productos;
import com.example.supermercadotico.Users.Usuario;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

/**
 * Clase de Activity para el cliente, va a mostrar los fragments que son especificos para el cliente
 */
public class ClienteActivity extends AppCompatActivity implements IClienteActivity, BottomNavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = "ClienteActivity";

    private Productos infodummyparaprobar;

    private ArrayList<Cliente> clientes = new ArrayList<>();//Base de datos temporal (Representan las tablas que vamos  a usar)

    private Cliente cliente;
    private Carrito carrito;
    private Inventario inventario;

    //---------------------------------------------------

    //widgets
    //Barra de navegación
    private BottomNavigationViewEx mBarraNavegacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        Log.d(TAG, "onCreate: Crear Cliente Activity");
        mBarraNavegacion = findViewById(R.id.navbar_inferior_view_cliente); //Barra de navegacion
        mBarraNavegacion.setOnNavigationItemSelectedListener(this);
        infodummyparaprobar = new Productos();
        initFragmentoLogIn();
        //crearCarritoDeCompra();//TODO:QUITAR
        //initFragmento_Facturas();
    }

    private void initBarraNavegacion(){
        Log.d(TAG, "initBarraNavegacion: initializing Barra Navegacion");
        mBarraNavegacion.enableAnimation(false);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.facturas_nav_cliente:{
                Log.d(TAG, "onNavigationItemSelected: Faturas");
                initFragmento_Facturas();
                item.setChecked(true);
                break;
            }
            case R.id.busqueda_nav_cliente:{
                Log.d(TAG, "onNavigationItemSelected: Busqueda");
                initFragmento_Busqueda();
                item.setChecked(true);
                break;
            }
            case R.id.carrito_nav_cliente:{
                Log.d(TAG, "onNavigationItemSelected: Carrito");
                initFragmentoCarrito();
                item.setChecked(true);
                break;
            }
            case R.id.perfil_nav_cliente:{
                Log.d(TAG, "onNavigationItemSelected: Perfil");
                initFragmento_Perfil();
                item.setChecked(true);
                break;
            }
            case R.id.cerarsesion_nav_cliente:{
                Log.d(TAG, "onNavigationItemSelected: CerrarSesion");
                item.setChecked(true);
                break;
            }
        }
        return false;
    }

    //-------------------------------------------------Inicilizar Fragmentos-------------------------------------------------

    /**
     * Inicializa el Fragment de Productos
     */
    private void initFragmento_Busqueda(){
        BusquedaProductosFragment busquedaProductosFragment = new BusquedaProductosFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cliente_content_frame, busquedaProductosFragment, getString(R.string.tag_user_fragment_busqueda));
        transaction.addToBackStack(getString(R.string.tag_user_fragment_busqueda));
        transaction.commit();
    }


    /**
     * Inicializa el Fragment de Facturas
     */
    private void initFragmento_Facturas(){
        FacturasFragment facturasFragment = new FacturasFragment();   //todo cambiar al fragment que se quiere cargar
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cliente_content_frame, facturasFragment, getString(R.string.tag_user_fragment_facturas_anteriores));
        transaction.addToBackStack(getString(R.string.tag_user_fragment_facturas_anteriores));
        transaction.commit();
    }

    private void initFragmento_Perfil(){
        PerfilClienteFragment perfilClienteFragment = new PerfilClienteFragment(); //todo: cambiar acá al fragment deseado

        //Acá es donde le pasa el objeto al fragment de la descripción
        Bundle args= new Bundle();
        args.putParcelable(getString(R.string.intent_perfil_cliente),infodummyparaprobar.getCliente1());
        perfilClienteFragment.setArguments(args); //Acá se lo pasa   //  //todo: cambiar el fragment acá

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cliente_content_frame, perfilClienteFragment, getString(R.string.tag_user_fragment_perfil));  //todo cambiar el fragment aca y cambiar el tag
        transaction.addToBackStack(getString(R.string.tag_user_fragment_perfil));
        transaction.commit();
    }

    private void initFragmentoLogIn()
    {
        LogInFragment logInFragment  = new LogInFragment(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cliente_content_frame, logInFragment, getString(R.string.tag_user_fragment_login));
        transaction.addToBackStack(getString(R.string.tag_user_fragment_login));
        transaction.commit();
    }

    private void initFragmentoSeleccionDeSucursal()
    {
        SucursalFragment sucursalFragment  = new SucursalFragment(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cliente_content_frame, sucursalFragment, getString(R.string.tag_user_fragment_sucursal));
        transaction.addToBackStack(getString(R.string.tag_user_fragment_sucursal));
        transaction.commit();
    }

    private void initFragmentoPerfilUsuario()
    {
        PerfilUsuarioFragment perfilUsuarioFragment  = new PerfilUsuarioFragment(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cliente_content_frame, perfilUsuarioFragment, getString(R.string.tag_user_fragment_perfil));
        transaction.addToBackStack(getString(R.string.tag_user_fragment_perfil));
        transaction.commit();
    }

    private void initFragmentoPerfilAdministrador()
    {
        PerfilAdministradorFragment perfilAdministradorFragment  = new PerfilAdministradorFragment(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cliente_content_frame, perfilAdministradorFragment, getString(R.string.tag_admin_fragment_perfil));
        transaction.addToBackStack(getString(R.string.tag_admin_fragment_perfil));
        transaction.commit();
    }

    private void initFragmentoRegistrarUsuario()
    {
        RegistrarUsuarioFragment registrarUsuarioFragment  = new RegistrarUsuarioFragment(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cliente_content_frame, registrarUsuarioFragment, getString(R.string.tag_user_fragment_registrar));
        transaction.addToBackStack(getString(R.string.tag_user_fragment_registrar));
        transaction.commit();
    }

    private void initFragmentoRegistarAdministrador()
    {
        RegistrarAdministradorFragment registrarAdministradorFragment  = new RegistrarAdministradorFragment(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cliente_content_frame, registrarAdministradorFragment, getString(R.string.tag_admin_fragment_registrar));
        transaction.addToBackStack(getString(R.string.tag_admin_fragment_registrar));
        transaction.commit();
    }

    private void initFragmentoCarrito() {

        CarritoFragment carritoFragment  = new CarritoFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cliente_content_frame, carritoFragment, getString(R.string.tag_user_fragment_carrito_compras));
        transaction.addToBackStack(getString(R.string.tag_user_fragment_carrito_compras));
        transaction.commit();
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------------

    //Ya le llego el producto que el usuario seleccionó, y ahora lo va a cargar en la descripción
    public void inflateDescripcion_Producto_Fragment(Producto pProducto) {
        ProductoDescripcionFragment productoDescripcionFragment = new ProductoDescripcionFragment();

        //Acá es donde le pasa el objeto al fragment de la descripción
        Bundle args= new Bundle();
        args.putParcelable(getString(R.string.intent_producto),pProducto);
        productoDescripcionFragment.setArguments(args); //Acá se lo pasa

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cliente_content_frame, productoDescripcionFragment, getString(R.string.tag_user_fragment_descripcion_producto));
        transaction.addToBackStack(getString(R.string.tag_user_fragment_descripcion_producto));
        transaction.commit();
    }

    //Ya le llego la factura que el usuario seleccionó, y ahora lo va a cargar en la descripción
    public void inflateDescripcion_Factura_Fragment(Factura pFactura) {   //todo hay que hacer uno de estos cuando se comunica y abre otro fagment copy paste de otro código
        FacturaDescripcionFragment facturaDescripcionFragment = new FacturaDescripcionFragment(); //todo: cambiar acá al fragment deseado

        //Acá es donde le pasa el objeto al fragment de la descripción
        Bundle args= new Bundle();
        args.putParcelable(getString(R.string.intent_factura),pFactura);
        facturaDescripcionFragment.setArguments(args); //Acá se lo pasa   //  //todo: cambiar el fragment acá

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cliente_content_frame, facturaDescripcionFragment, getString(R.string.tag_user_fragment_descripcion_facturas_anteriores));  //todo cambiar el fragment aca y cambiar el tag
        transaction.addToBackStack(getString(R.string.tag_user_fragment_descripcion_facturas_anteriores));
        transaction.commit();
    }


    //le envia una lista de produuctos al fragment
    @Override
    public ArrayList<Producto> getListaProductos_deCategoria(String pIDCategoria) {
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();

        for (Producto producto : infodummyparaprobar.PRODUCTOS){
            if (producto.getCategoria() == pIDCategoria) {
                listaProductos.add(producto);
            }
        }
        return listaProductos;
    }

    @Override
    public ArrayList<Producto> getListaProductos_Barra_Busqueda(String pName) {
        Log.d(TAG, "getListaProductos_Barra_Busqueda: Buscando Productos que tengan " + pName);
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();

        for (Producto producto : infodummyparaprobar.PRODUCTOS){
            if (producto.getNombre().toLowerCase().contains(pName.toLowerCase())) {
                listaProductos.add(producto);
            }
        }
        return listaProductos;
    }


    @Override
    public Cliente getCliente() {
        Log.d(TAG, "getCliente: mandando cliente");

        return infodummyparaprobar.cliente1;
    }

    @Override
    public ArrayList<Factura> getListaFacturasAnteriores() {
        Log.d(TAG, "getListaFacturasAnteriores: mandando lista de fcaturas");
        return null;
    }

//-------------------------------------REGISTRO--------------------------------------------

    @Override
    public void initRegisterView() {
        initFragmentoRegistrarUsuario();
    }

    @Override
    public ArrayList<Producto> getListaItemsCarrito() {
       return carrito.getProductos();
    }


    //Metodo que guarda los nuevos usuarios creados en la base de datos.
    @Override
    public void registrarUsuario(Cliente cliente) {
        infodummyparaprobar.CLIENTES.add(cliente);
    }



//----------------------------------------------------------------------------------------


//-------------------------------------LOGIN--------------------------------------------

    @Override
    public void initSucursalView(String user,String password) {
        Cliente clienteInDatabase = checkClienteInDatabase(user,password);
        if(clienteInDatabase != null) {
            initFragmentoSeleccionDeSucursal();
            this.cliente = clienteInDatabase;
        }
    }

    //Inicializa el Fragment de Pantalla principal del cliente
    public void initAdminView() {
        Log.d(TAG, "initAdminView: Iniciando Vista de Administrador");
        Intent intent = new Intent(ClienteActivity.this, AdministradorActivity.class);
        startActivity(intent);
        finish();
    }

    public void initUserView() {
        initBarraNavegacion();
        initFragmento_Busqueda();

    }

    //------------------------------------------------------------------------------------

    //-------------------------------------Compra------------------------------------------

    public void crearCarritoDeCompra() //Se usa para crear cada nueva orden de compra que el cliente necesite hacer. Siempre y cuando no tenga un pedido confirmado
    {
            this.carrito = new Carrito();
    }

    public void limpiarCarrito()
    {
        if(!carrito.isConfirmado())
        {
            this.carrito = new Carrito();
        }
    }

    public void comenzarCuentaRegresiva()//Hacer asincronica
    {
        new CountDownTimer(600000*5, 1000) {

            public void onTick(long millisUntilFinished) {
                //updateFrameDeContador();
            }

            public void onFinish() {
                orderCompletada();
            }

        }.start();
        //Cuando terminan los 5 minutos entonces se graba en la base de datos.
    }

    public void confirmarOrden()
    {
        carrito.cancelable = true;
        carrito.confirmado = true;
        comenzarCuentaRegresiva();
    }

    public void orderCompletada()
    {
        crearCarritoDeCompra();
        guardarFacturaEnBaseDeDatos();
    }

    @Override
    public void agregarAlCarrito(Producto mProducto) {
        carrito.addProducto(mProducto);
    }

    @Override
    public void cerrarVentana() {
        initFragmentoLogIn();
    }

    public void eliminarDelCarro(Producto producto)
    {
        carrito.eliminarProducto(producto);
    }

    //------------------------------------------------------------------------------------

    //-------------------------------DataBase Stuff------------------------------------

    private Cliente checkClienteInDatabase(String username,String password) {
        Cliente cliente;//Todo:Traer de la base de datos
        for (Cliente currentClient:infodummyparaprobar.CLIENTES
             ) {
            if(currentClient.getNombreUsuario().equals(username) && currentClient.getContrasena().equals(password)) {
                crearCarritoDeCompra();
                return currentClient;
            }
        }
        return null;
    }

    private void getUserFromDataBase(String userName){

    }


    //Le manda un array de catgeorias al fragment de categorias
    @Override
    public ArrayList<Categoria> getListaCategorias() {
        ArrayList<Categoria>  categorias = new ArrayList<Categoria>();

        for (Categoria categoria : infodummyparaprobar.CATEGORIAS){
            categorias.add(categoria);
        }

        return categorias;
    }

    @Override
    public void inflateProductos_Categoria(String pIDCategoria) {

        ProductosFragment productosFragment = new ProductosFragment();

        //Acá es donde le pasa el objeto al fragment de la descripción
        Bundle args= new Bundle();
        args.putString("IdCategoria", pIDCategoria);
        productosFragment.setArguments(args); //Acá se lo pasa   //  //todo: cambiar el fragment acá

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cliente_content_frame, productosFragment, getString(R.string.tag_user_fragment_lista_productos));
        transaction.addToBackStack(getString(R.string.tag_user_fragment_lista_productos));
        transaction.commit();
    }

    @Override
    public void inflateProductos_BarraBusqueda(String pNombre) {

        ProductosFragment productosFragment = new ProductosFragment();

        //Acá es donde le pasa el objeto al fragment de la descripción
        Bundle args= new Bundle();
        args.putString("NombreProducto", pNombre);
        productosFragment.setArguments(args); //Acá se lo pasa   //  //todo: cambiar el fragment acá

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cliente_content_frame, productosFragment, getString(R.string.tag_user_fragment_lista_productos));
        transaction.addToBackStack(getString(R.string.tag_user_fragment_lista_productos));
        transaction.commit();
    }

    private void guardarFacturaEnBaseDeDatos()
    {
       // carrito.generarFactura();
    }

    //------------------------------------------------------------------------------------


}