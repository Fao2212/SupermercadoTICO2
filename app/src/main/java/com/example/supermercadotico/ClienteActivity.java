package com.example.supermercadotico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.supermercadotico.Fragments.DescripcionProductoFragment;
import com.example.supermercadotico.Fragments.ProductosFragment;
import com.example.supermercadotico.Models.Producto;

/**
 * Clase de Activity para el cliente, va a mostrar los fragments que son especificos para el cliente
 */
public class ClienteActivity extends AppCompatActivity implements IClienteActivity{

    /**
     * El tag de cada activity y fragmento esta en res/values/strings.xml
     */
    private static final String TAG = "ClienteActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        Log.d(TAG, "onCreate: Crear Cliente Activity");

        //Inicializa el Fragment de Busqueda del Cliente
        initBusqueda();
    }

    /**
     * Inicializa el Fragment de busqueda
     */
    private void initBusqueda(){
        ProductosFragment busquedaFragment = new ProductosFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cliente_content_frame, busquedaFragment, getString(R.string.tag_user_fragment_busqueda));
        transaction.addToBackStack(getString(R.string.tag_user_fragment_busqueda));
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
}