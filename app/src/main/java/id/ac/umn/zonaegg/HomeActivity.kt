package id.ac.umn.zonaegg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.umn.zonaegg.data.Eatery

class HomeActivity : AppCompatActivity() {
    private lateinit var navLayoutManager : RecyclerView.LayoutManager
    private lateinit var navAdapter : RecyclerView.Adapter<HomeExploreNavAdapter.ViewHolder>
    private lateinit var cardLayoutManager : RecyclerView.LayoutManager
    private lateinit var cardAdapter : RecyclerView.Adapter<HomeExploreCardAdapter.ViewHolder>

    // Dummy
    private var eateryCategory = arrayOf("All", "Canteen", "Restaurant", "Warteg")
    private var eateryData = arrayOf(
        Eatery("Pondok", "Pondok", "Warteg", "4.8", 5f, "null"),
        Eatery("Pondok Lagi", "Pondok Lagi", "Warteg", "4.3", 4.5f, "null"),
        Eatery("Restototo", "Restototo", "Restaurant", "4.9", 4.1f, "null"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Change recyclerView Data
        /* val eateryFilteredData = eateryData.toMutableList()
        eateryFilteredData.removeAt(0) */

        val rvExploreNavs = findViewById<RecyclerView>(R.id.home_rvExploreNavs)
        val rvExploreCards = findViewById<RecyclerView>(R.id.home_rvExploreCards)

        navLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvExploreNavs.layoutManager = navLayoutManager

        cardLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvExploreCards.layoutManager = cardLayoutManager

        navAdapter = HomeExploreNavAdapter(eateryCategory)
        rvExploreNavs.adapter = navAdapter

        cardAdapter = HomeExploreCardAdapter(eateryData)
        rvExploreCards.adapter = cardAdapter
    }
}