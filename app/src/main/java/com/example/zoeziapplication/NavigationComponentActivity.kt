package com.example.zoeziapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NavigationComponentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_component)
//        val listHuruf = arrayListOf<String>()
//
//        for (item in 'A'..'Z'){
//            listHuruf.add(item.toString())
//        }
//
//
//        val adapter =  HurufAdapter(listHuruf, this) { sendData(it, listHuruf) }
//
//        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//
//        val recyclerView= findViewById<RecyclerView>(R.id.navContainer)
//
//        recyclerView.layoutManager = layoutManager
//        recyclerView.adapter = adapter
    }

//    private fun sendData(position: Int, list: ArrayList<String>) {
//        val huruf = list[position]
//        val manager = supportFragmentManager
//        val transaction = manager.beginTransaction()
//        val fragment = HomeFragment()
//        transaction.add(R.id.navContainer, fragment)
//        transaction.commit()
//    }
}