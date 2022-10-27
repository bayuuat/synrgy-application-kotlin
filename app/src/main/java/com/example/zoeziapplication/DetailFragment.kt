package com.example.zoeziapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zoeziapplication.databinding.FragmentDetailBinding
import com.example.zoeziapplication.databinding.FragmentHomeBinding

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding?=null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val context = view.getContext();
        super.onViewCreated(view, savedInstanceState)

        val data = getDetail()
        val adapter =  HurufAdapter(data as ArrayList<String>, context) { openWeb(it, data) }

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val recyclerView= binding?.detailFragment

        recyclerView?.layoutManager = layoutManager

        recyclerView?.adapter = adapter
    }

    fun getDetail(): List<String> {
        val listKata : ArrayList<String> = arrayListOf(
            "Audition", "American", "Academy", "Brown", "Indicator", "Data", "Outcome", "Catapult", "Clown",
            "Buy", "Box", "Dog", "Dawn", "Extras", "Ell", "Egg", "Fish", "Frog", "Family", "Ground", "Goal",
            "Ghost", "House", "Hommie", "Haunt", "Illness", "Jaguar", "Key", "Longshot", "Mature", "Nice",
            "Offside", "Petronom", "Quill", "Rex",  "Study", "Try", "Unzip", "Vendeta", "World", "X-Ray",
            "Yawn", "Zebra"
        )
        val huruf = arguments?.getString("HURUF").toString()
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