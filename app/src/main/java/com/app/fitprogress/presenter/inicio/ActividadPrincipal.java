package com.app.fitprogress.presenter.inicio;

import com.app.fitprogress.model.ItemLista;

import java.util.ArrayList;

public class ActividadPrincipal {
    int id = 0;
    private ArrayList<ItemLista> elementos = new ArrayList<ItemLista>();

    public ArrayList<ItemLista> getActividades() {
        return elementos;
    }

    public ItemLista agregarActividad(String nombre, String unidad){
        ItemLista nuevaActividad = new ItemLista(id, nombre, unidad, 0);
        elementos.add(nuevaActividad);
        id++;
        return nuevaActividad;
    }

    public ActividadPrincipal() {
        elementos.add(new ItemLista(1, "Fondos", "Repeticiones", 25));
    }
}
