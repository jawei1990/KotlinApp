package com.example.lab11

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentFliter = IntentFilter("MyMessage")
        registerReceiver(receiver,intentFliter)

        flag = MyService.flag

        btnOK.setOnClickListener()
        {
            flag = !flag
            btnOK.text = if(flag) "暫停" else "開始"
            startService(Intent(this,MyService::class.java).putExtra("" +
                    "flag",flag))

            Toast.makeText(this,if(flag) "計時暫停" else "計時開始",Toast.LENGTH_SHORT).show()
        }
    }

    private val receiver :BroadcastReceiver = object : BroadcastReceiver()
    {
        override fun onReceive(context: Context?, intent: Intent) {
            intent.extras?.let {
                tv_time?.text = "%02d:%02d:%02d".format(it.getInt("H"),it.getInt("M"),it.getInt("S"))
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}