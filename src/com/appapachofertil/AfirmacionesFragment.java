package com.appapachofertil;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.nostra13.universalimageloader.*;
import com.google.android.gms.plus.PlusShare;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.CalendarContract.Events;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class AfirmacionesFragment extends Fragment implements OnItemClickListener {

	public AfirmacionesFragment(){}
	 public ListView listView;
	 List<Item> arrayOfList;
	 private TextView textView;
	  String fechahoy=null;
	 private static final String rssFeed = "https://s3-us-west-1.amazonaws.com/test1carmen/afirmaciones.xml";
	 private static final String rssFeed1 = "https://s3-us-west-1.amazonaws.com/test1carmen/afirmacionesingles.xml";

	 ImageView dia;

	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	  
		 getActivity().setRequestedOrientation(
	                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		 
	        View rootView = inflater.inflate(R.layout.afirmaciones, container, false);
	        
	       
	    	
	    	 SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy ");
	 
	    	 dia = (ImageView)rootView.findViewById(R.id.dia);
 
	                Date fecha = new Date();
	                fechahoy = sf.format(fecha);
	    	                 System.out.println(fechahoy);
//	    	  Button btn =(Button)rootView.findViewById(R.id.btncon);
//	            btn.setOnClickListener(new OnClickListener(){
//
//					@Override
//					public void onClick(View v) {
//						// TODO Auto-generated method stub
//						Intent intent = new Intent(getActivity(), LogIn.class);
//						startActivity(intent);
//					}});
//	            
	           

	            
	    textView=(TextView)rootView.findViewById(R.id.textView1);
	       
	       



	    	listView = (ListView)rootView.findViewById(R.id.listView1);
			listView.setOnItemClickListener(this);
			
			if (Utils.isNetworkAvailable(getActivity())) {
				Resources res = getResources();
				String mainp = String.format(res.getString(R.string.mainphrase));
				if(mainp.toUpperCase().contains("THE"))
				{
					new MyTask().execute(rssFeed1);
				}
				else
				{
					new MyTask().execute(rssFeed);
				}
				
			} else {
				showToast("No Network Connection!!!");
			}


               
	        return rootView;
	    }
		class MyTask extends AsyncTask<String, Void, Void> {

			ProgressDialog pDialog;

			@Override
			protected void onPreExecute() {
				super.onPreExecute();

				pDialog = new ProgressDialog(getActivity());
				pDialog.setMessage("");
				pDialog.show();

			}

			@Override
			protected Void doInBackground(String... params) {
				arrayOfList = new NamesParser().getData(params[0]);
				
			
				
				return null;
			}

			@Override
			protected void onPostExecute(Void result) {
				super.onPostExecute(result);

				if (null != pDialog && pDialog.isShowing()) {
					pDialog.dismiss();
				}

				if (null == arrayOfList || arrayOfList.size() == 0) {
					showToast("No data found from web!!!");
					getActivity().finish();
				} else {

					// check data...
					
//					if(fechahoy != ){
//						
//						System.out.println("nada");
//						
//						
//					}
//					
					
					  for (int i = 0; i < arrayOfList.size(); i++) { Item item =
					  arrayOfList.get(i); System.out.println(item.getId());
					  System.out.println(item.getTitle());
					  System.out.println(item.getDesc());
					  System.out.println(item.getPubdate());
					  System.out.println(item.getLink()); }
					 

					  

					setAdapterToListview();

				}

			}
		}

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			final Item item = arrayOfList.get(position);
			
		       
					URL imageUrl = null;
					 HttpURLConnection conn = null;
					 
					
			
			
			String selectedFromList =(listView.getItemAtPosition(position).toString());
            
			if(selectedFromList!= null){
				
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
				
				
				 // get the layout inflater
			    LayoutInflater inflater = getActivity().getLayoutInflater();
			 
			    // inflate and set the layout for the dialog
			    // pass null as the parent view because its going in the dialog layout
			    alertDialog.setView(inflater.inflate(R.layout.dialog, null));
			                   
//			    try {
//					 
//					 imageUrl = new URL(item.getLink());
//					 conn = (HttpURLConnection) imageUrl.openConnection();
//					 conn.connect();
//					  
//					 BitmapFactory.Options options = new BitmapFactory.Options();
//					 options.inSampleSize = 1; // el factor de escala a minimizar la imagen, siempre es potencia de 2
//					 
//					 Bitmap imagen = BitmapFactory.decodeStream(conn.getInputStream(), new Rect(0, 0, 0, 0), options);
//					 dia.setImageBitmap(imagen);
//					 
//					 } catch (IOException e) {
//					 
//					 e.printStackTrace();
//					 
//					 }
		        // Setting Dialog Title
		        //alertDialog.setTitle("Confirm Delete...");
		 
		        // Setting Dialog Message
		      //   alertDialog.setMessage(item.getDesc());
		 //nuevo.setText(item.getDesc());
		        // Setting Icon to Dialog
		        // alertDialog.
		        // Setting Positive "Yes" Button
		        alertDialog.setPositiveButton("Cancelar", new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog,int which) {
		 
		            // Write your code here to invoke YES event
		       //     Toast.makeText(getActivity(), "You clicked on YES", Toast.LENGTH_SHORT).show();
		            }
		        });
		 
		        // Setting Negative "NO" Button
		        alertDialog.setNegativeButton("Compartir", new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int which) {
		            // Write your code here to invoke NO event
		          //  Toast.makeText(getActivity(), "You clicked on NO", Toast.LENGTH_SHORT).show();
		    		Intent intent = new Intent(android.content.Intent.ACTION_SEND);
					intent.setType("image/*");
					intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "asunto");//se usará por ejemplo para email
					intent.putExtra(Intent.EXTRA_TEXT, item.getDesc());
					startActivity(Intent.createChooser(intent, "Compartir usando"));
		
            
		            dialog.cancel();
		            }
		        });
		 
		        // Showing Alert Message
		        alertDialog.show();
		 
		            
            	
            }
			
			     
			textView.setText(item.getDesc());

			  
			 Button btn1 =(Button)getActivity().findViewById(R.id.btn1);
	            btn1.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(android.content.Intent.ACTION_SEND);
						intent.setType("image/*");
						intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "asunto");//se usará por ejemplo para email
						intent.putExtra(Intent.EXTRA_TEXT, item.getDesc());
						startActivity(Intent.createChooser(intent, "Compartir usando"));
					}
				});

	            Button btn2 =(Button)getActivity().findViewById(R.id.btn2);
	            btn2.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
//						 
//				        // Setting Dialog Title
				        alertDialog.setTitle("Confirm Delete...");
//				 
//				        // Setting Dialog Message
				        alertDialog.setMessage( item.getDesc());
//				 
//				        // Setting Icon to Dialog
				        alertDialog.setIcon(R.drawable.img);
				 
				        // Setting Positive "Yes" Button
				        alertDialog.setPositiveButton("Cancelar", new DialogInterface.OnClickListener() {
				            public void onClick(DialogInterface dialog,int which) {
				 
				            // Write your code here to invoke YES event
				       //     Toast.makeText(getActivity(), "You clicked on YES", Toast.LENGTH_SHORT).show();
				            }
				        });
				 
				        // Setting Negative "NO" Button
				        alertDialog.setNegativeButton("Compartir", new DialogInterface.OnClickListener() {
				            public void onClick(DialogInterface dialog, int which) {
				            // Write your code here to invoke NO event
				          //  Toast.makeText(getActivity(), "You clicked on NO", Toast.LENGTH_SHORT).show();
				    		Intent intent = new Intent(android.content.Intent.ACTION_SEND);
						intent.setType("image/*");
							intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "asunto");//se usará por ejemplo para email
							intent.putExtra(Intent.EXTRA_TEXT,item.getDesc());
							startActivity(Intent.createChooser(intent, "Compartir usando"));				
				            dialog.cancel();
				            }
				        });
				 
				        // Showing Alert Message
			        alertDialog.show();
					}
				});
		

		}

		public void setAdapterToListview() {
			NewsRowAdapter objAdapter = new NewsRowAdapter(getActivity(),
					R.layout.row, arrayOfList);
			listView.setAdapter(objAdapter);
		
		}

		public void fecha(){
			
//			if()
			
		}
		
		
		public void showToast(String msg) {

		}


	}
