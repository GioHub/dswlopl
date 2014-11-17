package com.appapachofertil;


import java.util.Calendar;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.TextView;


public class Evento extends Activity {

	Button btm_Salvar;
    TextView titulo, descripcion;
   DatePicker fecha;
   int Dia, Mes, Anio;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      
      ActionBar action= getActionBar();
  	action.hide();
  	
      setContentView(R.layout.evento);
      // Obtener fecha actual
      Calendar hoy = Calendar.getInstance();
      // inicializar datepicker
      fecha = (DatePicker) findViewById(R.id.datePicker1);
      fecha.init(hoy.get(Calendar.YEAR), hoy.get(Calendar.MONTH), hoy.get(Calendar.DAY_OF_MONTH), new OnDateChangedListener() {
         @Override
         public void onDateChanged(DatePicker arg0, int arg1, int arg2, int arg3) {
            Anio = arg1;
            Mes = arg2;
            Dia = arg3;
            System.out.println("***" + Anio + "-" + Mes + "-" + Dia + "***");
         }
      });
      fecha.setCalendarViewShown(false);
      fecha.setSpinnersShown(true);
      titulo = (EditText) findViewById(R.id.txt_titulo);
      
      Typeface typeFace = Typeface.createFromAsset(getAssets(),"NeutraText LightAlt.ttf" );
      titulo.setTypeface(typeFace);
      
      descripcion = (EditText) findViewById(R.id.txt_descripcion);
      
     // Typeface typeFace = Typeface.createFromAsset(getAssets(),"NeutraText LightAlt.ttf" );
      descripcion.setTypeface(typeFace);
      
      btm_Salvar = (Button) findViewById(R.id.button1);
      btm_Salvar.setOnClickListener(new OnClickListener() {
         @Override
         public void onClick(View arg0) {
            Calendar evento = Calendar.getInstance();
            evento.set(Anio, Mes, Dia);
            Intent intent = new Intent(Intent.ACTION_INSERT)
               .setData(Events.CONTENT_URI)
               .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, evento.getTimeInMillis())
               .putExtra(Events.TITLE, titulo.getText().toString())
               .putExtra(Events.DESCRIPTION, descripcion.getText().toString());
               
        
            
            startActivity(intent);
         }
      });
   }
}
