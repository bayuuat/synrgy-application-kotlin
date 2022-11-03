package com.example.challengeempat

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengeempat.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding
    private lateinit var sharedPref: SharedPref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = view.getContext();
        init(context)
        val application = requireNotNull(this.activity).application

        val dataSource = NoteDatabase.getInstance(application).noteDatabaseDao

        val viewModelFactory = NoteViewModelFactory(dataSource, application)

        val noteViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(NoteViewModel::class.java)

        binding?.tvLogout?.setOnClickListener {
            sharedPref.isLogin = false
            findNavController().popBackStack()
        }

        noteViewModel.allData.observe(viewLifecycleOwner, Observer { list ->
            val adapter =  NoteAdapter(
                list,
                context,
                onEdit = {onEdit(it, noteViewModel)},
                onDelete = {onDelete(it, noteViewModel)}
            )

            val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            val recyclerView = binding?.homeFragment

            recyclerView?.layoutManager = layoutManager
            recyclerView?.adapter = adapter
        })

        binding?.btnAddNote?.setOnClickListener{
            InputDialog(noteViewModel).show(parentFragmentManager, "dialog")
        }
    }

    fun init(context: Context){
        sharedPref = SharedPref(context)
    }

    private fun onEdit(note: Note, viewModel: NoteViewModel){
        InputDialog(viewModel, note).show(parentFragmentManager, "dialog")
    }

    private fun onDelete(note: Note, viewModel: NoteViewModel){
        val builder = AlertDialog.Builder(context)
        builder.setMessage("Really?")
        builder.setPositiveButton("YES") { p0, _ ->
            viewModel.onDelete(note)
            p0?.dismiss()
        }
        builder.setNegativeButton("NO") { p0, _  ->
            p0?.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }

}