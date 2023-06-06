package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

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
        adopcionToast("Max");
    }

    public void changeImage20(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view20);
        imageView.setImageResource(R.drawable.imagen21);
        adopcionToast("Felix");
    }

    public void changeImage30(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view30);
        imageView.setImageResource(R.drawable.imagen31);
        adopcionToast("Gatsby");
    }

    public void changeImage50(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view50);
        imageView.setImageResource(R.drawable.imagen51);
        adopcionToast("Tom");
    }

    public void changeImage70(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view70);
        imageView.setImageResource(R.drawable.imagen71);
        adopcionToast("Oreo");
    }

    public void changeImage80(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view80);
        imageView.setImageResource(R.drawable.imagen81);
        adopcionToast("Pulgas");
    }

    private void adopcionToast(String gatoNombre){
        Toast.makeText(this, "Contactaremos al dueño. ¡Gracias por adoptar a " + gatoNombre + "!", Toast.LENGTH_SHORT).show();
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
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String nombre = extras.getString("nombre");
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("nombre", nombre);
            startActivity(intent);
        }
    }

    public void thirdActivity(MenuItem item){
    }

}