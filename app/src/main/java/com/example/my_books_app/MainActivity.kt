package com.example.my_books_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my_books_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }

    private fun setBookList() {
        val rvBookListAdapter = BookListAdapter()

        binding.rvBookList.layoutManager = LinearLayoutManager(this)
        binding.rvBookList.adapter = rvBookListAdapter

        rvBookListAdapter.addBookList(Book)
    }
}