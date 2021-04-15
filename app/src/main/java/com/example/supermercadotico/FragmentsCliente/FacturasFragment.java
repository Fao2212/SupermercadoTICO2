package com.example.supermercadotico.FragmentsCliente;

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

import com.example.supermercadotico.Models.Factura;
import com.example.supermercadotico.Models.Producto;
import com.example.supermercadotico.R;
import com.example.supermercadotico.Utils.Productos;

import java.util.ArrayList;


public class FacturasFragment extends Fragment {

    //Tag para reconocer la clase
    private static final String TAG = "Facturas Fragment";                      //< todo: Cambiar al Tag del Fragment > !!!

    //Numero de columnas del fview
    private static final int NUM_COLUMNAS = 1;

    //Widgets
    private RecyclerView mRecyclerView;

    //Variables
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private FacturasRecyclerViewAdapter mRecyclerViewAdapter;               //< todo:Cambiar al Recycler View correspondiente > !!!
    private ArrayList<Factura> mListaFacturas = new ArrayList<>();        //< todo:Cambiar a la lista del objeto correspondiente > !!!

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_facturas,container, false); //< todo:Cambiar al layout correspondiente > !!!
        Log.d(TAG, "onCreateView: Iniciado");

        //Carga el recycler view
        mRecyclerView = view.findViewById(R.id.facturas_recyclerView);                         //< todo:Cambiar al recycler view correspondiente > !!!

        //Carga las facturas a la lista
        findFacturas();
        return view;
    }

    private void findFacturas(){
        //Acá le caen todos los datos de facturas
        Productos productos = new Productos();                              //Está utilizando los datos del paquete UTIL para cargar datos dummy
                                                                            //todo:Aca se tiene que comunicar con la interfaz del activity para que le devuelva la lista de facturas
        for (Factura factura : productos.FACTURAS){
            mListaFacturas.add(factura);
        }

        //Inicia el recycler view
        initRecyclerView();

    }

    //Crea las tarjetas
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNAS, LinearLayoutManager.VERTICAL);  //Setea las columnas
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);

        //Se agregan los datos al adapterView
        mRecyclerViewAdapter = new FacturasRecyclerViewAdapter(mListaFacturas, getActivity());   //todo: agrega la lista correspondiente  y cambiar el objeto al recycler corresponidentea lo que pide el recyclerView correspondiente
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

    }
}