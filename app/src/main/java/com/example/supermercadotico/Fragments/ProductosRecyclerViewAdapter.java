package com.example.supermercadotico.Fragments;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.supermercadotico.IClienteActivity;
import com.example.supermercadotico.Models.Producto;
import com.example.supermercadotico.R;

import java.util.ArrayList;

//Para poner la lista de items
public class ProductosRecyclerViewAdapter extends RecyclerView.Adapter<ProductosRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "BusquedaRecyclerViewAda";

    //variables
    private ArrayList<Producto> mProductos = new ArrayList<>();  //Lista de productos que se van a cargar en el fragmento
    private Context mContext;

    private IClienteActivity mInterface;


    public ProductosRecyclerViewAdapter(ArrayList<Producto> pProductos, Context pContext) {
        mProductos = pProductos;   //Lista de productos
        mContext = pContext;      //Contextp
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Acá el view de la tarjeta se conecta con en layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_producto_tarjeta,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");

//        //Creo que carga las cosas, a como el usuario va scrolleando hacia abajo o hacia arriba
//        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background);

        //coloca la imagen en el image view de la tarjeta
        Glide.with(mContext)
                .load(mProductos.get(position).getImagen_Producto())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imagen_Producto);

        //Hace un set de los otros componentes de la tarjeta
        holder.nombre.setText(mProductos.get(position).getNombre());
        holder.precio.setText("₡"+mProductos.get(position).getPrecio());
        holder.cardView.setOnClickListener((v -> {
            Log.d(TAG, "onBindViewHolder: clicked on:" + mProductos.get(position).getNombre() );

            //Cuando se presione un producto, va a pasar por la interfaz y el activity lo va a cargar en el fragmento de la descripcion
            mInterface.inflateDescripcionProductoFragment(mProductos.get(position));
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
        return mProductos.size();
    }

    //Esta clase es la que crea cada objeto "tarjeta" y se conecta con los componentes del layout, esto para luego crearlos
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imagen_Producto;
        TextView nombre;
        TextView precio;
        CardView cardView;

        public ViewHolder(View itemView){
            super(itemView);
            imagen_Producto = itemView.findViewById(R.id.imagenProducto);  //Se conecta con los componentes del layout
            nombre = itemView.findViewById(R.id.nombreProducto);
            precio = itemView.findViewById(R.id.precioProducto);
            cardView = itemView.findViewById(R.id.card_view);

        }
    }
}
