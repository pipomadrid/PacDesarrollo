package com.example.pacdesarrollo

import android.content.ContentValues
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main_activity2_2.*
import utilidades.Utilidades

class MainActivity2_2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity2_2)




        botonInsertar2.setOnClickListener {

            val campo1=Utilidades.campo1
            val campo2=Utilidades.campo2
            val valorCodigo = etInsertarCodigo.text.toString()
            val valorCampo1 = etInsertarCampo1.text.toString()
            val valorCampo2 = etInsertarCampo2.text.toString()

            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val BaseDeDatos: SQLiteDatabase = admin.writableDatabase


            if (!valorCodigo.isEmpty() && !valorCampo1.isEmpty() && !valorCampo2.isEmpty()) {

                val registro = ContentValues()
                registro.put("codigo",valorCodigo)
                registro.put(campo1, valorCampo1)
                registro.put(campo2, valorCampo2)
                try {
                    BaseDeDatos.insert(Utilidades.nombreTabla, null, registro)
                }catch(e:SQLiteConstraintException){
                    Toast.makeText(this, "El codigo ya está en uso", Toast.LENGTH_SHORT).show()

                }

                BaseDeDatos.close()
                etInsertarCampo1.setText("")
                etInsertarCodigo.setText("")
                etInsertarCampo2.setText("")
            } else {
                Toast.makeText(this, "debes rellenar todos los campos", Toast.LENGTH_SHORT).show()

            }
        }




    }
}