package com.zixos.bookworm.ui.favourite

import Book
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zixos.bookworm.BookDetails
import com.zixos.bookworm.adapter.BookAdapter
import com.zixos.bookworm.dal.DbContext
import com.zixos.bookworm.databinding.FragmentFavouriteBinding

class FavouriteFragment : Fragment() {

    private lateinit var favouriteViewModel: FavouriteViewModel
    private var _binding: FragmentFavouriteBinding? = null
    private var booksRecyclerView: RecyclerView? = null
    private var activityContext: Context? = null
    private var bookAdapter: BookAdapter? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        favouriteViewModel =
            ViewModelProvider(this).get(FavouriteViewModel::class.java)

        _binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initRecyclerView()

        return root
    }

    override fun onStart() {
        super.onStart()
        loadBooks()
    }

    private fun loadBooks() {
        val books: List<Book> = this.favouriteViewModel.getBooks()
        bookAdapter?.setItems(books)
    }

    private fun initRecyclerView() {
        booksRecyclerView = binding.booksRecyclerView
        booksRecyclerView?.layoutManager = LinearLayoutManager(booksRecyclerView?.context)
        bookAdapter = BookAdapter(this) { b -> toDetails(b) }
        booksRecyclerView?.adapter = bookAdapter
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityContext = context
    }

    private fun toDetails(bookInfo: Book)
    {
        var intent = Intent(activityContext, BookDetails::class.java)
        bookInfo.addDataToIntent(intent)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}