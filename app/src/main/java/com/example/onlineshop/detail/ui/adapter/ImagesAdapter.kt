package com.example.onlineshop.detail.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.core.Mapper
import com.example.onlineshop.signin.MyImageView

/**
 * @author Vitaly.N on 12.03.2023.
 */
class ImagesAdapter(private val clickListener: ClickListener) :
    RecyclerView.Adapter<ImageViewHolder>(), Mapper.Unit<List<String>> {

    private val list = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ImageViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_product_image, parent, false),
        clickListener
    )

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) =
        holder.bind(list[position])

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

    private val image = itemView.findViewById<MyImageView>(R.id.itemProductImageView)

    fun bind(model: String) {
        image.loadImage(model)
        itemView.setOnClickListener { clickListener.click(model) }
    }
}

interface ClickListener {
    fun click(item: String)
}

class DiffUtilCallback(
    private val oldList: List<String>,
    private val newList: List<String>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].equals(newList[newItemPosition])

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].equals(newList[newItemPosition])
}