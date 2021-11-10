package com.zixos.bookworm.ui.later

import Book
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zixos.bookworm.dal.DbContext

class LaterViewModel : ViewModel() {

    fun getBooks(dbContext: DbContext): MutableList<Book> {
        val books = dbContext.getBooks()
        val items = mutableListOf<Book>()

        for (book in books)
            if (book.Later)
                items.add(book)

        return  items
    }

}