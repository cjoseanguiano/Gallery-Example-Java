package org.horaapps.leafpic.data.sort;

import org.horaapps.leafpic.data.Album;

import java.util.Comparator;

/**
 * Created by dnld on 26/04/16.
 */
public class AlbumsComparators {


    private static Comparator<Album> getComparator(SortingMode sortingMode, Comparator<Album> base) {
        switch (sortingMode) {
           case DATE: default:
                return getDateComparator(base);
        }
    }

    public static Comparator<Album> getComparator(SortingMode sortingMode, SortingOrder sortingOrder) {

        Comparator<Album> comparator = getComparator(sortingMode, getBaseComparator(sortingOrder));

        return sortingOrder == SortingOrder.ASCENDING
                ? comparator : reverse(comparator);
    }

    private static Comparator<Album> reverse(Comparator<Album> comparator) {
        return (o1, o2) -> comparator.compare(o2, o1);
    }

    private static Comparator<Album> getBaseComparator(SortingOrder sortingOrder) {
        return sortingOrder == SortingOrder.ASCENDING
                ? getPinned() : getReversedPinned();
    }

    private static Comparator<Album> getPinned() {
        return (o1, o2) -> {
            if (o1.isPinned() == o2.isPinned()) return 0;
            return o1.isPinned() ? -1 : 1;
        };
    }

    private static Comparator<Album> getReversedPinned() {
        return (o1, o2) -> getPinned().compare(o2, o1);
    }

    private static Comparator<Album> getDateComparator(Comparator<Album> base){
        return (a1, a2) -> {
            int res = base.compare(a1, a2);
            if (res == 0)
                return a1.getDateModified().compareTo(a2.getDateModified());
            return res;
        };
    }

}
