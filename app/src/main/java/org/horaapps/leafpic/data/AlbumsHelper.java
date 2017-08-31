package org.horaapps.leafpic.data;

import android.content.Context;

import com.orhanobut.hawk.Hawk;

import org.horaapps.leafpic.data.sort.SortingMode;
import org.horaapps.leafpic.data.sort.SortingOrder;


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

}
