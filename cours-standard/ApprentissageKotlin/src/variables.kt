fun main(args: Array<String>) {
    var name:String? = null
    val notNullName:String = name ?: "Dinesh Chugtai"
    var capitalizedName:String? = name?.capitalize()
    if (name != null) {
        print("${name} possède ${name.length} lettre(s)")
    } else {
        print("Votre prénom est vide ? :(")
    }
}

fun valTypes() {
    val explicitString : String = "Sheldon"
    val implicitString = "Leonard"
    val explicitInt : Int = 20
    val implicitInt = 20
}