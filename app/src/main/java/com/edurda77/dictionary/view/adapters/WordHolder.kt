package com.edurda77.dictionary.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.edurda77.dictionary.R
import com.edurda77.dictionary.model.data.HTTPS_URL
import com.edurda77.mylibrary.Meanings

class WordHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_word, parent, false)) {

    private var wordTextView: TextView? = itemView.findViewById(R.id.word_item)
    private var wordImageView: ImageView? = itemView.findViewById(R.id.image_word_item)



    fun bind(meanings: Meanings) {
        wordTextView?.text=meanings.translation.textTranslation
        wordImageView?.let {
            Glide.with(this.itemView.context)
                .load(HTTPS_URL+meanings.imageUrl)
                .placeholder(R.drawable.ic_no_photo)
                .into(it)
        }
    }
}