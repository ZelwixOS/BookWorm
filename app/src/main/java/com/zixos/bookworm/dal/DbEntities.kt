package com.zixos.bookworm.dal

import android.provider.BaseColumns

object DbEntities {
    const val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${Books.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${Books.COLUMN_NAME_NAME} TEXT," +
                "${Books.COLUMN_NAME_AUTHOR} TEXT," +
                "${Books.COLUMN_NAME_CODE} TEXT," +
                "${Books.COLUMN_NAME_DESCRIPTION} TEXT," +
                "${Books.COLUMN_NAME_PRICE} TEXT," +
                "${Books.COLUMN_NAME_FAVOURITE} BOOLEAN," +
                "${Books.COLUMN_NAME_LATER} BOOLEAN," +
                "${Books.COLUMN_NAME_IMGSRC} TEXT)"

    const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${Books.TABLE_NAME}"


    object Books : BaseColumns {
            const val TABLE_NAME = "book"
            const val COLUMN_NAME_NAME = "name"
            const val COLUMN_NAME_AUTHOR = "author"
            const val COLUMN_NAME_PRICE = "price"
            const val COLUMN_NAME_IMGSRC = "imgSrc"
            const val COLUMN_NAME_DESCRIPTION = "description"
            const val COLUMN_NAME_CODE = "code"
            const val COLUMN_NAME_FAVOURITE = "favourite"
            const val COLUMN_NAME_LATER = "later"
        }
}