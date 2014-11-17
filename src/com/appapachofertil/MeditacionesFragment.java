package com.appapachofertil;


import java.io.IOException;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MeditacionesFragment extends Fragment {

	 public MeditacionesFragment(){}
//	 public TextView songName,startTimeField,endTimeField;
//	   private MediaPlayer mediaPlayer;
//	   private double startTime = 0;
//	   private double finalTime = 0;
//	   private Handler myHandler = new Handler();
//	   private int forwardTime = 5000; 
//	   private int backwardTime = 5000;
	//   private SeekBar seekbar;

	   public static int oneTimeOnly = 0;
	   String url = "http://android.programmerguru.com/wp-content/uploads/2013/04/hosannatelugu.mp3"; 
	   static MediaPlayer mPlayer;
	@Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	
//		ActionBar action=getActivity().getActionBar();
//    	action.hide();
    	getActivity().setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	        View rootView = inflater.inflate(R.layout.meditaciones, container, false);
	        

//	        Button btn =(Button)rootView.findViewById(R.id.btncon);
//            btn.setOnClickListener(new OnClickListener(){
//
//				@Override
//				public void onClick(View v) {
//					// TODO Auto-generated method stub
//					Intent intent = new Intent(getActivity(), LogIn.class);
//					startActivity(intent);
//				}});
            Button btn1 =(Button)rootView.findViewById(R.id.btn);
            btn1.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(getActivity(), Reproductor.class);
					startActivity(intent);
				}});
            Button btn2 =(Button)rootView.findViewById(R.id.btn2);
            btn2.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(getActivity(), Reproductor1.class);
					startActivity(intent);
				}});
            Button btn3 =(Button)rootView.findViewById(R.id.btn3);
            btn3.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(getActivity(), Reproductor2.class);
					startActivity(intent);
				}});
//            Button btn4 =(Button)rootView.findViewById(R.id.btn4);
//            btn4.setOnClickListener(new OnClickListener(){
//
//			@Override
//				public void onClick(View v) {
//					// TODO Auto-generated method stub
//					Intent intent3 = new Intent(getActivity(), Reproductor3.class);
//					startActivity(intent3);
//				}});
	        return rootView;
	    }
}
