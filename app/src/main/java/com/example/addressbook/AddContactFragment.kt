package com.example.addressbook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.activity.addCallback
import com.google.android.material.floatingactionbutton.FloatingActionButton


class AddContactFragment : Fragment() {

    private lateinit var saveButton: FloatingActionButton
    private lateinit var nameEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var streetEditText: EditText
    private lateinit var cityEditText: EditText
    private lateinit var stateEditText: EditText
    private lateinit var zipEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.nameEditText = view.findViewById(R.id.add_name_edit_text)
        this.phoneEditText = view.findViewById(R.id.add_phone_edit_text)
        this.emailEditText = view.findViewById(R.id.add_email_edit_text)
        this.streetEditText = view.findViewById(R.id.add_street_edit_text)
        this.cityEditText = view.findViewById(R.id.add_city_edit_text)
        this.stateEditText = view.findViewById(R.id.add_state_edit_text)
        this.zipEditText = view.findViewById(R.id.add_zip_edit_text)
        this.saveButton = view.findViewById(R.id.add_save_fab)
        saveButton.setOnClickListener { saveButtonHandler() }

//        val callback = requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
//
//        }
    }

    private fun saveButtonHandler() {
        val name = this.nameEditText.text.toString()
        val phone = this.phoneEditText.text.toString()
        val email = this.emailEditText.text.toString()
        val street = this.streetEditText.text.toString()
        val city = this.cityEditText.text.toString()
        val state = this.stateEditText.text.toString()
        val zip = this.zipEditText.text.toString()

        val newContact = Contact(name, phone, email, street, city, state, zip)
        (activity as MainActivity).setContact(newContact)
    }
}