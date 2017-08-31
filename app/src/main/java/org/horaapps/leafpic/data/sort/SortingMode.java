package org.horaapps.leafpic.data.sort;

import android.provider.MediaStore;

/**
 * Created by dnld on 18/08/16.
 */

public enum SortingMode {
  DATE (1, MediaStore.MediaColumns.DATE_MODIFIED, "max(" + MediaStore.Images.Media.DATE_MODIFIED + ")"),
  TYPE(3, MediaStore.MediaColumns.MIME_TYPE);

  int value;
  String mediaColumn;
  String albumsColumn;

  SortingMode(int value, String mediaColumn) {
    this.value = value;
    this.mediaColumn = mediaColumn;
    this.albumsColumn = mediaColumn;
  }

  SortingMode(int value, String mediaColumn, String albumsColumn) {
    this.value = value;
    this.mediaColumn = mediaColumn;
    this.albumsColumn = albumsColumn;
  }

  public String getMediaColumn() {
    return mediaColumn;
  }

  public String getAlbumsColumn() {
    return albumsColumn;
  }

  public int getValue() {
    return value;
  }

  public static SortingMode fromValue(int value) {
    switch (value) {
      case 1: default: return DATE;
      case 3: return TYPE;
    }
  }
}
