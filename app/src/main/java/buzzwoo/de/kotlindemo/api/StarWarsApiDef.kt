package buzzwoo.de.kotlindemo.api

import buzzwoo.de.kotlindemo.model.Response
import retrofit2.http.GET

/**
 * Created by Nutdanai Jantarawong on 7/25/2017 AD.
 */
interface StarWarsApiDef {
    @GET("films")
    fun loadFilms(): rx.Observable<Response>
}