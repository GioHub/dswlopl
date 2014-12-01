package com.appapachofertil;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONArray;
import com.appapachofertil.CalendarView.OnDispatchDateSelectListener;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;




public class HomeFragment extends Fragment implements OnDispatchDateSelectListener{

	
	
	 public HomeFragment(){}
	private Button btn;
	private Button btn3;
	private Button btn4;
	private Button btn5;
	 private TextView mTextView;
	 Activity context;
	 String text;
	String url="http://www.androidtoppers.com/VolleyExample/ws_API/get_array.php";
	private TextView 			mTextDate;
	private SimpleDateFormat 	mFormat;
	 public Calendar month;
		public CalendarAdapter adapter;
		public Handler handler;
		public ArrayList<String> items;
	
	
		
	
  
		@SuppressLint("SimpleDateFormat")
		@Override
	    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	  
	    	ActionBar action=getActivity().getActionBar();
	    	action.setDisplayHomeAsUpEnabled(true);

	    	//action.setCustomView(R.id.action_bar);
	    	
	    	getActivity().setRequestedOrientation(
	                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	            
	        View rootView = inflater.inflate(R.layout.home, container, false);
	        mTextView = (TextView)rootView.findViewById(R.id.textView4);
	        
	        mTextView.setOnClickListener(new OnClickListener() {

	        	            @Override
	        	            public void onClick(View view) {
	        	            	AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
	        	    		    View viewdialog = inflater.inflate(R.layout.dialog, null, false);
	        	    		    alertDialog.setView(viewdialog);
	        	    		    final TextView diag = (TextView)viewdialog.findViewById(R.id.diag);
	        	    		    String prev = "";
	        	    		    if(mTextView.getText().length()>30)
	        	    		    {
	        	    		    	prev = ((String) mTextView.getText()).substring(0, 31) + "-\n";
	        	    		    	prev += ((String) mTextView.getText()).substring(31, 55) + "...";
	        	    		    }
	        	    		    else{
	        	    		    	prev = (String) mTextView.getText();
	        	    		    }
	        	    		    diag.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
	        	    		    diag.setText(prev);
	        	    		    alertDialog.setPositiveButton("Cancelar", new DialogInterface.OnClickListener() {
	        	    	            public void onClick(DialogInterface dialog,int which) {
	        	    	            }
	        	    	        });
	        	    	        alertDialog.setNegativeButton("Compartir", new DialogInterface.OnClickListener() {
	        	    	            public void onClick(DialogInterface dialog, int which) {
	        	    	    		Intent intent = new Intent(android.content.Intent.ACTION_SEND);
	        	    				intent.setType("image/*");
	        	    				intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "asunto");
	        	    				intent.putExtra(Intent.EXTRA_TEXT, ((String)mTextView.getText()));
	        	    				startActivity(Intent.createChooser(intent, "Compartir usando"));
	        	    	
	        	            
	        	    	            dialog.cancel();
	        	    	            }
	        	    	        });
	        	    	 
	        	    	        // Showing Alert Message
	        	    	        alertDialog.show();
	        	            }
	        	        });

	        
	
	                    //mTextView.setText("Mos");//item.getDesc
	             
	        mFormat = new SimpleDateFormat("EEEE d MMMM yyyy");
	  
//	            if(event != null){
//	            	
//	            }
//	        
	        ((CalendarView)rootView.findViewById(R.id.calendar)).setOnDispatchDateSelectListener(this);
//	      btn =(Button)rootView.findViewById(R.id.btncon);
//            btn.setOnClickListener(new OnClickListener(){
//
//				@Override
//				public void onClick(View v) {
//					// TODO Auto-generated method stub
//					Intent intent = new Intent(getActivity(), LogIn.class);
//					startActivity(intent);
//				}});
 Button btn9 = (Button)rootView.findViewById(R.id.btn9);
         btn9.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startImageTargets();
			}
		});
            
	        return rootView;
	    }


	    public void startImageTargets()

	    {

	    	FragmentManager fragmentManager =  getFragmentManager ();
	    			 FragmentTransaction fragmentTransaction = fragmentManager . beginTransaction () ;
	    	AfirmacionesFragment fragment =  new  AfirmacionesFragment (); 
	    	//COMENTED fragmentTransaction . add (R.id.home, fragment ); 
	    	fragmentTransaction . commit ();
	        }
	       
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	    
	    	
	    	Intent i = new Intent(getActivity(),LogIn.class);
	    	   startActivity(i);
	    	
	        return true;
	    }
		
	    @Override
		public void onDispatchDateSelect(Date date) {
			//mTextView.setText(mFormat.format(date));		
		}
	
}


