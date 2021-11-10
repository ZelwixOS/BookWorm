package com.zixos.bookworm.ui.favourite

import Book
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zixos.bookworm.dal.DbContext

class FavouriteViewModel : ViewModel() {

    fun getBooks(dbContext: DbContext): MutableList<Book> {
        val books = dbContext.getBooks()
        val items = mutableListOf<Book>()

        for (book in books)
            if (book.Favourite)
                items.add(book)

        return  items
    }

}