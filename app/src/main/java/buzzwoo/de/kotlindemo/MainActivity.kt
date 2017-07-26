package buzzwoo.de.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import buzzwoo.de.kotlindemo.api.StarWarsApiDef
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridLayoutManager = GridLayoutManager(this, 2)
        rvFilms.layoutManager = gridLayoutManager

        fetchFilmsData()
    }

    fun fetchFilmsData() {
        var retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        var service = retrofit.create<StarWarsApiDef>(StarWarsApiDef::class.java)
        service.loadFilms()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        // On Response
                        var data = it.results!!.sortedBy { it -> it.episodeId }
                        rvFilms.adapter = CustomAdapter(data)
                    }, {
                        // On Error
                        it.printStackTrace()
                    }, {
                        // On Complete
                        rvFilms.adapter.notifyDataSetChanged()
                    })
    }
}
