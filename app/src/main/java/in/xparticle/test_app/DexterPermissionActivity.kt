package `in`.xparticle.test_app

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import android.content.pm.PackageManager




class DexterPermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dexter_permission)

        Dexter.withContext(this@DexterPermissionActivity)
            .withPermissions(
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(multiplePermissionsReport: MultiplePermissionsReport) {


                    // check if all permissions are granted
                    if (multiplePermissionsReport.areAllPermissionsGranted()) {
                        // do you work now

                        Toast.makeText(this@DexterPermissionActivity, "permission granted", Toast.LENGTH_SHORT).show()
                    }

                    // check for permanent denial of any permission
                    if (multiplePermissionsReport.isAnyPermissionPermanentlyDenied) {
                        // permission is denied permenantly, navigate user to app settings
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    list: List<PermissionRequest>,
                    permissionToken: PermissionToken
                ) {
                    permissionToken.continuePermissionRequest()
                }
            })
            .onSameThread()
            .check()

        checkPermissionGrated()
    }
    private fun checkPermissionGrated(){
//        val permission = Manifest.permission.WRITE_EXTERNAL_STORAGE
//        val res: Int = this.checkCallingOrSelfPermission(permission)
//        return res == PackageManager.PERMISSION_GRANTED

        val requiredPermission = Manifest.permission.ACCESS_FINE_LOCATION
        val checkVal: Int = this.checkCallingOrSelfPermission(requiredPermission)

        if (checkVal==PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this@DexterPermissionActivity, "storage and gsp granted", Toast.LENGTH_SHORT).show()

        }
        else{
            Toast.makeText(this@DexterPermissionActivity, " not storage and gsp granted", Toast.LENGTH_SHORT).show()

        }
    }
}