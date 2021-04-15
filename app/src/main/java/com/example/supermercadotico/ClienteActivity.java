package com.example.supermercadotico;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.supermercadotico.Fragments.DescripcionProductoFragment;
import com.example.supermercadotico.Fragments.LogInFragment;
import com.example.supermercadotico.Fragments.ProductosFragment;
import com.example.supermercadotico.Models.Producto;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Clase de Activity para el cliente, va a mostrar los fragments que son especificos para el cliente
 */
public class ClienteActivity extends AppCompatActivity implements IClienteActivity, BottomNavigationView.OnNavigationItemSelectedListener{


     //El tag de cada activity y fragmento esta en res/values/strings.xml
    private static final String TAG = "ClienteActivity";

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
                item.setChecked(true);
                break;
            }
            case R.id.busqueda_nav_cliente:{
                Log.d(TAG, "onNavigationItemSelected: Busqueda");
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
     * Inicializa el Fragment de busqueda
     */
    private void initFragmentoProductos(){
        ProductosFragment busquedaFragment = new ProductosFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cliente_content_frame, busquedaFragment, getString(R.string.tag_user_fragment_busqueda));
        transaction.addToBackStack(getString(R.string.tag_user_fragment_lista_productos));
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



    //Ya le llego el producto que el usuario seleccionó, y ahora lo va a cargar en la descripción
    @Override
    public void inflateDescripcionProductoFragment(Producto pProducto) {
        DescripcionProductoFragment descripcionProductoFragment = new DescripcionProductoFragment();

        //Acá es donde le pasa el objeto al fragment de la descripción
        Bundle args= new Bundle();
        args.putParcelable(getString(R.string.intent_producto),pProducto);
        descripcionProductoFragment.setArguments(args); //Acá se lo pasa

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cliente_content_frame, descripcionProductoFragment, getString(R.string.tag_user_fragment_descripcion_producto));
        transaction.addToBackStack(getString(R.string.tag_user_fragment_descripcion_producto));
        transaction.commit();
    }

    //Usado para accesar desde otro fragmento a los metodos de esta clase
    @Override
    public void initUserView() {
        //Inicializa el Fragment de Busqueda del Cliente
        initBarraNavegacion();
        initFragmentoProductos();
    }


}