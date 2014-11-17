package com.appapachofertil;


//import android.app.Fragment;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.appapachofertil.AfirmacionesFragment.MyTask;
import android.os.AsyncTask;
import android.os.Bundle;
import com.nostra13.universalimageloader.*;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TabHost.TabSpec;




public class LibrosFragment extends Fragment implements OnItemClickListener{

	public LibrosFragment(){}
	public ListView listView;
	 List<Item> arrayOfList;
	 private static final String rssFeed = "https://s3-us-west-1.amazonaws.com/test1carmen/imagelistview.xml";
	
	 SitiosFragment f1;


	 
	 
	 
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	         Bundle savedInstanceState) {
		 
		 getActivity().setRequestedOrientation(
	                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		 
	        View rootView = inflater.inflate(R.layout.libros, container, false);

	       Button b1 = (Button)rootView.findViewById(R.id.button1);	
	        b1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

//COMENTED	SitiosFragment secondFragment = (SitiosFragment) LibrosFragment.this.getActivity().getSupporFragmentManager().findFragmentById(R.id.sitios);
			//.getSupportFragmentManager().findFragmentById(R.id.sitios);
 //COMENTED           secondFragment.getView().setVisibility(View.VISIBLE);
            LibrosFragment.this.getView().setVisibility(View.GONE);
            
                 
				}
			});	
	        
	        
	        listView =(ListView)rootView.findViewById(R.id.listView1);
			listView.setOnItemClickListener(this);
			
			if (Utils.isNetworkAvailable(getActivity())) {
				new MyTask().execute(rssFeed);
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
						
//						if(fechahoy != ){
//							
//							System.out.println("nada");
//							
//							
//						}
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
		
	       
		
		 
		


String selectedFromList =(listView.getItemAtPosition(position).toString());



    // Showing Alert Message
 

        
	
}

     
  

public void setAdapterToListview() {
NewsRowAdapter objAdapter = new NewsRowAdapter(getActivity(),
		R.layout.row, arrayOfList);
listView.setAdapter(objAdapter);

}

public void showToast(String msg) {

}



//public void setCommunicator(Communicator communicator){
//	
//	this.communicator = communicator;
//	
//}
//Communicator comm;
//
//
//
//public interface Communicator
//{
//	 public void respond(int index);
//		 
//	 }


}
