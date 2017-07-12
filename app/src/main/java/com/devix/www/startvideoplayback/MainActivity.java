package com.devix.www.startvideoplayback;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.method.MovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private VideoView videoView;
    private FrameLayout frameLayout;
    private FloatingActionButton floatingActionButton;
    private boolean btnVisible = false;

    ///    TODO https://code.tutsplus.com/es/tutorials/streaming-video-in-android-apps--cms-19888
    private String videoAddress = "/storage/sdcard0/dcim/VID_20170426_132838.mp4";
//    private String videoAddress = "/storage/emulated/0/WhatsApp/Media/WhatsApp Video/VID-20170612-WA0019.mp4";

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.fragmentContainer);
        floatingActionButton = findViewById(R.id.fab);

        createVideoViewNew();
        videoView.setVideoPath(videoAddress);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        floatingActionButton.setVisibility(View.GONE);
        videoView.start();

        Snackbar snackbar = Snackbar.make(frameLayout, "Welcome", Snackbar.LENGTH_LONG);
        snackbar.show();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hola Mundo", Toast.LENGTH_SHORT).show();
            }
        });


        videoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (videoView.isPlaying()) {
                    methodVisible();
                } else {
                    Log.i(TAG, "onTouch: NO");
                }
                return false;
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.i(TAG, "onCompletion: ");
                floatingActionButton.setVisibility(View.VISIBLE);
            }
        });
    }

    private void methodVisible() {
        if (floatingActionButton.getVisibility() == View.VISIBLE) {
            btnVisible = true;
        }else{
            btnVisible = false;
        }
    }


    public void createVideoViewNew() {
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) frameLayout.getLayoutParams();
        videoView = new VideoView(this);
        videoView.setId(R.id.videoFile);
        videoView.setLayoutParams(params);
        frameLayout.addView(videoView);

    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        int action = MotionEventCompat.getActionMasked(event);
//
//        switch (action) {
//            case (MotionEvent.ACTION_DOWN):
//                if (videoView.isPlaying()) {
//                    floatingActionButton.setVisibility(View.GONE);
//                } else {
//                    floatingActionButton.setVisibility(View.VISIBLE);
//                }
//                return true;
//            default:
//                return super.onTouchEvent(event);
//        }
//    }

}
