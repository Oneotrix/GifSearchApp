package com.vita_zaebymba.gifsearchapp.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vita_zaebymba.gifsearchapp.adapter.GifAdapter
import com.vita_zaebymba.gifsearchapp.GiphyClient
import com.vita_zaebymba.gifsearchapp.R
import com.vita_zaebymba.gifsearchapp.coroutine.Coroutine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val giphyClient = GiphyClient() // создает экземпляр GiphyClient и использует его для получения популярных GIF-изображений с помощью метода getTrendingGifs()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gifList: RecyclerView = findViewById(R.id.gif_list) // полученные данные используются для заполнения RecyclerView, который отображает список GIF-изображений
        gifList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val adapter = GifAdapter(emptyList()) { gif ->
            val intent = GifDetailActivity.newIntent(this@MainActivity, gif)
            startActivity(intent)
        }
        gifList.adapter = adapter

        Coroutine.coroutineTrendingGifs(lifecycleScope, giphyClient, adapter)
    }

}