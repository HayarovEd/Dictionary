package com.edurda77.dictionary.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.edurda77.dictionary.R
import com.edurda77.dictionary.model.data.HTTPS_URL
import com.edurda77.dictionary.model.data.HistoryEntity
import com.edurda77.dictionary.model.data.WordTranslate

class  HistoryHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_history, parent, false)) {

    private var wordItem: TextView? = null
    private var descriptionItem: TextView? = null

    init {
        wordItem = itemView.findViewById(R.id.history_word_item)
        descriptionItem = itemView.findViewById(R.id.history_description_item)
    }

    fun bind(historyEntity: HistoryEntity) {
        wordItem?.text = historyEntity.word
        descriptionItem?.text = historyEntity.description
    }
}