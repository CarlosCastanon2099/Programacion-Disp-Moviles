package com.example.proyecto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UsuarioFactory {

    public static Usuario crearUsuario(String nombre, String correo, String contraseña, String tipoUsuario) {
        return new Usuario(nombre, correo, contraseña, tipoUsuario);
    }

    public static void insertarUsuario(Context context, Usuario usuario) {
        BaseDeDatosUsuarios dbHelper = new BaseDeDatosUsuarios(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nombre", usuario.getNombre());
        values.put("correo", usuario.getCorreo());
        values.put("contraseña", usuario.getContraseña());
        values.put("tipoUsuario", usuario.getTipoUsuario());

        long id = database.insert("usuarios", null, values);


    }

    public static Usuario buscarUsuario(Context context, String nombre) {
        BaseDeDatosUsuarios dbHelper = new BaseDeDatosUsuarios(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        String[] projection = {"nombre", "correo", "contraseña", "tipoUsuario"};
        String selection = "nombre = ?";
        String[] selectionArgs = {nombre};

        Cursor cursor = database.query("usuarios", projection, selection, selectionArgs, null, null, null);

        Usuario usuario = null;

        while (cursor.moveToNext()) {
            String nombreUsuario = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
            String correoUsuario = cursor.getString(cursor.getColumnIndexOrThrow("correo"));
            String contraseñaUsuario = cursor.getString(cursor.getColumnIndexOrThrow("contraseña"));
            String tipoUsuario = cursor.getString(cursor.getColumnIndexOrThrow("tipoUsuario"));

            usuario = UsuarioFactory.crearUsuario(nombreUsuario, correoUsuario, contraseñaUsuario, tipoUsuario);
        }

        cursor.close();

        return usuario;
    }

    public static void eliminarUsuario(Context context, String nombre) {
        BaseDeDatosUsuarios dbHelper = new BaseDeDatosUsuarios(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        String selection = "nombre = ?";
        String[] selectionArgs = {nombre};

        database.delete("usuarios", selection, selectionArgs);
    }

    public static void actualizarUsuario(Context context, Usuario usuario) {
        BaseDeDatosUsuarios dbHelper = new BaseDeDatosUsuarios(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nombre", usuario.getNombre());
        values.put("correo", usuario.getCorreo());
        values.put("contraseña", usuario.getContraseña());
        values.put("tipoUsuario", usuario.getTipoUsuario());

        String selection = "nombre = ?";
        String[] selectionArgs = {usuario.getNombre()};

        int count = database.update("usuarios", values, selection, selectionArgs);
    }

    

}