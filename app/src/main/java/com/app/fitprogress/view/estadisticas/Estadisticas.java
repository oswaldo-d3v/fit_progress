package com.app.fitprogress.view.estadisticas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.fitprogress.R;
import com.app.fitprogress.model.Actividad;
import com.app.fitprogress.presenter.estadisticas.Fecha;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.datepicker.MaterialDatePicker;

public class Estadisticas extends AppCompatActivity {

  Dialogos dialogos = new Dialogos();
  Fecha fecha = Fecha.getInstance();
  Button fechaEtiqueta;
  ChipGroup filtro;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.actividad_estadisticas);
    Actividad base = (Actividad) getIntent().getExtras().getSerializable("actividad");

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setElevation(0);
    this.setTitle(base.getNombre());

    fechaEtiqueta = findViewById(R.id.btn_fecha);
    filtro = (ChipGroup) findViewById(R.id.grupo_filtros);

    actualizarInterfaz();
    filtro.setOnCheckedChangeListener((grupo, id) -> actualizarInterfaz());
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_actividad_estadisticas, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    switch (item.getItemId()) {
      case R.id.actualizar_nombre:
        Toast.makeText(this, R.string.renombrar_actividad, Toast.LENGTH_SHORT).show();
        return true;
      case R.id.actualizar_unidad:
        Toast.makeText(this, R.string.renombrar_unidad, Toast.LENGTH_SHORT).show();
        return true;
      case R.id.eliminar_actividad:
        Toast.makeText(this, R.string.eliminar_actividad, Toast.LENGTH_SHORT).show();
        return true;
      default:
        finish();
        return false;
    }
  }

  public void seleccionarFecha(View v) {
    switch (filtro.getCheckedChipId()) {
      case R.id.filtro_dia:
        showDatePicker();
        break;
      case R.id.filtro_rango:
        showDataRangePicker();
        break;
    }
  }

  private void showDatePicker() {
    MaterialDatePicker<Long> dialogo = dialogos.showDialogDataPicker(s -> {
      fecha.setFecha(Long.parseLong(s.toString()));
      actualizarInterfaz();
    });
    dialogo.show(getSupportFragmentManager(), "DATAPICKER");
  }

  private void showDataRangePicker() {
    MaterialDatePicker<Pair<Long, Long>> dialogo = dialogos.showDialogDataRangePicker(s -> {
      Pair<Long, Long> rango = (Pair<Long, Long>) s;
      fecha.setFechaRango(rango);
      actualizarInterfaz();
    });
    dialogo.show(getSupportFragmentManager(), "DATARANGEPICKER");
  }

  public void actualizarInterfaz() {
    actualizarEtiquetaFecha();
    // llamar actualizar graficas y estadisticas
  }

  private void actualizarEtiquetaFecha() {
    switch (filtro.getCheckedChipId()) {
      case R.id.filtro_dia:
        fechaEtiqueta.setText(fecha.getFechaView());
        break;
      case R.id.filtro_rango:
        fechaEtiqueta.setText(fecha.getFechaRangoView());
        break;
    }
  }
}