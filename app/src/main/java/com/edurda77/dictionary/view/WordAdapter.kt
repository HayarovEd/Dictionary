package com.edurda77.dictionary.view

import TranslateHolder
import WordHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.dictionary.model.data.Meanings
import com.edurda77.dictionary.model.data.WordTranslate


class WordAdapter(
    private val list: List<Meanings>) :
    RecyclerView.Adapter<WordHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordHolder {
        val inflater = LayoutInflater.from(parent.context)
        return WordHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: WordHolder, position: Int) {
        val meanings: Meanings = list[position]
        holder.bind(meanings)
    }

    override fun getItemCount(): Int = list.size
}
