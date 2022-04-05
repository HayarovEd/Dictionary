package com.edurda77.dictionary.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.dictionary.databinding.ActivityWordBinding
import com.edurda77.dictionary.model.data.Meanings
import com.edurda77.dictionary.model.data.WordTranslate

class WordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityWordBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val arguments = intent.extras
        if (arguments != null) {
            val wordTranslate =
                arguments.getSerializable(WordTranslate::class.java.simpleName) as WordTranslate
            binding.wordCurrent.text = wordTranslate.text
            setOotRecycledView(wordTranslate.meanings)
        }
    }

    private fun setOotRecycledView(list: List<Meanings>) {

        val recyclerView: RecyclerView = binding.wordRecycledView
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )

        recyclerView.adapter = WordAdapter(list)
    }
}