package com.vita_zaebymba.gifsearchapp.coroutine

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import com.vita_zaebymba.gifsearchapp.GiphyClient
import com.vita_zaebymba.gifsearchapp.adapter.GifAdapter
import kotlinx.coroutines.launch

class Coroutine {
    companion object {
        fun coroutineTrendingGifs(lifecycleScope: LifecycleCoroutineScope,
                                  giphyClient: GiphyClient,
                                  adapter: GifAdapter) {
            lifecycleScope.launch { // корутина, которая асинхронно получает список популярных GIF-изображений из API Giphy и устанавливает его в адаптер RecyclerView
                val gifs = giphyClient.getTrendingGifs()
                adapter.gifs = gifs
                adapter.notifyDataSetChanged()
            }
        }

        fun coroutineSearchGifs(lifecycleScope: LifecycleCoroutineScope,
                                giphyClient: GiphyClient,
                                adapter: GifAdapter,
                                searchString: String) {
            lifecycleScope.launch {
                val gifs = giphyClient.getSearchGifs(searchString)
                adapter.gifs = gifs
                adapter.notifyDataSetChanged()
            }
        }
    }
}