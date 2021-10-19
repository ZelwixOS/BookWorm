package com.zixos.bookworm.ui.main

import Book
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    public fun getBooks(): Collection<Book> {
        return setOf(
            Book("Book1", "Author1", "100", "http://img2.joyreactor.cc/pics/post/it-%D1%8E%D0%BC%D0%BE%D1%80-geek-6974973.png", "",
                favourite = true,
                later = false
            ),
            Book("Book2", "Author2", "99", "http://img2.joyreactor.cc/pics/post/full/Ryoku-sui-Suzuran-%28Arknights%29-Arknights-%D0%98%D0%B3%D1%80%D1%8B-6974897.jpeg", "",
                favourite = false,
                later = false
            ),
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