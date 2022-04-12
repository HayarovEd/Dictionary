package com.edurda77.dictionary.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.dictionary.databinding.ActivityMainBinding
import com.edurda77.dictionary.view.adapters.TranslateAdapter
import com.edurda77.dictionary.viewmodel.MainActivityViewModel
import com.edurda77.mylibrary.WordTranslate
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val scope: Scope by lazy { getKoin().getOrCreateScope(this.toString(), named("MainActivity")) }
    //private val viewModel: MainActivityViewModel by inject()
//    private val recyclerView  by
//    ViewByIdDelegate<RecyclerView>(R.id.recycled_view)
    //private val search1 by ViewByIdDelegate<Button>(window.decorView.findViewById(R.id.history),R.id.history)

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.search.setOnClickListener {
            val searchWord = binding.enter.text.toString()
            scope.get<MainActivityViewModel>().getData(searchWord)
            //viewModel.getData(searchWord)
        }
        scope.get<MainActivityViewModel>().liveData.observe(this) {
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

    override fun onDestroy() {
        super.onDestroy()
        scope.close()
    }
}
