package com.app.fitprogress.presenter.estadisticas;

import androidx.core.util.Pair;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Fecha {
  private static Fecha fecha = null;

  public final String FECHA_USUARIO = "dd/MM/yy";
  public final String FECHA_RANGO_USUARIO = "dd/MM";
  public final String FECHA_SQL = "dd/MM/yyyyy";

  private LocalDate fechaSeleccionada;
  private LocalDate fechaInferior;
  private LocalDate fechaSuperior;

  private Fecha() {
    fechaSeleccionada = LocalDate.now();
    fechaInferior = fechaSeleccionada;
    fechaSuperior = fechaSeleccionada;
  }

  public static Fecha getInstance() {
    if (fecha == null) fecha = new Fecha();
    return fecha;
  }

  public String getFechaView() {
    return fechaFormat(fechaSeleccionada, FECHA_USUARIO);
  }

  public String getFechaRangoView() {
    return fechaFormat(fechaInferior, FECHA_RANGO_USUARIO) + " - " + fechaFormat(fechaSuperior, FECHA_RANGO_USUARIO);
  }

  private String fechaFormat(LocalDate fecha, String formato) {
    return fecha.format(DateTimeFormatter.ofPattern(formato));
  }

  public void setFecha(Long fecha) {
    this.fechaSeleccionada = Instant.ofEpochMilli(fecha).atZone(ZoneId.systemDefault()).toLocalDate();
  }

  public void setFechaRango(Pair<Long, Long> rango) {
    this.fechaInferior = Instant.ofEpochMilli(rango.first).atZone(ZoneId.systemDefault()).toLocalDate();
    this.fechaSuperior = Instant.ofEpochMilli(rango.second).atZone(ZoneId.systemDefault()).toLocalDate();
  }
}
