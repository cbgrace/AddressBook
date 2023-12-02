package com.example.addressbook

import org.json.JSONObject

class Contact {
    var name: String = ""
    var phone: String = ""
    var email: String = ""
    var street: String = ""
    var city: String = ""
    var state: String = ""
    var zip: String = ""

    constructor(name: String, phone: String, email: String, street: String, city: String,
        state: String, zip: String) {
        this.name = name
        this.phone = phone
        this.email = email
        this.street = street
        this.city = city
        this.state = state
        this.zip = zip
    }

    constructor(json: JSONObject) {
        this.name = json.getString("name")
        this.phone = json.getString("phone")
        this.email = json.getString("email")
        this.street = json.getString("street")
        this.city = json.getString("city")
        this.state = json.getString("state")
        this.zip = json.getString("zip")
    }

    constructor() {}

    public fun toJSON() : JSONObject {
        val json = JSONObject()
        json.put("name", this.name)
        json.put("phone", this.phone)
        json.put("email", this.email)
        json.put("street", this.street)
        json.put("city", this.city)
        json.put("state", this.state)
        json.put("zip", this.zip)
        return json
    }

}