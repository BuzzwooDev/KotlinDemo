package buzzwoo.de.kotlindemo.extensions

import android.widget.ImageView
import buzzwoo.de.kotlindemo.model.Film
import buzzwoo.de.kotlindemo.utils.ImageUtil
import com.bumptech.glide.Glide

/**
 * Created by Nutdanai Jantarawong on 7/26/2017 AD.
 */

//ImageView Extension
fun ImageView.loadThumbnail(res: Int) = Glide.with(this.context).load(res).into(this)
fun Film.getPosterImage(): Int = ImageUtil().getFilmPoster(this.episodeId!!.toInt())