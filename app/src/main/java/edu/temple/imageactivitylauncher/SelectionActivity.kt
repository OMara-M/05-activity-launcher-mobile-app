package edu.temple.imageactivitylauncher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        val dogNames = resources.getStringArray(R.array.names)
        return arrayOf(
            ImageData(R.drawable.d0,dogNames[0]),
            ImageData(R.drawable.d1,dogNames[1]),
            ImageData(R.drawable.d2,dogNames[2]),
            ImageData(R.drawable.d3,dogNames[3]),
            ImageData(R.drawable.d4,dogNames[4]),
            ImageData(R.drawable.d5,dogNames[5]),
            ImageData(R.drawable.d6,dogNames[6]),
            ImageData(R.drawable.d7,dogNames[7]),
            ImageData(R.drawable.d8,dogNames[8]),
            ImageData(R.drawable.d9,dogNames[9])
        )
    }

}