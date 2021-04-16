package com.example.supermercadotico.FragmentsCliente;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.supermercadotico.ClienteActivity;
import com.example.supermercadotico.IClienteActivity;
import com.example.supermercadotico.Models.Producto;
import com.example.supermercadotico.R;
import com.example.supermercadotico.Sucursal;

import java.util.ArrayList;

public class SucursalFragment extends Fragment {

    private String TAG = "SeleccionarSucursal";

    private Context mContext;

    private ArrayList<Sucursal> sucursales;

    private IClienteActivity mInterface;

    private Button botonConfirmar;

    private Spinner spinnerProvincias;

    public SucursalFragment(Context pContext) {
        mContext = pContext;
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
        View view = inflater.inflate(R.layout.fragment_seleccion_sucursal,container,false);
        setBotones(view);
        setSpinnerProvincias(view);
        return view;
    }

    public void setBotones(View view)
    {
        botonConfirmar = view.findViewById(R.id.botonConfirmarSeleccionSucursal);
        botonConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInterface.initUserView();
            }
        });
    }

    public void setSpinnerProvincias(View view)
    {
        Log.d("Y la mierda","Ylaslallas");
        spinnerProvincias = view.findViewById(R.id.spinnerSucursal);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(mContext,
                R.array.provincias_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerProvincias.setAdapter(adapter);
    }

}
