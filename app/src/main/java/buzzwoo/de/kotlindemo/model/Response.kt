package buzzwoo.de.kotlindemo.model

import com.google.gson.annotations.SerializedName

class Response {

    @SerializedName("count")
    var count: Long? = null
    @SerializedName("next")
    var next: Any? = null
    @SerializedName("previous")
    var previous: Any? = null
    @SerializedName("results")
    var results: List<Film>? = null

}
