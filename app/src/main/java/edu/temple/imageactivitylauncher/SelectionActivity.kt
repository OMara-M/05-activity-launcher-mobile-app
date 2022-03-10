package edu.temple.imageactivitylauncher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionActivity : AppCompatActivity() {

    companion object {
        val ITEM_KEY = "key"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.selection_activity_main)

        val imageData = createDogList()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val handleClick = { item: ImageData ->
            val launchIntent = Intent(this, DisplayActivity::class.java)
                .putExtra(ITEM_KEY, item)

            startActivity(launchIntent)
        }

        recyclerView.adapter = ImageAdapter(imageData, handleClick)
    }

    private fun createDogList(): Array<ImageData> {
        return arrayOf(
            ImageData(R.drawable.d0,"German Shepherd"),
            ImageData(R.drawable.d1,"Shiba Doge"),
            ImageData(R.drawable.d2,"Golden Retriever"),
            ImageData(R.drawable.d3,"Long Hair German Shepherd"),
            ImageData(R.drawable.d4,"Husky"),
            ImageData(R.drawable.d5,"Akita"),
            ImageData(R.drawable.d6,"Welsh Corgi"),
            ImageData(R.drawable.d7,"Boxer"),
            ImageData(R.drawable.d8,"Rottweiler"),
            ImageData(R.drawable.d9,"Bernese Mountain Dog")
        )
    }

}