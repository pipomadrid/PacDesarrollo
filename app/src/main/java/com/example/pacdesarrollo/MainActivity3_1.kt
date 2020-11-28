package com.example.pacdesarrollo

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_activity3_1.*

class MainActivity3_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity3_1)
        Toast.makeText(this, "Estas en el servicio de musica", Toast.LENGTH_SHORT).show()






        botonPlay.setOnClickListener {
            val mensaje="play"
            val mediaPlayer = Intent(this, servicioMusic::class.java)
            mediaPlayer.putExtra("data", mensaje)
            this.startService(mediaPlayer)

        }

        botonPause.setOnClickListener {
            val mensaje="pause"
            val mediaPlayer = Intent(this, servicioMusic::class.java)
            mediaPlayer.putExtra("data",mensaje)
            this.startService(mediaPlayer)


        }

        botonBlock.setOnClickListener{

            val mensaje="block"
            val mediaPlayer = Intent(this, servicioMusic::class.java)
            mediaPlayer.putExtra("data",mensaje)
            this.startService(mediaPlayer)
        }

        botonVolver.setOnClickListener{
            val intent=Intent(this,MainActivity3::class.java)
            startActivity(intent)

        }
    }

}