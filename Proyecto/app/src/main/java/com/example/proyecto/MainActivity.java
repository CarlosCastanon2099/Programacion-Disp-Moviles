package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView registro = (TextView) findViewById(R.id.opcion_registro);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Registro.class);
                startActivity(intent);
            }
        });

        Button continuar = (Button)findViewById(R.id.button_main_to_second);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = ((EditText)findViewById(R.id.usuario)).getText().toString();
                String contraseña = ((EditText) findViewById(R.id.contraseña_nueva)).getText().toString();

                BaseDeDatosUsuarios bd = new BaseDeDatosUsuarios(MainActivity.this);
                Cursor usuario = bd.obtenerUsuario(nombre);
                if(usuario.getCount() > 0){
                    usuario.moveToFirst();
                    String contraseñaGuardada = usuario.getString(usuario.getColumnIndexOrThrow("contraseña"));
                    if(contraseña.equals(contraseñaGuardada)) {
                        Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                        intent.putExtra("nombre", nombre);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    } else{
                        Toast msg = Toast.makeText(MainActivity.this, R.string.contraseña_incorrecta, Toast.LENGTH_SHORT);
                        msg.show();
                    }
                } else{
                    Toast msg = Toast.makeText(MainActivity.this, R.string.usuario_no_existe, Toast.LENGTH_SHORT);
                    msg.show();
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item){
        int id =  item.getItemId();

        if(id == R.id.item1){
            Toast.makeText(this, "Seleccionaste la opción Ayuda", Toast.LENGTH_SHORT).show();
        } else if(id == R.id.item2){
            Toast.makeText(this, "Seleccionaste la opción Cambiar contraseña", Toast.LENGTH_SHORT).show();
        } else if(id == R.id.item3){
            Toast.makeText(this, "Seleccionaste la opción Ejemplos de uso", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}