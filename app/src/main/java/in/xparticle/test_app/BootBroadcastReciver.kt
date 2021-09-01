package `in`.xparticle.test_app

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BootBroadcastReciver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.e("TAG", "onReceive:  boot complete")
        context?.sendBroadcast(Intent().setAction("in.xparticle.test_app.demo"))
        
    }
}