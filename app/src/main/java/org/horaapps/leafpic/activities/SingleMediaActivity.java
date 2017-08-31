/*
package org.horaapps.leafpic.activities;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.orhanobut.hawk.Hawk;
import com.yalantis.ucrop.UCrop;

import org.horaapps.leafpic.R;
import org.horaapps.leafpic.activities.base.SharedMediaActivity;
import org.horaapps.leafpic.data.Album;
import org.horaapps.leafpic.data.AlbumSettings;
import org.horaapps.leafpic.data.Media;
import org.horaapps.leafpic.data.StorageHelper;
import org.horaapps.leafpic.fragments.ImageFragment;
import org.horaapps.leafpic.util.Measure;
import org.horaapps.leafpic.views.HackyViewPager;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import horaapps.org.liz.ColorPalette;

*/
/**
 * Created by dnld on 18/02/16.
 *//*

@SuppressWarnings("ResourceAsColor")
public class SingleMediaActivity extends SharedMediaActivity {

    private static final String TAG = SingleMediaActivity.class.getSimpleName();

    private static final int SLIDE_SHOW_INTERVAL = 5000;
    private static final String ISLOCKED_ARG = "isLocked";
    public static final String ACTION_OPEN_ALBUM = "org.horaapps.leafpic.intent.VIEW_ALBUM";
    private static final String ACTION_REVIEW = "com.android.camera.action.REVIEW";


    @BindView(R.id.photos_pager)
    HackyViewPager mViewPager;

    @BindView(R.id.PhotoPager_Layout)
    RelativeLayout activityBackground;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private boolean fullScreenMode, customUri = false;
    int position;

    private Album album;
    private ArrayList<Media> media;
    private boolean isSlideShowOn = false;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_media);

        ButterKnife.bind(this);

        String action = getIntent().getAction();

        if (action != null && action.equals(ACTION_OPEN_ALBUM)) {
            album = getIntent().getParcelableExtra("album");
            position = getIntent().getIntExtra("position", 0);
            media = getIntent().getParcelableArrayListExtra("media");
        } else if (getIntent().getData() != null) {
            loadUri(getIntent().getData());
        }

        if (savedInstanceState != null) {
            mViewPager.setLocked(savedInstanceState.getBoolean(ISLOCKED_ARG, false));
        }

        initUi();
    }

    private void loadUri(Uri uri) {
        album = new Album(uri.toString(), uri.getPath());
        album.settings = AlbumSettings.getDefaults();

        */
/*
        String path = StorageHelper.getMediaPath(getApplicationContext(), getIntent().getData());
                Album album = null;

                if (path != null) {
                    album = ContentProviderHelper.getAlbumFromMedia(getApplicationContext(), path);
                    if (album != null) {
                        //album.updatePhotos(getApplicationContext());
                        album.setCurrentMedia(path);
                    }
                }
        *//*


        try {
            InputStream inputStream = getContentResolver().openInputStream(uri);
            if (inputStream != null) inputStream.close();
        } catch (Exception ex) {
            //TODO: EMOJI EASTER EGG - THERE'S NOTHING TO SHOW
            ((TextView) findViewById(R.id.nothing_to_show_text_emoji_easter_egg)).setText(R.string.error_occured_open_media);
            findViewById(R.id.nothing_to_show_placeholder).setVisibility(Hawk.get("emoji_easter_egg", 0) == 0 ? View.VISIBLE : View.GONE);
            findViewById(R.id.ll_emoji_easter_egg).setVisibility(Hawk.get("emoji_easter_egg", 0) == 1 ? View.VISIBLE : View.GONE);
        }

        media = new ArrayList<>(Collections.singletonList(new Media(getApplicationContext(), uri)));
        position = 0;
        customUri = true;
    }


    private void initUi() {

        setSupportActionBar(toolbar);
        toolbar.bringToFront();
        toolbar.setNavigationIcon(getToolbarIcon(GoogleMaterial.Icon.gmd_arrow_back));
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        setupSystemUI();

        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener
                (visibility -> {
                    if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) showSystemUI();
                    else hideSystemUI();
                });


        mViewPager.setCurrentItem(position);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                SingleMediaActivity.this.position = position;

                supportInvalidateOptionsMenu();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        if (((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay().getRotation() == Surface.ROTATION_90) {
            Configuration configuration = new Configuration();
            configuration.orientation = Configuration.ORIENTATION_LANDSCAPE;
            onConfigurationChanged(configuration);
        }
    }

    Handler handler = new Handler();
    Runnable slideShowRunnable = new Runnable() {
        @Override
        public void run() {
            try{
                mViewPager.setCurrentItem((mViewPager.getCurrentItem() + 1) % album.getCount());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally{
                handler.postDelayed(this, SLIDE_SHOW_INTERVAL);
            }
        }
    };

    @CallSuper
    public void updateUiElements() {
        super.updateUiElements();
        */
/**** Theme ****//*

        toolbar.setBackgroundColor(
                themeOnSingleImgAct()
                        ? ColorPalette.getTransparentColor(getPrimaryColor(), getTransparency())
                        : ColorPalette.getTransparentColor(getDefaultThemeToolbarColor3th(), 175));

        toolbar.setPopupTheme(getPopupToolbarStyle());


        activityBackground.setBackgroundColor(getBackgroundColor());

        setStatusBarColor();
        setNavBarColor();
        setRecentApp(getString(R.string.app_name));

        //TODO: EMOJI EASTER EGG - THERE'S NOTHING TO SHOW
        ((TextView) findViewById(R.id.emoji_easter_egg)).setTextColor(getSubTextColor());
        ((TextView) findViewById(R.id.nothing_to_show_text_emoji_easter_egg)).setTextColor(getSubTextColor());


        */
/**** SETTINGS ****//*


        if (Hawk.get("set_max_luminosity", false))
            updateBrightness(1.0F);
        else try {
            // TODO: 12/4/16 redo
            float brightness = android.provider.Settings.System.getInt(
                    getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS);
            brightness = brightness == 1.0F ? 255.0F : brightness;
            updateBrightness(brightness);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }

        if (Hawk.get("set_picture_orientation", false))
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        else setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Glide.get(getApplicationContext()).clearMemory();
        Glide.get(getApplicationContext()).trimMemory(TRIM_MEMORY_COMPLETE);
        System.gc();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (isSlideShowOn) {
            getMenuInflater().inflate(R.menu.menu_view_page_slide_on, menu);
        } else {
            getMenuInflater().inflate(R.menu.menu_view_pager, menu);

            menu.findItem(R.id.action_delete).setIcon(getToolbarIcon(CommunityMaterial.Icon.cmd_delete));
            menu.findItem(R.id.action_share).setIcon(getToolbarIcon(GoogleMaterial.Icon.gmd_share));
            menu.findItem(R.id.action_rotate).setIcon(getToolbarIcon(CommunityMaterial.Icon.cmd_rotate_right));
            menu.findItem(R.id.rotate_right_90).setIcon(getToolbarIcon(CommunityMaterial.Icon.cmd_rotate_right).color(getIconColor()));
            menu.findItem(R.id.rotate_left_90).setIcon(getToolbarIcon(CommunityMaterial.Icon.cmd_rotate_left).color(getIconColor()));
            menu.findItem(R.id.rotate_180).setIcon(getToolbarIcon(CommunityMaterial.Icon.cmd_replay).color(getIconColor()));
        }
        return true;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            params.setMargins(0, 0, Measure.getNavigationBarSize(SingleMediaActivity.this).x, 0);
        else
            params.setMargins(0, 0, 0, 0);

        toolbar.setLayoutParams(params);
    }

    @Override
    public boolean onPrepareOptionsMenu(final Menu menu) {
        if (!isSlideShowOn) {
            menu.setGroupVisible(R.id.only_photos_options, !getCurrentMedia().isVideo());

            if (customUri) {
                menu.setGroupVisible(R.id.on_internal_storage, false);
                menu.setGroupVisible(R.id.only_photos_options, false);
                menu.findItem(R.id.sort_action).setVisible(false);
            }
        }
        return super.onPrepareOptionsMenu(menu);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null && resultCode == RESULT_OK) {
            switch (requestCode) {
                case UCrop.REQUEST_CROP:
                    final Uri imageUri = UCrop.getOutput(data);
                    if (imageUri != null && imageUri.getScheme().equals("file")) {
                        try {
                            //copyFileToDownloads(imageUri);
                            // TODO: 21/08/16 handle this better
                            if (StorageHelper.copyFile(getApplicationContext(), new File(imageUri.getPath()), new File(this.album.getPath()))) {
                                //((ImageFragment) adapter.getRegisteredFragment(this.album.getCurrentMediaIndex())).displayMedia(true);
                                Toast.makeText(this, R.string.new_file_created, Toast.LENGTH_SHORT).show();
                            }
                            //adapter.notifyDataSetChanged();
                        } catch (Exception e) {
                            Log.e("ERROS - uCrop", imageUri.toString(), e);
                        }
                    }
                    break;
                default:
                    super.onActivityResult(requestCode, resultCode, data);
                    break;
            }
        }
    }

    public Media getCurrentMedia() {
        return media.get(position);
    }


    private void updateBrightness(float level) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.screenBrightness = level;
        getWindow().setAttributes(lp);
    }

    @SuppressWarnings("ResourceAsColor")
    private UCrop.Options getUcropOptions() {

        UCrop.Options options = new UCrop.Options();
        options.setCompressionFormat(Bitmap.CompressFormat.PNG);
        options.setCompressionQuality(90);
        options.setActiveWidgetColor(getAccentColor());
        options.setToolbarColor(getPrimaryColor());
        options.setStatusBarColor(isTranslucentStatusBar() ? ColorPalette.getObscuredColor(getPrimaryColor()) : getPrimaryColor());
        options.setCropFrameColor(getAccentColor());
        options.setFreeStyleCropEnabled(true);

        return options;
    }

    @Override
    public void setNavBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (themeOnSingleImgAct())
                if (isNavigationBarColored())
                    getWindow().setNavigationBarColor(ColorPalette.getTransparentColor(getPrimaryColor(), getTransparency()));
                else
                    getWindow().setNavigationBarColor(ColorPalette.getTransparentColor(ContextCompat.getColor(getApplicationContext(), R.color.md_black_1000), getTransparency()));
            else
                getWindow().setNavigationBarColor(ColorPalette.getTransparentColor(ContextCompat.getColor(getApplicationContext(), R.color.md_black_1000), 175));
        }
    }

    @Override
    protected void setStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (themeOnSingleImgAct())
                if (isTranslucentStatusBar() && isTransparencyZero())
                    getWindow().setStatusBarColor(ColorPalette.getObscuredColor(getPrimaryColor()));
                else
                    getWindow().setStatusBarColor(ColorPalette.getTransparentColor(getPrimaryColor(), getTransparency()));
            else
                getWindow().setStatusBarColor(ColorPalette.getTransparentColor(
                        ContextCompat.getColor(getApplicationContext(), R.color.md_black_1000), 175));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        if (mViewPager != null) {
            outState.putBoolean(ISLOCKED_ARG, mViewPager.isLocked());
        }
        super.onSaveInstanceState(outState);
    }

    public void toggleSystemUI() {
        if (fullScreenMode)
            showSystemUI();
        else hideSystemUI();
    }

    private void hideSystemUI() {
        runOnUiThread(new Runnable() {
            public void run() {
                toolbar.animate().translationY(-toolbar.getHeight()).setInterpolator(new AccelerateInterpolator())
                        .setDuration(200).start();
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                    @Override
                    public void onSystemUiVisibilityChange(int visibility) {
                        Log.wtf(TAG, "ui changed: " + visibility);
                    }
                });
                getWindow().getDecorView().setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                                | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                                | View.SYSTEM_UI_FLAG_IMMERSIVE);

                fullScreenMode = true;
                changeBackGroundColor();
            }
        });
    }

    private void setupSystemUI() {
        toolbar.animate().translationY(Measure.getStatusBarHeight(getResources())).setInterpolator(new DecelerateInterpolator())
                .setDuration(0).start();
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    private void showSystemUI() {
        runOnUiThread(new Runnable() {
            public void run() {
                toolbar.animate().translationY(Measure.getStatusBarHeight(getResources())).setInterpolator(new DecelerateInterpolator())
                        .setDuration(240).start();
                getWindow().getDecorView().setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                fullScreenMode = false;
                changeBackGroundColor();
            }
        });
    }

    private void changeBackGroundColor() {
        int colorTo;
        int colorFrom;
        if (fullScreenMode) {
            colorFrom = getBackgroundColor();
            colorTo = (ContextCompat.getColor(SingleMediaActivity.this, R.color.md_black_1000));
        } else {
            colorFrom = (ContextCompat.getColor(SingleMediaActivity.this, R.color.md_black_1000));
            colorTo = getBackgroundColor();
        }
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(240);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                activityBackground.setBackgroundColor((Integer) animator.getAnimatedValue());
            }
        });
        colorAnimation.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(slideShowRunnable);
        handler = null;
    }
}

*/
