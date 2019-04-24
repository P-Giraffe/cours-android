fun main(args: Array<String>) {
    val v1 = Voiture("207")
    val r1 = Voiture.Roue()
    val personne1 = Personne("Bob")
    val pied1 = personne1.Pied()
}

class Voiture(val name: String) {
    class Roue {

    }
}

class Personne(val name:String) {

    inner class Pied() {
        fun afficheToi() {
            println("Je suis le pied de ${name}")
        }
    }
}

