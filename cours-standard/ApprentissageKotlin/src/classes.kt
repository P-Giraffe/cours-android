fun main(args: Array<String>) {
    val texte:String = "Bazinga!"
    val entier:Int = 10
    val reel:Double = 10.5
    var booleen:Boolean = true

    val p1 = Player("Sheldon")
    val p2 = Player("Leonard")

    p1.printYourself()
    p2.printYourself()

    p1.hit(p2, 50)
    p1.printYourself()
    p2.printYourself()
    p2.hit(p1, 40)
    p1.printYourself()
    p2.printYourself()
}

class Player (val nickname:String) {
    var score:Int = 0
    var health:Int = 100

    fun printYourself() {
        println("${this.nickname} | Score : ${this.score} | Santé : ${this.health}")
    }

    fun receiveHit(hitPower:Int) {
        println("${this.nickname} : Ouch!")
        this.health = this.health - hitPower
    }

    fun hit(player:Player, hitPower:Int) {
        player.receiveHit(hitPower)
        this.score = this.score + hitPower
    }
}