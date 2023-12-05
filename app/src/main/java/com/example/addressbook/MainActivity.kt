package com.example.addressbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private val recyclerFragment = RecyclerFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.replaceFragment(this.recyclerFragment)
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
        this.recyclerFragment.setContact(contact)
        this.replaceFragment(recyclerFragment)
    }

    fun showContact(positionIndex: Int) {
        this.recyclerFragment.showContact(positionIndex)
    }

    fun deleteContact(contact: Contact) {
        this.recyclerFragment.deleteContact(contact)
    }

}