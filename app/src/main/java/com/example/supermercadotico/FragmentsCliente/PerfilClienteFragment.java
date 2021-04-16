package com.example.supermercadotico.FragmentsCliente;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.supermercadotico.IClienteActivity;
import com.example.supermercadotico.Models.Cliente;
import com.example.supermercadotico.Models.Factura;
import com.example.supermercadotico.R;
import com.example.supermercadotico.Users.Comprador;
import com.like.LikeButton;
import com.like.OnLikeListener;


public class PerfilClienteFragment extends Fragment implements OnLikeListener {
    //Tag para los logs y saber de donde se están haciendo
    private static final String TAG = "DescripcionPerfilfrag";     //todo: cambiar el tag al correspondinete de la clase

    //Variables
    //Objeto donde se va a cargar la información que el cliente seleccionó del fragment pasado
    private Cliente mCliente;                                   //todo: cambiar el objeto que se va a mostrar al objeto correspondiende
    private IClienteActivity mInterfaceClienteActivity;


    //widgets Todo: cambiar los widgets a los widgets que se van a usar en el layout de la descripción
    //Ids del layout de fragment_factura_descripcion
    private EditText mNombre_usuario_perfil_cliente_frag, mNombre_perfil_cliente_frag, mApellido_perfil_cliente_frag, mDireccion_perfil_cliente_frag, mEmail_perfil_cliente_frag,mContrasena_perfil_cliente_frag;  //TextViews de todos los campos del producto
    private LikeButton mGuardar_cambios_boton_perfil_cliente_frag;   //Boton de like que hace una animación cuando se presiona
    private ImageView mImagenPerfilCliente;      //Imagen del producto

    //Se carga el bundle en el onCreate, por que OnCreate se ejecuta primero que OnCreate view,
    //para que cuando se busquen los componentes ya el bundle con el objeto de producto ya este cargado
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //El bundle es lo que permite que el objeto producto puede enviarse desde el fragmento anterior a este,
        //por eso es parcelable
        Bundle bundle = this.getArguments();
        if(bundle!=null){
            mCliente = bundle.getParcelable(getString(R.string.intent_perfil_cliente));  //todo acá hay que ir al archivo de strings.xml y poner otro string que sea el intent correspondiente
            Log.d(TAG, "onCreate: Tengo el Cliente " + mCliente.getNombreUsuario());  //todo: se cambia al objeto correspondiente
        }
    }

    //Acá se asignan los componentes a los objetos.. se conectan  con el layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla la vista con este fragmento
        View view = inflater.inflate(R.layout.fragment_perfilcliente,container,false);  //todo cambiar el fragment al fragmento correspondiente
        Log.d(TAG, "onCreateView: started.");

        //Buscando los componentes y los conecta con los objetos de este fragmento     //todo conectar los componentes del fragment a los objetos correspondientes, osea el id del componente del layout

        mGuardar_cambios_boton_perfil_cliente_frag = view.findViewById(R.id.guardar_cambios_boton_perfil_cliente_frag);
        mImagenPerfilCliente = view.findViewById(R.id.imagen_perfil_cliente_frag);
        mNombre_usuario_perfil_cliente_frag = view.findViewById(R.id.nombre_usuario_perfil_cliente_frag);
        mNombre_perfil_cliente_frag = view.findViewById(R.id.nombre_perfil_cliente_frag);

        mApellido_perfil_cliente_frag = view.findViewById(R.id.apellido_perfil_cliente_frag);
        mDireccion_perfil_cliente_frag = view.findViewById(R.id.direccion_perfil_cliente_frag);
        mEmail_perfil_cliente_frag = view.findViewById(R.id.email_perfil_cliente_frag);
        mContrasena_perfil_cliente_frag = view.findViewById(R.id.contrasena_perfil_cliente_frag);

        mGuardar_cambios_boton_perfil_cliente_frag.setOnLikeListener(this);

        init();             //Inicializa carga la infromación a los componentes.
        return view;
    }

    //Se inicializa, o sea se carga toda la info del Producto en el layout
    private void init(){
        Log.d(TAG, "init: Initializing" + getString(R.string.tag_user_fragment_perfil));    //todo: cambiar todo con lo del

        //Si el producto no es null, osea no le llegó el produto del fragment anterior
        if (mCliente !=null){ //Si le llegó el Producto
            //!!! Acá le pone la imagen pero en este caso, no hay que hacerlo, ver ejemplo en lo de productos
            Glide.with(getActivity())
                    .load(mCliente.getImagenPerfilCliente())
                    .into(mImagenPerfilCliente);   //Le pone la imagen


            mNombre_usuario_perfil_cliente_frag.setText(mCliente.getNombreUsuario());
            mNombre_perfil_cliente_frag.setText(mCliente.getNombre());

            mApellido_perfil_cliente_frag.setText(mCliente.getApellido());
            mDireccion_perfil_cliente_frag.setText(mCliente.getDireccion());
            mEmail_perfil_cliente_frag.setText(mCliente.getEmail());
            mContrasena_perfil_cliente_frag.setText(mCliente.getContrasena());
        }
    }

    @Override
    public void liked(LikeButton likeButton) {
        Log.d(TAG, "liked: Información del Cliente Actualizada");
    }

    @Override
    public void unLiked(LikeButton likeButton) {
        Log.d(TAG, "unLiked: Información del Cliente Actualizada");
    }
}