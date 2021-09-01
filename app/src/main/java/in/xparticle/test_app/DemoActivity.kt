package `in`.xparticle.test_app

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class DemoActivity: AppCompatActivity() {

    val br: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.e("TAG", "onReceive: 1")
        }
    }

    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
        btn = findViewById(R.id.btn)
        btn.setOnClickListener {
        sendBroadcast(Intent().setAction("in.xparticle.test_app.demo"))
        }

    }

    override fun onStart() {
        super.onStart()
        registerReceiver(br, IntentFilter("in.xparticle.test_app.demo"))
    }

    override fun onPause() {
        super.onPause()
        //unregisterReceiver(br)
    }

}