package com.example.repasandoexamenfinal.dialogo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.repasandoexamenfinal.R;
import com.example.repasandoexamenfinal.utils.Inventario;

import java.util.zip.Inflater;

public class DialogoAyuda extends DialogFragment {


    TextView texto;
    Inventario detallePerso;
    View view;

    public static DialogoAyuda newInstance(Inventario inventario) {
        Bundle args = new Bundle();
        args.putSerializable("key",inventario);
        DialogoAyuda fragment = new DialogoAyuda();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        detallePerso = (Inventario) this.getArguments().getSerializable("key");

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        view = LayoutInflater.from(getContext()).inflate(R.layout.dialogo_ayuda,null);
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        texto = getView().findViewById(R.id.textoNombre);
        texto.setText(detallePerso.getPrecio());
    }
}
