package com.example.supermercadotico;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.supermercadotico.Fragments.BusquedaFragment;

/**
 *
 */
public class ClienteActivity extends AppCompatActivity {

    private static final String TAG = "ClienteActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        Toast toast1 = Toast.makeText(getApplicationContext(), "Activity Cliente", Toast.LENGTH_SHORT);
        toast1.show();
        Log.d(TAG, "onCreate: Crear Cliente Activity");

        //Inicializa el Fragment de Busqueda del Cliente
        initBusqueda();
    }

    private void initBusqueda(){
        BusquedaFragment busquedaFragment = new BusquedaFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.cliente_content_frame, busquedaFragment, getString(R.string.tag_user_fragment_busqueda));
        transaction.addToBackStack(getString(R.string.tag_user_fragment_busqueda));
        transaction.commit();
    }

}