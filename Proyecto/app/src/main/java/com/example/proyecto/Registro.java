package com.example.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Button continuar = (Button) findViewById(R.id.button_main_to_second);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textEditEmail = (EditText) findViewById(R.id.usuario);
                EditText textNuevaContraseña = (EditText) findViewById(R.id.contraseña_nueva);
                EditText textContraseñaConf = (EditText) findViewById(R.id.contraseña_conf);

                String email = textEditEmail.getText().toString();
                String pass = textNuevaContraseña.getText().toString();
                String pass_conf = textContraseñaConf.getText().toString();

                if(!isEmailValid(email)){
                    Toast msg = Toast.makeText(Registro.this, R.string.verifica_email, Toast.LENGTH_SHORT);
                    msg.show();
                } else if(pass.length() < 8){
                    Toast msg = Toast.makeText(Registro.this, R.string.verifica_largo_contraseña, Toast.LENGTH_SHORT);
                    msg.show();
                } else if(!pass.equals(pass_conf)){
                    Toast msg = Toast.makeText(Registro.this, R.string.verifica_contraseña_igual, Toast.LENGTH_SHORT);
                    msg.show();
                }
                else {
                    String nombre = ((EditText) findViewById(R.id.text_nombre_nuevo)).getText().toString();
                    BaseDeDatosUsuarios bd = new BaseDeDatosUsuarios(Registro.this);
                    /* Guardar la contraseña así es inseguro, pero es para probar la bd. */
                    bd.insertarUsuario(nombre, email, pass, "Estándar");
                    Intent intent = new Intent(Registro.this, ThirdActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("nombre", nombre);
                    startActivity(intent);
                }
            }
        });
    }


    public void regresaInicioSesion(View view){
        finish();
    }

    private boolean isEmailValid(CharSequence email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}