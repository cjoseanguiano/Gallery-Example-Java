package org.horaapps.leafpic.data.sort;

import org.horaapps.leafpic.data.Media;
import org.horaapps.leafpic.util.NumericComparator;

import java.util.Comparator;

/**
 * Created by dnld on 26/04/16.
 */

public class MediaComparators {

    public static Comparator<Media> getComparator(SortingMode sortingMode, SortingOrder sortingOrder) {
        return  sortingOrder == SortingOrder.ASCENDING
                ? getComparator(sortingMode) : reverse(getComparator(sortingMode));
    }

    public static Comparator<Media> getComparator(SortingMode sortingMode) {
        switch (sortingMode) {
            case DATE: default: return getDateComparator();
            case TYPE: return getTypeComparator();
        }
    }

    private static Comparator<Media> reverse(Comparator<Media> comparator) {
        return (o1, o2) -> comparator.compare(o2, o1);
    }

    private static Comparator<Media> getDateComparator(){
        return (f1, f2) -> f1.getDateModified().compareTo(f2.getDateModified());
    }
    private static Comparator<Media> getTypeComparator() {
        return (f1, f2) -> f1.getMimeType().compareTo(f2.getMimeType());
    }

}
