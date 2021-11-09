package com.zixos.bookworm.ui.favourite

import Book
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zixos.bookworm.BookDetails
import com.zixos.bookworm.adapter.BookAdapter
import com.zixos.bookworm.databinding.FragmentFavouriteBinding

class FavouriteFragment : Fragment() {

    private lateinit var favouriteViewModel: FavouriteViewModel
    private var _binding: FragmentFavouriteBinding? = null
    private var booksRecyclerView: RecyclerView? = null
    private var activityContext: Context? = null
    private var bookAdapter: BookAdapter? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
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
        loadBooks()
        return root
    }

    private fun loadBooks() {
        val books: Collection<Book> = this.favouriteViewModel.getBooks()
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
        val intent = Intent(activityContext, BookDetails::class.java)
        intent.putExtra("name", bookInfo.Name)
        intent.putExtra("imgSrc", bookInfo.ImgSrc)
        intent.putExtra("author" ,bookInfo.Author)
        intent.putExtra("description", bookInfo.Description)
        intent.putExtra("price", bookInfo.Price)
        intent.putExtra("favourite", bookInfo.Favourite)
        intent.putExtra("later", bookInfo.Later)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}