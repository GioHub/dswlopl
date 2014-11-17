package com.appapachofertil;


import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import android.support.v4.app.NotificationCompat;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class LogIn extends Activity implements OnClickListener {

	private ImageButton ib;
	 private Calendar cal;
	 private int day;
	 private int month;
	 private int year;
	 private EditText et;
	Button aceptar;
	EditText nombre,correo;
	private Switch opciones;
	private Spinner spinner1;
	 private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

		private GoogleCloudMessaging gcm = null;
		
		private String SENDER_ID = "1091839697145";
		private String regid;
		String value,date;
		String page;
		String str="";
		Button nuevo;
	public LogIn(){}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log_in);
		ActionBar action=this.getActionBar();
    	action.hide();
    	this.setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
   
    	
    	
    	TextView priv = (TextView)findViewById(R.id.priv);
    	TextView acerca = (TextView)findViewById(R.id.acerc);
    	
    	Typeface typeFace = Typeface.createFromAsset(getAssets(),"NeutraText LightAlt.ttf" );
    	          priv.setTypeface(typeFace);
    	          acerca.setTypeface(typeFace);
    	    priv.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
			        AlertDialog alertDialog1 = new AlertDialog.Builder(
		                    LogIn.this).create();
		 
		            // Setting Dialog Title
		            alertDialog1.setTitle("Aviso");
		            
		        
		            
		            // Setting Dialog Message
		            alertDialog1.setMessage("AVISO DE PRIVACIDAD La protección de sus datos personales es de suma importancia para María del Carmen Dorotea Martínez Jover; este AVISO DE PRIVACIDAD es en cumplimiento a la LEY FEDERAL DE PROTECCIÓN DE DATOS PERSONALES EN POSESIÓN DE LOS PARTICULARES, y tiene como fin informarle el tipo de datos personales que recabamos de Usted, cómo los usamos, manejamos y aprovechamos, y con quién los compartimos.Con base en la LEY FEDERAL DE PROTECCIÓN DE DATOS PERSONALES EN POSESIÓN DE PARTICULARES, María del Carmen Dorotea Martínez Jover, reconoce que la privacidad y la seguridad de su información personal es un derecho humano importante para usted, por lo cual estamos comprometidos a resguardar su información personal con los más altos niveles de seguridad legal, tecnológica y administrativa. No venderemos, alquilaremos, compartiremos ni divulgaremos su información personal a terceros.De acuerdo a lo anterior, el presente AVISO DE PRIVACIDAD se aplica a toda la información, incluyendo la información personal recopilada por María del Carmen Dorotea Martínez Jover, y su personal, así como de terceros con los que celebremos o tengamos relación contractual, a efecto de brindarle servicios personalizados, contando siempre con los más altos niveles de seguridad exigidos por ley. Por lo antes mencionado, y al momento de leer el presente AVISO DE PRIVACIDAD, usted otorga su consentimiento a María del Carmen Dorotea Martínez Jover, para recopilar y utilizar sus datos personales para los fines que más adelante se especifican DATOS PERSONALES QUE DE USTED RECABAMOS Como cliente de nuestros servicios, podemos solicitarle información personal, relativa a su nombre, su dirección, su fecha y lugar de nacimiento, su estado civil, su ocupación, su RFC, su correo electrónico y número telefónico; ciertos datos patrimoniales como números de sus cuentas bancarias, comprobantes oficiales que acrediten su identidad y la información que Usted declara.USO DE SUS DATOS PERSONALES María del Carmen Dorotea Martínez Jover, recaba y usa sus datos personales para el cumplimiento de las siguientes finalidades: Proveer los servicios y productos requeridos por usted. Informar sobre cambios o nuevos productos o servicios que estén relacionados con el contratado o adquirido por el cliente. Dar cumplimiento a obligaciones contraídas con nuestros clientes. Evaluar la calidad del servicio, y realizar estudios internos sobre hábitos de consumo.Si usted no manifiesta su oposición para que sus datos personales sean transferidos, se entenderá que ha otorgado su consentimiento para ello.□ No consiento que mis datos personales sean transferidos en los términos que señala el presente aviso de privacidad.LIMITACIÓN DEL USO O DE LA DIVULGACIÓN DE SU INFORMACIÓN PERSONAL Usted puede limitar el uso y divulgación de su información personal: (i) presentando su solicitud personalmente en nuestro domicilio dirigida a María del Carmen Dorotea Martínez Jover, persona encargada de la privacidad de sus datos personales; (ii) enviando correo electrónico a la siguiente dirección electrónica: carmen@carmenmartinezjover.com. Es importante mencionar que no puede limitarse el uso o divulgación de su información personal, cuando sea necesario dar cumplimiento a obligaciones legales o a solicitudes de autoridades competentes.ACCESO, RECTIFICACIÓN, CANCELACIÓN U OPOSICIÓN AL TRATAMIENTO DE SUS DATOS PERSONALES El ejercicio de los derechos de acceso, rectificación, cancelación y oposición o la revocación del consentimiento para el uso de sus datos personales, podrá efectuarse presentado una solicitud por escrito en nuestro domicilio dirigida a María del Carmen Dorotea Martínez Jover, vía correo electrónico a carmen@carmenmartinezjover.com. CAMBIOS AL PRESENTE AVISO DE PRIVACIDAD El presente AVISO DE PRIVACIDAD puede modificarse, cambiarse o actualizarse, por lo que nos comprometemos a mantenerlo.CONTACTO Si usted tiene alguna duda sobre el presente AVISO DE PRIVACIDAD, puede escribirnos a la dirección electrónica carmen@carmenmartinezjover.com, o a la dirección Mariano Escobedo 353A, Col. Chapultepec Morales, 11570 en México, D.F.");
		 
		            // Setting Icon to Dialog
		            //alertDialog1.setIcon(R.drawable.appicon);
		 
		            // Setting OK Button
		            alertDialog1.setButton("Acepto", new DialogInterface.OnClickListener() {
		 
		                public void onClick(DialogInterface dialog, int which) {
		                    // Write your code here to execute after dialog
		                    // closed
		                    Toast.makeText(getApplicationContext(),
		                            "", Toast.LENGTH_SHORT).show();
		                }
		            });
		 
		            // Showing Alert Message	
		            alertDialog1.show();
		        
				}
			});

      acerca.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			AlertDialog alertDialog1 = new AlertDialog.Builder(
                    LogIn.this).create();
 
            // Setting Dialog Title
            alertDialog1.setTitle("Acerca de");
            
        
            
            // Setting Dialog Message
            alertDialog1.setMessage("Esta aplicación fue diseñada y programada por el equipo de ZMERCA MERCADO DE IDEAS SA DE CV" +"\n"
            		+ "Armonízate pre tratamiento"
            		+"Ideal para que te relajes antes un tratamiento de fertilidad" +"\n"
            		+ "Autora, Guión, Voz: Carmen Martínez Jover"
            		+"\n" +"Música:  André Espinoza del Toro"
            		+"\n" +"Diseño sonoro: Aarón Trejo González"
            		
                    +"\n" +"Iluminando mi interior" +
                    "\t" +"Un hermoso audio que te ayuda a amarte a ti misma"
                    +"\n" +"Autora, Guión, Voz: Carmen Martínez Jover"
                    +"\n" +"Música y diseño sonoro: Aarón Trejo González"
            		
                    +"\n" +"¿Fue negativo? ¡Re-Armonizate!"
            		+"\n" +"Ayuda a levantarte después del duro golpe de un resultado negativo de embarazo"
            		+"\n" +"Autora, Guión, Voz: Carmen Martínez Jover"
            		+"\n" +"Música:  André Espinoza del Toro"
            		+"\n" +"Diseño sonoro: Aarón Trejo González"
            		
                    +"\n" +"Alcanzando mis sueños"
                    +"\n" +"Te ayuda a visualizar, quitar bloqueos para llegar a tus metas y alcanzar sueños"
                    +"\n" +"Autora, Guión, Voz: Carmen Martínez Jover"
                    +"\n" +"Música:  André Espinoza del Toro"
                    +"\n" +"Diseño sonoro: Aarón Trejo González");
 
            // Setting Icon to Dialog
            //alertDialog1.setIcon(R.drawable.appicon);
 
            // Setting OK Button
            alertDialog1.setButton("Aceptar", new DialogInterface.OnClickListener() {
 
                public void onClick(DialogInterface dialog, int which) {
                 
                }
            });
 
            // Showing Alert Message	
            alertDialog1.show();
		}
	});	
    	    
    	    
		nombre = (EditText) findViewById(R.id.editText1);
		        value = nombre.getText().toString();
		   aceptar= (Button) findViewById(R.id.button1);
	         opciones = (Switch)findViewById(R.id.switch2);
		 spinner1 = (Spinner) findViewById(R.id.spinner1);
		 
	        List<String> list = new ArrayList<String>();

	        list.add("Alemania");
	        list.add("Argentina");
	        list.add("Australia");
	        list.add("Belgica");	
	        list.add("Brazil");	
	        list.add("Bulgaria");	
	        list.add("Canada");
	        list.add("Chile");	
	        list.add("Colombia");
	        list.add("Dinamarca");
	        list.add("Estados Unidos");
	        list.add("España");
	        list.add("Finlandia");
	        list.add("Francia");
	        list.add("Grecia");
	        list.add("Holanda");
	        list.add("Hungaria");
	        list.add("India");
	        list.add("Irlanda");
	        list.add("Islandia");
	        list.add("Israel");
	        list.add("Italia");
	        list.add("Japón");
	        list.add("Kenya");
	        list.add("México");
	        list.add("Nigeria");
	        list.add("Noruega");
	        list.add("Nueva Zelanda");
	        list.add("Portugal");
	        list.add("Reino Unido");
	        list.add("Sudafrica");
	        list.add("Suecia");
	        list.add("Turquia");
	        list.add("Ucrania");
	        list.add("Uganda");
	        list.add("Uruguay");
	        list.add("Zambia");
	        list.add("Zimbabwe");
	        
	        
	        
             
	        	        ib = (ImageButton) findViewById(R.id.imageButton1);
	        cal = Calendar.getInstance();
	        day = cal.get(Calendar.DAY_OF_MONTH);
	        month = cal.get(Calendar.MONTH);
	        year = cal.get(Calendar.YEAR);
	        
	    	 SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy ");
	    	 
	    	 
	    	 
	    	 System.out.println(sf);
	    	
	    	 if(sf.equals(date)){
	    		 
	    		 System.out.println(R.string.cumpleanos);
                 	    		 
	    		 
	    	 }else{
	    		 System.out.println("Nada");
	    	 }
	        et = (EditText) findViewById(R.id.editText3);
	           date = et.getText().toString();
	           
	        ib.setOnClickListener(this);
	         aceptar.setOnClickListener(new OnClickListener(){
                 
					@Override
					public void onClick(View v) {
						Intent a = new Intent(LogIn.this,MainActivity.class);
					startActivity(a);
					Toast.makeText(getApplication(), "Bienvanida" + "\n"+ value , Toast.LENGTH_LONG).show();
					System.out.println(date);
            // Status();
					
					  NotificationCompat.Builder notificacion = new NotificationCompat.Builder(LogIn.this);
//					     // Personalizacion
					        notificacion.setSmallIcon(R.drawable.notification); // Icono pequeno superior
					        notificacion.setTicker("Felicidades"); // Mensaje cuando aparece
					        notificacion.setWhen(System.currentTimeMillis()); // Hora que mostramos en la notificacion
					        notificacion.setContentTitle("Appapacho Fértil");
					        notificacion.setContentText("Usted esta registrado en Appapacho Fértil y recibirá una notificación diaria!");
					        notificacion.setContentInfo("Afirmaciones Diarias"); // Informacion breve-extra
					        Uri sonido = RingtoneManager.getDefaultUri(Notification.DEFAULT_SOUND);
					        notificacion.setSound(sonido);
//					        
//					     // Creamos la notificacion (tenemos un objeto Notification.Builder)
					        Notification n = notificacion.build();
//					         
//					        // Llamo al Manager de notificaciones y le mando mi notificacion con un ID.
					        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
					        nm.notify(1, n);
//					        
					        PendingIntent myPendingIntent;
					        Intent myIntent = new Intent();
					         Context myContext = getApplicationContext(); // Actual Activity
//					         
					        myIntent.setClass(myContext,AfirmacionesFragment.class); // Intent para invocar luego el Activity
					        myIntent.putExtra("ID", 1); // Mismo ID que la notificacion para luego borrar la notificacion de la barra superior
					        myPendingIntent = PendingIntent.getActivity(myContext, 0, myIntent, 0); // Intent pendiente de invocar
					        notificacion.setContentIntent(myPendingIntent); // Lo asignamos
					        notificacion.setDeleteIntent(myPendingIntent);
					    
					       
					}
		        	 
		         });
	        /*COMENTED if( checkPlayServices(LogIn.this) == true ){
				getReigstrationId(LogIn.this);
			}*/
	        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
	                     (this, android.R.layout.simple_spinner_item,list);
	                      
	        dataAdapter.setDropDownViewResource
	                     (android.R.layout.simple_spinner_dropdown_item);
	                      
	        spinner1.setAdapter(dataAdapter);
	         
	        // Spinner item selection Listener  
	        addListenerOnSpinnerItemSelection();
	         
	        // Button click Listener 
	        //addListenerOnButton();
	         
	 
	    }
	 

	public void getReigstrationId(final Context context){
		new AsyncTask<Void, Void, Void>(){

			private String msg;
			
			@Override
			protected Void doInBackground(Void... arg0) {
				
				if (gcm == null) {
	                gcm = GoogleCloudMessaging.getInstance(context);
	            }
	            
	            try {
	            	Log.i("Sender",SENDER_ID);
	            	
					regid = gcm.register(SENDER_ID);
					
					msg = "Registrado" + regid;
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				return null;
			}

			@Override
			protected void onPostExecute(Void result) {
				
				Log.i("Developer",msg);
				//Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
			}
		}.execute();
	}
	public static boolean checkPlayServices(Context context) {
	    int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
	    if (resultCode != ConnectionResult.SUCCESS) {
	        if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
	            GooglePlayServicesUtil.getErrorDialog(resultCode, (Activity) context,PLAY_SERVICES_RESOLUTION_REQUEST).show();
	        } else {
	            Log.i("Developer", "This device is not supported.");
	        }
	        return false;
	    }
	    return true;
	}
	
	    // Add spinner data
	     
	    public void addListenerOnSpinnerItemSelection(){
	         
	                spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());

		         opciones.setOnCheckedChangeListener(new OnCheckedChangeListener() {

		        	 @Override
		        	 public void onCheckedChanged(CompoundButton buttonView,
		        	 boolean isChecked) {

		        	 if (isChecked) {

		        	 Toast.makeText(getApplicationContext(), "The switch is ON",
		        	 Toast.LENGTH_SHORT).show();

		        	 
		        	 } else {

		        	 Toast.makeText(getApplicationContext(),
		        	 "The switch is OFF", Toast.LENGTH_SHORT).show();
		        	 }

		        	 }
		        	 });

		        	 
		         opciones.setChecked(true);
	
		         loadSavedPreferences();
		     }

		     private void loadSavedPreferences() {
		         SharedPreferences sharedPreferences = PreferenceManager
		                 .getDefaultSharedPreferences(this);

		        // boolean checkBoxValue = sharedPreferences.getBoolean("CheckBox_Value", false);
		         String name = sharedPreferences.getString("storedName", "Usuario");

		     
		         nombre.setText(name);
		     }

		     private void savePreferences(String key, boolean value) {
		         SharedPreferences sharedPreferences = PreferenceManager
		                 .getDefaultSharedPreferences(this);
		         Editor editor = sharedPreferences.edit();
		         editor.putBoolean(key, value);
		         editor.commit();
		     }
		     private void savePreferences(String key, String value) {
		         SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		         Editor editor = sharedPreferences.edit();
		         editor.putString(key, value);
		         editor.commit();
		     }


		     @Override
		     public void onClick(View v) {
		      showDialog(0);
		     }
		     
		     @Override
		     @Deprecated
		     protected Dialog onCreateDialog(int id) {
		      return new DatePickerDialog(this, datePickerListener, year, month, day);
		      
		     }

		     private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
		      public void onDateSet(DatePicker view, int selectedYear,
		        int selectedMonth, int selectedDay) {
		       et.setText(selectedDay + " / " + (selectedMonth + 1) + " / "
		         + selectedYear);
		      }
		     };
		     
//		 public void Status(){
//			 if( value.equals(value)){
//				 
//				 Intent i = new Intent(LogIn.this,AfirmacionesFragment.class);
//				 
//				  startActivity(i);
//					 
//				 
//				 
//			 }
//		 }
		 
		 }
