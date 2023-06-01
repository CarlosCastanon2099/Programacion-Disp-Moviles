package com.example.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    public void secondActivity(View view){
        EditText textEditEmail = (EditText) findViewById(R.id.email);
        String email = textEditEmail.getText().toString();
        EditText textNuevaContraseña = (EditText) findViewById(R.id.contraseña_nueva);
        String pass = textNuevaContraseña.getText().toString();
        EditText textContraseñaConf = (EditText) findViewById(R.id.contraseña_conf);
        String pass_conf = textContraseñaConf.getText().toString();
        if(!isEmailValid(email)){
            Toast msg = Toast.makeText(this, R.string.verifica_email, Toast.LENGTH_SHORT);
            msg.show();
        } else if(pass.length() < 8){
            Toast msg = Toast.makeText(this, R.string.verifica_largo_contraseña, Toast.LENGTH_SHORT);
            msg.show();
        } else if(!pass.equals(pass_conf)){
            Toast msg = Toast.makeText(this, R.string.verifica_contraseña_igual, Toast.LENGTH_SHORT);
            msg.show();
        }
        else {
            Intent intent = new Intent(this, ThirdActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            //finish();
        }
    }

    public void regresaInicioSesion(View view){
        finish();
    }

    private boolean isEmailValid(CharSequence email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}