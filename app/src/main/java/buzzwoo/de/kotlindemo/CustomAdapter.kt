package buzzwoo.de.kotlindemo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import buzzwoo.de.kotlindemo.extensions.getPosterImage
import buzzwoo.de.kotlindemo.extensions.loadThumbnail
import buzzwoo.de.kotlindemo.model.Film
import kotlinx.android.synthetic.main.item_row.view.*
import org.jetbrains.anko.startActivity

/**
 * Created by Nutdanai Jantarawong on 7/25/2017 AD.
 */

class CustomAdapter(var films: List<Film>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_row, parent, false) as View)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindData(films, position)
    }

    override fun getItemCount(): Int {
        return films.size
    }

    class ViewHolder(var view: View): RecyclerView.ViewHolder(view) {
        fun bindData(films: List<Film>, position: Int){

            view.thumbnail.loadThumbnail(films[position].getPosterImage())
            view.thumbnail.setOnClickListener {
                view.context.startActivity<DetailActivity>(Pair("film", films[position]))
            }
            view.title.text = films[position].title
            view.episode.text = "Episode: ${films[position].episodeId.toString()}"
        }
    }
}