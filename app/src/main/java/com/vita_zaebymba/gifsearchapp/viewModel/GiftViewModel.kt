package com.vita_zaebymba.gifsearchapp.viewModel

import androidx.lifecycle.ViewModel

class GiftViewModel : ViewModel() {
    lateinit var id: String
    lateinit var title: String
    lateinit var url: String
    lateinit var previewUrl: String
    var width: Int = 0
    var height: Int = 0
}