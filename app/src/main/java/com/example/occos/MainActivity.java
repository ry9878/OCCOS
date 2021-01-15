package com.example.occos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.occos.ui.login.LoginActivity;
import com.google.android.material.navigation.NavigationView;

import static android.app.ProgressDialog.show;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    CardView c1, c2, c3, c4, c5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.logout).setVisible(false);
        menu.findItem(R.id.account).setVisible(false);

        c1=(CardView) findViewById(R.id.card1);
        c2=(CardView) findViewById(R.id.card2);
        c3=(CardView) findViewById(R.id.card3);
        c4=(CardView) findViewById(R.id.card4);
        c5=(CardView) findViewById(R.id.card5);
        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);
        c5.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    /*
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        super.onCreateOptionsMenu(menu);
    }*/

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent i;
        switch (item.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.nav_register:
                i = new Intent(MainActivity.this, Activity2.class);
                startActivity(i);
                break;
            case R.id.login:
                i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                break;
            case R.id.nav_custom:
                i= new Intent(MainActivity.this, Activity4.class);
                startActivity(i);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch(v.getId()){
            case R.id.card1:
                i=new Intent(this,ActivityCake1.class);
                startActivity(i);
                break;
            case R.id.card2:
                i=new Intent(this,ActivityCake2.class);
                startActivity(i);
                break;
            case R.id.card3:
                i=new Intent(this,ActivityCake3.class);
                startActivity(i);
                break;
            case R.id.card4:
                i=new Intent(this,ActivityCake4.class);
                startActivity(i);
                break;
            case R.id.card5:
                i=new Intent(this,ActivityCake5.class);
                startActivity(i);
                break;
        }
    }
}