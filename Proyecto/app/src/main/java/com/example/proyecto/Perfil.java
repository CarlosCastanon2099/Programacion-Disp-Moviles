package com.example.proyecto;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
//import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.Objects;

public class Perfil extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        // Especificación del botón para abrir/cerrar el drawer
        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.abrir_drawer, R.string.cerrar_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        ImageView pfp = (ImageView) findViewById(R.id.imagen_perfil);
        pfp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Perfil.this, "El cambio de imagen no está disponible ahora", Toast.LENGTH_SHORT).show();
            }
        });

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String nombre = extras.getString("nombre");
            BaseDeDatosUsuarios bd = new BaseDeDatosUsuarios(this);
            Cursor usuario = bd.obtenerUsuario(nombre);
            usuario.moveToFirst();
            ((TextView) findViewById(R.id.nombre_valor)).setText(nombre);
            ((TextView)findViewById(R.id.correo_valor)).setText(usuario.getString(usuario.getColumnIndexOrThrow("correo")));
            ((TextView)findViewById(R.id.tipo_usuario_valor)).setText(usuario.getString(usuario.getColumnIndexOrThrow("tipoUsuario")));
        }
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
    }

    public void secondActivity(MenuItem item){
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String nombre = extras.getString("nombre");
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("nombre", nombre);
            startActivity(intent);
        }
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