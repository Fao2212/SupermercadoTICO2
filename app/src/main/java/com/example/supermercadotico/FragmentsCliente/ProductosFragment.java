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

import com.example.supermercadotico.IClienteActivity;
import com.example.supermercadotico.Models.Producto;
import com.example.supermercadotico.R;
import com.example.supermercadotico.Utils.Productos;

import java.util.ArrayList;

/**
 * Fragment para la busqueda de productos del cliente, por categoría y nombre
 * Todo: RecyclerView para las categorias
 *       Cuando se ingrese a una categoria que se carguen los productos
 *       Cuando se selecciona un producto que se cargue la info de ese producto
 *       Cuando se busque por nombre que aparezca ese producto o productos
 */
public class ProductosFragment extends Fragment {

    //Tag para reconocer la clase
    private static final String TAG = "ProductosFragment";

    //Numero de columnas del fview
    private static final int NUM_COLUMNAS = 2;

    //Widgets
    private RecyclerView mRecyclerView;

    //Variables
    private IClienteActivity interfaceclienteActivity;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private ProductosRecyclerViewAdapter mRecyclerViewAdapter;
    private ArrayList<Producto> mListaProductos = new ArrayList<>();
    private String mCategoria = " ";
    private String mNombreProducto = " ";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if(bundle!=null){
                mCategoria = bundle.getString("IdCategoria");  //Acá toma el objeto
                mNombreProducto = bundle.getString("NombreProducto");
            Log.d(TAG, "onCreate: Tengo el producto que seleccionó el cliente" + mCategoria);
            Log.d(TAG, "onCreate: Tengo el producto que seleccionó el cliente" + mNombreProducto);

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_productos,container, false);
        Log.d(TAG, "onCreateView: Iniciado");
        interfaceclienteActivity = (IClienteActivity) getActivity();

        //Carga el recycler view
        mRecyclerView = view.findViewById(R.id.productos_recyclerView);

        //Carga los productos a la lista
        findProducts();
       return view;
    }

    //Se conecta con la interfaz y ClienteActivity le da la lista con los productos de esa categoria
    private void findProducts(){
        //Acá le caen todos los datos de productos
        if (mCategoria != null){
            mListaProductos = interfaceclienteActivity.getListaProductos_deCategoria(mCategoria);
        }else {
            mListaProductos = interfaceclienteActivity.getListaProductos_Barra_Busqueda(mNombreProducto);
        }
        //Inicia el recycler view
        initRecyclerView();
    }

    //Crea las tarjetas
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNAS, LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);

        //Se agregan los datos al adapterView
        mRecyclerViewAdapter = new ProductosRecyclerViewAdapter(mListaProductos, getActivity());
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

    }
}