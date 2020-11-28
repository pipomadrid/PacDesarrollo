package com.example.pacdesarrollo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import utilidades.Utilidades
import java.sql.SQLException

class AdminSQLiteOpenHelper(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int )
    : SQLiteOpenHelper(context, name, factory, version) {


    var nombre=Utilidades.nombreTabla
    var campo1=Utilidades.campo1
    var campo2=Utilidades.campo2
    var crearTabla="Create table " + nombre + "( codigo INTEGER primary key, " + campo1 + " TEXT," + campo2 + " TEXT)"

     override fun onCreate(BaseDeDatos: SQLiteDatabase?) {


         if (BaseDeDatos != null) {

             BaseDeDatos.execSQL(crearTabla)
         }
     }

     override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
         if (p0 != null) {
             p0.execSQL("DROP TABLE IF EXISTS " + crearTabla)
         }
         onCreate(p0)
     }



 }