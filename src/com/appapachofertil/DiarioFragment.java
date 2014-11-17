package com.appapachofertil;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class DiarioFragment extends Fragment {

	 public DiarioFragment(){}
	 public static final String MyPREFERENCES = "MyPrefs" ;
		EditText et;
		Button b;
		ListView lv;
		ArrayList<String> al;
		ArrayAdapter<String> aa;
		SharedPreferences sharedpreferences;
		private SQLiteDatabase db;
		 @Override
		    public View onCreateView(LayoutInflater inflater, ViewGroup container,
		            Bundle savedInstanceState) {
		  
			 
			 
			 
		        View rootView = inflater.inflate(R.layout.diario, container, false);
		        sharedpreferences =this.getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
		        et = (EditText)rootView.findViewById(R.id.editText1);
		        et.setText(sharedpreferences.getString("item", ""));
				b = (Button)rootView.findViewById(R.id.button1);
				lv = (ListView)rootView.findViewById(R.id.listView1);
				al = new ArrayList<String>();//initialize array list
				aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, al);//step4 : establish communication bw arraylist and adapter
				//step5 : establish communication bw adapter and dest (listview)
				lv.setAdapter(aa);
//				ActionBar action=getActivity().getActionBar();
//		    	action.hide();
				TextSQLiteHelper usdbh=
						new TextSQLiteHelper(getActivity(),"DBTexto",null,1);
				
				db=usdbh.getWritableDatabase();
				
                   SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy ");
		    	 
				b.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						//step i: take text from et and add to arraylist
						String item = et.getText().toString();
						al.add(0, item);
						//step ii: notify to adapter
						aa.notifyDataSetChanged();
						//step iii: clr edit text
						et.setText("");
						ContentValues nuevoRegistro = new ContentValues();
						nuevoRegistro.put("diario", item);
						db.insert("Texto", null, nuevoRegistro);
					}
				});
				lv.setOnItemClickListener(new OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, 
							View v, int arg2,
							long arg3) {
						String item = al.get(arg2);
						Toast.makeText(getActivity(), item, 0).show();
						
						ContentValues nuevoRegistro = new ContentValues();
						nuevoRegistro.put("diario", item);
						db.insert("Texto", null, nuevoRegistro);
						
				
						}
				});
		   	 return rootView;
			}	
		
	}
