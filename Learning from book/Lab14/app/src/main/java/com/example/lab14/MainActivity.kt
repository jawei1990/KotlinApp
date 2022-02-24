package com.example.lab14

import android.app.ProgressDialog.show
import android.content.*
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.appcompat.app.AlertDialog
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private val receiver: BroadcastReceiver = object :BroadcastReceiver()
    {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.e("Awei","33536+")
            val json = intent?.extras?.getString("json")?: return
            val data = Gson().fromJson(json,Data::class.java)
            val items = arrayOfNulls<String>(data.result.results.size)
            for(i in 0 until data.result.results.size)
                items[i] = "\n 列車即將進入: ${data.result.results[i].Station}" +
                            "\n 列車行駛目的地: + ${data.result.results[i].Destination}"
            this@MainActivity.runOnUiThread{
                AlertDialog.Builder(this@MainActivity)
                    .setTitle("台北捷運列車到站站名")
                    .setItems(items,null)
                    .show()
            }

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentfilter = IntentFilter("MyMessage")
        registerReceiver(receiver,intentfilter)

        val isWifiEable = CheckWifiEnable()
        when
        {
            isWifiEable == true ->
                Log.e("Awei","網路已開啟")
            else ->
                this@MainActivity.runOnUiThread{
                    Log.e("Awei","沒有網路")
                    Toast.makeText(this@MainActivity,"請開啟Wifi或 網路",Toast.LENGTH_SHORT).show()
                }

        }

        btnSearch.setOnClickListener()
        {
            val req = Request.Builder()
                .url("https://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire" +
                        "&rid=55ec6d6e-dc5c-4268-a725-d04cc262172b").build()
            OkHttpClient().newCall(req).enqueue(object:Callback
            {
                override fun onResponse(call: Call, response: Response) {
                    when
                    {
                        response.code() == 200 ->
                        {
                            val json = response.body()?.string()?: return
                            sendBroadcast(Intent("MyMessage").putExtra("json",json))
                        }

                        !response.isSuccessful -> Log.e("Awei","伺服器錯誤: ${response.code()} ${response.message()}")
                        else -> Log.e("Awei","其他錯誤: ${response.code()} ${response.message()}")
                    }
                }

                override fun onFailure(call: Call, e: IOException) {
                    val isWifiEable = CheckWifiEnable()
                    when
                    {
                        isWifiEable == true ->
                            Log.e("Awei","查詢錯誤: + $e")
                        else ->
                            this@MainActivity.runOnUiThread{
                                Log.e("Awei","Error: + $e")
                                Toast.makeText(this@MainActivity,"請開啟Wifi或 網路",Toast.LENGTH_SHORT).show()
                            }

                    }

                }
            })
        }
    }

    fun CheckWifiEnable(): Boolean
    {
        val WifiManager : WifiManager = getSystemService(Context.WIFI_SERVICE) as WifiManager
        return WifiManager.isWifiEnabled
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}