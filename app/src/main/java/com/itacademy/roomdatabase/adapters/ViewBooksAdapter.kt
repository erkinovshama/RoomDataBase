package com.itacademy.roomdatabase.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.itacademy.roomdatabase.R
import com.itacademy.roomdatabase.entities.Book

class ViewBooksAdapter(private val array: Array<Book>, val context: FragmentActivity): RecyclerView.Adapter<ViewBooksAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.item_name_book)
        val author: TextView = view.findViewById(R.id.item_author_book)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_books, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.name.text = item.bookName
        holder.author.text = item.author
    }

    override fun getItemCount(): Int {
        return array.size
    }
}