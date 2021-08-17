package com.app.fitprogress.view.inicio;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.app.fitprogress.R;

public class Dialogos {

  AlertDialog.Builder addActividad;
  View interfaz;

  public Dialogos(MainActivity mainActivity) {
    addActividad = new AlertDialog.Builder(mainActivity);
    addActividad.setTitle(R.string.agregar_actividad);

    LayoutInflater layoutInflater = mainActivity.getLayoutInflater();
    interfaz = layoutInflater.inflate(R.layout.dialogo_agregar_actividad, null);
    addActividad.setView(interfaz);

    addActividad.setNegativeButton(R.string.cancelar, (dialogInterface, i) -> dialogInterface.dismiss());
  }
}
