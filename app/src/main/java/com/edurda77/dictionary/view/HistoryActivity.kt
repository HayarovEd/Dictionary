package com.edurda77.dictionary.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edurda77.dictionary.databinding.ActivityHistoryBinding
import com.edurda77.dictionary.databinding.ActivityMainBinding
import com.edurda77.dictionary.viewmodel.HistoryActivityViewModel
import com.edurda77.dictionary.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding
    private val viewModel: HistoryActivityViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.historyCurrent.text
        viewModel.getAllData()
    }
}