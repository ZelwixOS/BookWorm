package com.zixos.bookworm.dal

import Book
import java.lang.Exception

class DbInitializer {

    fun InitDB(db: DbContext)
    {
        try {
            db.getBooks()
        }
        catch (e: Exception)
        {
            InitBooks(db)
        }
    }

    fun InitBooks(db: DbContext)
    {
        val books = getBooks()
        for(book in books) {
            db.addBook(book)
        }
    }

    fun getBooks(): Collection<Book> {
        return setOf(
            Book(null, "Book1", "Author1", "100", "http://img2.joyreactor.cc/pics/post/it-%D1%8E%D0%BC%D0%BE%D1%80-geek-6974973.png", "Description", "0000001",
                favourite = true,
                later = false
            ),
            Book(null,"Book2", "Author2", "99", "http://img2.joyreactor.cc/pics/post/full/Ryoku-sui-Suzuran-%28Arknights%29-Arknights-%D0%98%D0%B3%D1%80%D1%8B-6974897.jpeg", "SFafafaf", "0000002",
                favourite = false,
                later = false
            ),
            Book(null,"Book3", "Author3", "101", "http://img2.joyreactor.cc/pics/post/it-%D1%8E%D0%BC%D0%BE%D1%80-geek-6974973.png", "arhgghrehregrwgrhrhrwwgwegew", "0000003",
                favourite = true,
                later = true
            ),
            Book(null, "Book4444444444444444444444444444444444444444444444444444444444444444444444", "Author3", "101", "http://img2.joyreactor.cc/pics/post/it-%D1%8E%D0%BC%D0%BE%D1%80-geek-6974973.png", "egGGAGAGWGWERGEGSG", "0000004",
                favourite = false,
                later = true
            )
        )
    }
}