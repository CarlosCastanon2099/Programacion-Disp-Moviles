package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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