package com.zixos.bookworm.dal

import Book
import android.content.ContentValues
import android.content.Context
import android.provider.BaseColumns
import com.zixos.bookworm.dal.DbEntities.Books
import java.lang.Boolean.getBoolean

class DbContext(context: Context) {
    private val dbHelper = DbHelper(context)

    fun addBook(book: Book) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(Books.COLUMN_NAME_NAME, book.Name)
            put(Books.COLUMN_NAME_AUTHOR, book.Author)
            put(Books.COLUMN_NAME_DESCRIPTION, book.Description)
            put(Books.COLUMN_NAME_FAVOURITE, book.Favourite)
            put(Books.COLUMN_NAME_LATER, book.Later)
            put(Books.COLUMN_NAME_CODE, book.Code)
            put(Books.COLUMN_NAME_IMGSRC, book.ImgSrc)
            put(Books.COLUMN_NAME_PRICE, book.Price)
        }
        val newRowId = db?.insert(Books.TABLE_NAME, null, values)
    }

    fun getBooks(): MutableList<Book> {
        val db = dbHelper.readableDatabase

        val projection = arrayOf(
            BaseColumns._ID,
            Books.COLUMN_NAME_NAME,
            Books.COLUMN_NAME_AUTHOR,
            Books.COLUMN_NAME_CODE,
            Books.COLUMN_NAME_DESCRIPTION,
            Books.COLUMN_NAME_PRICE,
            Books.COLUMN_NAME_IMGSRC,
            Books.COLUMN_NAME_FAVOURITE,
            Books.COLUMN_NAME_LATER
        )

        val sortOrder = "${Books.COLUMN_NAME_NAME} ASC"

        val cursor = db.query(
            Books.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            sortOrder
        )

        val items = mutableListOf<Book>()
        with(cursor) {
            while (moveToNext()) {
                val id = getString(getColumnIndexOrThrow(BaseColumns._ID))
                val itemName = getString(getColumnIndexOrThrow(Books.COLUMN_NAME_NAME))
                val itemAuthor = getString(getColumnIndexOrThrow(Books.COLUMN_NAME_AUTHOR))
                val itemDescription= getString(getColumnIndexOrThrow(Books.COLUMN_NAME_DESCRIPTION))
                val itemPrice = getString(getColumnIndexOrThrow(Books.COLUMN_NAME_PRICE))
                val itemCode = getString(getColumnIndexOrThrow(Books.COLUMN_NAME_CODE))
                val itemImgSrc = getString(getColumnIndexOrThrow(Books.COLUMN_NAME_IMGSRC))
                val itemLater = getInt(getColumnIndexOrThrow(Books.COLUMN_NAME_LATER)) > 0
                val itemFavourite= getInt(getColumnIndexOrThrow(Books.COLUMN_NAME_FAVOURITE)) > 0

                items.add(Book(id, itemName, itemAuthor, itemPrice, itemImgSrc, itemDescription, itemCode, itemFavourite, itemLater))
            }
        }
        cursor.close()

        return items
    }

    fun putStatusBook(book: Book) {
        val db = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(Books.COLUMN_NAME_FAVOURITE, book.Favourite)
            put(Books.COLUMN_NAME_LATER, book.Later)
        }

        val selection = "${BaseColumns._ID} LIKE ?"
        val selectionArgs = arrayOf(book.Id.toString())
        val count = db.update(
            Books.TABLE_NAME,
            values,
            selection,
            selectionArgs)
    }
}