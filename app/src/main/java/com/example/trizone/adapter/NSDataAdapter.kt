package com.example.trizone.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.trizone.R
import com.example.trizone.data.NSDataModel
import java.util.concurrent.Executors

/*Created by Maneesha on 22/01/2022*/
class NSDataAdapter(private var dataList: List<NSDataModel>, private val context: Context) :
    RecyclerView.Adapter<NSDataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataList.get(position)
        //  val imageURL = dataModel.thumbnailurl
        val imageURL: String =
            "https://i.picsum.photos/id/966/200/200.jpg?hmac=RmCTCEjm_X8xE8OAxo2-eCKM4eJu4LGQu-8U6Y3OmEM"
        holder.itemNameTextView.text = dataModel.title
        val handler = Handler(Looper.getMainLooper())
        val executor = Executors.newSingleThreadExecutor()
        // Initializing the image
        var image: Bitmap? = null
        executor.execute {
            try {
                val `in` = java.net.URL(imageURL).openStream()
                image = BitmapFactory.decodeStream(`in`)

                // Only for making changes in UI
                handler.post {
                    holder.itemImageView.setImageBitmap(image)
                }
            }  // If the URL doesnot point to
            // image or any other kind of failure
            catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var itemNameTextView: TextView = itemView.findViewById(R.id.itemNameTextView)
        var itemImageView: ImageView = itemView.findViewById(R.id.itemImageView)
        var itemPriceTextView: TextView = itemView.findViewById(R.id.priceTextView)

    }

}