package id.ac.umn.zonaegg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.umn.zonaegg.data.Eatery
import id.ac.umn.zonaegg.data.Serving
import id.ac.umn.zonaegg.databinding.ActivityEateryBinding

class EateryActivity : AppCompatActivity() {

    private lateinit var bind: ActivityEateryBinding

    val servingData : ArrayList<Serving> = arrayListOf(
        Serving("1","Ikan Gurame Sambla Pete",40000F, R.drawable.ikan_gurame_sambal_pete),
        Serving("2","Nasi Ayam sambal pete",35000F, R.drawable.nasi_ayam_sambel_pete),
        Serving("3","Udang Sambal Pete",20000F, R.drawable.udang_sambel_pete)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityEateryBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val data: Eatery? = intent.getParcelableExtra<Eatery>("data")

        data?.photoUrl?.let { bind.view.setBackgroundResource(it) }
        data?.let {
            bind.view.setBackgroundResource(it.photoUrl)
            bind.category.text = it.category
            bind.name.text = it.name
        }

        bind.btnGoBack.setOnClickListener{
            val goBackToHome = Intent(this, HomeActivity::class.java)
            goBackToHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            this.startActivity(goBackToHome)
        }

        bind.rvServing.adapter = EateryAdapter(servingData)
//        bind.rvServing.layoutManager = LinearLayoutManager(this)
        bind.rvServing.layoutManager = GridLayoutManager(this, 2)

    }
}