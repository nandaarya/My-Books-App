package com.example.my_books_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my_books_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = "My Books"

        setBookList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        openMenu(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun openMenu (selectedMenu: Int) {
        when (selectedMenu) {
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun setBookList() {
        val rvBookListAdapter = BookListAdapter()

        binding.rvBookList.layoutManager = LinearLayoutManager(this)
        binding.rvBookList.adapter = rvBookListAdapter

        rvBookListAdapter.addBookList(BookList.bookList)
    }
}