# LAB 14 
----

1. 接收 http response 後, 需要將 JSON 字串轉成程式物件, 這動作叫做`反序列化`, 可透過 Google 
    提供的 Open library GSON 做 JSON 轉化
   
    ![image](https://github.com/jawei1990/KotlinApp/blob/master/Lab14/img/jsonToGson.PNG)

2. 再使用 HTTPS 的前提之下,需要Wifi 網路, 若沒有網路OKhttpClient 則會呼叫失敗,         這時候會得到的錯誤訊息
    ``` kotlin
    java.net.UnknownHostException: Unable to resolve host 
    ```
    所以再APP被 create 的剛開始, 可以檢查是否打開網路, 再去送OKhttp 等相關作業
    ``` kotlin
    fun CheckWifiEnable(): Boolean
    {
        val WifiManager : WifiManager = 
                        getSystemService(Context.WIFI_SERVICE) as WifiManager
        return WifiManager.isWifiEnabled
    }
    ```    
    再使用 WifiManager 前, 必須要先在AndroidManifest內打開`ACCESS_WIFI_STATE`的權限
    ``` kotlin
     <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
    ``` 
