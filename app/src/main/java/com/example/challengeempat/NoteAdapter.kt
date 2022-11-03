package com.example.challengeempat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(
    private val listNote: List<Note>,
    var context: Context,
    private var onEdit: ((Note)->Unit)? = null,
    private var onDelete:((Note)->Unit)? = null
): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val noteText = itemView.findViewById<TextView>(R.id.tvNoteTitle)
        val noteContent = itemView.findViewById<TextView>(R.id.tvNoteContent)
        val btnEdit = itemView.findViewById<ImageButton>(R.id.btnEdit)
        val btnDelete = itemView.findViewById<ImageButton>(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = listNote[position]
        holder.noteText.text = note.noteTitle
        holder.noteContent.text = note.noteContent

        holder.btnEdit.setOnClickListener() { onEdit?.invoke(note) }
        holder.btnDelete.setOnClickListener() { onDelete?.invoke(note) }
    }

    override fun getItemCount(): Int {
        return listNote.size
    }

    fun setOnDelete(callback: (Note)->Unit){
        onDelete = callback
    }
}