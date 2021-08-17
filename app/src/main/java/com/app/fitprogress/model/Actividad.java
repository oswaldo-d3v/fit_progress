package com.app.fitprogress.model;

import java.io.Serializable;

public class Actividad implements Serializable {
  private String nombre;
  private String unidad;

  public Actividad(String nombre, String unidad) {
    this.nombre = nombre;
    this.unidad = unidad;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getUnidad() {
    return unidad;
  }

  public void setUnidad(String unidad) {
    this.unidad = unidad;
  }
}
