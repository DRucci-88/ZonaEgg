package id.ac.umn.zonaegg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import id.ac.umn.zonaegg.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("home", "On Create")
        binding.toolbarHome.setOnMenuItemClickListener {
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

    override fun onStart() {
        super.onStart()
        Log.d("home", "On Start")
    }

    override fun onPause() {
        super.onPause()
        Log.d("home", "On Pause")
    }

    override fun onResume() {
        super.onResume()
        Log.d("home", "On Resume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("home", "On Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("home", "On Destroy")
    }
}

