import java.util.*
import kotlin.concurrent.schedule

fun main(args: Array<String>) {
    println("Coucou")
    Timer().schedule(3000) {
        println("A au fait je suis toujours là...")
    }
    println("Bye bye")
}