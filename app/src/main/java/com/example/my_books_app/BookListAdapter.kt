package com.example.my_books_app

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.my_books_app.databinding.ShowItemListBinding

class BookListAdapter : RecyclerView.Adapter<BookListAdapter.BookListViewHolder>() {

    private var listOfBook = ArrayList<Book>()

    fun addBookList(list: List<Book>) {
        this.listOfBook.clear()
        this.listOfBook.addAll(list)
        notifyDataSetChanged()
    }

    inner class BookListViewHolder(private val binding: ShowItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val itemNow = listOfBook[position]
            binding.tvBookTitle.text = itemNow.bookTitle

            binding.cardView.setOnClickListener {
                val intent = Intent(itemView.context, DetailBookActivity::class.java)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        return BookListViewHolder(
            ShowItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listOfBook.size
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
        holder.bind(position)
    }
}