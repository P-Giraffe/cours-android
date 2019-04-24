package fr.purplegiraffe.tvcharacters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cell_character.view.*

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
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.cell_character,parent,false)

        // 2 - Créer un viewholder pour contrôler cette vue
        val holder = CharacterViewHolder(rootView)

        // 3 - retourner le viewholder
        return holder
    }

    override fun getItemCount(): Int {
        return _characterList.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        // 1 - Obtenir le personnage
        val character = _characterList[position]

        // 2 - Envoyer les infos du personnage dans le holder
        holder.fillWithCharacter(character)
    }

    class CharacterViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
        private val ui_title = rootView.ui_title
        private val ui_subtitle = rootView.ui_subtitle

        fun fillWithCharacter(character: Character) {
            ui_title.text = character.name
            ui_subtitle.text = character.show
        }
    }
}