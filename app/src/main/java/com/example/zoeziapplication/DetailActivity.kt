package com.example.zoeziapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = getDetail()
        val adapter =  HurufAdapter(data as ArrayList<String>, this) { openWeb(it, data) }

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val recyclerView= findViewById<RecyclerView>(R.id.viewDetailListHuruf)

        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = adapter
    }

    fun getDetail(): List<String> {
        val listKata : ArrayList<String> = arrayListOf(
            "Audition", "American", "Academy", "Brown", "Indicator", "Data", "Outcome", "Catapult", "Clown",
            "Buy", "Box", "Dog", "Dawn", "Extras", "Ell", "Egg", "Fish", "Frog", "Family", "Ground", "Goal",
            "Ghost", "House", "Hommie", "Haunt", "Illness", "Jaguar", "Key", "Longshot", "Mature", "Nice",
            "Offside", "Petronom", "Quill", "Rex",  "Study", "Try", "Unzip", "Vendeta", "World", "X-Ray",
            "Yawn", "Zebra"
        )
        val huruf = intent.getStringExtra("HURUF").toString()
        val data = listKata.filter { kata -> kata.startsWith(huruf) }

        for (item in data){
            Log.e("HRR", item)
        }
        return data
    }

    fun openWeb(position: Int, list: List<String>){
        val kata = list[position]
        val url = "https://www.google.com/search?q=${kata}"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}