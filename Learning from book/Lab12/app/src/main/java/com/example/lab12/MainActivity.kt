package com.example.lab12

import android.content.pm.PackageManager
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    companion object
    {
        private const val REQUEST_PERMISSIONS = 1
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray)
    {
        if(grantResults.isEmpty()) return
        when(requestCode)
        {
            REQUEST_PERMISSIONS->
            {
                for(result in grantResults)
                    if(result != PackageManager.PERMISSION_GRANTED)
                    {
                        finish()
                    }
                    else
                    {
                        val map = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
                        map?.getMapAsync(this)
                    }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this,
            arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),REQUEST_PERMISSIONS)
        else
        {
            Log.e("Awei","maps_api_key:" + getString(R.string.maps_api_key))
            if (getString(R.string.maps_api_key).isEmpty()) {
                Toast.makeText(this, "Add your own API key in /.../Lab12/app/secure.properties as MAPS_API_KEY=YOUR_API_KEY", Toast.LENGTH_LONG).show()
            }

            val map = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
            map?.getMapAsync(this)
        }
    }

    override fun onMapReady(map: GoogleMap?) {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED )
            return

        map ?: return

        // 必須要開 Coarse or fine loacation 權限
        map.isMyLocationEnabled = true
        val marker = MarkerOptions()
        marker.position(LatLng(25.033611,121.56500))
        marker.title("台北101")
        marker.draggable(true)

        map.addMarker(marker)
        marker.position(LatLng(25.047924,121.517081))
        marker.title("台北火車站")
        marker.draggable(true)

        // 折線設定
        val polylineOpt = PolylineOptions()
        polylineOpt.add(LatLng(25.033611,121.565000))
        polylineOpt.add(LatLng(25.032728,121.565137))
        polylineOpt.add(LatLng(25.047924,121.517081))
        polylineOpt.color(Color.BLUE)
        val polyline = map.addPolyline(polylineOpt)
        polyline.width = 10f

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(25.034,121.5445),13f))

    }
}