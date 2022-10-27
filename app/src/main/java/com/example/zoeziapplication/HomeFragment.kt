package com.example.zoeziapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zoeziapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val context = view.getContext();
        super.onViewCreated(view, savedInstanceState)

        val listHuruf = arrayListOf<String>()

        for (item in 'A'..'Z'){
            listHuruf.add(item.toString())
        }

        val adapter =  HurufAdapter(listHuruf, context) { sendData(it, listHuruf) }

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val recyclerView = binding?.homeFragment

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter
    }

    private fun sendData(position: Int, list: ArrayList<String>){
        val huruf = list[position]
        val bundle = Bundle()
        bundle.putString("HURUF", huruf)
        findNavController().navigate(R.id.action_homeFragment2_to_detailFragment2, bundle)
    }

}