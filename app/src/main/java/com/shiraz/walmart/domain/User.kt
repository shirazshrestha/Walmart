package com.shiraz.walmart.domain

/*
Task 2 : We don’t have a database. So, create a User class which consists of firstname, lastname,
username  (will  be  an  email  id)  and  password  instances.  Make  a  constructor  to
initialize the  values. Right  click  on  your  project  by  choosing  File ->  New ->
Kotlin  File/Class to  create  a  User.kt file
 */

class User {
    lateinit var username: String
    lateinit var password: String
    lateinit var firstname: String
    lateinit var lastname: String


    constructor(username: String, password: String) {
        this.username = username
        this.password = password
    }

    constructor(firstname: String, lastname: String, username: String, password: String) {
        this.firstname = firstname
        this.lastname = lastname
        this.username = username
        this.password = password
    }


}