package com.example.wishlist_

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var wishList: ArrayList<Wish>
    lateinit var adapter: WishListAdapter
    lateinit var btnSubmit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wishList = ArrayList()
        recyclerView = findViewById(R.id.rvWishes)
        btnSubmit = findViewById(R.id.btnSubmit)
        adapter = WishListAdapter(this,wishList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        val etName = findViewById<EditText>(R.id.etName)
        val etPrice = findViewById<EditText>(R.id.etPrice)
        val etLink = findViewById<EditText>(R.id.etLink)
        btnSubmit.setOnClickListener {
            val name = etName.text.toString()
            val price = etPrice.text.toString().toDouble()
            val link = etLink.text.toString()
            wishList.add(Wish("Name: $name","Price: $price", "$link"))
            adapter.notifyDataSetChanged()
            recyclerView.smoothScrollToPosition(adapter.itemCount - 1)
            etLink.setText("")
            etPrice.setText("")
            etName.setText("")
        }
    }
}