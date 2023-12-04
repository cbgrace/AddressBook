package com.example.addressbook

import android.content.Context
import org.json.JSONArray
import org.json.JSONTokener
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

const val FILE_NAME = "SavedData"

class Serializer(val context: Context) {

    fun save(contacts: ArrayList<Contact>) {
        val array = JSONArray()
        for (contact in contacts) {
            array.put(contact.toJSON())
        }

        context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE).use {
            file -> OutputStreamWriter(file).use {
                writer -> writer.write(array.toString()) } }
    }

    fun load(): ArrayList<Contact> {
        val contacts = ArrayList<Contact>()
        val json = this.context.openFileInput(FILE_NAME).use {
            input -> BufferedReader(InputStreamReader(input)).use {
                reader -> StringBuilder().apply {
                    reader.forEachLine { line -> append(line) } } } }

        val array = JSONTokener(json.toString()).nextValue() as JSONArray
        for (index in 0 until array.length()) {
            contacts.add(Contact(array.getJSONObject(index)))
        }
        return contacts
    }
}