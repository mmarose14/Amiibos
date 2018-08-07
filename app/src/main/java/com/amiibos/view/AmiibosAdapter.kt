package com.amiibos.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amiibos.R
import com.amiibos.activity.AmiiboClickListener
import com.amiibos.model.Amiibo
import kotlinx.android.synthetic.main.amiibo_item.view.*

class AmiibosAdapter(val amiibos: List<Amiibo>, val context: Context, val onClickListener: AmiiboClickListener) : RecyclerView.Adapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.amiiboName.text = amiibos.get(position).name
        holder.amiiboSeries.text = amiibos.get(position).amiiboSeries
        holder.itemView.setOnClickListener { view ->
            onClickListener.onClickListener(amiibos.get(position))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.amiibo_item, parent, false))
    }

    override fun getItemCount(): Int {
        return amiibos.size
    }

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val amiiboName = view.amiibo_name
    val amiiboSeries = view.amiibo_series
}
