package com.vita_zaebymba.gifsearchapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.vita_zaebymba.gifsearchapp.data.Gif
import com.vita_zaebymba.gifsearchapp.R

// константа используется для передачи экземпляра класса Gif между различными компонентами приложения
// дополнение ключа именем пакета предотвращает конфликт имен с дополнениями других пакетов
private const val EXTRA_GIF = "com.vita_zaebymba.gifsearchapp.extra_gif"

/**
 * класс для отображения подробной информации о выбранном GIF-изображении
 * */
class GifDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gif_detail)

        val gif: Gif = intent.getParcelableExtra(EXTRA_GIF)!!


        val gifTitle: TextView = findViewById(R.id.gif_title) // текстовому полю gifTitle устанавливается текст заголовка GIF-изображения с помощью метода setText, используя свойство title объекта gif
        gifTitle.text = gif.title


    }
}