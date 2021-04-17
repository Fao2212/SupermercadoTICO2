package com.example.supermercadotico.FragmentsCliente.CarritoCompras;

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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.supermercadotico.FragmentsCliente.Busqueda_Productos.BusquedaProductosRecyclerViewAdapter;
import com.example.supermercadotico.IClienteActivity;
import com.example.supermercadotico.Models.Categoria;
import com.example.supermercadotico.Models.Producto;
import com.example.supermercadotico.R;
import com.example.supermercadotico.Utils.Productos;

import java.util.ArrayList;


public class CarritoFragment extends Fragment implements View.OnClickListener {//Tag para reconocer la clase
    private static final String TAG = "CarritoFragment";                      //< todo: Cambiar al Tag del Fragment > !!!

    //Numero de columnas del fview
    private static final int NUM_COLUMNAS = 1;

    //Widgets
    private RecyclerView mRecyclerView;

    //Variables
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private CarritoRecyclerViewAdapter mRecyclerViewAdapter;               //< todo:Cambiar al Recycler View correspondiente > !!!
    private ArrayList<Producto> mListaItemsCarrito = new ArrayList<>();        //< todo:Cambiar a la lista del objeto correspondiente > !!!
    private IClienteActivity interfazClienteActivity;

    private IClienteActivity mInterface;

    private CheckBox confimado,cancelado;

    private TextView totalCompra;
    private Button botonBorrarCarrito;
    private Button botonConfirmarCarrito,botonCancelarCarrito;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mInterface = (IClienteActivity) getActivity();
        View view = inflater.inflate(R.layout.fragment_carrito,container, false); //< todo:Cambiar al layout correspondiente > !!!
        Log.d(TAG, "onCreateView: Iniciado Carrito de compras");

        //Carga el recycler view
        totalCompra = view.findViewById(R.id.total_carrito_compras);
        botonBorrarCarrito = view.findViewById(R.id.boton_borrar_carrito_carrito_compras);
        botonConfirmarCarrito = view.findViewById(R.id.boton_confirmar_carrito_compras);
        botonCancelarCarrito = view.findViewById(R.id.boton_cancelar_carrito_compras2);
        mRecyclerView = view.findViewById(R.id.carrito_compras_recyclerView);                         //< todo:Cambiar al recycler view correspondiente > !!!
        cancelado = view.findViewById(R.id.checkBoxCancelable);
        confimado = view.findViewById(R.id.checkBoxConfirmado);
        botonConfirmarCarrito.setOnClickListener(this);
        botonBorrarCarrito.setOnClickListener(this);
        botonCancelarCarrito.setOnClickListener(this);


        //Carga las facturas a la lista
        interfazClienteActivity = (IClienteActivity) getActivity();
        findItemsCarrito();
        return view;
    }

    private void actualizarPrecio(){
        float total = 0;
        if ( mListaItemsCarrito.size() != 0 ){
            for (Producto producto: mListaItemsCarrito) {
                total += Float.parseFloat(producto.getPrecio());
            }
        }
        totalCompra.setText("₡"+total);
    }

    private void findItemsCarrito(){
        //Acá le caen todos los datos de los productos
        mListaItemsCarrito = interfazClienteActivity.getListaItemsCarrito();
        //Log.d(TAG, "findItemsCarrito: "+mListaItemsCarrito.get(0).getCategoria());
        //Inicia el recycler view
        actualizarPrecio();
        initRecyclerView();
    }

    //Crea las tarjetas
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNAS, LinearLayoutManager.VERTICAL);  //Setea las columnas
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);

        //Se agregan los datos al adapterView
        mRecyclerViewAdapter = new CarritoRecyclerViewAdapter(mListaItemsCarrito, getActivity());   //todo: agrega la lista correspondiente  y cambiar el objeto al recycler corresponidentea lo que pide el recyclerView correspondiente
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.boton_borrar_carrito_carrito_compras:{
                mInterface.borrarCarrito();
                confimado.setChecked(false);
                cancelado.setChecked(false);
                break;
            }
            case R.id.boton_confirmar_carrito_compras:{

                mInterface.confirmarCarrito();
                confimado.setChecked(true);
                cancelado.setChecked(true);
                break;
            }
            case R.id.boton_cancelar_carrito_compras2:{
                confimado.setChecked(false);
                cancelado.setChecked(false);
                mInterface.cancelarCarrito();
            }
        }
    }
}