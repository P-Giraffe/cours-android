fun main(args: Array<String>) {
    val texte:String = "Bazinga!"
    val entier:Int = 10
    val reel:Double = 10.5
    var booleen:Boolean = true

    val p1 = Player("Sheldon")
    val p2 = Player("Leonard")
    val bowser = Bot(100)
    bowser.receiveHit(10)
    p1.receiveHit(10)
    println(bowser.health)

    p1.printYourself()
    p2.printYourself()

    p1.hit(p2, 50)
    p1.printYourself()
    p2.printYourself()
    p2.hit(p1, 60)
    p1.printYourself()
    p2.printYourself()

    if (p1 > p2) {
        println("${p1.nickname} a gagné")
    } else if (p2 > p1) {
        println("${p2.nickname} a gagné")
    } else {
        println("Match nul…")
    }
}

open class Person {
    var health:Int = 100

    open fun receiveHit(hitPower:Int) {
        this.health = this.health - hitPower
    }
}

class Bot (val strength:Int) : Person() {

}

class Player (val nickname:String) : Person(), Comparable<Player> {
    var score:Int = 0

    fun printYourself() {
        println("${this.nickname} | Score : ${this.score} | Santé : ${this.health}")
    }

    override fun receiveHit(hitPower: Int) {
        super.receiveHit(hitPower)
        println("${this.nickname} : Ouch!")
    }

    fun hit(player:Player, hitPower:Int) {
        player.receiveHit(hitPower)
        this.score = this.score + hitPower
    }

    override fun compareTo(other: Player): Int {
        return this.score - other.score
    }
}