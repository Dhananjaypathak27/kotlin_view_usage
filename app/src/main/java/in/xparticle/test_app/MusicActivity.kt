package `in`.xparticle.test_app

import android.media.MediaParser
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MusicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)

        val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.ride_assign_music);

        mediaPlayer.start();
    }
}