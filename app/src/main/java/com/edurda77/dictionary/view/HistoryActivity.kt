package com.edurda77.dictionary.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.dictionary.databinding.ActivityHistoryBinding
import com.edurda77.mylibrary.HistoryEntity
import com.edurda77.dictionary.view.adapters.HistoryAdapter
import com.edurda77.dictionary.viewmodel.HistoryActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding
    private val viewModel: HistoryActivityViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.getAllData()
        viewModel.liveData.observe(this){
            setOotRecycledView(it)
        }

    }
    private fun setOotRecycledView(list: List<HistoryEntity>) {

        val recyclerView: RecyclerView = binding.historyRecycledView
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        recyclerView.adapter = HistoryAdapter(list)
    }
}