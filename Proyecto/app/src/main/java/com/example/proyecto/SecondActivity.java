package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Especificación del botón para abrir/cerrar el drawer
        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.abrir_drawer, R.string.cerrar_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Button mostrarGatitos = (Button) findViewById(R.id.button2);
        mostrarGatitos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                if(extras != null) {
                    String nombre = extras.getString("nombre");
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    intent.putExtra("nombre", nombre);
                    startActivity(intent);
                }
            }
        });
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
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void perfil(MenuItem item){
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String nombre = extras.getString("nombre");
            Intent intent = new Intent(this, Perfil.class);
            intent.putExtra("nombre", nombre);
            startActivity(intent);
        } else{
            Toast msg = Toast.makeText(this, "No se pudo recuperar los datos del usuario", Toast.LENGTH_SHORT);
            msg.show();
        }
    }

    public void secondActivity(MenuItem item){
    }

    public void thirdActivity(MenuItem item){
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String nombre = extras.getString("nombre");
            Intent intent = new Intent(this, ThirdActivity.class);
            intent.putExtra("nombre", nombre);
            startActivity(intent);
        }
    }
}