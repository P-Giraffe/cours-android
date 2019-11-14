package fr.purplegiraffe.tvcharacters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

    fun onCharacterClick(index:Int, context:Context) {
        val character = _characterList[index]
        Toast.makeText(context, character.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        // 1 - Charger la vue en XML
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.cell_character,parent,false)

        // 2 - Créer un viewholder pour contrôler cette vue
        val holder = CharacterViewHolder(rootView)

        // 3 - retourner le viewholder
        Log.i("LOG", "onCreateViewHolder")
        return holder
    }

    override fun getItemCount(): Int {
        Log.i("LOG", "getItemCount")
        return _characterList.size

    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        // 1 - Obtenir le personnage
        val character = _characterList[position]

        // 2 - Envoyer les infos du personnage dans le holder
        holder.fillWithCharacter(character)
        Log.i("LOG", "onBindViewHolder : ${position}")

    }

    inner class CharacterViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView), View.OnClickListener {
        private val ui_title = rootView.ui_title
        private val ui_subtitle = rootView.ui_subtitle

        init {
            rootView.setOnClickListener(this)
        }

        fun fillWithCharacter(character: Character) {
            ui_title.text = character.name
            ui_subtitle.text = character.show
        }

        override fun onClick(v: View?) {
            if (v != null) {
                onCharacterClick(adapterPosition, v.context)
            }
        }
    }
}