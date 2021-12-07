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
import id.ac.umn.zonaegg.data.EaterySlider
import id.ac.umn.zonaegg.databinding.FragmentHomePopularSliderBinding
import kotlin.math.abs

class HomePopularSliderFragment : Fragment() {

    private lateinit var bind: FragmentHomePopularSliderBinding
    private var sliderHandler = Handler(Looper.getMainLooper())
    private val popularList: ArrayList<EaterySlider> = arrayListOf(
//        EaterySlider("Pondok Makan", "Pondok Makan", "Warteg", 4.9, 2.8, R.drawable.background_pondok),
//        EaterySlider("Nyapii!", "Nyapii!", "Restaurant", 5.0, 4.8, R.drawable.background_nyapi),
//        EaterySlider("Lamian Palace", "Lamian Palace", "Restaurant", 4.9, 4.1, R.drawable.background_lamian_palace),
//        EaterySlider("Libro UMN", "Libro UMN", "Canteen",4.8, 0.1, R.drawable.background_libro),
//        EaterySlider("Mie Ayam Bakso Wonogiri", "Mie Ayam Bakso Wonogiri", "Canteen", 4.5, 0.3, R.drawable.background_wonogori),
        EaterySlider("O! Fish", "O! Fish", "Restaurant", 4.8, 3.6, R.drawable.background_fish),
        EaterySlider("Sushi Naru", "Sushi Naru", "Restaurant", 4.2, 3.9, R.drawable.background_sushi_naru),
        EaterySlider("Raos", "Raos", "Warteg", 4.8, 4.1, R.drawable.background_raos)
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

        val compositePageTransformer = CompositePageTransformer()
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
//                sliderHandler.removeCallbacks(sliderRunnable)
//                sliderHandler.postDelayed(sliderRunnable, 3000)
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