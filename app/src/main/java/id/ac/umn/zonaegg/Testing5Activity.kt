package id.ac.umn.zonaegg

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import id.ac.umn.zonaegg.data.Eatery
import id.ac.umn.zonaegg.data.Serving
import id.ac.umn.zonaegg.databinding.ActivityTesting5Binding
import id.ac.umn.zonaegg.home.HomeExploreCardAdapter
import id.ac.umn.zonaegg.home.HomeExploreListener


class Testing5Activity : AppCompatActivity() {

    private lateinit var bind: ActivityTesting5Binding
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityTesting5Binding.inflate(layoutInflater)
        setContentView(bind.root)

        val list = ArrayList<Eatery>()
        val listServing = ArrayList<Serving>()
        var temp: Eatery
        var tempServing: Serving
        var i = 0

        // Get eateries
        db.collection("Kantin UMN")
            .get()
            .addOnSuccessListener { eateries ->
                for (eatery in eateries) {
                    Log.d("testing5", "${eatery.id} => ${eatery.data}")
                    temp = Eatery(eatery.id,
                        eatery.getString("name"),
                        eatery.getString("category"),
                        eatery.getDouble("rating"),
                        eatery.getDouble("distance"),
                        eatery.getString("photoBackground"))
                    list.add(temp)
                    Log.d("testing5", list[i].name!!)
                    i++

                    // Get servings for each eateries
                    db.collection("Kantin UMN").document(eatery.id).collection("menu")
                        .get()
                        .addOnSuccessListener { servings ->
                            for (serving in servings) {
                                Log.d("testing5", "${serving.id} => ${serving.data}")
                                tempServing = Serving(
                                    serving.id,
                                    serving.getString("name")!!,
                                    serving.getDouble("price")!!.toFloat(),
                                    serving.getString("photoUrl")!!
                                )
                                listServing.add(tempServing)
                                Log.d("testing5", tempServing.name)
                            }
                        }
                        .addOnFailureListener { exception ->
                            Log.d("testing5", "Error getting servings: ", exception)
                        }
                }
            }
            .addOnFailureListener { exception ->
                Log.d("testing5", "Error getting eateries: ", exception)
            }
//        Log.d("testing5", list[0].name.toString())
        val testingListener = object : HomeExploreListener {
            override fun onChangeNav(category: String) {
                list.clear()
                db.collection("eatery")
                    .whereEqualTo("category", category)
                    .get()
                    .addOnSuccessListener { result ->
                        for (document in result) {
                            temp = Eatery(document.id,
                                document.getString("name"),
                                document.getString("category"),
                                document.getDouble("rating"),
                                document.getDouble("distance"),
                                document.getString("photoBackground"))
                            list.add(temp)
                            Log.d("testing5", "${document.id} => ${document.data["name"]}")
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
            Log.d("testing5", "--4 ${it.name}")
        }

        for (it in listServing) {
            Log.d("testing5", "-- ${it.name}")
        }


        bind.testing5Rv.adapter = HomeExploreCardAdapter(list, testingListener)
        bind.testing5Rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
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
