package com.edurda77.dictionary.view

import TranslateHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.dictionary.model.data.WordTranslate


class TranslateAdapter(
    private val list: List<WordTranslate>,
    private val onClickListener: OnStateClickListener
) :
    RecyclerView.Adapter<TranslateHolder>() {
    interface OnStateClickListener {
        fun onStateClick(word: WordTranslate, position: Int)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TranslateHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TranslateHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: TranslateHolder, position: Int) {
        val wordTranslate: WordTranslate = list[position]
        holder.bind(wordTranslate)
        holder.itemView.setOnClickListener {
            onClickListener.onStateClick(wordTranslate, position)
        }
    }

    override fun getItemCount(): Int = list.size
}

