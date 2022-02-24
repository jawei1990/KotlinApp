# Google Map APP
----

1.Initialize layout 後, 按下 Build & Run, 要開 **網路** 才會顯示整個地圖,不然只會顯示google 的 icon.

2.在 Kotlin 中, as 通常用作"不安全的轉換操作符號",如果轉換是不可能的,轉換操作符號會拋出異常而為避免拋出異常, as 可作為安全符號, 也就是 as? ,可在失敗時返回null, [參考該寫法]( https://www.kotlincn.net/docs/reference/typecasts.html)

3.`android.permission.ACCESS_COARSE_LOCATION`: 允許使用Wifi 或行動數據(或兩者皆有)來判斷位置,API 回傳位置以城市街區為單位
`android.permission.ACCESS_FINE_LOCATION`: 除了Wifi 和行動數據可以使用,還可以透過定位服務系統供應商(GPS)精確判斷位址

4.LatLng: 原文如下, 也就是將 **經緯度座標轉換成角度**
```su
An immutable class representing a pair of latitude and longitude coordinates, stored as degrees.
```

5.PolylineOption 相關設定可參考: https://www.oxxostudio.tw/articles/201802/google-maps-9-polyline.html

### Screen Shot
![image](https://github.com/jawei1990/KotlinApp/blob/master/Lab12/pic/ScreenShots.png)
