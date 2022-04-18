package com.edurda77.dictionary.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.dictionary.databinding.ActivityMainBinding
import com.edurda77.mylibrary.WordTranslate
import com.edurda77.dictionary.view.adapters.TranslateAdapter
import com.edurda77.dictionary.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.S) {
            installSplashScreen()
        }
        setContentView(binding.root)

        binding.search.setOnClickListener {
            val searchWord = binding.enter.text.toString()
            viewModel.getData(searchWord)
        }
        viewModel.liveData.observe(this) {
            setOotRecycledView(it)
        }
        binding.history.setOnClickListener {
            val intent = Intent(this@MainActivity, HistoryActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setOotRecycledView(list: List<WordTranslate>) {

        val recyclerView: RecyclerView = binding.recycledView
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        val stateClickListener: TranslateAdapter.OnStateClickListener =
            object : TranslateAdapter.OnStateClickListener {
                override fun onStateClick(word: WordTranslate, position: Int) {
                    val intent = Intent(this@MainActivity, WordActivity::class.java)
                    intent.putExtra(WordTranslate::class.java.simpleName, word)
                    startActivity(intent)
                }
            }
        recyclerView.adapter = TranslateAdapter(list, stateClickListener)
    }

}
