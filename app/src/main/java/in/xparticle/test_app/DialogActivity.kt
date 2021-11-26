package `in`.xparticle.test_app

import `in`.xparticle.test_app.util.AppUtils
import `in`.xparticle.test_app.util.ButtonClickInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class DialogActivity : AppCompatActivity(),ButtonClickInterface{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        findViewById<Button>(R.id.clickBtn).setOnClickListener(View.OnClickListener {
            AppUtils.alertDialog("this is title","this is message",this@DialogActivity)
        })

        findViewById<Button>(R.id.clickBtn2).setOnClickListener(View.OnClickListener {
            AppUtils.posNegAlertDialog("this is title","this is message",this@DialogActivity,this@DialogActivity)
        })
    }

    override fun positiveButtonClicked() {
        Toast.makeText(this, "positive button ", Toast.LENGTH_SHORT).show()
    }

    override fun negativeButtonClicked() {
        Toast.makeText(this, "negative button ", Toast.LENGTH_SHORT).show()

    }
}