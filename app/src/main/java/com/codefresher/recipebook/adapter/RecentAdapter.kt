package com.codefresher.recipebook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codefresher.recipebook.R
import com.codefresher.recipebook.model.PopularModel
import com.codefresher.recipebook.model.RecentModel
import com.codefresher.recipebook.model.TrendingModel

class RecentAdapter(
    private val listRecent: ArrayList<RecentModel>,

) : RecyclerView.Adapter<RecentAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemImage.setImageResource(listRecent[position].img)
        holder.itemTitle.text = listRecent[position].title
    }

    override fun getItemCount(): Int {
        return listRecent.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView

        init {
            itemImage = itemView.findViewById(R.id.imgItem)
            itemTitle = itemView.findViewById(R.id.tvItem)
        }
    }
}