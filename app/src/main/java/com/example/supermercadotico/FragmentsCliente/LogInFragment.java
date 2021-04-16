package com.example.supermercadotico.FragmentsCliente;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.supermercadotico.IClienteActivity;
import com.example.supermercadotico.R;

public class LogInFragment  extends Fragment {

    private static final String TAG = "LogInFrag";

    private IClienteActivity mInterface;

    private Context mContext;

    private EditText userEditText,passwordEditText;//TODO: Para el boton del ojo se puede tener un input text por debajo y cuando se presiona el boton entonces se hace un cambio

    private Button botonEntrar,botonRegistrarse,botonAdministrador;

    public LogInFragment(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInterface = (IClienteActivity) mContext;
        Bundle bundle = this.getArguments();
        if(bundle!=null){
            Log.d(TAG, "onCreate: Asi es");//Podria guardarse un usuario por defecto
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_client,container,false);
        botonEntrar = view.findViewById(R.id.botonEntrarInicio);
        botonRegistrarse = view.findViewById(R.id.botonRegistrarseInicio);
        botonAdministrador = view.findViewById(R.id.botonAdministradorInicio);

        botonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInterface.initUserView();
            }
        });
        return view;
    }

    private void setButton()
    {

    }
}
