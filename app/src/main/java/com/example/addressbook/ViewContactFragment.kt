package com.example.addressbook

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment


class ViewContactFragment : DialogFragment() {

    private var currentContact = Contact()
    private lateinit var closeButton: Button
    private lateinit var deleteButton: Button

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(this.requireActivity())
        val inflater = this.requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.fragment_view_contact, null, false)

        view.findViewById<TextView>(R.id.view_name_text_view).text = this.getString(
            R.string.view_name_text_view_text, this.currentContact.name)
        view.findViewById<TextView>(R.id.view_number_text_view).text = this.getString(
            R.string.view_number_text_view_text, this.currentContact.phone)
        view.findViewById<TextView>(R.id.view_email_text_view).text = this.getString(
            R.string.view_email_text_view_text, this.currentContact.email)
        view.findViewById<TextView>(R.id.view_street_text_view).text = this.getString(
            R.string.view_street_text_view_text, this.currentContact.street)
        view.findViewById<TextView>(R.id.view_city_text_view).text = this.getString(
            R.string.view_city_text_view_text, this.currentContact.city)
        view.findViewById<TextView>(R.id.view_state_text_view).text = this.getString(
            R.string.view_state_text_view_text, this.currentContact.state)
        view.findViewById<TextView>(R.id.view_zip_text_view).text = this.getString(
            R.string.view_zip_text_view_text, this.currentContact.zip)

        builder.setView(view).setMessage(R.string.view_contact_fragment_message_text)

        this.closeButton = view.findViewById(R.id.view_close_button)
        this.closeButton.setOnClickListener { closeButtonHandler() }
        this.deleteButton = view.findViewById(R.id.view_delete_button)
        this.deleteButton.setOnClickListener { deleteButtonHandler() }

        return builder.create()
    }

    fun setContact(contact: Contact) {
        this.currentContact = contact
    }

    private fun closeButtonHandler() {
        this.dismiss()
    }

    private fun deleteButtonHandler() {
        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setTitle("Confirm")
        alertDialogBuilder.setMessage("Are you sure you want to delete this contact?")
        alertDialogBuilder.setPositiveButton("Yes") { _, _ ->
            (requireActivity() as MainActivity).deleteContact(this.currentContact)
            this.dismiss()
        }
        alertDialogBuilder.setNegativeButton("No") { dialog, _ ->
            // Do Nothing...
            dialog.dismiss()
        }

        val alertDialog: AlertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

}