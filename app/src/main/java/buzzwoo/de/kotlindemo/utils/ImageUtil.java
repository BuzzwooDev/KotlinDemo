package buzzwoo.de.kotlindemo.utils;

import android.content.Context;

import buzzwoo.de.kotlindemo.R;

/**
 * Created by Nutdanai Jantarawong on 7/25/2017 AD.
 */

public class ImageUtil {

    public int getFilmPoster(int episodeId) {

        int res = R.drawable.starwarr;
        switch (episodeId) {
            case 1:
                res = R.drawable.starwar1;
                break;
            case 2:
                res = R.drawable.starwar2;
                break;
            case 3:
                res = R.drawable.starwar3;
                break;
            case 4:
                res = R.drawable.starwar4;
                break;
            case 5:
                res = R.drawable.starwar5;
                break;
            case 6:
                res = R.drawable.starwar6;
                break;
            case 7:
                res = R.drawable.starwar7;
                break;
        }
        return res;
    }
}
