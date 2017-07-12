package com.devix.www.startvideoplayback;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.MovementMethod;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

import life.knowledge4.videotrimmer.K4LVideoTrimmer;
import life.knowledge4.videotrimmer.interfaces.OnTrimVideoListener;

public class MainActivity extends AppCompatActivity implements OnTrimVideoListener {

    private static final String TAG = MainActivity.class.getSimpleName();
//    private VideoView videoViews;
    private FrameLayout frameLayout;
    private FloatingActionButton floatingActionButton;
    private K4LVideoTrimmer mVideoTrimmer;

    //TODO https://code.tutsplus.com/es/tutorials/streaming-video-in-android-apps--cms-19888

    private String videoLenovo = "/storage/sdcard0/dcim/VID_20170712_093839.mp4";
    private String videoSamsung = "/storage/emulated/0/WhatsApp/Media/WhatsApp Video/VID-20170612-WA0019.mp4";
    MediaController mediaController;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.fragmentContainer);
        floatingActionButton = findViewById(R.id.fab);
//        videoViews = findViewById(R.id.videoNew);
//        createVideoViewNew();

        mVideoTrimmer = ((K4LVideoTrimmer) findViewById(R.id.timeLine));
        if (mVideoTrimmer != null) {
            mVideoTrimmer.setMaxDuration(10);
            mVideoTrimmer.setOnTrimVideoListener(this);
//            mVideoTrimmer.setOnK4LVideoListener(this);
            //mVideoTrimmer.setDestinationPath("/storage/emulated/0/DCIM/CameraCustom/");
            mVideoTrimmer.setVideoURI(Uri.parse(videoLenovo));
//            mVideoTrimmer.setVideoInformationVisibility(true);
        }

//        videoViews.setVideoPath(videoLenovo);
//        mediaController = new MediaController(new ContextThemeWrapper(this, R.style.Theme_Design_Light));
//        mediaController.setAlwaysDrawnWithCacheEnabled(true);
//        mediaController.requestFocus();
//        floatingActionButton.setVisibility(View.INVISIBLE);
//        videoViews.start();


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hola Mundo", Toast.LENGTH_SHORT).show();
            }
        });

//        videoViews.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mediaPlayer) {
//                floatingActionButton.setVisibility(View.VISIBLE);
//            }
//        });
//
//        videoViews.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
//                    @Override
//                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
//                        videoViews.setMediaController(mediaController);
//                        mediaController.setAnchorView(videoViews);
//                    }
//                });
//            }
//        });
//
//
//        videoViews.setOnErrorListener(new MediaPlayer.OnErrorListener() {
//            @Override
//            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
//                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
//                alertDialogBuilder.setTitle("ERROR");
//                alertDialogBuilder.setMessage("Ocurrió un error en la reproducción del video");
//                alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface qbitsChat, int which) {
//                        qbitsChat.dismiss();
//                    }
//                });
//                alertDialogBuilder.show();
//                return true;
//            }
//        });
//
//        videoViews.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                //Visualiza si los botones estan activos
////                boolean isShowing = mediaController[0].isShowing();
//
//                if (videoViews.isPlaying()) {
//                    methodVisible();
//                } else {
//                    methodVisible();
//                }
//
//                return false;
//            }
//        });


    }

    private void methodVisible() {

        if (floatingActionButton.getVisibility() == View.VISIBLE) {
            floatingActionButton.setVisibility(View.INVISIBLE);
        } else {
            floatingActionButton.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void getResult(Uri uri) {

    }

    @Override
    public void cancelAction() {

    }


//    public void createVideoViewNew() {
//        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) frameLayout.getLayoutParams();
//        videoViews = new VideoView(this);
//        videoViews.setId(R.id.videoFile);
//        videoView.setLayoutParams(params);
//        frameLayout.addView(videoViews);
//
//
//        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) frameLayout.getLayoutParams();
//
//    }


}
