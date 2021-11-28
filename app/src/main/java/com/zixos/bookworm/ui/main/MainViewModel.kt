package com.zixos.bookworm.ui.main

import Book
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zixos.bookworm.dal.DbContext

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext
    private val dbContext = DbContext(context)

    fun getBooks(): List<Book> {
        return this.dbContext.getBooks()
    }

}