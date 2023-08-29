package com.example.my_books_app

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.my_books_app.databinding.ActivityDetailBookBinding

class DetailBookActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBookBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setData()
    }

    private fun setData() {
        val bookData = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("bookData", Book::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("bookData")
        }

        Glide
            .with(this)
            .load(bookData?.bookCover)
            .into(binding.ivBookCover)
    }
}