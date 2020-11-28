package com.example.pacdesarrollo
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main3.*


class MainActivity3 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        Toast.makeText(this, "Estas en la Activity 3", Toast.LENGTH_SHORT).show()



        /*val spinner: Spinner = findViewById(R.id.spinner)

        ArrayAdapter.createFromResource(this, R.array.opciones_spinner, R.layout.spinner_item_musica).also { adapter ->

            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
            spinner.adapter = adapter
        }*/

        botonServicio.setOnClickListener {

                val intent=Intent(this,MainActivity3_1::class.java)
                startActivity(intent)
                /*val mediaPlayer = Intent(this, servicioMusic::class.java)
                val seleccionItem = spinner.selectedItem.toString()
                mediaPlayer.putExtra("item", seleccionItem)
                this.startService(mediaPlayer)*/


        }
        botonDetener.setOnClickListener {
            val mediaPlayer = Intent(this, servicioMusic::class.java)
            this.stopService(mediaPlayer)

        }


        botonVolver.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }

    }
}
