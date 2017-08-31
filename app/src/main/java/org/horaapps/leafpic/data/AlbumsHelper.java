package org.horaapps.leafpic.data;

import android.content.Context;
import android.media.MediaScannerConnection;

import com.orhanobut.hawk.Hawk;

import org.horaapps.leafpic.data.sort.SortingMode;
import org.horaapps.leafpic.data.sort.SortingOrder;

import java.io.File;
import java.io.FileOutputStream;


/**
 * Created by dnld on 3/25/17.
 */

public class AlbumsHelper {

    public static SortingMode getSortingMode(Context context) {
        return SortingMode.fromValue(Hawk.get("albums_sorting_mode", SortingMode.DATE.getValue()));
    }

    public static SortingOrder getSortingOrder(Context context) {
        return SortingOrder.fromValue(Hawk.get("albums_sorting_order", SortingOrder.DESCENDING.getValue()));
    }

    public static void scanFile(Context context, String[] path) {  MediaScannerConnection.scanFile(context, path, null, null); }

    public static void hideAlbum(String path, Context context) {
        File dirName = new File(path);
        File file = new File(dirName, ".nomedia");
        if (!file.exists()) {
            try {
                FileOutputStream out = new FileOutputStream(file);
                out.flush();
                out.close();
                scanFile(context, new String[]{ file.getAbsolutePath() });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
