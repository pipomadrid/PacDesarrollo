package com.example.pacdesarrollo

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import utilidades.Utilidades

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Toast.makeText(this, "Estas en la Activity 2", Toast.LENGTH_SHORT).show()

        botonCrear.setOnClickListener{
            val intent=Intent(this,MainActivity2_1::class.java)
            startActivity(intent)

        }


        botonInsertar.setOnClickListener{
            val intent=Intent(this,MainActivity2_2::class.java)
            startActivity(intent)

        }

        botonConsultar.setOnClickListener {

            val intent=Intent(this,MainActivity2_3::class.java)
            startActivity(intent)


        }

        botonVolverAct2.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)

        }

    }


}





       /* val boton2: Button = findViewById(R.id.botonVolverAct1)
        boton2.setOnClickListener{
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)

        }

    }
     fun Registrar(view : View) {

         val admin =AdminSQLiteOpenHelper(this,"administracion", null,1)

         val BaseDeDatos:SQLiteDatabase= admin.writableDatabase

         val codigo=etCodigo.getText().toString()
         val nombre=etNombre.getText().toString()
         val puntuacion=etPuntuacion.getText().toString()

         if(!codigo.isEmpty() && !nombre.isEmpty() && !puntuacion.isEmpty()){

             val registro:ContentValues= ContentValues()
             registro.put("codigo", codigo)
             registro.put("nombre" , nombre)
             registro.put("puntuacion" , puntuacion)

             BaseDeDatos.insert("puntuaciones", null ,registro)
             BaseDeDatos.close()
             etCodigo.setText("")
             etNombre.setText("")
             etPuntuacion.setText("")
         }else{
             Toast.makeText(this,"debes rellenar todos los campos", Toast.LENGTH_SHORT).show()

         }

    }

    fun Buscar(view:View){

        val admin = AdminSQLiteOpenHelper(this, "administracion",null,1)

        val BaseDeDatos :SQLiteDatabase=admin.readableDatabase

        val codigo=etCodigo.getText().toString()
        if(!codigo.isEmpty()) {
            val fila:Cursor =BaseDeDatos.rawQuery("select nombre,puntuacion from  puntuaciones  where codigo= " + codigo,null)
            if(fila.moveToFirst()){
                etNombre.setText(fila.getString(0))
                etPuntuacion.setText(fila.getString(1))
                BaseDeDatos.close()

            }else{
                Toast.makeText(this,"No existe la puntuacion asociada a ese usuario", Toast.LENGTH_SHORT).show()
                BaseDeDatos.close()            }

        }else {
            Toast.makeText(this,"debes introducir un codigo", Toast.LENGTH_SHORT).show()
        }

    }
}*/