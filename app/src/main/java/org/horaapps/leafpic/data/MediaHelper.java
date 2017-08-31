//package org.horaapps.leafpic.data;
//
//import android.content.Context;
//import android.media.MediaScannerConnection;
//import android.net.Uri;
//import android.provider.MediaStore;
//
//import org.horaapps.leafpic.util.StringUtils;
//
//import java.io.File;
//
///**
// * Created by dnld on 8/8/17.
// */
//
//public class MediaHelper {
//    private static Uri external = MediaStore.Files.getContentUri("external");
//
//    public static boolean deleteMedia(Context context, Media media) {
//        File file = new File(media.getPath());
//        boolean success = StorageHelper.deleteFile(context, file);
//        if (success)
//            context.getContentResolver().delete(external,
//                    MediaStore.MediaColumns.DATA + "=?", new String[]{file.getPath()});
//        return success;
//    }
//
//    public static boolean moveMedia(Context context, Media media, String targetDir) {
//        boolean success = false;
//        try {
//            File from = new File(media.getPath());
//            File to = new File(targetDir, from.getName());
//            if (success = StorageHelper.moveFile(context, from, to)) {
//
//                context.getContentResolver().delete(external,
//                        MediaStore.MediaColumns.DATA + "=?", new String[]{from.getPath()});
//
//
//                scanFile(context, new String[]{StringUtils.getPhotoPathMoved(media.getPath(), targetDir)});
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return success;
//    }
//
//    public static boolean copyMedia(Context context, Media media, String targetDir) {
//        boolean success = false;
//        try {
//            File from = new File(media.getPath());
//            File to = new File(targetDir);
//            if (success = StorageHelper.copyFile(context, from, to))
//                scanFile(context, new String[]{StringUtils.getPhotoPathMoved(media.getPath(), targetDir)});
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return success;
//    }
//
//    private static void scanFile(Context context, String[] path) {
//        MediaScannerConnection.scanFile(context, path, null, null);
//    }
//}
