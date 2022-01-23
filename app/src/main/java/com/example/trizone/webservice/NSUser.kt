package com.example.trizone.webservice

class NSUser {
    lateinit var id: String
    lateinit var name: String
    lateinit var password: String
    lateinit var email: String
    lateinit var phone: String

    constructor(id: String, name: String, password: String, email: String, phone: String) {
        this.id = id
        this.name = name
        this.password = password
        this.email = email
        this.phone = phone
    }

    constructor()
}