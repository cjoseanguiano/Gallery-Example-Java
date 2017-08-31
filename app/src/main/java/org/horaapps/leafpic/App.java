package org.horaapps.leafpic;

import android.app.Application;

import com.orhanobut.hawk.Hawk;
import com.squareup.leakcanary.LeakCanary;

import org.horaapps.leafpic.data.Album;
import org.horaapps.leafpic.data.HandlingAlbums;

/**
 * Created by dnld on 28/04/16.
 */
public class App extends /*horaapps.org.liz.App*/ Application {

    private static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
/*
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
*/

        Hawk.init(this).build();

        mInstance = this;
    }

    public static App getInstance() {
        return mInstance;
    }

    @Deprecated
    public Album getAlbum() {
        return Album.getEmptyAlbum();
    }

    @Deprecated
    public HandlingAlbums getAlbums() {
        return HandlingAlbums.getInstance(getApplicationContext());
    }
}