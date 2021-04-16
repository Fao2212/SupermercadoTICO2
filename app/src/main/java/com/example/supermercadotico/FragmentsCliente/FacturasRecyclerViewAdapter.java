package com.example.supermercadotico.FragmentsCliente;

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
import com.example.supermercadotico.Models.Factura;
import com.example.supermercadotico.Models.Producto;
import com.example.supermercadotico.R;

import java.util.ArrayList;

public class FacturasRecyclerViewAdapter extends RecyclerView.Adapter<FacturasRecyclerViewAdapter.ViewHolder> { //todo: cambiar al Recycler view adapter correspondiente

    private static final String TAG = "BusquedaRecyclerViewAda";

    //variables
    private ArrayList<Factura> mFacturas = new ArrayList<>();  //Lista de productos que se van a cargar en el fragmento   //Todo:cambiar a lo correspondiente
    private Context mContext;
    private IClienteActivity mInterface;


    public FacturasRecyclerViewAdapter(ArrayList<Factura> pFacturas, Context pContext) {   //todo: cambiar la lista a lo correspondiente
        mFacturas = pFacturas;   //Lista de productos
        mContext = pContext;      //Contextp
    }

    @Override
    public FacturasRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Acá el view de la tarjeta se conecta con en layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_factura_tarjeta,parent,false);   //todo: cambiar el layout a la tarjeta correspondiente
        FacturasRecyclerViewAdapter.ViewHolder holder = new FacturasRecyclerViewAdapter.ViewHolder(view);  //todo:cambiar al recyclerview correspondiente
        return holder;
    }

    //Esta clase es la que crea cada objeto "tarjeta" y se conecta con los componentes del layout, esto para luego crearlos
    public class ViewHolder extends RecyclerView.ViewHolder{     //Todo: Cambiar todo a la información de la tarjeta a la tarjeta correspondiente

        TextView id_numerofactura_tarjeta;
        TextView fechafactura_factura_tarjeta;
        CardView factura_tarjeta_card_view;

        public ViewHolder(View itemView){
            super(itemView);
            id_numerofactura_tarjeta = itemView.findViewById(R.id.id_numerofactura_tarjeta);    //todo:acá se conecta con los componentes del layout por eso van con los R.ID
            fechafactura_factura_tarjeta = itemView.findViewById(R.id.fechafactura_factura_tarjeta);
            factura_tarjeta_card_view = itemView.findViewById(R.id.factura_tarjeta_card_view);

        }
    }

    @Override
    public void onBindViewHolder(final FacturasRecyclerViewAdapter.ViewHolder holder, final int position) {  //todo:cambiar al recyclerview adapter correspondiente
        Log.d(TAG, "onBindViewHolder: called");

//        //Creo que carga las cosas, a como el usuario va scrolleando hacia abajo o hacia arriba
//        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background);

        //coloca la imagen en el image view de la tarjeta
                                                                 //todo: hay que poner lo del Glide.with si que quiere cargar una imagen, en este caso no


        //Hace un set de los otros componentes de la tarjeta                            //todo: acá se carga la info a la tarjeta o Viewholder, acá hay que cambiarlo según corresponda
        holder.id_numerofactura_tarjeta.setText(mFacturas.get(position).getId());
        holder.fechafactura_factura_tarjeta.setText("₡"+mFacturas.get(position).getFecha());
        holder.factura_tarjeta_card_view.setOnClickListener((v -> {
            Log.d(TAG, "onBindViewHolder: clicked on:" + mFacturas.get(position).getId() );

            //Cuando se presione un producto, va a pasar por la interfaz y el activity lo va a cargar en el fragmento de la descripcion
            mInterface.inflateDescripcion_Factura_Fragment(mFacturas.get(position));    //todo: hay que cmabiar el método para que se comunique con el activity y cargue la descripción de la factura
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
        return mFacturas.size();
    }


}
