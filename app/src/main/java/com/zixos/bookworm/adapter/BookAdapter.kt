package com.zixos.bookworm.adapter

import Book
import OwnerFragment
import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityManager
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.net.Uri
import android.os.Bundle
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.zixos.bookworm.BookDetails
import com.zixos.bookworm.MainActivity
import com.zixos.bookworm.R
import com.zixos.bookworm.ui.favourite.FavouriteFragment
import com.zixos.bookworm.ui.later.LaterFragment
import java.net.URI
import java.net.URL
import kotlin.coroutines.coroutineContext

class BookAdapter(owner: Fragment, open: (book: Book) -> Unit): RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    private val adapterOwner = owner
    private val openDetails: (book: Book) -> Unit = open
    private var bookList: List<Book>? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(books: List<Book>) {
            bookList = books
            notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearItems() {
        bookList = null
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.book_card_fragment, parent, false)
        return  BookViewHolder(view, adapterOwner, openDetails)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(bookList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        return if (bookList != null) bookList?.size!! else 0
    }

    class BookViewHolder(itemView: View, owner: Fragment, open: (book: Book) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        private var bookImage: ImageView? = null
        private var bookName: TextView? = null
        private var bookAuthor: TextView? = null
        private var bookPrice: TextView? = null
        private var favourite: ImageView? = null
        private var later: ImageView? = null
        private var card: MaterialCardView? = null
        private var adapterOwner: Fragment? = owner
        private var openDetails: ((book: Book) -> Unit)? = open

        init {
            bookImage = itemView.findViewById(R.id.bookImage)
            bookName = itemView.findViewById(R.id.bookNameText)
            bookAuthor = itemView.findViewById(R.id.authorNameText)
            bookPrice = itemView.findViewById(R.id.PriceText)
            favourite = itemView.findViewById(R.id.favouriteIcon)
            later = itemView.findViewById(R.id.laterIcon)
            card = itemView.findViewById(R.id.bookCard)
        }

        @SuppressLint("SetTextI18n")
        fun bind(book: Book) {
            bookName?.text = if (book.Name.length > 25)
                book.Name.substring(0, 22) + "..."
            else
                book.Name

            bookAuthor?.text = if (book.Author.length > 25)
                book.Author.substring(0, 22) + "..."
            else
                book.Author
            bookPrice?.text = "$" + book.Price

            //var bookImg: Uri = Uri.parse(book.ImgSrc)
            //bookImage?.setImageURI(bookImg)
            bookImage?.setColorFilter((adapterOwner?.context?.getColor( R.color.teal_700))!!, PorterDuff.Mode.SRC_IN)
            bookImage?.setImageResource(R.drawable.ic_launcher_foreground)

            book?.SetImageFromInternet(bookImage!!)?.execute()

            if (adapterOwner !is FavouriteFragment)
            {
                if (book.Favourite)
                {
                    favourite?.setColorFilter((adapterOwner?.context?.getColor( R.color.red_700))!!, PorterDuff.Mode.SRC_IN)
                    favourite?.setImageResource(R.drawable.ic_baseline_favorite_24)
                }
                else
                {
                    favourite?.setColorFilter((adapterOwner?.context?.getColor( R.color.grey_700))!!, PorterDuff.Mode.SRC_IN)
                    favourite?.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                }
            }
            else
            {
                favourite?.isVisible = false
            }

            if (adapterOwner !is LaterFragment)
            {
                if (book.Later)
                {
                    later?.setColorFilter((adapterOwner?.context?.getColor( R.color.light_green_700))!!, PorterDuff.Mode.SRC_IN)
                    later?.setImageResource(R.drawable.ic_baseline_watch_later_24)
                }
                else
                {
                    later?.setColorFilter((adapterOwner?.context?.getColor( R.color.grey_700))!!, PorterDuff.Mode.SRC_IN)
                    later?.setImageResource(R.drawable.ic_outline_watch_later_24)
                }
            }
            else
            {
                later?.isVisible = false
            }

            card?.setOnClickListener {
                openDetails?.invoke(book)
            }
        }
    }
}