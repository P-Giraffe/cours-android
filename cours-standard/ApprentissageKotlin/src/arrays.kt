fun main(args: Array<String>) {
    val listeNotes = mutableListOf(15, 12, 8, 17)
    print(listeNotes[0])
    print(listeNotes[1])
    print(listeNotes[2])
    print(listeNotes[3])
    listeNotes[3] = 10
    listeNotes.add(0, 20)
    print(listeNotes[4])
    listeNotes.removeAt(2)

}