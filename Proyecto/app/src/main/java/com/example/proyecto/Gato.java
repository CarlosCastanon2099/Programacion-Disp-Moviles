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

public class Gato {
    private String color;
    private String raza;
    private String edad;
    private boolean esterilizado;

    public Gato(String color, String raza, String edad, boolean esterilizado) {
        this.color = color;
        this.raza = raza;
        this.edad = edad;
        this.esterilizado = esterilizado;
    }

    // Getters
    public String getColor() {
        return color;
    }

    public String getRaza() {
        return raza;
    }

    public String getEdad() {
        return edad;
    }

    public boolean esEsterilizado() {
        return esterilizado;
    }

    // Setters
    public void setColor(String color) {
        this.color = color;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setEsterilizado(boolean esterilizado) {
        this.esterilizado = esterilizado;
    }

}