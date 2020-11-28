package com.example.pacdesarrollo

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

class servicioMusic: Service(){
    private lateinit var mp: MediaPlayer
    lateinit var mimusica:Musica

    override fun   onCreate() {
        super.onCreate()
        mp= MediaPlayer.create(this,R.raw.steel)
        mimusica=Musica(mp)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

            val datos = intent?.extras?.getString("data")

            if (datos != null) {
                if (datos== "play") {
                    Toast.makeText(this, "reproduciendo", Toast.LENGTH_SHORT).show()
                    mp.start()

                } else if (datos == "pause") {
                    Toast.makeText(this, "pausado", Toast.LENGTH_SHORT).show()
                    mp.pause()

                } else if (datos == "block") {
                    Toast.makeText(this, "Bloqueado", Toast.LENGTH_SHORT).show()
                    mimusica.start()
                }

            }

            return START_STICKY

    }

    override fun onDestroy() {
        super.onDestroy()
        mp.stop()
        mp.release()

    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }


}
class Musica(mp:MediaPlayer) :Thread (){

    val mp:MediaPlayer = mp
    override fun run() {
        mp.pause()
        sleep(15000)
        mp.start()
    }


}
