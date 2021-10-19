package com.zixos.bookworm.ui.later

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
import com.zixos.bookworm.databinding.FragmentLaterBinding

class LaterFragment : Fragment() {

    private lateinit var laterViewModel: LaterViewModel
    private var _binding: FragmentLaterBinding? = null
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
        laterViewModel =
            ViewModelProvider(this).get(LaterViewModel::class.java)

        _binding = FragmentLaterBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initRecyclerView()
        loadBooks()

        return root
    }

    private fun loadBooks() {
        val books: Collection<Book> = this.laterViewModel.getBooks()
        bookAdapter?.setItems(books)
    }

    private fun initRecyclerView() {
        booksRecyclerView = binding.booksRecyclerView
        booksRecyclerView?.layoutManager = LinearLayoutManager(booksRecyclerView?.context)
        bookAdapter = BookAdapter(this, { toDetails() })
        booksRecyclerView?.adapter = bookAdapter
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityContext = context
    }

    private fun toDetails()
    {
        val intent = Intent(activityContext, BookDetails::class.java)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}