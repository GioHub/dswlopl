package com.appapachofertil;

import java.util.ArrayList;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import com.nostra13.universalimageloader.*;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private String[] titulos;
    private DrawerLayout NavDrawerLayout;
    private ListView NavList;
    private ArrayList<Item_objct> NavItms;
    private TypedArray NavIcons;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    NavigationAdapter NavAdapter;  
@Override
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		Resources res = getResources();

		//Drawer Layout
		NavDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		//Lista
        NavList = (ListView) findViewById(R.id.lista);
        //Declaramos el header el cual sera el layout de header.xml
        //View header = getLayoutInflater().inflate(R.layout.header, null);
        //Establecemos header
        // NavList.addHeaderView(header);
		//Tomamos listado  de imgs desde drawable
        NavIcons = getResources().obtainTypedArray(R.array.navigation_iconos);			
		//Tomamos listado  de titulos desde el string-array de los recursos @string/nav_options
        titulos = getResources().getStringArray(R.array.nav_options);
        //Listado de titulos de barra de navegacion
        NavItms = new ArrayList<Item_objct>();
        //Agregamos objetos Item_objct al array
        //Perfil	      
        NavItms.add(new Item_objct("                          " + String.format(res.getString(R.string.menu1)), NavIcons.getResourceId(1, -1)));
        //Favoritos
        NavItms.add(new Item_objct("                          " + "", NavIcons.getResourceId(1, -1)));
        //NavItms.add(new Item_objct(titulos[1], NavIcons.getResourceId(1, -1)));
        //Eventos
        NavItms.add(new Item_objct("                          " + String.format(res.getString(R.string.menu3)), NavIcons.getResourceId(2, -1)));
        //Lugares
        NavItms.add(new Item_objct("                          " + String.format(res.getString(R.string.menu4)), NavIcons.getResourceId(3, -1)));
        //Etiquetas
        NavItms.add(new Item_objct("                          " + String.format(res.getString(R.string.menu5)), NavIcons.getResourceId(4, -1)));
        
        NavItms.add(new Item_objct("                          " + String.format(res.getString(R.string.menu6)), NavIcons.getResourceId(5, -1)));
        //Configuracion
       // NavItms.add(new Item_objct(titulos[5], NavIcons.getResourceId(5, -1)));
        //Share
       // NavItms.add(new Item_objct(titulos[6], NavIcons.getResourceId(6, -1)));
        
       // NavItms.add(new Item_objct(titulos[7], NavIcons.getResourceId(7,-1)));
      
        //Declaramos y seteamos nuestro adaptador al cual le pasamos el array con los titulos	       
        NavAdapter= new NavigationAdapter(this,NavItms);
        NavList.setAdapter(NavAdapter);	
        //Siempre vamos a mostrar el mismo titulo
        mTitle = mDrawerTitle = getTitle();
        
        //Declaramos el mDrawerToggle y las imgs a utilizar
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                NavDrawerLayout,         /* DrawerLayout object */
                R.drawable.barra_menu,  /* Icono de navegacion*/
                R.string.app_name,  /* "open drawer" description */
                R.string.hello_world  /* "close drawer" description */
                ) {	

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
            	Log.e("Cerrado completo", "!!");
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                Log.e("Apertura completa", "!!");
            }
        };	        


        
        
        // Establecemos que mDrawerToggle declarado anteriormente sea el DrawerListener
        NavDrawerLayout.setDrawerListener(mDrawerToggle);
        //Establecemos que el ActionBar muestre el Boton Home
        getActionBar().setDisplayHomeAsUpEnabled(true);
//        getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME);
//        getActionBar().setCustomView(R.layout.header);
//
//        getActionBar().setHomeButtonEnabled(true);
//        getActionBar().setDisplayHomeAsUpEnabled(true);

        //Establecemos la accion al clickear sobre cualquier item del menu.
        //De la misma forma que hariamos en una app comun con un listview.
        NavList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
            	MostrarFragment(position);
            }
        });
        
        //Cuando la aplicacion cargue por defecto mostrar la opcion Home
        MostrarFragment(1);
}

/*Pasando la posicion de la opcion en el menu nos mostrara el Fragment correspondiente*/
private void MostrarFragment(int position) {
    // update the main content by replacing fragments
    Fragment fragment = null;
  
    switch (position) {
    case -1:
        fragment = new AfirmacionesFragment();
        break;
    case 0:
        fragment = new AfirmacionesFragment();
        break;
    case 1:
        fragment = new HomeFragment();
        break;
    case 2:
        fragment = new MeditacionesFragment();
        break;
    case 3:
    	fragment = new  CalendarioFragment();
    	break;
    case 4:
    	fragment = new DiarioFragment();
    	break;
    case 5:
 
    	fragment=new LibrosFragment();

    	break;
    case 6:
    	fragment = new HomeFragment();
    	break;
    case 7:
    	fragment = new AfirmacionesFragment();
    	break;
    case 8:
    	fragment = new SitiosFragment();
    	break;

    default:
    	//si no esta la opcion mostrara un toast y nos mandara a Home
    	Toast.makeText(getApplicationContext(),"Opcion "+titulos[position-1]+"no disponible!", Toast.LENGTH_SHORT).show();
        fragment = new AfirmacionesFragment();
        position=1;
        break;
    }
    //Validamos si el fragment no es nulo
    if (fragment != null) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        // Actualizamos el contenido segun la opcion elegida
        NavList.setItemChecked(position, true);
        NavList.setSelection(position);
        //Cambiamos el titulo en donde decia "
        if(position<=0)
        {
        	setTitle(titulos[position]);
        }
        else
        {
        	setTitle(titulos[position-1]);
        }
        //Cerramos el menu deslizable
        NavDrawerLayout.closeDrawer(NavList);
    } else {
        //Si el fragment es nulo mostramos un mensaje de error.
        Log.e("Error  ", "MostrarFragment"+position);
    }
}
  
@Override
protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    // Sync the toggle state after onRestoreInstanceState has occurred.
    mDrawerToggle.syncState();
}
@Override
public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    mDrawerToggle.onConfigurationChanged(newConfig);
}
@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Pass the event to ActionBarDrawerToggle, if it returns
    // true, then it has handled the app icon touch event
    if (mDrawerToggle.onOptionsItemSelected(item)) {
        Log.e("mDrawerToggle pushed", "x");
      return true;
    }
    // Handle your other action bar items...
    return super.onOptionsItemSelected(item);
   }
}
