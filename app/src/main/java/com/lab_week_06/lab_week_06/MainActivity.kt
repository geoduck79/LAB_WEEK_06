package com.lab_week_06.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lab_week_06.lab_week_06.model.CatBreed
import com.lab_week_06.lab_week_06.model.CatModel
import com.lab_week_06.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }
    private val catAdapter by lazy {
//Glide is used here to load the images
//Here we are passing the onClickListener function to the Adapter
        CatAdapter(layoutInflater, GlideImageLoader(this), object:
            CatAdapter.OnClickListener {
            //When this is triggered, the pop up dialog will be shown
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup the adapter for the recycler view
        recyclerView.adapter = catAdapter

        // Setup the layout manager for the recycler view
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        // Add data to the model list in the adapter
        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Bengal,
                    "Simba",
                    "Fast and fierce",
                    "https://cdn2.thecatapi.com/images/O3btzLlsO.png"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.MaineCoon,
                    "Luna",
                    "Fluffy and gentle",
                    "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Siamese,
                    "Oliver",
                    "Talkative and playful",
                    "https://cdn2.thecatapi.com/images/ai6.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Persian,
                    "Molly",
                    "Loves napping",
                    "https://cdn2.thecatapi.com/images/LY-JqzdcT.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.Sphynx,
                    "Mystic",
                    "Bold and curious",
                    "https://cdn2.thecatapi.com/images/BDb8ZXb1v.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Ragdoll,
                    "Max",
                    "Relaxed and friendly",
                    "https://cdn2.thecatapi.com/images/ka7.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.BritishShorthair,
                    "Chloe",
                    "Calm and loyal",
                    "https://cdn2.thecatapi.com/images/nh5.jpg"
                )
            )
        )

    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
//Set the title for the dialog
            .setTitle("Cat Selected")
//Set the message for the dialog
            .setMessage("You have selected cat ${cat.name}")
//Set if the OK button should be enabled
            .setPositiveButton("OK") { _, _ -> }.show()
    }

}
