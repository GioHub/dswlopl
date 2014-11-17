package com.appapachofertil;


import java.util.ArrayList;
import java.util.List;	
import android.app.ActionBar;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class SitiosFragment extends Fragment implements OnItemClickListener {

	 public SitiosFragment(){}
	 public final String TAG = getClass().getSimpleName();
	 private ArrayList<Blog> blogList;
		private ListView listView;
		private BlogAdapter ba;
		private ProgressDialog progress;
		List<Item> arrayOfList;

		private static final String rssFeed = "https://s3-us-west-1.amazonaws.com/test1carmen/imagelistview.xml";

	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	  
	    	ActionBar action=getActivity().getActionBar();
	    	action.hide();
	    	
	        View rootView = inflater.inflate(R.layout.sitios, container, false);

	    	listView = (ListView)rootView.findViewById(R.id.listView1);
			listView.setOnItemClickListener(this);

			if (Utils.isNetworkAvailable(getActivity())) {
				new MyTask().execute(rssFeed);
			} else {
				showToast("No Network Connection!!!");
			}
	        
	        //	    	blogList = new ArrayList<Blog>();
//			listView = (ListView)rootView.findViewById(R.id.listView1);
//			ba = new BlogAdapter(getActivity(), R.layout.blog_item, blogList);
//
//			listView.setAdapter(ba);
//			RequestQueue reqQueue = Volley.newRequestQueue(getActivity());
//			String url = null;
//			try {
//				url = "https://ajax.googleapis.com/ajax/services/feed/find?v=1.0&q="
//						+ URLEncoder.encode("Official Google Blogs", "utf-8");
//
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			JsonObjectRequest jr = new JsonObjectRequest(Request.Method.GET, url,
//					null, new Response.Listener<JSONObject>() {
//
//						@Override
//						public void onResponse(JSONObject response) {
//							// TODO Auto-generated method stub
//							parseJSONRespone(response);
//							ba.notifyDataSetChanged();
//							progress.dismiss();
//						}
//
//					}, new Response.ErrorListener() {
//
//						@Override
//						public void onErrorResponse(VolleyError error) {
//							// TODO Auto-generated method stub
//							Log.v(TAG, error.getMessage());
//						}
//					});
//
//			progress = ProgressDialog.show(getActivity(), "",
//					"Loading google's official blogs");
//			reqQueue.add(jr);
			return rootView;
		}
	 // My AsyncTask start...

		class MyTask extends AsyncTask<String, Void, Void> {

			ProgressDialog pDialog;

			@Override
			protected void onPreExecute() {
				super.onPreExecute();

				pDialog = new ProgressDialog(getActivity());
				pDialog.setMessage("Cargando links");
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
					/*
					 * for (int i = 0; i < arrayOfList.size(); i++) { Item item =
					 * arrayOfList.get(i); System.out.println(item.getId());
					 * System.out.println(item.getTitle());
					 * System.out.println(item.getDesc());
					 * System.out.println(item.getPubdate());
					 * System.out.println(item.getLink()); }
					 */

					setAdapterToListview();

				}

			}
		}

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Item item = arrayOfList.get(position);
			Intent intent = new Intent(getActivity(), DetailActivity.class);
			intent.putExtra("url", item.getLink());
			intent.putExtra("title", item.getTitle());
			intent.putExtra("desc", item.getDesc());
			startActivity(intent);
		}

		public void setAdapterToListview() {
			NewsRowAdapter objAdapter = new NewsRowAdapter(getActivity(),
					R.layout.row, arrayOfList);
			listView.setAdapter(objAdapter);
		}

		public void showToast(String msg) {

		}
		
		
//		public void changeData(int index){
//			
//			String[] descriptions=getResources().getStringArray(R.array.Array_libros);
//			
//			
//		}
	}
	 

		
		
