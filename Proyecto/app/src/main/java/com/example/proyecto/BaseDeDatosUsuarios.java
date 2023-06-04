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
// import java.sql.*;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDeDatosUsuarios extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "usuarios.db";
    public static final String TABLE_NAME = "usuarios";
    public static final String COL_1 = "nombre";
    public static final String COL_2 = "correo";
    public static final String COL_3 = "contraseña";
    public static final String COL_4 = "tipoUsuario";

    public BaseDeDatosUsuarios(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    // Se crea la tabla
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (nombre TEXT PRIMARY KEY, correo TEXT, contraseña TEXT, tipoUsuario TEXT)");
    }

    // Se actualiza la tabla
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }

    // Se inserta un usuario
    public boolean insertarUsuario(String nombre, String correo, String contraseña, String tipoUsuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, nombre);
        contentValues.put(COL_2, correo);
        contentValues.put(COL_3, contraseña);
        contentValues.put(COL_4, tipoUsuario);
        long resultado = db.insert(TABLE_NAME, null, contentValues);
        if (resultado == -1) {
            return false;
        } else {
            return true;
        }
    }

    // Se obtienen todos los usuarios
    public Cursor obtenerTodosLosUsuarios() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    // Se obtiene un usuario
    public Cursor obtenerUsuario(String nombre) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME + " where nombre = '" + nombre + "'", null);
        return res;
    }

    // Se actualiza un usuario
    public boolean actualizarUsuario(String nombre, String correo, String contraseña, String tipoUsuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, nombre);
        contentValues.put(COL_2, correo);
        contentValues.put(COL_3, contraseña);
        contentValues.put(COL_4, tipoUsuario);
        db.update(TABLE_NAME, contentValues, "nombre = ?", new String[]{nombre});
        return true;
    }

    // Se elimina un usuario
    public Integer eliminarUsuario(String nombre) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "nombre = ?", new String[]{nombre});
    }

}