package com.example.supermercadotico.FragmentsCliente;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.supermercadotico.Controlador;
import com.example.supermercadotico.IClienteActivity;
import com.example.supermercadotico.Models.Producto;
import com.example.supermercadotico.R;
import com.like.LikeButton;
import com.like.OnLikeListener;

/**
 * Fragmento para cargar la descripción de un producto
 * Implementa OnLikeListener, para el botón de agregar al carrito.
 * El fragmento de Productos, le pasa un objeto producto a este view para cargarlo en pantalla
 */
public class ProductoDescripcionFragment extends Fragment implements OnLikeListener {
    //Tag para los logs y saber de donde se están haciendo
    private static final String TAG = "DescripcionProductoFrag";

    //Variables
    //Objeto donde se va a cargar la información que el cliente seleccionó del fragment pasado
    private Producto mProducto;

    //widgets
    private TextView mNombreProducto, mPrecio,mStock, mDescripcion, mCategoria, mProveedor;  //TextViews de todos los campos del producto
    private LikeButton mBotonAgregarCarrito;   //Boton de like que hace una animación cuando se presiona
    private RelativeLayout mBotonAtras;      //Botón de la flecha de la barra de arriba
    private ImageView mImagenProducto;      //Imagen del producto
    private IClienteActivity mInterface;

    //Se carga el bundle en el onCreate, por que OnCreate se ejecuta primero que OnCreate view,
    //para que cuando se busquen los componentes ya el bundle con el objeto de producto ya este cargado
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInterface = (IClienteActivity) getActivity();
        //El bundle es lo que permite que el objeto producto puede enviarse desde el fragmento anterior a este,
        //por eso es parcelable
        Bundle bundle = this.getArguments();
        if(bundle!=null){
            mProducto = bundle.getParcelable(getString(R.string.intent_producto));  //Acá toma el objeto
            Log.d(TAG, "onCreate: Tengo el producto que seleccionó el cliente" + mProducto.getNombre());
        }
    }

    //Acá se asignan los componentes a los objetos.. se conectan  con el layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla la vista con este fragmento
        View view = inflater.inflate(R.layout.fragment_descripcion_producto,container,false);
        Log.d(TAG, "onCreateView: started.");

        //Buscando los componentes y los conecta con los objetos de este fragmento
        mNombreProducto = view.findViewById(R.id.nombreProducto_desc);  //Nombre del producto
        mPrecio = view.findViewById(R.id.precio_desc);                  //Precio del Producto
        mStock = view.findViewById(R.id.stock_desc);                    //Cantidad en el inventario
        mCategoria = view.findViewById(R.id.categoria_desc);           //Ctegoría del producto
        mProveedor = view.findViewById(R.id.proveedor_desc);            //Proveedor del producto
        mDescripcion = view.findViewById(R.id.descripcion_desc);        //DEscripción del producto
        mBotonAgregarCarrito = view.findViewById(R.id.agregar_carrito_desc); //Boton de "like" para agregar al carrito
        mBotonAtras = view.findViewById(R.id.boton_atras_desc);         //Boton de la flecha para ir al fragment anterior
        mImagenProducto = view.findViewById(R.id.imagen_Producto_desc);  //Imagen del producto

        mBotonAgregarCarrito.setOnLikeListener(this);       //Listener del botón de like

        init();             //Inicializa carga la infromación a los componentes.

        return view;
    }

    //Se inicializa, o sea se carga toda la info del Producto en el layout
    private void init(){
        Log.d(TAG, "init: Initializing" + getString(R.string.tag_user_fragment_descripcion_producto));

        //Si el producto no es null, osea no le llegó el produto del fragment anterior
        if (mProducto !=null){ //Si le llegó el Producto
            Glide.with(getActivity())
                    .load(mProducto.getImagen_Producto())
                    .into(mImagenProducto);   //Le pone la imagen
            mNombreProducto.setText(mProducto.getNombre());  //Carga el nombre y los datos a los componentes
            mPrecio.setText(mProducto.getPrecio());
            mCategoria.setText(mProducto.getCategoria());
            mDescripcion.setText(mProducto.getDescripcion());
            mProveedor.setText(mProducto.getProveedor());
            mStock.setText(mProducto.getInventario());
        }
    }

    //Cuando se presiona el botón de like y queda de color verde
    @Override
    public void liked(LikeButton likeButton) {
        mInterface.agregarAlCarrito(mProducto);
    }

    //Cuando se vuelve a presionar para quitarle el like, queda de color negro. 
    @Override
    public void unLiked(LikeButton likeButton) {
        Log.d(TAG, "Eliminado del Carrito: ");
    }
}