package com.example.supermercadotico.FragmentsCliente.Busqueda_Productos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.supermercadotico.FragmentsCliente.FacturasRecyclerViewAdapter;
import com.example.supermercadotico.IClienteActivity;
import com.example.supermercadotico.Models.Categoria;
import com.example.supermercadotico.Models.Factura;
import com.example.supermercadotico.R;
import com.example.supermercadotico.Utils.Productos;

import java.util.ArrayList;


public class BusquedaProductosFragment extends Fragment {

    //Tag para reconocer la clase
    private static final String TAG = "BusquedProductosFragmen";                      //< todo: Cambiar al Tag del Fragment > !!!

    //Numero de columnas del fview
    private static final int NUM_COLUMNAS = 1;

    //Widgets
    private RecyclerView mRecyclerView;

    //Variables
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private BusquedaProductosRecyclerViewAdapter mRecyclerViewAdapter;               //< todo:Cambiar al Recycler View correspondiente > !!!
    private ArrayList<Categoria> mListaCategorias = new ArrayList<>();        //< todo:Cambiar a la lista del objeto correspondiente > !!!
    private IClienteActivity interfazClienteActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_busqueda_productos,container, false); //< todo:Cambiar al layout correspondiente > !!!
        Log.d(TAG, "onCreateView: Iniciado");

        //Carga el recycler view
        mRecyclerView = view.findViewById(R.id.recyclerView_busqueda_producto);                         //< todo:Cambiar al recycler view correspondiente > !!!

        //Carga las facturas a la lista
        interfazClienteActivity = (IClienteActivity) getActivity();
        findCategerias();
        return view;
    }

    private void findCategerias(){
        //Acá le caen todos los datos de facturas
        Productos productos = new Productos();                              //Está utilizando los datos del paquete UTIL para cargar datos dummy
         mListaCategorias = interfazClienteActivity.inflateCategorias_Busqueda_Fragment();
        //Inicia el recycler view
        initRecyclerView();
    }

    //Crea las tarjetas
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNAS, LinearLayoutManager.VERTICAL);  //Setea las columnas
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);

        //Se agregan los datos al adapterView
        mRecyclerViewAdapter = new BusquedaProductosRecyclerViewAdapter(mListaCategorias, getActivity());   //todo: agrega la lista correspondiente  y cambiar el objeto al recycler corresponidentea lo que pide el recyclerView correspondiente
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }
}