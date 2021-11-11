package com.zixos.bookworm

import Book
import android.annotation.SuppressLint
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class BookDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)
        arguments = intent.extras
        initComponentElements()
        initElementsValue()
    }

    private var arguments: Bundle? = null
    private var bookImage: ImageView? = null
    private var bookName: TextView? = null
    private var bookAuthor: TextView? = null
    private var bookPrice: TextView? = null
    private var bookCode: TextView? = null
    private var bookDescription: TextView? = null
    private var favourite: ImageView? = null
    private var later: ImageView? = null

    private var bookInfo: Book? = null

    private fun initComponentElements() {
        bookImage = this.findViewById(R.id.bookDImage)
        bookName = this.findViewById(R.id.bookDNameText)
        bookAuthor = this.findViewById(R.id.bookDAuthorNameText)
        bookPrice = this.findViewById(R.id.bookDPrice)
        bookDescription = this.findViewById(R.id.bookDDescription)
        bookCode = this.findViewById(R.id.bookDCodeValueText)
        favourite = this.findViewById(R.id.bookDFavourite)
        later = this.findViewById(R.id.bookDLater)
    }

    private fun bookInit()
    {
        bookInfo = Book(
            arguments?.getString("id"),
            arguments?.getString("name")!!,
            arguments?.getString("author")!!,
            arguments?.getString("price")!!,
            arguments?.getString("ImgSrc")!!,
            arguments?.getString("description")!!,
            arguments?.getString("code")!!,
            arguments?.getBoolean("favourite")!!,
            arguments?.getBoolean("later")!!
        )
    }

    private fun setFavourite(fav: Boolean)
    {
        // DB updateStatus
        if (fav)
        {
            favourite?.setColorFilter((this.getColor( R.color.red_700)), PorterDuff.Mode.SRC_IN)
            favourite?.setImageResource(R.drawable.ic_baseline_favorite_24)
        }
        else
        {
            favourite?.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }
    }

    private fun setLater(lat: Boolean)
    {
        // DB updateStatus
        if (lat)
        {
            later?.setColorFilter((this.getColor( R.color.light_green_700)), PorterDuff.Mode.SRC_IN)
            later?.setImageResource(R.drawable.ic_baseline_watch_later_24)
        }
        else
        {
            later?.setImageResource(R.drawable.ic_outline_watch_later_24)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initElementsValue() {
        bookInit()
        bookImage?.setColorFilter((this.getColor( R.color.teal_700)), PorterDuff.Mode.SRC_IN)
        bookImage?.setImageResource(R.drawable.ic_launcher_foreground)

        bookName?.text = bookInfo?.Name
        bookAuthor?.text = bookInfo?.Author
        bookPrice?.text = "$" + bookInfo?.Price
        bookDescription?.text = bookInfo?.Description
        bookCode?.text = bookInfo?.Code

        setFavourite(bookInfo?.Favourite!!)
        setLater(bookInfo?.Later!!)

        later?.setOnClickListener {
            bookInfo?.Later = !(bookInfo?.Later!!)
            setLater(bookInfo?.Later!!)
        }

        favourite?.setOnClickListener {
            bookInfo?.Favourite = !(bookInfo?.Favourite!!)
            setFavourite(bookInfo?.Favourite!!)
        }
    }
}