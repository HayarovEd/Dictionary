package com.edurda77.dictionary.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.edurda77.dictionary.R
import com.edurda77.dictionary.model.data.HTTPS_URL
import com.edurda77.mylibrary.WordTranslate

class  TranslateHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_translate, parent, false)) {

    private var textItem: TextView? = null
    private var imageItem: ImageView? = null

    init {
        textItem = itemView.findViewById(R.id.text_item)
        imageItem = itemView.findViewById(R.id.image_item)
    }

    fun bind(wordTranslate: WordTranslate) {
        textItem?.text = wordTranslate.text
        imageItem?.let {
            Glide.with(this.itemView.context)
                .load(HTTPS_URL+wordTranslate.meanings[0].imageUrl)
                .placeholder(R.drawable.ic_no_photo)
                .transform(CircleCrop())
                .into(it)
        }
    }
}