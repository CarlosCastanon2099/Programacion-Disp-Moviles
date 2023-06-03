package com.example.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
//import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.Objects;

public class UsuarioFactory {

    public static Usuario crearUsuario(String nombre, String correo, String contraseña, String tipoUsuario) {
        return new Usuario(nombre, correo, contraseña, tipoUsuario);
    }

}