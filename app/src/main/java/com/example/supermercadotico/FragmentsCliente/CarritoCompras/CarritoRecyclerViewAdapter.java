package com.example.supermercadotico.FragmentsCliente.CarritoCompras;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.supermercadotico.FragmentsCliente.Busqueda_Productos.BusquedaProductosRecyclerViewAdapter;
import com.example.supermercadotico.IClienteActivity;
import com.example.supermercadotico.Models.Categoria;
import com.example.supermercadotico.Models.Producto;
import com.example.supermercadotico.R;

import java.util.ArrayList;

public class CarritoRecyclerViewAdapter extends RecyclerView.Adapter<CarritoRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "BusquedaRecyclerViewAda";

    //variables
    private ArrayList<Producto> mItemsCarrito = new ArrayList<>();  //Lista de productos que se van a cargar en el fragmento
    private Context mContext;
    private IClienteActivity mInterface;


    public CarritoRecyclerViewAdapter(ArrayList<Producto> pCategorias, Context pContext) {
        mItemsCarrito = pCategorias;   //Lista de productos
        mContext = pContext;      //Contextp
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Acá el view de la tarjeta se conecta con en layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_producto_carrito_tarjeta,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called" );
        //Actualizar la vara

        holder.precioProducto.setText("₡"+mItemsCarrito.get(position).getPrecio()+" por unidad");
        holder.nombreProducto.setText(mItemsCarrito.get(position).getNombre());

       holder.botonMasProductos.setOnClickListener((v -> {
           holder.cantidadProducto.setText("12");
           Log.d(TAG, "onBindViewHolder: clicked on: boton mas" );
           //Cuando se presione un producto, va a pasar por la interfaz y el activity lo va a cargar en el fragmento de la descripcion
       }));

       holder.botonMenosProductos.setOnClickListener((v -> {
           Log.d(TAG, "onBindViewHolder: clicked on: boton mas" );
           holder.cantidadProducto.setText("13");
           //Cuando se presione un producto, va a pasar por la interfaz y el activity lo va a cargar en el fragmento de la descripcion
       }));
    }

    //Acá es donde le pegamos la interfaz al fragmento
    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mInterface = (IClienteActivity) mContext;
    }

    @Override
    public int getItemCount() {
        return mItemsCarrito.size();
    }


    //Esta clase es la que crea cada objeto "tarjeta" y se conecta con los componentes del layout, esto para luego crearlos
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nombreProducto;
        TextView precioProducto;
        TextView cantidadProducto;

        RelativeLayout botonMenosProductos;
        RelativeLayout botonMasProductos;

        CardView cardView;

        public ViewHolder(View itemView){
            super(itemView);
            nombreProducto = itemView.findViewById(R.id.nombre_producto_tarjeta_carrito);  //Se conecta con los componentes del layout
            precioProducto = itemView.findViewById(R.id.precio_producto_tarjeta_carrito);
            cantidadProducto = itemView.findViewById(R.id.cantidad_producto_tarjeta_carrito);
            botonMenosProductos = itemView.findViewById(R.id.boton_mas_tarjeta_carrito);
            botonMasProductos = itemView.findViewById(R.id.boton_menos_tarjeta_carrito);
            cardView = itemView.findViewById(R.id.tarjeta_producto_carrito_card_view);

        }
    }
}