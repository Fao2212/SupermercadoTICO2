package com.example.supermercadotico.FragmentsCliente;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.supermercadotico.ClienteActivity;
import com.example.supermercadotico.IClienteActivity;
import com.example.supermercadotico.R;
import com.example.supermercadotico.Tools.EditTextManager;
import com.example.supermercadotico.Users.Comprador;
import com.example.supermercadotico.Users.Usuario;

public class RegistrarUsuarioFragment extends Fragment {

    EditTextManager textNombre,textApellidos,textDireccion,textEmail,textUsuario,textContrasena;

    Button createUserButton; //todo: queda pendiente las verificaciones de usuario. No usuario repetidos etc...

    Context mContext;

    IClienteActivity mInterface;

    public RegistrarUsuarioFragment(Context context)
    {
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInterface = (IClienteActivity) mContext;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro_usuario,container,false);
        setButtton(view);
        setEditText(view);
        return view;
    }
    private void setButtton(View view)
    {
        createUserButton = view.findViewById(R.id.botonRegistrarseInicio);
        createUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearUsuario();
            }
        });
    }

    //Cada editTextManager tiene un booleando que me deja controlar cuales espacios se pueden borrar. Y puedo agregar metodos a la clase
    //Para los editText que estoy utilizando.
    private void setEditText(View view)
    {
        //Todo:Puedo convertir en un array para un manejo mas facil
        textNombre = new EditTextManager(view.findViewById(R.id.textNombreRegistroUsuario));
        textApellidos = new EditTextManager(view.findViewById(R.id.textApellidosRegistroUsuario));
        textDireccion = new EditTextManager(view.findViewById(R.id.textDireccionRegistroUsuario));
        textEmail = new EditTextManager(view.findViewById(R.id.textEmailRegistroUsuario));
        textUsuario = new EditTextManager(view.findViewById(R.id.textUsuarioRegistroUsuario));
        textContrasena = new EditTextManager(view.findViewById(R.id.textContrasenaRegistroUsuario));
    }

    private Usuario crearUsuario(){
        //TODO:Aqui van las condiciones de creacion. Si cumple con todo entonces puede crear el usuario
        if (notEmptySpaces() && numericValues() && validEmail()) {
            Comprador comprador = new Comprador(textNombre.getText(),textContrasena.getText(),textDireccion.getText(),textEmail.getText());
        }
        return null;
    }

    //Verificacion de que no queden espacios vacios
    private boolean notEmptySpaces(){
        return true;
    }

    //Verificacion de que los espacios con valores numericos sean nunmeros
    private boolean numericValues()
    {
        return true;
    }

    private boolean validEmail()
    {
        return true;
    }

}
