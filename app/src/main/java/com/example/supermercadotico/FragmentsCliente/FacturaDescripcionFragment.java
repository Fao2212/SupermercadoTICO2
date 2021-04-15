package com.example.supermercadotico.FragmentsCliente;

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
import com.example.supermercadotico.Models.Factura;
import com.example.supermercadotico.Models.Producto;
import com.example.supermercadotico.R;
import com.like.LikeButton;
import com.like.OnLikeListener;



public class FacturaDescripcionFragment extends Fragment {
    //Tag para los logs y saber de donde se están haciendo
    private static final String TAG = "DescripcionFACTURAfrag";     //todo: cambiar el tag al correspondinete de la clase

    //Variables
    //Objeto donde se va a cargar la información que el cliente seleccionó del fragment pasado
    private Factura mFactura;                                   //todo: cambiar el objeto que se va a mostrar al objeto correspondiende

    //widgets Todo: cambiar los widgets a los widgets que se van a usar en el layout de la descripción
            //Ids del layout de fragment_factura_descripcion
            /**
            ID BOTON ATRAS = boton_atras_fact
            ID Imagen Factura: imagen_Factura_frag
            ID textView Sucursal: sucursal_factura_frag
            ID TextView nombre usuario: nombre_usuario_factura_frag
            ID textView fecha: fecha_factura_frag
            ID textview productos: productos_factura_frag
            ID total de la compra: total_fact_frag
             **/
            private TextView mSucursal_factura_frag, mNombre_usuario_factura_frag, mFecha_factura_frag, mProductos_factura_frag, mTotal_fact_frag;  //TextViews de todos los campos del producto
            private RelativeLayout mBoton_atras_fact;      //Botón de la flecha de la barra de arriba

    //Se carga el bundle en el onCreate, por que OnCreate se ejecuta primero que OnCreate view,
    //para que cuando se busquen los componentes ya el bundle con el objeto de producto ya este cargado
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //El bundle es lo que permite que el objeto producto puede enviarse desde el fragmento anterior a este,
        //por eso es parcelable
        Bundle bundle = this.getArguments();
        if(bundle!=null){
            mFactura = bundle.getParcelable(getString(R.string.intent_factura));  //todo acá hay que ir al archivo de strings.xml y poner otro string que sea el intent correspondiente
            Log.d(TAG, "onCreate: Tengo el producto que seleccionó el cliente" + mFactura.getId());  //todo: se cambia al objeto correspondiente
        }
    }

    //Acá se asignan los componentes a los objetos.. se conectan  con el layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla la vista con este fragmento
        View view = inflater.inflate(R.layout.fragment_factura_descripcion,container,false);  //todo cambiar el fragment al fragmento correspondiente
        Log.d(TAG, "onCreateView: started.");

        //Buscando los componentes y los conecta con los objetos de este fragmento     //todo conectar los componentes del fragment a los objetos correspondientes, osea el id del componente del layout
        mSucursal_factura_frag = view.findViewById(R.id.sucursal_factura_frag);  //Sucursal de la factura
        mNombre_usuario_factura_frag = view.findViewById(R.id.nombre_usuario_factura_frag);    //Nombre de usuario que hizo la factura/pedido
        mFecha_factura_frag = view.findViewById(R.id.fecha_factura_frag);              //Fecha de creación de la factura
        mProductos_factura_frag = view.findViewById(R.id.productos_factura_frag);      //Lista de productos de la factura
        mTotal_fact_frag = view.findViewById(R.id.total_fact_frag);            //total de la factura
        mBoton_atras_fact = view.findViewById(R.id.boton_atras_fact);         //Boton de la flecha para ir al fragment anterior


        init();             //Inicializa carga la infromación a los componentes.
        return view;
    }

    //Se inicializa, o sea se carga toda la info del Producto en el layout
    private void init(){
        Log.d(TAG, "init: Initializing" + getString(R.string.tag_user_fragment_descripcion_producto));

        //Si el producto no es null, osea no le llegó el produto del fragment anterior
        if (mFactura !=null){ //Si le llegó el Producto
                               //!!! Acá le pone la imagen pero en este caso, no hay que hacerlo, ver ejemplo en lo de productos


            mSucursal_factura_frag.setText(mFactura.getSucursal());  //Carga el nombre y los datos a los componentes
            mNombre_usuario_factura_frag.setText(mFactura.getUsuario());
            mFecha_factura_frag.setText(mFactura.getFecha());
            mProductos_factura_frag.setText(mFactura.getProductos());
            mTotal_fact_frag.setText(mFactura.getTotal());
        }
    }

}