package com.example.challengeempat

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.example.challengeempat.databinding.CreateDialogBinding
import com.example.challengeempat.databinding.FragmentLoginBinding

class InputDialog(
    private val viewModel: NoteViewModel,
    private val note: Note? = null
): DialogFragment() {
    private var _binding: CreateDialogBinding? = null
    private val binding get() = _binding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = CreateDialogBinding.inflate(LayoutInflater.from(context))

        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding?.root)

        if (note == null){
            binding?.btnSend?.setOnClickListener{
                val title = binding?.etTitle?.text.toString()
                val content = binding?.etContent?.text.toString()
                val newNote = Note(noteTitle = title, noteContent = content)
                viewModel.addNote(newNote)
                dismiss()
            }
        } else {
            binding?.etTitle?.setText(note.noteTitle)
            binding?.etContent?.setText(note.noteContent)
            binding?.btnSend?.setOnClickListener{
                val title = binding?.etTitle?.text.toString()
                val content = binding?.etContent?.text.toString()
                val newNote = Note(noteTitle = title, noteContent = content)
                newNote.noteId = note.noteId
                viewModel.updateNote(newNote)
                dismiss()
            }
        }


        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }
}