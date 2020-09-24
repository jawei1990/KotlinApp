package com.example.lab9_1

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private var rab_progress = 0
    private var tot_progress = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BtnStart.setOnClickListener()
        {
            BtnStart.isEnabled = false;
            rab_progress = 0
            tot_progress = 0

            sb_rabblit.progress = 0
            sb_totle.progress = 0

            runThread() // 處理Random 兔子移動
            runAyncTask() // 處理烏龜移動
        }
    }

    private fun runThread()
    {
        object : Thread()
        {
            override fun run()
            {
                while (rab_progress <= 100 && tot_progress < 100)
                {
                    try
                    {
                        Thread.sleep(100) // delay 0.1s
                    }
                    catch (e: InterruptedException)
                    {
                        e.printStackTrace()
                    }

                    rab_progress += (Math.random() * 3).toInt()
                    val msg = Message()
                    msg.what = 1
                    mHandler.sendMessage(msg)
                }
            }
        }.start()
    }

    private val mHandler = Handler(Handler.Callback { msg->
        when(msg.what)
        {
            1->sb_rabblit.progress = rab_progress
        }

        if(rab_progress >= 100 && tot_progress < 100)
        {
            Toast.makeText(this,"兔子勝利",Toast.LENGTH_SHORT).show()
            BtnStart.isEnabled = true
        }
        true
    })

    private fun runAyncTask()
    {
        object: AsyncTask<Void, Int, Boolean>()
        {
            override fun doInBackground(vararg params: Void?): Boolean {
                while (tot_progress <= 100 && rab_progress < 100)
                {
                    try
                    {
                        Thread.sleep(100) // delay 0.1s
                    }
                    catch(e:InterruptedException)
                    {
                        e.printStackTrace()
                    }

                    tot_progress += (Math.random()*3).toInt()
                    publishProgress(tot_progress)
                }
                return true
            }

            override fun onProgressUpdate(vararg values: Int?)
            {
                super.onProgressUpdate(*values)
                values[0]?.let {
                    sb_totle.progress = it
                }
            }

            override fun onPostExecute(result: Boolean?)
            {
                super.onPostExecute(result)

                if(tot_progress >= 100 && rab_progress < 100)
                {
                    Toast.makeText(this@MainActivity,"烏龜贏了",Toast.LENGTH_SHORT).show()
                    BtnStart.isEnabled = true
                }
            }
        }.execute()
    }
}