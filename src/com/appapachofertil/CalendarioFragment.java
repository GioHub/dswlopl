package com.appapachofertil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import android.R.string;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.provider.CalendarContract.Events;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CalendarView.OnDateChangeListener;

public class CalendarioFragment extends Fragment {

	
	 public CalendarioFragment(){}
	 private Button btnadd;
	 public Calendar month;
	 public Calendar day;
		public CalendarAdapter adapter;
		public Handler handler;
		public ArrayList<String> items; 
		public TextView desc,info;
	
		 @Override
		    public View onCreateView(LayoutInflater inflater, ViewGroup container,
		            Bundle savedInstanceState) {
			 getActivity().setRequestedOrientation(
		                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		        View rootView = inflater.inflate(R.layout.calendario, container, false);
		        month = Calendar.getInstance();
		        day = Calendar.getInstance();
		
//		        
		       
	
		        
		    
	
		           
		        TextView textView = (TextView)rootView.findViewById(R.id.textView2);
		        
//		        textView.setText(Events.DESCRIPTION);
		        
		        TextView hora1 = (TextView)rootView.findViewById(R.id.hora1);
		        TextView hora2 = (TextView)rootView.findViewById(R.id.hora2);
//		           textView.setVisibility(View.GONE);
//		           
//		           if(textView.equals("descripcion")){
//		        	   
//		        	   
//		        	   textView.setVisibility(View.VISIBLE);
//		           
//		           }
//		        Intent intent = getActivity().getIntent();
//		        String mensaje = intent.getStringExtra("description");
//		            textView.setText(mensaje);
		            
		            
		        CalendarView calendarView=(CalendarView)rootView.findViewById(R.id.calendarView1);
		        calendarView.setOnDateChangeListener(new OnDateChangeListener() {

		            @Override
		            public void onSelectedDayChange(CalendarView view, int year, int month,
		                    int dayOfMonth) {
		                 Toast.makeText(getActivity(), ""+dayOfMonth, 0).show();// TODO Auto-generated method stub
		                 Intent intent = new Intent(Intent.ACTION_EDIT);
		                 intent.setType("vnd.android.cursor.item/event");
		                 intent.putExtra("title", "Cita médica");
		                 intent.putExtra("description", "Acudir a la cita médica con el resultado de las pruebas");
		                 startActivity(Intent.createChooser(intent, "Seleccione una aplicación"));   

		            }
		        });
		        
//		  
//		     Button   btn =(Button)rootView.findViewById(R.id.btncon);
//	            btn.setOnClickListener(new OnClickListener(){
//
//					@Override
//					public void onClick(View v) {
//						// TODO Auto-generated method stub
//						Intent intent = new Intent(getActivity(), LogIn.class);
//						startActivity(intent);
//					}});
		        
		        btnadd = (Button)rootView.findViewById(R.id.btnadd);
		            btnadd.setOnClickListener(new OnClickListener(){

						@Override
						public void onClick(View v) {
						
							Intent otro = new Intent(getActivity(),Evento.class);
						    startActivity(otro);
							
						}});
	          
		        Button btnstick =(Button)rootView.findViewById(R.id.btnstick);
		              btnstick.setOnClickListener(new OnClickListener(){

						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
						
						}});
		              
		        return rootView;
		 }

		 public void refreshCalendar()
			{
				//COMENTED TextView title = (TextView)getView().findViewById(R.id.title);
				  TextView dia = (TextView)getView().findViewById(R.id.textView1);
				
				
				//adapter.refreshDays();
				adapter.notifyDataSetChanged();				
				handler.post(calendarUpdater); // generate some random calendar items				
				
				//COMENTED title.setText(android.text.format.DateFormat.format("MMMM yyyy", month));
				dia.setText(android.text.format.DateFormat.format("MMMM yyyy", month));
				
			}
			
			public void onNewIntent(Intent intent) {
				String date = intent.getStringExtra("date");
				String[] dateArr = date.split("-"); // date format is yyyy-mm-dd
				month.set(Integer.parseInt(dateArr[0]), Integer.parseInt(dateArr[1]), Integer.parseInt(dateArr[2]));
			}
			
			public Runnable calendarUpdater = new Runnable() {
				
				@Override
				public void run() {
					items.clear();
					// format random values. You can implement a dedicated class to provide real values
					for(int i=0;i<31;i++) {
						Random r = new Random();
						
						if(r.nextInt(10)>6)
						{
							items.add(Integer.toString(i));
						}
					}

					//adapter.setItems(items);
					adapter.notifyDataSetChanged();
				}
			};
	}
