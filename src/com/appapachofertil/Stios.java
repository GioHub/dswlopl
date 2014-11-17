package com.appapachofertil;

import java.util.List;
import com.nostra13.universalimageloader.*;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Stios extends Activity implements OnItemClickListener{

	 public ListView listView;
 	 List<Item> arrayOfList;
 	 private static final String rssFeed = "https://s3-us-west-1.amazonaws.com/test1carmen/imagelistview.xml";
 	
	 @Override
	   public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_stios);
	 
	 	setRequestedOrientation(
	                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		 
	        
	 	listView =(ListView)findViewById(R.id.listView1);
		listView.setOnItemClickListener(this);
		
//		if (Utils.isNetworkAvailable(this)) {
//			new MyTask().execute(rssFeed);
//		} else {
//			showToast("No Network Connection!!!");
//		}
   
      }
//	 class MyTask extends AsyncTask<String, Void, Void> {
//
//			ProgressDialog pDialog;
//
//			@Override
//			protected void onPreExecute() {
//				super.onPreExecute();
//
//				pDialog = new ProgressDialog(getApplication());
//				pDialog.setMessage("");
//				pDialog.show();
//
//			}

//			@Override
//			protected Void doInBackground(String... params) {
//				arrayOfList = new NamesParser().getData(params[0]);
//				
//			
//				
//				return null;
//			}
//
//			@Override
//			protected void onPostExecute(Void result) {
//				super.onPostExecute(result);
//
//				if (null != pDialog && pDialog.isShowing()) {
//					pDialog.dismiss();
//				}
//
//				if (null == arrayOfList || arrayOfList.size() == 0) {
//					showToast("No data found from web!!!");
//					//getApplication().finish();
//				} else {
//
//					// check data...
//							
//					  for (int i = 0; i < arrayOfList.size(); i++) { Item item =
//					  arrayOfList.get(i); System.out.println(item.getId());
//					  System.out.println(item.getTitle());
//					  System.out.println(item.getDesc());
//					  System.out.println(item.getPubdate());
//					  System.out.println(item.getLink()); }
//					 
//
//					  
//
//					setAdapterToListview();
//
//				}
//
//			}
	//	}


@Override
public void onItemClick(AdapterView<?> parent, View view, int position,
		long id) {
//	   final Item item = arrayOfList.get(position);
//	
//   String selectedFromList =(listView.getItemAtPosition(position).toString());



// Showing Alert Message


 

}




//    public void setAdapterToListview() {
//        NewsRowAdapter objAdapter = new NewsRowAdapter(this,
//         	R.layout.row, arrayOfList);
//               listView.setAdapter(objAdapter);
//
//          }

//
//   public void showToast(String msg) {
//
//   }


}