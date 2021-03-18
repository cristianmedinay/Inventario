package com.example.repasandoexamenfinal.fragments;

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

import com.example.repasandoexamenfinal.R;
import com.example.repasandoexamenfinal.utils.Inventario;

public class FragmentAgregar extends Fragment {

     View view;
     EditText nombre,marca,descripcion,precio,tipo;
     Button btnAgregar;
     OnAgregarSelectedInventario listener;
    Inventario agregado;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        listener = (OnAgregarSelectedInventario) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view =inflater.inflate(R.layout.fragment_agregar,container,false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        nombre= getView().findViewById(R.id.nombre);
        marca= getView().findViewById(R.id.marca);
        descripcion= getView().findViewById(R.id.descripcion);
        precio= getView().findViewById(R.id.precio);
        tipo= getView().findViewById(R.id.tipo);
        btnAgregar= getView().findViewById(R.id.btn_agregar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n1 = String.valueOf(nombre.getText());
                String n2 = marca.getText().toString();
                String n3 = descripcion.getText().toString();
                String n4 = precio.getText().toString();
                String n5 = tipo.getText().toString();
                agregado  = new Inventario(n1,n2,n3,n4,n5);
                listener.SelectedAgregarIventario(agregado);

            }
        });

    }

    public interface OnAgregarSelectedInventario{
        void SelectedAgregarIventario(Inventario inventario);
    }



}
