package com.example.repasandoexamenfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.repasandoexamenfinal.adaptador.RecyclerListar;
import com.example.repasandoexamenfinal.fragments.FragmentAgregar;
import com.example.repasandoexamenfinal.fragments.FragmentListar;
import com.example.repasandoexamenfinal.utils.Inventario;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  implements
        FragmentAgregar.OnAgregarSelectedInventario,RecyclerListar.OnIntentarioSelected {


    private NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FrameLayout fragmentUno,fragmentDos,fragmentTres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
        personalizarBarra();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_uno,new FragmentListar(),"dos");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_uno,new FragmentAgregar(),"uno");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }

    private void acciones() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.menu_opcion_uno:
                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.add(R.id.fragment_uno,new FragmentAgregar(),"uno");
                        fragmentTransaction.addToBackStack(null);
                        break;
                    case R.id.menu_opcion_dos:

                        fragmentManager = getSupportFragmentManager();
                        FragmentListar fragment = (FragmentListar) fragmentManager.findFragmentByTag("dos");
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_uno,fragment,"dos");
                        fragmentTransaction.addToBackStack(null);
                        break;
                    case R.id.menu_opcion_tres:
                        System.exit(0);
                        break;
                }
                fragmentTransaction.commit();
                drawerLayout.closeDrawers();
                return true;
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            System.exit(0);
        }
    }
    private void instancias() {
        toolbar = findViewById(R.id.toolbar_fragment_m);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.menu_navigation);
        fragmentUno = findViewById(R.id.fragment_uno);

    }

    private void personalizarBarra() {
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.open_draw,R.string.close_draw);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }


    @Override
    public void SelectedAgregarIventario(Inventario inventario) {
        System.out.println(inventario);
        FragmentListar fragments = (FragmentListar) getSupportFragmentManager().findFragmentByTag("dos");
        fragments.agregarInventarioSelected(inventario);
    }



    @Override
    public void SelectedIntentario(Inventario inventario) {
        Toast.makeText(getApplicationContext(),inventario.getPrecio().toString(),Toast.LENGTH_SHORT).show();

    }
}