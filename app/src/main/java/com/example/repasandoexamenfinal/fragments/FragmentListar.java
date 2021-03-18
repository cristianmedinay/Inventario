package com.example.repasandoexamenfinal.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.repasandoexamenfinal.R;
import com.example.repasandoexamenfinal.adaptador.RecyclerListar;
import com.example.repasandoexamenfinal.utils.Inventario;

import java.util.ArrayList;

public class FragmentListar extends Fragment {

    View view;
    RecyclerListar adaptadorInvetario;
    ArrayList<Inventario> lista;
    RecyclerView recyclerView;
    Inventario detalleRecuperado;
    TextView nombre,marca;
    OnInvetarioPulsacion listener;
    Inventario inventario;

    public static FragmentListar newInstance(Inventario inventario) {
        Bundle args = new Bundle();
        args.putSerializable("lista",inventario);
        FragmentListar fragment = new FragmentListar();
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //listener = (OnInvetarioPulsacion) context;

        /*if(this.getArguments()!= null) {
            detalleRecuperado = (Inventario) this.getArguments().getSerializable("lista");
        }else{
        }
        lista = new ArrayList();*/

        adaptadorInvetario = new RecyclerListar(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       //error de no poner la lista
        view = inflater.inflate(R.layout.recylcer_listar,container,false);
        return view;
    }

    public void agregarInventarioSelected(Inventario inventarios){
        adaptadorInvetario.agregarInventario(inventarios);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = getView().findViewById(R.id.id_recycler_fragment);
        recyclerView.setAdapter(adaptadorInvetario);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
        //nombre = getView().findViewById(R.id.nombre);
        //marca= getView().findViewById(R.id.marca);

        //nombre.setText(detalleRecuperado.getNombre());
        //marca.setText(detalleRecuperado.getMarca());

        //listener.PrecioSelectedPulsacion(detalleRecuperado);

    }

    public interface OnInvetarioPulsacion{
        void PrecioSelectedPulsacion(Inventario invetario);
    }



}
