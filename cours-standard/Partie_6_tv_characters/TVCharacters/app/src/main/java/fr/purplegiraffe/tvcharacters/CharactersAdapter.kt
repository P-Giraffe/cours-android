package fr.purplegiraffe.tvcharacters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CharactersAdapter : RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {
    val _characterList = arrayOf(Character("Richard Hendricks", "Silicon Valley"),
        Character("Jared Dunn", "Silicon Valley"),
        Character("Will McAvoy", "The Newsroom"),
        Character("Mackenzie MacHale", "The Newsroom"),
        Character("Jim Harper", "The Newsroom"),
        Character("Ross Geller", "Friends"),
        Character("Chandler Bing", "Friends"),
        Character("Joey Tribbiani", "Friends"),
        Character("Monical Geller", "Friends"),
        Character("Charlie Harper", "Two and a Half Men"),
        Character("Allan Harper", "Two and a Half Men"),
        Character("Jake Harper", "Two and a Half Men"))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        // 1 - Charger la vue en XML

        // 2 - Créer un viewholder pour contrôler cette vue

        // 3 - retourner le viewholder
        TODO()
    }

    override fun getItemCount(): Int {
        return _characterList.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        // 1 - Obtenir le personnage
        // 2 - Envoyer les infos du personnage dans le holder
    }

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}