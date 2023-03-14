package com.example.onlineshop.detail.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.core.presenter.Mapper
import com.example.core.presenter.MyButton

/**
 * @author Vitaly.N on 13.03.2023.
 */
class ColorsAdapter(private val clickListener: ClickListener) :
    RecyclerView.Adapter<ColorsViewHolder>(), com.example.core.presenter.Mapper.Unit<List<String>> {

    private val list = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ColorsViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_color_product_detail, parent, false),
        clickListener
    )

    override fun onBindViewHolder(holder: ColorsViewHolder, position: Int) =
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

class ColorsViewHolder(view: View, private val clickListener: ClickListener) :
    RecyclerView.ViewHolder(view) {

    private val imageButton = itemView.findViewById<com.example.core.presenter.MyButton>(R.id.colorImageButton)

    fun bind(model: String) {
        imageButton.loadBackground(model)
        imageButton.setOnClickListener { clickListener.click(model) }
    }
}

