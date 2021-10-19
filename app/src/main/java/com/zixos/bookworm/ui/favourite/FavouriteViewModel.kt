package com.zixos.bookworm.ui.favourite

import Book
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavouriteViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    public fun getBooks(): Collection<Book> {
        return setOf(
            Book("Book1", "Author1", "100", "http://img2.joyreactor.cc/pics/post/it-%D1%8E%D0%BC%D0%BE%D1%80-geek-6974973.png", "",
                favourite = true,
                later = false
            ),
            Book("Book3", "Author3", "101", "http://img2.joyreactor.cc/pics/post/it-%D1%8E%D0%BC%D0%BE%D1%80-geek-6974973.png", "",
                favourite = true,
                later = true
            )
        )
    }
}