package com.example.onlineshop.detail.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.core.presenter.Mapper
import com.example.core.presenter.MyImageView

/**
 * @author Vitaly.N on 12.03.2023.
 */
class ImagesAdapter(private val clickListener: ClickListener) :
    RecyclerView.Adapter<ImageViewHolder>(), com.example.core.presenter.Mapper.Unit<List<String>> {

    private val list = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ImageViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_product_image, parent, false),
        clickListener
    )

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) =
        holder.bind(list[position], position)

    override fun getItemCount() = list.size

    override fun map(source: List<String>) {
        val diff = DiffUtilCallback(list, source)
        val result = DiffUtil.calculateDiff(diff)
        list.clear()
        list.addAll(source)
        result.dispatchUpdatesTo(this)
    }
}

class ImageViewHolder(view: View, private val clickListener: ClickListener) :
    RecyclerView.ViewHolder(view) {
    private val view = view
    private val image = itemView.findViewById<com.example.core.presenter.MyImageView>(R.id.itemProductImageView)

    fun bind(model: String, position: Int) {
        image.loadImage(model)
        if (position == 1) {
            image.increase()}
        image.setOnClickListener { clickListener.click(model) }
    }
}


