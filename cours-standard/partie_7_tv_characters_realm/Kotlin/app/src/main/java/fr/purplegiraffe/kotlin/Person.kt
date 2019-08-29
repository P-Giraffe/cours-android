package fr.purplegiraffe.kotlin

class Person(val name:String) {
    val familyName:String
    init {
        familyName = name.substringAfter(" ")
        sayHello()
    }

    constructor() : this("John Doe")


    fun sayHello() {
        println("Hello my name is $name. Mon nom de famille est $familyName")
    }
}