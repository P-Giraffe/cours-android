package fr.purplegiraffe.apprentissagekotlinv2

abstract class Executable {
    private var output = ""
    abstract fun main()
    fun execute() : String {
        output = ""
        main()
        return output
    }

    fun print(text:Any) {
        output.plus(text)
    }

    fun println(text:Any) {
        print(text)
        output.plus("\n")
    }
}