package com.zixos.bookworm.ui.later

import Book
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LaterViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }

    public fun getBooks(): Collection<Book> {
        return setOf(
            Book("Book3", "Author3", "101", "http://img2.joyreactor.cc/pics/post/it-%D1%8E%D0%BC%D0%BE%D1%80-geek-6974973.png", "",
                favourite = true,
                later = true
            ),
            Book("Book4444444444444444444444444444444444444444444444444444444444444444444444", "Author3", "101", "http://img2.joyreactor.cc/pics/post/it-%D1%8E%D0%BC%D0%BE%D1%80-geek-6974973.png", "",
                favourite = false,
                later = true
            )
        )
    }

    val text: LiveData<String> = _text
}