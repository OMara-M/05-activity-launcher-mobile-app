package edu.temple.imageactivitylauncher

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display_activity)

        findViewById<Button>(R.id.button).setOnClickListener {
            val launchIntent = Intent(this, SelectionActivity::class.java)

            startActivity(launchIntent)
        }

        val imageView = findViewById<ImageView>(R.id.imageView)
        val textView = findViewById<TextView>(R.id.textView)

        val item = intent.getParcelableExtra<ImageData>(SelectionActivity.ITEM_KEY)

        item?.resourceId?.let { imageView.setImageResource(it) }
        item?.description?.let { textView.text = it }
    }
}