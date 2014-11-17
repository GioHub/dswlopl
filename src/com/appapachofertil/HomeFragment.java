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
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
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
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	  
	    	ActionBar action=getActivity().getActionBar();
	    	action.setDisplayHomeAsUpEnabled(true);

	    	//action.setCustomView(R.id.action_bar);
	    	
	    	getActivity().setRequestedOrientation(
	                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	            
	        View rootView = inflater.inflate(R.layout.home, container, false);
	        mTextView = (TextView)rootView.findViewById(R.id.textView4);
	
	                  //  mTextView.setText(item.getDesc);
	             
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


