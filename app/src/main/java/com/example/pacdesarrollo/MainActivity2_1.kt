package com.example.pacdesarrollo

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main_activity2_1.*
import kotlinx.android.synthetic.main.activity_main_activity2_1.view.*
import utilidades.Utilidades
import java.lang.Exception
import java.sql.SQLException

class MainActivity2_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity2_1)


        botonCrear2.setOnClickListener {

            //recogemos los datos de los et y los guardamos en variables
            var nombreTabla=etNombre.text.toString()
            var campo1=etCampo1.text.toString()
            var campo2=etCampo2.text.toString()

            //cmprobamos si se han rellenado todos los campos
            if(nombreTabla.isNotEmpty() && campo1.isNotEmpty() && campo2.isNotEmpty()) {

                /*guardamos las variables en la clase utilidades para que sean accesibles a
                 todo el proyecto*/

                Utilidades.nombreTabla=nombreTabla
                Utilidades.campo1=campo1
                Utilidades.campo2=campo2

                val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
                val BaseDeDatos: SQLiteDatabase = admin.writableDatabase

                //Comprobamos si la base de datos ha sido creada, si no lo ha sido
                if(BaseDeDatos!=null) {
                    try {
                        /*creamos aqui la tabla para que cree una cada vez que damos al boton crear
                        y capturamos el error por si la tabla ya existe
                         */
                        BaseDeDatos.execSQL("Create table " + nombreTabla + "( codigo INTEGER primary key, " + campo1 + " TEXT," + campo2 + " TEXT)")
                    }catch (e:SQLiteException){
                        Toast.makeText(this, "La tabla ya existe", Toast.LENGTH_SHORT).show()

                    }
                }

                Toast.makeText(this, "Has creado la tabla", Toast.LENGTH_SHORT).show()
                //creamos la tabla y volvemos a la activity 2
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)

            }else{

                Toast.makeText(this, "No has completado todos los campos", Toast.LENGTH_SHORT).show()
            }

        }
        //Boton para volver a  activity 2
        botonVolverAct2_1.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)


        }


    }


}