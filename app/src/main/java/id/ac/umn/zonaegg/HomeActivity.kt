package id.ac.umn.zonaegg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.umn.zonaegg.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var bind: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(bind.root)
    }
}

