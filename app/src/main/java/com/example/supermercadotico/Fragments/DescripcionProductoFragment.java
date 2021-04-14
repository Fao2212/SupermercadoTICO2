package com.example.supermercadotico.Fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.supermercadotico.Models.Producto;
import com.example.supermercadotico.R;
import com.like.LikeButton;
import com.like.OnLikeListener;


public class DescripcionProductoFragment extends Fragment implements OnLikeListener {
    private static final String TAG = "DescripcionProductoFrag";

    //Variables
    private Producto mProducto;

    //widgets
    private TextView mNombreProducto, mPrecio,mStock, mDescripcion, mCategoria, mProveedor;
    private LikeButton mBotonAgregarCarrito;
    private RelativeLayout mBotonAtras;
    private ImageView mImagenProducto;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if(bundle!=null){
            mProducto = bundle.getParcelable(getString(R.string.intent_producto));
            Log.d(TAG, "onCreate: Tengo el producto que seleccionó el cliente" + mProducto.getNombre());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_descripcion_producto,container,false);
        Log.d(TAG, "onCreateView: started.");

        //Buscando los componentes
        mNombreProducto = view.findViewById(R.id.nombreProducto_desc);
        mPrecio = view.findViewById(R.id.precio_desc);
        mStock = view.findViewById(R.id.stock_desc);
        mCategoria = view.findViewById(R.id.categoria_desc);
        mProveedor = view.findViewById(R.id.proveedor_desc);
        mDescripcion = view.findViewById(R.id.descripcion_desc);
        mBotonAgregarCarrito = view.findViewById(R.id.agregar_carrito_desc);
        mBotonAtras = view.findViewById(R.id.boton_atras_desc);
        mImagenProducto = view.findViewById(R.id.imagen_Producto_desc);

        mBotonAgregarCarrito.setOnLikeListener(this);

        init();

        return view;
    }

    private void init(){
        Log.d(TAG, "init: Initializing" + getString(R.string.tag_user_fragment_descripcion_producto));
        if (mProducto !=null){
            Glide.with(getActivity())
                    .load(mProducto.getImagen_Producto())
                    .into(mImagenProducto);
            mNombreProducto.setText(mProducto.getNombre());
            mPrecio.setText(mProducto.getPrecio());
            mCategoria.setText(mProducto.getCategoria());
            mDescripcion.setText(mProducto.getDescripcion());
            mProveedor.setText(mProducto.getProveedor());
            mStock.setText(mProducto.getInventario());
        }
    }

    @Override
    public void liked(LikeButton likeButton) {
        Log.d(TAG, "Agregado al Carrito: ");
    }

    @Override
    public void unLiked(LikeButton likeButton) {
        Log.d(TAG, "Eliminado del Carrito: ");
    }
}