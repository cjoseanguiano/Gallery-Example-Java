package org.horaapps.leafpic.data;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.widget.Toast;

import com.orhanobut.hawk.Hawk;

import org.horaapps.leafpic.R;
import org.horaapps.leafpic.activities.SplashScreen;
import org.horaapps.leafpic.data.sort.SortingMode;
import org.horaapps.leafpic.data.sort.SortingOrder;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import static org.horaapps.leafpic.util.BitmapUtils.addWhiteBorder;
import static org.horaapps.leafpic.util.BitmapUtils.getCroppedBitmap;

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
