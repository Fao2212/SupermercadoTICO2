package com.example.supermercadotico.FragmentsCliente;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.supermercadotico.ClienteActivity;
import com.example.supermercadotico.IClienteActivity;
import com.example.supermercadotico.Users.Usuario;
import com.example.supermercadotico.R;
import com.like.LikeButton;
import com.like.OnLikeListener;

public class PerfilUsuarioFragment extends Fragment implements OnLikeListener {
    //Tag para los logs y saber de donde se están haciendo
    private static final String TAG = "DescrPerfilUsuariofrag";     //todo: cambiar el tag al correspondinete de la clase

    //Variables
    //Objeto donde se va a cargar la información que el cliente seleccionó del fragment pasado
    private Usuario mUsuario;                                   //todo: cambiar el objeto que se va a mostrar al objeto correspondiende
    private IClienteActivity mInterfaceClienteActivity;
    Context mContext;

    //widgets Todo: cambiar los widgets a los widgets que se van a usar en el layout de la descripción
    //Ids del layout de fragment_usuario
    private EditText mEditTextUsuarioPerfilUsuario, mEditTextNombrePerfilUsuario, mEditTextApellidoPerfilUsuario, mEditTextDireccionPerfilUsuario, mEditTextEmailPerfilUsuario, mEditTextContrasenaPerfilUsuario;  //EditText de todos los campos del producto

    public PerfilUsuarioFragment(Context context) {
        mContext = context;
    }
    //private LikeButton mConfirmar_cambios_boton__usuario_frag;   //Boton de like que hace una animación cuando se presiona ---- Cual??
    //private ImageView mImagenPerfilUsuario;      //Imagen

    //Se carga el bundle en el onCreate, por que OnCreate se ejecuta primero que OnCreate view,
    //para que cuando se busquen los componentes ya el bundle con el objeto de producto ya este cargado
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //El bundle es lo que permite que el objeto puede enviarse desde el fragmento anterior a este,
        //por eso es parcelable
        Bundle bundle = this.getArguments();
        if(bundle!=null){
            mUsuario = bundle.getParcelable(getString(R.string.intent_perfil_usuario));  //todo acá hay que ir al archivo de strings.xml y poner otro string que sea el intent correspondiente
            Log.d(TAG, "onCreate: Tengo el Usuario " + mUsuario.getNombre());  //todo: se cambia al objeto correspondiente
        }
    }

    //Acá se asignan los componentes a los objetos.. se conectan  con el layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla la vista con este fragmento
        View view = inflater.inflate(R.layout.fragment_perfil_usuario,container,false);  //todo cambiar el fragment al fragmento correspondiente
        Log.d(TAG, "onCreateView: started.");

        //Buscando los componentes y los conecta con los objetos de este fragmento     //todo conectar los componentes del fragment a los objetos correspondientes, osea el id del componente del layout

        //mConfirmar_cambios_boton__usuario_frag = view.findViewById(R.id.confirmar_cambios_boton_perfil_usuario_frag);
        //mImagenPerfilUsuario = view.findViewById(R.id.imagen_perfil_usuario_frag);
        mEditTextUsuarioPerfilUsuario = view.findViewById(R.id.editTextUsuarioPerfilUsuario);
        mEditTextNombrePerfilUsuario = view.findViewById(R.id.editTextNombrePerfilUsuario);

        mEditTextApellidoPerfilUsuario = view.findViewById(R.id.editTextApellidoPerfilUsuario);
        mEditTextDireccionPerfilUsuario = view.findViewById(R.id.editTextDireccionPerfilUsuario);
        mEditTextEmailPerfilUsuario = view.findViewById(R.id.editTextEmailPerfilUsuario);
        mEditTextContrasenaPerfilUsuario = view.findViewById(R.id.editTextContrasenaPerfilUsuario);

        //mConfirmar_cambios_boton__usuario_frag.setOnLikeListener(this);

        init();             //Inicializa carga la infromación a los componentes.
        return view;
    }

    //Se inicializa, o sea se carga toda la info del Producto en el layout
    private void init(){
        Log.d(TAG, "init: Initializing" + getString(R.string.tag_user_fragment_perfil));    //todo: cambiar todo con lo del

        //Si el producto no es null, osea no le llegó el produto del fragment anterior
        if (mUsuario !=null){ //Si le llegó el Producto
            //!!! Acá le pone la imagen pero en este caso, no hay que hacerlo, ver ejemplo en lo de productos
            Glide.with(getActivity());
                    //.load(mUsuario.getImagenUsuario()) //Tiene imagen?
                    //.into(mImagenPerfilUsuario);   //Le pone la imagen


            mEditTextUsuarioPerfilUsuario.setText(mUsuario.getNombre());
            mEditTextNombrePerfilUsuario.setText(mUsuario.getNombre()); // Se repite con lo anterior?

            //mEditTextApellidoPerfilUsuario.setText(mUsuario.getApellido()); // Falta el metodo en la clase?
            mEditTextDireccionPerfilUsuario.setText(mUsuario.getDireccion());
            //mEditTextEmailPerfilUsuario.setText(mUsuario.getEmail()); // Falta el metodo en la clase?
            //mEditTextContrasenaPerfilUsuario.setText(mUsuario.getContrasena()); // Falta el metodo en la clase?
        }
    }

    @Override
    public void liked(LikeButton likeButton) {
        Log.d(TAG, "liked: Información del Usuario Actualizada");
    }

    @Override
    public void unLiked(LikeButton likeButton) {
        Log.d(TAG, "unLiked: Información del Usuario Actualizada");
    }
}
