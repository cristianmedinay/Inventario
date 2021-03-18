package com.example.repasandoexamenfinal.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.repasandoexamenfinal.R;
import com.example.repasandoexamenfinal.utils.Inventario;

import java.util.ArrayList;

public class RecyclerListar extends RecyclerView.Adapter<RecyclerListar.MiHolder> {

    ArrayList<Inventario> listaIventario;
    Context context;
    OnIntentarioSelected listener;
    /*public RecyclerListar(ArrayList<Inventario> listaIventario, Context context) {
        this.listaIventario = listaIventario;
        this.context = context;
        listener = (OnIntentarioSelected) context;
    }*/

    public RecyclerListar(Context context) {
        this.listaIventario = new ArrayList<>();
        this.context = context;
        listener = (OnIntentarioSelected) context;
    }
    @NonNull
    @Override
    public RecyclerListar.MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false);
        MiHolder miHolder = new MiHolder(view);
        return miHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerListar.MiHolder holder, int position) {

        final Inventario inventario = listaIventario.get(position);
        holder.getNombre().setText(inventario.getNombre());
        holder.getMarca().setText(inventario.getMarca());
        holder.getMarca().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.SelectedIntentario(inventario);
            }
        });
    }

    public void agregarInventario(Inventario inventario){
        listaIventario.add(inventario);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listaIventario.size();
    }
    public interface OnIntentarioSelected{
        void SelectedIntentario(Inventario inventario);
    }


    public class MiHolder extends RecyclerView.ViewHolder {
        TextView nombre,marca,precio;
        public MiHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            marca = itemView.findViewById(R.id.marca);
        }

        public TextView getNombre() {
            return nombre;
        }

        public void setNombre(TextView nombre) {
            this.nombre = nombre;
        }

        public TextView getMarca() {
            return marca;
        }

        public void setMarca(TextView marca) {
            this.marca = marca;
        }
    }
}
