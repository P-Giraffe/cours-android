fun main(args: Array<String>) {
    val s1 = Student("Joe", 20)
    val s2 = Student("Jane", 22)
    val s3 = Student("Joe", 20)

    if (s1 == s3) {
        println("s1 et s3 sont les mêmes")
    } else {
        println("s1 et s3 sont différents")
    }
    println(s1)
}

data class Student(val name:String, val age:Int)