package com.example.my_books_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.my_books_app.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_about)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = "About"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setData()
    }

    @Suppress("DEPRECATION")
    override fun onSupportNavigateUp(): Boolean {
        // Tindakan ketika tombol kembali ditekan
        onBackPressed()
        return true
    }

    private fun setData() {
        Glide.with(this)
            .load(R.drawable.foto)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .into(binding.profileImage)

        binding.name.text = getString(R.string.name)
        binding.email.text = getString(R.string.email)
    }
}