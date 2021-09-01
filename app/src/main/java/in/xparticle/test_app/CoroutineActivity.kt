package `in`.xparticle.test_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineActivity : AppCompatActivity() {

    private val TAG = "CoroutineActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)

        GlobalScope.launch {
            delay(3000L)
            android.util.Log.e(TAG, "onCreate: thead name is ${Thread.currentThread().name}" )
        }

        android.util.Log.e(TAG, "onCreate: thead name is ${Thread.currentThread().name}" )


    }
}