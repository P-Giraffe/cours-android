fun main(args: Array<String>) {

}

fun nullableValues() {
    val name:String? = null
    var capitalizedName:String? = name?.capitalize()
    val notNullName:String = name ?: "Dinesh Chugtai"
    val crazyNotNullName:String = name!!
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