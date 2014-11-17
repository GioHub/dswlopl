package com.appapachofertil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Libros extends Fragment {

	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	 
	        View libros = inflater.inflate(R.layout.activity_libros, container, false);
	       // ((TextView)ios.findViewById(R.id.textView)).setText("iOS");
	        return libros;
}}