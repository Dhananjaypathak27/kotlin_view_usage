package `in`.xparticle.test_app

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class AnonymousBroadcastReceiverMainActivity : AppCompatActivity() {

    lateinit var broadcastReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anonymous_broadcast_receiver_main)
    }

    override fun onStart() {
        super.onStart()


        val intentFilter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
        registerReceiver(wifiStateReceiver, intentFilter)
    }

//    override fun onStop() {
//        super.onStop()
//        unregisterReceiver(wifiStateReceiver)
//    }

    private val wifiStateReceiver : BroadcastReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent != null) {
                when (intent.getIntExtra(
                    WifiManager.EXTRA_WIFI_STATE,
                    WifiManager.WIFI_STATE_UNKNOWN)) {
                    WifiManager.WIFI_STATE_ENABLED -> {

                        Toast.makeText(this@AnonymousBroadcastReceiverMainActivity, "Wifi is On", Toast.LENGTH_SHORT).show()
                        Log.e("TAG", "onReceive: wifi is onn" )
                    }
                    WifiManager.WIFI_STATE_DISABLED -> {
                        Log.e("TAG", "onReceive: wifi is disable" )
                        Toast.makeText(this@AnonymousBroadcastReceiverMainActivity, "Wifi is Off", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }

    }
}