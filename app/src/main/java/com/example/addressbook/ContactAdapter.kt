package com.example.addressbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(val activity: MainActivity, var contactList: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ContactHolder>() {

        inner class ContactHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
            var nameTextView = view.findViewById<TextView>(R.id.holder_name_text_view)

            init {
                view.isClickable = true
                view.setOnClickListener(this)
            }

            override fun onClick(p0: View?) {
                activity.showContact(adapterPosition)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val itemView = LayoutInflater.from(this.activity).inflate(R.layout.holder_contact,
            parent, false)
        return ContactHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        val currentContact = this.contactList[position]
        holder.nameTextView.text = currentContact.name
    }

    override fun getItemCount(): Int {
        return this.contactList.size
    }

}