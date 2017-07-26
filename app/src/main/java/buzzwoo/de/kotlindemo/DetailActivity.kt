package buzzwoo.de.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import buzzwoo.de.kotlindemo.extensions.getPosterImage
import buzzwoo.de.kotlindemo.extensions.loadThumbnail
import buzzwoo.de.kotlindemo.model.Film
import kotlinx.android.synthetic.main.activity_detail.*

/**
 * Created by Nutdanai Jantarawong on 7/25/2017 AD.
 */

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val film = intent.extras.get("film") as Film

        collapsing_toolbar.title = "${film.title} ep.${film.episodeId}"

        image.loadThumbnail(film.getPosterImage())
        txt_opening_crawl.text = film.openingCrawl
        txt_director_name.text = film.director
        txt_producer_name.text = film.producer
        txt_release_date.text = film.releaseDate

    }

}