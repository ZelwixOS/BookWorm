package com.zixos.bookworm

import android.annotation.SuppressLint
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

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

    @SuppressLint("SetTextI18n")
    private fun initElementsValue() {
        bookImage?.setColorFilter((this.getColor( R.color.teal_700)), PorterDuff.Mode.SRC_IN)
        bookImage?.setImageResource(R.drawable.ic_launcher_foreground)

        bookName?.text = arguments?.getString("name")
        bookAuthor?.text = arguments?.getString("author")
        bookPrice?.text = "$" + arguments?.getString("price")
        bookDescription?.text = arguments?.getString("description")
        bookCode?.text = arguments?.getString("code")

        if (arguments?.getBoolean("later") == true)
        {
            later?.setColorFilter((this.getColor( R.color.light_green_700)), PorterDuff.Mode.SRC_IN)
            later?.setImageResource(R.drawable.ic_baseline_watch_later_24)
        }
        else
        {
            later?.setImageResource(R.drawable.ic_outline_watch_later_24)
        }

        later?.setOnClickListener {
            // Action
        }

        if (arguments?.getBoolean("favourite") == true)
        {
            favourite?.setColorFilter((this.getColor( R.color.red_700)), PorterDuff.Mode.SRC_IN)
            favourite?.setImageResource(R.drawable.ic_baseline_favorite_24)
        }
        else
        {
            favourite?.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }

        favourite?.setOnClickListener {
            // Action
        }
    }
}