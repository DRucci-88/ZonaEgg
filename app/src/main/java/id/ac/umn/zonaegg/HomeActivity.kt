package id.ac.umn.zonaegg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import id.ac.umn.zonaegg.data.Eatery
import id.ac.umn.zonaegg.databinding.ActivityHomeBinding
import id.ac.umn.zonaegg.home.HomePopularSliderAdapter
import kotlin.math.abs

class HomeActivity : AppCompatActivity() {

    private lateinit var bind: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(bind.root)
    }
}