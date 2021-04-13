package com.example.supermercadotico.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.supermercadotico.R;


public class BusquedaFragment extends Fragment {

    private static final String TAG = "BusquedaFragment";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_busqueda,container, false);
        Log.d(TAG, "onCreateView: Iniciado");
       return view;
    }
}