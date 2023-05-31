package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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

    public void secondActivity(View view){
        EditText textEditEmail = (EditText) findViewById(R.id.email);
        String email = textEditEmail.getText().toString();
        if(!isEmailValid(email)){
            Toast msg = Toast.makeText(this, R.string.verifica_email, Toast.LENGTH_SHORT);
            msg.show();
        }
        else {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        }
    }

    private boolean isEmailValid(CharSequence email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}