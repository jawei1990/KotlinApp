package com.example.lab10

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder

class MyService : Service() {

    override fun onCreate() {
        super.onCreate()

 /*       Handler().postDelayed({
            val intent = Intent(this@MyService,MainActivity2::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            this@MyService.startActivity(intent)
        },5000)*/
        Thread(Runnable {
          try
          {
              Thread.sleep(5000) // Delay 5s
              val intent = Intent(this@MyService,MainActivity2::class.java)
              intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
              this@MyService.startActivity(intent)
          }
          catch(e:InterruptedException)
          {
              e.printStackTrace()
          }
        }).start()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return Service.START_NOT_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}
