package com.example.supermercadotico;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import com.example.supermercadotico.FragmentsCliente.FacturaDescripcionFragment;
import com.example.supermercadotico.FragmentsCliente.FacturasFragment;
import com.example.supermercadotico.FragmentsCliente.PerfilClienteFragment;
import com.example.supermercadotico.FragmentsCliente.ProductoDescripcionFragment;
import com.example.supermercadotico.FragmentsCliente.ProductosFragment;
import com.example.supermercadotico.Models.Cliente;
import com.example.supermercadotico.Models.Factura;
import com.example.supermercadotico.FragmentsCliente.LogInFragment;
import com.example.supermercadotico.Models.Producto;
import com.example.supermercadotico.Utils.Productos;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

/**
 * Clase de Activity para el cliente, va a mostrar los fragments que son especificos para el cliente
 */
public class ClienteActivity extends AppCompatActivity implements IClienteActivity, BottomNavigationView.OnNavigationItemSelectedListener{


     //El tag de cada activity y fragmento esta en res/values/strings.xml
    private static final String TAG = "ClienteActivity";


    private Productos infodummyparaprobar;

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
                initFragmento_Productos();
                item.setChecked(true);
                break;
            }
            case R.id.carrito_nav_cliente:{
                Log.d(TAG, "onNavigationItemSelected: Carrito");
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

    /**
     * Inicializa el Fragment de Productos
     */
    private void initFragmento_Productos(){
        ProductosFragment busquedaFragment = new ProductosFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cliente_content_frame, busquedaFragment, getString(R.string.tag_user_fragment_lista_productos));
        transaction.addToBackStack(getString(R.string.tag_user_fragment_lista_productos));
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

    /**
     * Inicializa el Fragment de Perfil del CLiente
     */
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
        transaction.replace(R.id.cliente_content_frame, sucursalFragment, getString(R.string.tag_user_sucursal));
        transaction.addToBackStack(getString(R.string.tag_user_sucursal));
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
        transaction.replace(R.id.cliente_content_frame, perfilAdministradorFragment, getString(R.string.tag_user_fragment_perfil));
        transaction.addToBackStack(getString(R.string.tag_user_fragment_perfil));
        transaction.commit();
    }

    private void initFragmentoRegistrarUsuario()
    {
        RegistrarUsuarioFragment registrarUsuarioFragment  = new RegistrarUsuarioFragment(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cliente_content_frame, registrarUsuarioFragment, getString(R.string.tag_user_fragment_perfil));
        transaction.addToBackStack(getString(R.string.tag_user_fragment_perfil));
        transaction.commit();
    }

    private void initFragmentoRegistarAdministrador()
    {
        RegistrarAdministradorFragment registrarAdministradorFragment  = new RegistrarAdministradorFragment(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cliente_content_frame, registrarAdministradorFragment, getString(R.string.tag_user_fragment_perfil));
        transaction.addToBackStack(getString(R.string.tag_user_fragment_perfil));
        transaction.commit();
    }

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

    @Override
    public ArrayList<Producto> getListaProductos() {
        Log.d(TAG, "getListaProductos: mandadnolista de productos");
        return null;
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
    //Usado para accesar desde otro fragmento a los metodos de esta clase
    @Override
    public void initUserView() {
        //Inicializa el Fragment de Busqueda del Cliente
        initBarraNavegacion();
        initFragmento_Productos();
    }

    @Override
    public void initSucursalView() {
        initFragmentoSeleccionDeSucursal();
    }


}