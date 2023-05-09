package com.example.tarea3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.Objects;

public class ThirdActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Especificación del botón para abrir/cerrar el drawer
        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.abrir_drawer, R.string.cerrar_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    public void changeImage10(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view10);
        imageView.setImageResource(R.drawable.imagen11);
    }

    public void changeImage20(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view20);
        imageView.setImageResource(R.drawable.imagen21);
    }

    public void changeImage30(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view30);
        imageView.setImageResource(R.drawable.imagen31);
    }

    public void changeImage50(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view50);
        imageView.setImageResource(R.drawable.imagen51);
    }

    public void changeImage70(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view70);
        imageView.setImageResource(R.drawable.imagen71);
    }

    public void changeImage80(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view80);
        imageView.setImageResource(R.drawable.imagen81);
    }

    /* Componentes de navegación */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void mainActivity(MenuItem item){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void secondActivity(MenuItem item){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void thirdActivity(MenuItem item){
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

}