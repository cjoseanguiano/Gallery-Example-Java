package org.horaapps.leafpic.util;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.Spanned;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import horaapps.org.liz.ColorPalette;

/**
 * Created by dnld on 1/3/16.
 */
public class StringUtils {

    public static String getMimeType(String path) {
        int index;
        if (path == null || (index = path.lastIndexOf('.')) == -1)
            return "unknown";

        String mime = MimeTypeMap.getSingleton().getMimeTypeFromExtension(path.substring(index + 1).toLowerCase());
        return  mime != null ? mime : "unknown";
    }

    public static String[] asArray(String ... a) {
        return a;
    }

    @SuppressWarnings("deprecation")
    public static Spanned html(String s) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            return Html.fromHtml(s, Html.FROM_HTML_MODE_LEGACY);
        else return Html.fromHtml(s);
    }

    public static String getName(String path) {
        String b[] = path.split("/");
        return b[b.length - 1];
    }

    public static String incrementFileNameSuffix(String name) {
        StringBuilder builder = new StringBuilder();

        int dot = name.lastIndexOf('.');
        String baseName = dot != -1 ? name.subSequence(0, dot).toString() : name;
        String nameWoSuffix = baseName;
        Matcher matcher = Pattern.compile("_\\d").matcher(baseName);
        if(matcher.find()) {
            int i = baseName.lastIndexOf("_");
            if (i != -1) nameWoSuffix = baseName.subSequence(0, i).toString();
        }
        builder.append(nameWoSuffix).append("_").append(new Date().getTime());
        builder.append(name.substring(dot));
        return builder.toString();
    }

    public static String getBucketPathByImagePath(String path) {
        String b[] = path.split("/");
        String c = "";
        for (int x = 0; x < b.length - 1; x++) c += b[x] + "/";
        c = c.substring(0, c.length() - 1);
        return c;
    }

    public static String b(String content) {
        return String.format(Locale.ENGLISH, "<b>%s</b>", content);
    }

    public static String i(String content) {
        return String.format(Locale.ENGLISH, "<i>%s</i>", content);
    }

    public static Spanned htmlFormat(String content, int color, boolean bold, boolean italic) {
        String res = content;
        if (color != -1) res = color(color, res);
        if (bold) res = b(res);
        if (italic) res = i(res);
        return html(res);
    }

    public static String color(int color, String content) {
        return String.format(Locale.ENGLISH,
                "<font color='%s'>%s</font>",
                ColorPalette.getHexColor(color), content);
    }

    public static String color(String color, String content) {
        return String.format(Locale.ENGLISH,
                "<font color='%s'>%s</font>",
                color, content);
    }

}
