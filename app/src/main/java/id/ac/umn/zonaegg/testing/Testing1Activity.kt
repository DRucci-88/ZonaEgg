package id.ac.umn.zonaegg.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.appbar.AppBarLayout
import id.ac.umn.zonaegg.R
import id.ac.umn.zonaegg.data.Serving
import id.ac.umn.zonaegg.databinding.ActivityTesting1Binding
import id.ac.umn.zonaegg.eatery.EateryAdapter

class Testing1Activity : AppCompatActivity() {

    private lateinit var bind: ActivityTesting1Binding

    private val servingData : ArrayList<Serving> = arrayListOf(
        Serving("1","Ikan Gurame Sambla Pete",40000F, R.drawable.ikan_gurame_sambal_pete),
        Serving("2","Nasi Ayam sambal pete",35000F, R.drawable.nasi_ayam_sambel_pete),
        Serving("3","Udang Sambal Pete",20000F, R.drawable.udang_sambel_pete)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityTesting1Binding.inflate(layoutInflater)
        setContentView(bind.root)

        setSupportActionBar(bind.testingToolbar)

        bind.testingAppBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            Log.d("Testing", verticalOffset.toString())
            Log.d("Testing", bind.testingCollapsingToolbar.scrimVisibleHeightTrigger.toString())
            if (verticalOffset <= -600) {
                bind.testingCollapsingToolbar.title = "Pondok Makan"

            }
            else
                bind.testingCollapsingToolbar.title = ""
        })

        bind.testingServing.adapter = EateryAdapter(servingData)
        bind.testingServing.layoutManager = GridLayoutManager(this, 2)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.testing_image_prominent, menu)
        return super.onCreateOptionsMenu(menu)

    }
}
