package com.zixos.bookworm.ui.main

import Book
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zixos.bookworm.dal.DbContext

class MainViewModel : ViewModel() {

    fun getBooks(dbContext: DbContext): MutableList<Book> {
        return dbContext.getBooks()
    }

}