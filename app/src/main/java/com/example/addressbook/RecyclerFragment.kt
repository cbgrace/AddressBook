package com.example.addressbook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecyclerFragment : Fragment() {

    private val contactList = ArrayList<Contact>()
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var addButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recycler, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val layoutManager = LinearLayoutManager(requireContext())
        this.contactAdapter = ContactAdapter(requireActivity(), this.contactList)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = this.contactAdapter
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(),
            LinearLayoutManager.VERTICAL))

        this.addButton = view.findViewById(R.id.add_contact_fab)
        this.addButton.setOnClickListener { addButtonOnClick() }
    }

//    override fun onPause() {
//        super.onPause()
//        Serializer(requireContext()).save(this.contactList)
//    }
//
//    override fun onResume() {
//        super.onResume()
//        val serializer = Serializer(requireContext())
//        try {
//            val list = serializer.load()
//            this.contactList.clear()
//            this.contactList.addAll(list)
//            this.contactAdapter.notifyDataSetChanged()
//        } catch (ex: IOException) {
//            // ??
//        }
//    }

    private fun addButtonOnClick() {
        (requireActivity() as MainActivity).replaceFragment(AddContactFragment())
    }

    fun showContact(positionIndex: Int) {
        val mainActivity = requireActivity() as MainActivity
        val dialog = ViewContactFragment()
        dialog.setContact(this.contactList[positionIndex])
        dialog.show(mainActivity.supportFragmentManager, "")
    }

    fun setContact(contact: Contact) {
        this.contactList.add(contact)
        this.contactAdapter.notifyDataSetChanged()
    }

    fun deleteContact(contact: Contact) {
        this.contactList.remove(contact)
        this.contactAdapter.notifyDataSetChanged()
    }

}