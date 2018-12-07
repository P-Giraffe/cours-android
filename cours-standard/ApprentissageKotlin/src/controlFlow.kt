fun main(args: Array<String>) {

}

fun ifelse() {
    val age = 17
    if (age < 18) {
        print("Vous êtes mineur(e)")
    } else if (age == 18) {
        print("Vous venez de devenir majeur(e) en france")
    } else if (age < 21) {
        print("Vous allez bientôt devenir majeur(e) aux USA")
    } else {
        print("Vous êtes majeur(e)")
    }
}

fun whenElse() {
    val age = 17
    when (age) {
        in 0..17 -> print("Vous êtes mineur(e)")
        18 -> print("Vous venez de devenir majeur(e) en france")
        19,20 -> print("Vous allez bientôt devenir majeur(e) aux USA")
        else -> print("Vous êtes majeur(e)")
    }
}