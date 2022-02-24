package com.example.lab9_2

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOK.setOnClickListener()
        {
            when
            {
                ed_hight.length() < 1 ->
                    Toast.makeText(this,"請輸入身高",Toast.LENGTH_SHORT).show()
                ed_weight.length() < 1 ->
                    Toast.makeText(this,"請輸入體重",Toast.LENGTH_SHORT).show()
                else ->
                    runAsyncTask()
            }
        }
    }

    private fun runAsyncTask()
    {
        object : AsyncTask<Void,Int,Boolean>()
        {
            override fun onPreExecute() {
                super.onPreExecute()

                tv_stand.text = getString(R.string.defualt_weigth)
                tv_fat.text = getString(R.string.defualt_fat)
                progress_bar.progress = 0
                tv_progress.text = "0%"
                progressLayout.visibility = View.VISIBLE
            }

            override fun doInBackground(vararg params: Void?): Boolean {
                var process = 0
                while (process <= 100)
                {
                    try
                    {
                        Thread.sleep(50) // delay 50ms
                        publishProgress(process)
                        process++
                    }
                    catch (e:Exception)
                    {
                        e.printStackTrace()
                    }
                }
                return true
            }

            override fun onProgressUpdate(vararg values: Int?) {
                super.onProgressUpdate(*values)
                values[0]?.let {
                    progress_bar.progress = it
                    tv_progress.text = "$it %"
                }
            }

            override fun onPostExecute(result: Boolean?) {
                super.onPostExecute(result)
                progressLayout.visibility = View.INVISIBLE
                val cal_height = ed_hight.text.toString().toDouble()
                val cal_weight = ed_weight.text.toString().toDouble()

                val cal_stand:Double
                val cal_fat:Double

                if(rb_man.isChecked)
                {
                    cal_stand = (cal_height - 80) * 0.7
                    cal_fat = (cal_weight - 0.82 * cal_stand) / cal_weight * 100
                }
                else
                {
                    cal_stand = (cal_height - 70) * 0.6
                    cal_fat = (cal_weight - 0.82 * cal_stand) / cal_weight * 100
                }

                tv_stand.text = "標準體重 \n ${String.format("%.2f",cal_stand)}"
                tv_fat.text = "體脂肪 \n ${String.format("%.2f",cal_fat)}"
            }
        }.execute()
    }
}