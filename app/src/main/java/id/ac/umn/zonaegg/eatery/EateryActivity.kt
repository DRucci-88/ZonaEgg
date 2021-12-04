package id.ac.umn.zonaegg.eatery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator
import id.ac.umn.zonaegg.R
import id.ac.umn.zonaegg.data.Eatery
import id.ac.umn.zonaegg.databinding.ActivityEateryBinding

class EateryActivity : AppCompatActivity() {

    private lateinit var bind: ActivityEateryBinding

    private val headerSegment = arrayOf("Menu", "Review")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityEateryBinding.inflate(layoutInflater)
        setContentView(bind.root)

        setSupportActionBar(bind.toolbarEatery)

        val data: Eatery? = intent.getParcelableExtra<Eatery>("data")

        bind.appBarEatery.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (verticalOffset <= -600) {
                bind.collapsingToolbarEatery.title = "Pondok Makan"
//                bind.testingCollapsingToolbar.contentScrim = getDrawable(R.color.black)
            }
            else{
                bind.collapsingToolbarEatery.title = ""
//                bind.testingCollapsingToolbar.contentScrim = getDrawable(R.color.blue_500)
            }
        })

        data?.photoUrl?.let { bind.ivBackgroundEatery.setBackgroundResource(it) }
        data?.let {
            bind.ivBackgroundEatery.setBackgroundResource(it.photoUrl)
            bind.tvCategoryEatery.text = it.category
            bind.tvNameEatery.text = it.name
        }

        val fragmentList: ArrayList<Fragment> = arrayListOf(EateryMenuFragment(), EateryReviewFragment())
        val adapter = EateryViewPagerAdapter(fragmentList, this.supportFragmentManager, lifecycle)
        bind.viewPagerEatery.adapter = adapter

        TabLayoutMediator(bind.tabLayoutEatery, bind.viewPagerEatery) { tab, position ->
            tab.text = headerSegment[position]
        }.attach()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.testing_image_prominent, menu)
        return super.onCreateOptionsMenu(menu)
    }
}