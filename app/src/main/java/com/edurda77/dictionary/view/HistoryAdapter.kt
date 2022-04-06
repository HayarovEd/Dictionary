package com.edurda77.dictionary.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.dictionary.model.data.HistoryEntity
import com.edurda77.dictionary.model.data.WordTranslate


class HistoryAdapter(
    private val list: List<HistoryEntity>
) :
    RecyclerView.Adapter<HistoryHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryHolder {
        val inflater = LayoutInflater.from(parent.context)
        return HistoryHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        val historyEntity: HistoryEntity = list[position]
        holder.bind(historyEntity)
    }

    override fun getItemCount(): Int = list.size
}

