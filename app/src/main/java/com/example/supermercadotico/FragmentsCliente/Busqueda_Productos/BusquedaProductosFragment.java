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
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.supermercadotico.FragmentsCliente.FacturasRecyclerViewAdapter;
import com.example.supermercadotico.IClienteActivity;
import com.example.supermercadotico.Models.Categoria;
import com.example.supermercadotico.Models.Factura;
import com.example.supermercadotico.R;
import com.example.supermercadotico.Utils.Productos;

import java.util.ArrayList;


public class BusquedaProductosFragment extends Fragment implements View.OnClickListener {

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

    private EditText espacioBusqueda;
    private RelativeLayout botonBusqueda;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_busqueda_productos,container, false); //< todo:Cambiar al layout correspondiente > !!!
        Log.d(TAG, "onCreateView: Iniciado");

        //Carga el recycler view
        espacioBusqueda = view.findViewById(R.id.edit_text_busqueda_producto);
        botonBusqueda = view.findViewById(R.id.boton_busqueda_producto);
        mRecyclerView = view.findViewById(R.id.recyclerView_busqueda_producto);                         //< todo:Cambiar al recycler view correspondiente > !!!

        botonBusqueda.setOnClickListener(this);

        //Carga las facturas a la lista
        interfazClienteActivity = (IClienteActivity) getActivity();
        findCategerias();
        return view;
    }

    private void findCategerias(){
        //Acá le caen todos los datos de facturas
        mListaCategorias = interfazClienteActivity.getListaCategorias();
        Log.d(TAG, "findCategerias: "+mListaCategorias.get(0).getCategoria());
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

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.boton_busqueda_producto){
            Log.d(TAG, "onClick: Buscar producto " + espacioBusqueda.getText());
            interfazClienteActivity.inflateProductos_BarraBusqueda(espacioBusqueda.getText().toString());
        }
    }
}