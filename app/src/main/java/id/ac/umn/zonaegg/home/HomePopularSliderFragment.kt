package id.ac.umn.zonaegg.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import id.ac.umn.zonaegg.R
import id.ac.umn.zonaegg.data.Eatery
import id.ac.umn.zonaegg.databinding.FragmentHomePopularSliderBinding
import kotlin.math.abs

class HomePopularSliderFragment : Fragment() {

    private lateinit var bind: FragmentHomePopularSliderBinding
    private var sliderHandler = Handler(Looper.getMainLooper())
    private val popularList: ArrayList<Eatery> = arrayListOf(
        Eatery("Pondok Makan", "Pondok Makan", "Warteg", 4.9, 2.8, "https://firebasestorage.googleapis.com/v0/b/zonaegg-8bf3b.appspot.com/o/Warteg%2FPondok%20Makan%2FS__4448275.jpg?alt=media&token=1685d49d-f757-4f70-9536-e966bcc746d8"),
        Eatery("Nyapii!", "Nyapii!", "Restaurant", 5.0, 4.8, "https://firebasestorage.googleapis.com/v0/b/zonaegg-8bf3b.appspot.com/o/Restoran%2FNyapii!%2F120271355_104652764739956_2039778306485302658_n.jpg?alt=media&token=e0f2b9d0-1bef-47cb-803a-de893b059990"),
        Eatery("Lamian Palace", "Lamian Palace", "Restaurant", 4.9, 4.1, "https://firebasestorage.googleapis.com/v0/b/zonaegg-8bf3b.appspot.com/o/Restoran%2FLamian%20Palace%2FBakpao%20Naga%20Durian%20Cropped.jpg?alt=media&token=60fbadb2-4aa7-45d1-9574-a640eb31eb34")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        bind = FragmentHomePopularSliderBinding.inflate(inflater, container, false)

        // https://www.youtube.com/watch?v=iA9iqygq11Q
        bind.sliderHomePopular.adapter = HomePopularSliderAdapter(popularList, bind.sliderHomePopular)
        bind.sliderHomePopular.clipToPadding = false
        bind.sliderHomePopular.clipChildren = false
        bind.sliderHomePopular.offscreenPageLimit = 3
        bind.sliderHomePopular.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer =  CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85F + r * 0.15F
//            page.scaleY = 1F
        }

        bind.sliderHomePopular.setPageTransformer(compositePageTransformer)
        bind.sliderHomePopular.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
//                Log.d("heroism",position.toString())
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 3000)
            }
        })
        return bind.root
    }
    val sliderRunnable: Runnable = Runnable {
        kotlin.run {
            bind.sliderHomePopular.currentItem = bind.sliderHomePopular.currentItem + 1
        }
    }
    override fun onResume() {
        super.onResume()
        sliderHandler.postDelayed(sliderRunnable, 3000)
    }
    override fun onPause() {
        super.onPause()
        sliderHandler.removeCallbacks(sliderRunnable)
    }
}