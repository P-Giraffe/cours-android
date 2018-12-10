fun main(args: Array<String>) {
    val texte:String = "Bazinga!"
    val entier:Int = 10
    val reel:Double = 10.5
    var booleen:Boolean = true

    val p1 = Player("Sheldon")
    val p2 = Player("Leonard")

    p1.score = 10
    p2.score = 20
    println("${p1.nickname}, score: ${p1.score}")
    println("${p2.nickname}, score: ${p2.score}")
}

class Player (val nickname:String) {
    var score:Int = 0
    var health:Int = 100
}