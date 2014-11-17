package com.appapachofertil;

import java.io.IOException;

import android.app.ActionBar;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Reproductor1 extends Activity {

	static MediaPlayer mPlayer;
	private static final String med2 = "https://s3-us-west-1.amazonaws.com/test1carmen/02_eng.mp3";

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reproductor1);
		ActionBar action=getActionBar();
    	action.hide();
    	this.setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
       Button Play = (Button)findViewById(R.id.btn3);
    	      Play.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
				Toast.makeText(getApplication(), "Hola", Toast.LENGTH_SHORT).show();
				mPlayer = new MediaPlayer();
				mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
				try {
					
					mPlayer.setDataSource(med2);
				} catch (IllegalArgumentException e) {
					Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
				} catch (SecurityException e) {
					Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
				} catch (IllegalStateException e) {
					Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
				} catch (IOException e) {
					e.printStackTrace();
				}
					try {
					mPlayer.prepare();
				} catch (IllegalStateException e) {
					Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
				} catch (IOException e) {
					Toast.makeText(getApplicationContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
			}
				mPlayer.start();
					}
				});
	    	
		}
	}
