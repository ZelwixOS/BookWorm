package com.zixos.bookworm.ui.later

import Book
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zixos.bookworm.dal.DbContext

class LaterViewModel (application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext
    private val dbContext = DbContext(context)

    fun getBooks(): List<Book> {
        val books = this.dbContext.getBooks()
        val items = mutableListOf<Book>()

        for (book in books)
            if (book.Later)
                items.add(book)

        return  items.toList()
    }

}