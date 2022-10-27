package com.example.zoeziapplication

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        val listHuruf = arrayListOf<String>()

        for (item in 'A'..'Z'){
            listHuruf.add(item.toString())
        }


        val adapter =  HurufAdapter(listHuruf, this) { sendData(it, listHuruf) }

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val recyclerView= findViewById<RecyclerView>(R.id.viewListHuruf)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun sendData(position: Int, list: ArrayList<String>){
        val huruf = list[position]
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("HURUF", huruf)
        startActivity(intent)
    }
}