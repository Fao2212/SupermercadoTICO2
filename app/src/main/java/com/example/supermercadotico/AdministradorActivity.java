package com.example.supermercadotico;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.supermercadotico.FragmentsAdministrador.PerfilUsuarioFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class AdministradorActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private static final String TAG = "AdministradorActivity";   //tag del administrador

    //widgets
    private BottomNavigationViewEx mBarraNavegacionAdministrador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);
        Log.d(TAG, "onCreate: Crear administrador activity");
        mBarraNavegacionAdministrador = findViewById(R.id.navbar_inferior_view_administrador);
        mBarraNavegacionAdministrador.setOnNavigationItemSelectedListener(this);
        initFragmento_Perfil_Administrador();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.facturasdetodos_nav_administrador:{
                Log.d(TAG, "onNavigationItemSelected: Facturas");
                initFragmento_Facturas_Administrador();
                item.setChecked(true);
                break;
            }
            case R.id.empleados_nav_administrador:{
                Log.d(TAG, "onNavigationItemSelected: Empleados");
                initFragmento_CRUD_Empleados_Administrador();
                item.setChecked(true);
                break;
            }
            case R.id.productos_nav_administrador:{
                Log.d(TAG, "onNavigationItemSelected: Productos");
                initFragmento_CRUD_Productos_Administrador();
                item.setChecked(true);
                break;
            }
            case R.id.perfil_nav_administrador:{
                Log.d(TAG, "onNavigationItemSelected: Perfil");
                initFragmento_Perfil_Administrador();
                item.setChecked(true);
                break;
            }
            case R.id.cerarsesion_nav_administrador:{
                Log.d(TAG, "onNavigationItemSelected: CerrarSesion");
                cerrarSesion_Administrador();
                item.setChecked(true);
                break;
            }
        }
        return false;
    }

    //Inicia el fragmento de perfil del administrador
    private void initFragmento_Perfil_Administrador(){
        Log.d(TAG, "initFragmento_Perfil_Administrador: Iniciando fragmento perfil admin");
    }

    //Inicia el fragmento de perfil del administrador
    private void initFragmento_CRUD_Empleados_Administrador(){
        Log.d(TAG, "initFragmento_CRUD_Empleados_Administrador: Iniciando vista Empleado para ingresarlos");
    }

    //Inicia el fragmento de perfil del administrador
    private void initFragmento_CRUD_Productos_Administrador(){
        Log.d(TAG, "initFragmento_Perfil_Administrador: Iniciando fragmento perfil admin");
    }

    //Inicia el fragmento de perfil del administrador
    private void initFragmento_Facturas_Administrador(){
        Log.d(TAG, "initFragmento_Perfil_Administrador: Iniciando fragmento perfil admin");
    }

    private void cerrarSesion_Administrador(){
        Log.d(TAG, "cerrarSesion_Administrador: Cerrando sesión");

    }


}

