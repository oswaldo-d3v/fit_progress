package com.app.fitprogress.model;

import java.io.Serializable;

public class ItemLista extends Actividad implements Serializable {
    private int id;
    private int frecuencia;

    public ItemLista(int id, String nombre, String unidad, int frecuencia) {
        super(nombre, unidad);
        this.id = id;
        this.frecuencia = frecuencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }
}
