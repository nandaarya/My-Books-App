package com.example.my_books_app

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.my_books_app.databinding.ActivityDetailBookBinding

class DetailBookActivity : AppCompatActivity() {
    private lateinit var bookTitle: String
    private lateinit var synopsis: String
    private lateinit var bookData: Book

    private lateinit var binding: ActivityDetailBookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBookBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = "Detail Buku"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        bookData = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("bookData", Book::class.java)!!
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("bookData")!!
        }

        setData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        openMenu(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun openMenu (selectedMenu: Int) {
        when (selectedMenu) {
            R.id.action_share -> {
                bookTitle = bookData.bookTitle
                synopsis = bookData.synopsis
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Judul Buku: $bookTitle.\n" +
                            "Sinopsis: $synopsis")
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }
    }

    @Suppress("DEPRECATION")
    override fun onSupportNavigateUp(): Boolean {
        // Tindakan ketika tombol kembali ditekan
        onBackPressed()
        return true
    }

    private fun setData() {
        Glide
            .with(this)
            .load(bookData.bookCover)
            .into(binding.ivBookCover)

        binding.tvBookTitle.text = getString(R.string.book_title, bookData.bookTitle)
        binding.tvAuthorName.text = getString(R.string.author_name, bookData.authorName)
        binding.tvPublicationYear.text = getString(R.string.publication_year,
            bookData.publicationYear
        )
        binding.tvCategory.text = getString(R.string.category, bookData.category)
        binding.tvSinopsis.text = bookData.synopsis
    }
}