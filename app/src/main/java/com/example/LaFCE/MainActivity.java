package com.example.LaFCE;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.LaFCE.Adapters.Utilidades;
import com.example.LaFCE.vistas.AutoridadesFragment;
import com.example.LaFCE.vistas.CarrerasFragment;
import com.example.LaFCE.vistas.ContactoDBFragment;
import com.example.LaFCE.vistas.ContactoFragment;
import com.example.LaFCE.vistas.DatosFragment;
import com.example.LaFCE.vistas.DptoFragment;
import com.example.LaFCE.vistas.FceFragment;
import com.example.LaFCE.vistas.InstitucionalFragment;
import com.example.LaFCE.vistas.RedesFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, InstitucionalFragment.OnFragmentInteractionListener,
        CarrerasFragment.OnFragmentInteractionListener,RedesFragment.OnFragmentInteractionListener,
        ContactoFragment.OnFragmentInteractionListener, FceFragment.OnFragmentInteractionListener,
        AutoridadesFragment.OnFragmentInteractionListener, DptoFragment.OnFragmentInteractionListener,
        DatosFragment.OnFragmentInteractionListener, ContactoDBFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //Fragmento de inicio
        if(Utilidades.validaPantalla==true){
            Fragment fragment = new InstitucionalFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();
            Utilidades.validaPantalla=false;

        }



        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment miFragment = null;
        boolean fragSeleccionado= false;

        if (id == R.id.nav_home) {
            miFragment=new InstitucionalFragment();
            fragSeleccionado=true;
        } else if (id == R.id.nav_carreras) {
            miFragment=new CarrerasFragment();
            fragSeleccionado=true;

        } else if (id == R.id.nav_redes) {
            miFragment=new RedesFragment();
            fragSeleccionado=true;

        } else if (id == R.id.nav_contacto) {
            miFragment=new ContactoFragment();
            fragSeleccionado=true;

        }

        if(fragSeleccionado==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,miFragment).commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
