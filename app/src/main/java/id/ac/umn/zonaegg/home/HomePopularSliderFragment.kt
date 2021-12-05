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
//        Eatery("1", "Jujutsu", "Anime","5", 4.5F, R.drawable.sangkyuu_somuch_besto_frendo),
//        Eatery("2", "Animal", "Anime","4.5", 4.5F, R.drawable.pepatah_kakek_kura_kura),
//        Eatery("3", "Kaiser", "Anime","3.7", 4.5F, R.drawable.swaq_face)
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