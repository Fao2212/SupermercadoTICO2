package com.example.supermercadotico.FragmentsCliente.Busqueda_Productos;

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
import com.example.supermercadotico.FragmentsCliente.ProductosRecyclerViewAdapter;
import com.example.supermercadotico.IClienteActivity;
import com.example.supermercadotico.Models.Categoria;
import com.example.supermercadotico.Models.Producto;
import com.example.supermercadotico.R;

import java.util.ArrayList;

public class BusquedaProductosRecyclerViewAdapter extends RecyclerView.Adapter<BusquedaProductosRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "BusquedaRecyclerViewAda";

    //variables
    private ArrayList<Categoria> mCategorias = new ArrayList<>();  //Lista de productos que se van a cargar en el fragmento
    private Context mContext;

    private IClienteActivity mInterface;


    public BusquedaProductosRecyclerViewAdapter(ArrayList<Categoria> pCategorias, Context pContext) {
        mCategorias = pCategorias;   //Lista de productos
        mContext = pContext;      //Contextp
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Acá el view de la tarjeta se conecta con en layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_categoria_tarjeta,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called" + mCategorias.get(position).getImagen_categoria());

//        //Creo que carga las cosas, a como el usuario va scrolleando hacia abajo o hacia arriba
//        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background);

       // coloca la imagen en el image view de la tarjeta
        Glide.with(mContext)
                .load(mCategorias.get(position).getImagen_categoria())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imagen_Categoria);

        //Hace un set de los otros componentes de la tarjeta
        holder.nombreCategoria.setText(mCategorias.get(position).getCategoria());
        holder.cardView.setOnClickListener((v -> {
            Log.d(TAG, "onBindViewHolder: clicked on:" + mCategorias.get(position).getCategoria() );
            //Cuando se presione un producto, va a pasar por la interfaz y el activity lo va a cargar en el fragmento de la descripcion
            mInterface.inflateProductos_Categoria(mCategorias.get(position).getId_categoria());
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
        return mCategorias.size();
    }

    //Esta clase es la que crea cada objeto "tarjeta" y se conecta con los componentes del layout, esto para luego crearlos
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imagen_Categoria;
        TextView nombreCategoria;
        CardView cardView;

        public ViewHolder(View itemView){
            super(itemView);
            imagen_Categoria = itemView.findViewById(R.id.imagen_categoria_busqueda);  //Se conecta con los componentes del layout
            nombreCategoria = itemView.findViewById(R.id.nombre_categoria_busqueda);
            cardView = itemView.findViewById(R.id.tarjeta_categoria_busqueda);

        }
    }
}
