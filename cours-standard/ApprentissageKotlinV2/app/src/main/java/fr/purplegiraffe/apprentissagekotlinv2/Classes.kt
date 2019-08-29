package fr.purplegiraffe.apprentissagekotlinv2

class Classes : Executable() {
    override fun main() {
        val p1 = Person("Maxime")
        val d1 =  Dog("Sushi")
        d1.age = 3
        d1.owner = p1
        d1.sayHello()
    }

    inner class Person(val name:String)

    inner class Dog(val name:String) {
        var age:Int = 0
        lateinit var owner:Person

        fun sayHello() {
            println("Hello I'm $name, I'm $age year(s) old and I live with ${owner.name}")
        }
    }
}




