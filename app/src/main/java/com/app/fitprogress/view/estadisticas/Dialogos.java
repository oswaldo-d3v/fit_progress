package com.app.fitprogress.view.estadisticas;

import android.widget.Toast;

import androidx.core.util.Pair;
import androidx.fragment.app.DialogFragment;

import com.app.fitprogress.R;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class Dialogos extends DialogFragment {

  public MaterialDatePicker<Long> showDialogDataPicker(MaterialPickerOnPositiveButtonClickListener accion) {
    MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
    builder.setTitleText(R.string.seleciona_fecha);
    final MaterialDatePicker<Long> datePicker = builder.build();
    datePicker.addOnPositiveButtonClickListener(accion);
    return datePicker;
  }

  public MaterialDatePicker<Pair<Long, Long>> showDialogDataRangePicker(MaterialPickerOnPositiveButtonClickListener accion){
    MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker();
    builder.setTitleText(R.string.seleciona_fecha);
    final MaterialDatePicker dateRangePicker = builder.build();
    dateRangePicker.addOnPositiveButtonClickListener(accion);
    return dateRangePicker;
  }
}
