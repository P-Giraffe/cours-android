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
    p2.hit(p1, 40)
    p1.printYourself()
    p2.printYourself()
}

open class Person {
    var health:Int = 100

    open fun receiveHit(hitPower:Int) {
        this.health = this.health - hitPower
    }
}

class Bot (val strength:Int) : Person() {

}

class Player (val nickname:String) : Person() {
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
}