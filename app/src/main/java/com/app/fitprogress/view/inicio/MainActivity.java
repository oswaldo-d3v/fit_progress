package com.app.fitprogress.view.inicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.app.fitprogress.R;
import com.app.fitprogress.model.ItemLista;
import com.app.fitprogress.presenter.inicio.ActividadPrincipal;
import com.app.fitprogress.view.estadisticas.Estadisticas;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  private final ActividadPrincipal presenter = new ActividadPrincipal();
  private final ArrayList<ItemLista> actividades = presenter.getActividades();
  private RecyclerView vistaActividades;
  private int interfazActiva;

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_actividad_principal, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.agregar_actividad:
        solicitarNuevaActividad();
        return true;
      case R.id.mostrar_informacion:
        Toast.makeText(this, R.string.informacion, Toast.LENGTH_SHORT).show();
        return true;
      case R.id.salir:
        finish();
    }
    return false;
  }

  public void solicitarNuevaActividad() {
    Dialogos dialogo = new Dialogos(MainActivity.this);
    dialogo.addActividad.setPositiveButton(R.string.agregar, (dialogInterface, i) -> agregarActividad(
        ((EditText) dialogo.interfaz.findViewById(R.id.actividad_txt)).getText().toString(),
        ((EditText) dialogo.interfaz.findViewById(R.id.unidad_txt)).getText().toString())
    );
    dialogo.addActividad.show().setCancelable(false);
  }

  private void agregarActividad(String nombre, String unidad) {
//        actividades.add(presenter.agregarActividad(nombre, unidad));
    presenter.agregarActividad(nombre, unidad);
    if (interfazActiva == R.layout.actividad_main_vacia) {
      setInterfazConElementos();
    }
    actualizarVistaActividades();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (actividades.size() > 0) {
      setInterfazConElementos();
      actualizarVistaActividades();
    } else {
      setInterfazVacia();
    }
  }

  private void setInterfazConElementos() {
    interfazActiva = R.layout.actividad_main;
    setContentView(interfazActiva);
    vistaActividades = findViewById(R.id.lista_actividades_rv);
    vistaActividades.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
  }

  private void actualizarVistaActividades() {
    AdaptadorLista adaptadorLista = new AdaptadorLista(actividades);
    adaptadorLista.setOnClickListener((view) -> {
      Bundle bundle = new Bundle();
      bundle.putSerializable("actividad", actividades.get(vistaActividades.getChildAdapterPosition(view)));
      Intent intent = new Intent(MainActivity.this, Estadisticas.class);
      intent.putExtras(bundle);
      startActivity(intent);
    });
    vistaActividades.setAdapter(adaptadorLista);
  }

  private void setInterfazVacia() {
    vistaActividades = null;
    interfazActiva = R.layout.actividad_main_vacia;
    setContentView(interfazActiva);
  }
}