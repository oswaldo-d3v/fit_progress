package com.app.fitprogress.view.inicio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.fitprogress.R;
import com.app.fitprogress.model.ItemLista;

import java.util.ArrayList;

public class AdaptadorLista extends RecyclerView.Adapter<AdaptadorLista.Elemento> implements View.OnClickListener {

    ArrayList<ItemLista> items;
    private View.OnClickListener escuchante;

    public AdaptadorLista(ArrayList<ItemLista> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public Elemento onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View plantilla = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, null, false);
        plantilla.setOnClickListener(this);
        return new Elemento(plantilla);
    }

    @Override
    public void onBindViewHolder(@NonNull Elemento holder, int position) {
        holder.setContenido(items.get(position));
        holder.botonAgregarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(), "Clase: AdaptadorLista", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onClick(View view) {
        if (escuchante != null) {
            escuchante.onClick(view);
        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.escuchante = listener;
    }

    public class Elemento extends RecyclerView.ViewHolder {
        private Button botonAgregarRegistro;
        private TextView nombreActividad;
        private TextView informacionActividad;
        public ItemLista contenido;

        public Elemento(@NonNull View itemView) {
            super(itemView);
            nombreActividad = itemView.findViewById(R.id.nombre_actividad_txt);
            informacionActividad = itemView.findViewById(R.id.informacion_actividad_txt);
            botonAgregarRegistro = itemView.findViewById(R.id.agregar_actividad_btn);
        }

        public void setContenido(ItemLista item) {
            String informacion = item.getFrecuencia() + " " + item.getUnidad();
            contenido = item;
            nombreActividad.setText(item.getNombre());
            informacionActividad.setText(informacion);
        }
    }
}
