package fr.purplegiraffe.tvshows.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.purplegiraffe.tvshows.R
import fr.purplegiraffe.tvshows.data.Show
import kotlinx.android.synthetic.main.show_cell.view.*

class ShowListAdapter(delegate:Delegate) : RecyclerView.Adapter<ShowListAdapter.ShowViewHolder>() {
    interface Delegate {
        fun touchedShow(show:Show, index:Int)
    }
    private val delegate = delegate
    private var showList:List<Show> = listOf()

    fun reloadShowList(list:List<Show>) {
        showList = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val cell = LayoutInflater.from(parent.context).inflate(R.layout.show_cell,parent,false)
        val holder = ShowViewHolder(cell)
        return holder
    }

    override fun getItemCount(): Int {
        return showList.size
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        val show = showList[position]
        holder.layoutForShow(show)
    }

    fun touchedShowAtIndex(showIndex: Int) {
        delegate.touchedShow(showList[showIndex], showIndex)
    }

    inner class ShowViewHolder(rootView: View):RecyclerView.ViewHolder(rootView),
        View.OnClickListener {
        val textView = rootView.title

        init {
            rootView.setOnClickListener(this)
        }

        fun layoutForShow(show:Show) {
            textView.text = show.title
        }

        override fun onClick(v: View?) {
            touchedShowAtIndex(adapterPosition)
        }

    }

}
