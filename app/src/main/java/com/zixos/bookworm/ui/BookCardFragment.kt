package com.zixos.bookworm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zixos.bookworm.R
import android.graphics.drawable.Drawable
import java.io.InputStream
import java.lang.Exception
import java.net.URL


class BookCardFragment : Fragment() {

    companion object {
        fun newInstance() = BookCardFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.book_card_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}