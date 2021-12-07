package id.ac.umn.zonaegg.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import com.google.android.material.appbar.AppBarLayout
import id.ac.umn.zonaegg.R
import id.ac.umn.zonaegg.data.Serving
import id.ac.umn.zonaegg.databinding.ActivityTesting3Binding

class Testing3Activity : AppCompatActivity() {

    private lateinit var bind: ActivityTesting3Binding
    private val servingData : ArrayList<Serving> = arrayListOf(
        Serving("1","Ikan Gurame Sambla Pete",40000F, R.drawable.ikan_gurame_sambal_pete),
        Serving("2","Nasi Ayam sambal pete",35000F, R.drawable.nasi_ayam_sambel_pete),
        Serving("3","Udang Sambal Pete",20000F, R.drawable.udang_sambel_pete)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityTesting3Binding.inflate(layoutInflater)
        setContentView(bind.root)

        setSupportActionBar(bind.testing3Toolbar)

        bind.testing3AppBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            Log.d("Testing", verticalOffset.toString())
            if (verticalOffset <= -600) {
                bind.testing3CollapsingToolbar.title = "Pondok Makan"
//                bind.testingCollapsingToolbar.contentScrim = getDrawable(R.color.black)
            }
            else{
                bind.testing3CollapsingToolbar.title = ""
//                bind.testingCollapsingToolbar.contentScrim = getDrawable(R.color.blue_500)
            }

        })

//        bind.testing2RvServing.adapter = EateryAdapter(servingData)
//        bind.testing2RvServing.layoutManager = GridLayoutManager(this, 2)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.testing_image_prominent, menu)
        return super.onCreateOptionsMenu(menu)
    }
}