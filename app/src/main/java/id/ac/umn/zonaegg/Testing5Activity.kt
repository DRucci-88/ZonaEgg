package id.ac.umn.zonaegg

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import id.ac.umn.zonaegg.data.Eatery
import id.ac.umn.zonaegg.databinding.ActivityTesting5Binding
import id.ac.umn.zonaegg.home.HomeExploreCardAdapter
import id.ac.umn.zonaegg.home.HomeExploreListener


class Testing5Activity : AppCompatActivity() {

    private lateinit var bind: ActivityTesting5Binding
    private lateinit var list: ArrayList<Eatery>
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityTesting5Binding.inflate(layoutInflater)
        setContentView(bind.root)

        list = ArrayList<Eatery>()
        var temp: Eatery

        db.collection("Kantin UMN")
            .get()
            .addOnSuccessListener { result ->
                Log.d("testing5", "SUCCESS")
                for (document in result) {
                    Log.d("testing5", "${document.id} => ${document.data["name"]}")
                    temp = Eatery(document.id,
                        document.getString("name"),
                        "Kantin UMN",
                        document.getString("rating"),
                        document.getDouble("distance"),
                        document.getString("photoBackground"))
                    list.add(temp)
                    Log.d("testing5", temp.name!!)
                }
            }
            .addOnFailureListener { exception ->
                Log.d("testing5", "Error getting documents: ", exception)
            }
//        Log.d("testing5", list[0].name.toString())
        val testingListener = object : HomeExploreListener {
            override fun onChangeNav(category: String) {
                list.clear()
                db.collection("eatery")
                    .get()
                    .addOnSuccessListener { result ->
                        for (document in result) {
                            if (document.getString("category").equals(category, true)) {
                                temp = Eatery(document.id,
                                    document.getString("name"),
                                    "Kantin UMN",
                                    document.getString("rating"),
                                    document.getDouble("distance"),
                                    document.getString("photoBackground"))
                                list.add(temp)
                                Log.d("testing5", "${document.id} => ${document.data["name"]}")
                            }
                        }
                    }
                    .addOnFailureListener { exception ->
                        Log.d("testing5", "Error getting documents: ", exception)
                    }
            }

            override fun goToDetailEatery(data: Eatery) {

            }

        }

        list.map {
            Log.d("testing5", "-- ${it.name}")
        }

        bind.testingRv.adapter = HomeExploreCardAdapter(list, testingListener)
        bind.testingRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onStart() {
        super.onStart()

    }

//    private fun EventChangeListener(){
//
//        db= FirebaseFirestore.getInstance()
//        db.collection("").
//                addSnapshotListener(object : EventListener<QuerySnapshot>{
//                    override fun onEvent(
//                        value: QuerySnapshot?,
//                        error: FirebaseFirestoreException?
//                    ){
//
//
//
//                    }
//                })
//    }
}
