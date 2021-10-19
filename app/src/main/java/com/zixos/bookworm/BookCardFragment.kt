package com.zixos.bookworm

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class BookCardFragment : Fragment() {

    companion object {
        fun newInstance() = BookCardFragment()
    }

    private lateinit var viewModel: BookCardViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.book_card_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BookCardViewModel::class.java)
        // TODO: Use the ViewModel
    }

}