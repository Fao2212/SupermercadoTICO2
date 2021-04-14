package com.example.supermercadotico.Fragments;

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

import com.example.supermercadotico.Models.Producto;
import com.example.supermercadotico.R;
import com.example.supermercadotico.Utils.Productos;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragment para la busqueda de productos del cliente, por categoría y nombre
 * Todo: RecyclerView para las categorias
 *       Cuando se ingrese a una categoria que se carguen los productos
 *       Cuando se selecciona un producto que se cargue la info de ese producto
 *       Cuando se busque por nombre que aparezca ese producto o productos
 */
public class BusquedaFragment extends Fragment {

    private static final String TAG = "BusquedaFragment";

    //constante
    private static final int NUM_COLUMNAS = 2;

    //Widgets
    private RecyclerView mRecyclerView;

    //Variables
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private BusquedaRecyclerViewAdapter mRecyclerViewAdapter;
    private ArrayList<Producto> mListaProductos = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_busqueda,container, false);
        Log.d(TAG, "onCreateView: Iniciado");

        mRecyclerView = view.findViewById(R.id.busqueda_recyclerView);
        findProducts();
       return view;
    }

    private void findProducts(){
        //Acá le caen todos los datos de productos
        Productos productos = new Productos();

        for (Producto producto : productos.PRODUCTOS){
            mListaProductos.add(producto);
        }

        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNAS, LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);

        //Se agregan los datos al adapterView
        mRecyclerViewAdapter = new BusquedaRecyclerViewAdapter(mListaProductos, getActivity());
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

    }
}