package `in`.xparticle.test_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate


//https://www.geeksforgeeks.org/how-to-implement-dark-night-mode-in-android-app/

class ChangeThemeActivity : AppCompatActivity() {

    var isLightModeEnable = true
    lateinit var btnToggleDark: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_theme)

        btnToggleDark = findViewById(R.id.btnToggleDark)

        btnToggleDark.setOnClickListener {
            when {
                isLightModeEnable -> {
                    isLightModeEnable = false
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
                else -> {
                    isLightModeEnable = true
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
            }
        }
    }
}