package com.example.my_books_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.my_books_app.databinding.ActivityDetailBookBinding

class DetailBookActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBookBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun setData() {

    }
}