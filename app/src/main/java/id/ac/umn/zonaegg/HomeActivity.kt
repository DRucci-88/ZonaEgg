package id.ac.umn.zonaegg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import id.ac.umn.zonaegg.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var bind: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.toolbarHome.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.top_bar_home_search -> {
                    true
                }
                R.id.top_bar_home_settings -> {
                    true
                }
                else -> false
            }
        }


    }
}

