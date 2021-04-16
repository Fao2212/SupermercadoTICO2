package com.example.supermercadotico.FragmentsCliente;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.supermercadotico.ClienteActivity;
import com.example.supermercadotico.R;

public class RegistrarUsuarioFragment extends Fragment {
    public RegistrarUsuarioFragment(ClienteActivity clienteActivity) {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro_usuario,container,false);
        return view;
    }
}
