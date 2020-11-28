package com.example.pacdesarrollo

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_activity2_3.*
import utilidades.Utilidades

class MainActivity2_3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity2_3)



        val campo1= Utilidades.campo1
        val campo2=Utilidades.campo2
        val nombreTabla=Utilidades.nombreTabla

        et2.setHint(campo1)
        et3.setHint(campo2)

        tituloTabla.setText(nombreTabla)

        prueba.setOnClickListener {

            val admin = AdminSQLiteOpenHelper(this, "administracion",null,1)

            val BaseDeDatos : SQLiteDatabase =admin.readableDatabase

            val codigo=et1.getText().toString()
            if(!campo1.isEmpty()) {
                val fila: Cursor =BaseDeDatos.rawQuery("select $campo1, $campo2 from  $nombreTabla  where codigo= $codigo",null)
                if(fila.moveToFirst()){
                    et2.setText(fila.getString(0))
                    et3.setText(fila.getString(1))
                    BaseDeDatos.close()

                }else{
                    Toast.makeText(this,"No existe el codigo", Toast.LENGTH_SHORT).show()
                    BaseDeDatos.close()            }

            }else {
                Toast.makeText(this,"debes introducir un codigo", Toast.LENGTH_SHORT).show()
            }

        }
    }
}