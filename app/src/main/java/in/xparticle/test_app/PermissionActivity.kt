package `in`.xparticle.test_app

import android.Manifest

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat


class PermissionActivity : AppCompatActivity() {

    private  val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        findViewById<Button>(R.id.btnRequestPermission).setOnClickListener {
            Toast.makeText(this,"permission",Toast.LENGTH_SHORT).show()
            requestPermission()
            }
        }

    private fun hasWriteExternalStoragePermission() = ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

    private fun hasLocationForgroundPermission() = ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun hasLocationBackGroundPermission() = ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED


    private fun requestPermission() {
        var permissionToRequest = mutableListOf<String>()
        if(!hasWriteExternalStoragePermission()){
            permissionToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }

//        @RequiresApi(Build.VERSION_CODES.Q)
//        if(!hasLocationBackGroundPermission()){
//            permissionToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
//        }

        if(!hasLocationForgroundPermission()){
            permissionToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }

        if(permissionToRequest.isNotEmpty()){

            ActivityCompat.requestPermissions(this,permissionToRequest.toTypedArray(),0)
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == 0 && grantResults.isNotEmpty()){
            for(i in grantResults.indices){
                if(grantResults[i] == PackageManager.PERMISSION_GRANTED){
                    Log.e(TAG, "onRequestPermissionsResult: ${permissions[i]} permission grandted" )
                }
            }
        }
    }
}