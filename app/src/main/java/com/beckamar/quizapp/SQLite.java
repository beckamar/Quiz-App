package com.beckamar.quizapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite extends SQLiteOpenHelper {
    public SQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE pregunta ( id INTEGER PRIMARY KEY AUTOINCREMENT, preg  TEXT NOT NULL, resp1 TEXT NOT NULL, resp2 TEXT NOT NULL,  resp3 TEXT NOT NULL,  resp4 TEXT NOT NULL, respCorrect TEXT NOT NULL );";
        db.execSQL(query);

        query = "INSERT INTO pregunta VALUES (NULL, 'Botones de Java', 'Jbutton', 'JComboBox',  'Jdialog', 'JFileSelection', 'Jbutton');";
        db.execSQL(query);
        query = "INSERT INTO pregunta VALUES (NULL, 'Nombre de la materia', 'Programación Orientada a Objetos' , 'Tópicos Avanzados de Programación', 'Estructuras de Datos','Fundamentos de Programación', 'Tópicos Avanzados de Programación');";
        db.execSQL(query);
        query = "INSERT INTO pregunta VALUES (NULL, 'Biblioteca para uso de colecciones en Java', 'IO', 'lang' , 'math' , 'util', 'util');";
        db.execSQL(query);
        query = "INSERT INTO pregunta VALUES (NULL, 'Nombre de la maestra de TAP', 'Virginia Pérez González' , 'Victoria Lagunes Barradas',  'Virginia Lagunes Barradas',  'Ninguno de los anteriores', 'Virginia Lagunes Barradas');";
        db.execSQL(query);
        query = "INSERT INTO pregunta VALUES (NULL, 'Nombre de TAP', 'Virginia Pérez González' , 'Victoria Lagunes Barradas', 'Virginia Lagunes Barradas',  'Ninguno de los anteriores', 'Virginia Lagunes Barradas');";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
//INSERT INTO preguntas VALUES (NULL, '@', '@', '@', '@', '@', '@', '@', '@', '@');
