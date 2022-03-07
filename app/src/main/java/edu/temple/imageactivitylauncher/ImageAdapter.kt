package edu.temple.imageactivitylauncher

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(_imageDataItems: Array<ImageData>, _handleClick: (ImageData) -> Unit) :
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    private val imageDataItems = _imageDataItems
    val handleClick = _handleClick

    inner class ViewHolder(_view: ImageView) : RecyclerView.ViewHolder(_view) {
        lateinit var item: ImageData
        val imageView = _view.apply {
            setOnClickListener { handleClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ImageView(parent.context).apply {
            layoutParams = ViewGroup.LayoutParams(200, 200)
        })
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(imageDataItems[position].resourceId)
        holder.item = imageDataItems[position]
    }

    override fun getItemCount(): Int {
        return imageDataItems.size
    }

}