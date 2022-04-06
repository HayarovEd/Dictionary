package com.edurda77.dictionary.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edurda77.dictionary.databinding.ActivityHistoryBinding
import com.edurda77.dictionary.databinding.ActivityMainBinding

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}