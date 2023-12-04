package com.example.addressbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.replaceFragment(RecyclerFragment())
    }

    fun replaceFragment(fragment: Fragment) {
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(
            R.anim.enter_from_right,
            R.anim.exit_to_left,
            R.anim.enter_from_left,
            R.anim.exit_to_right)
        transaction.replace(R.id.container, fragment).commit()
    }

    fun setContact(contact: Contact) {
        val recyclerFragment = RecyclerFragment()
        this.replaceFragment(recyclerFragment)
        recyclerFragment.setContact(contact)
    }

    fun showContact(positionIndex: Int) {
        RecyclerFragment().showContact(positionIndex)
    }

}