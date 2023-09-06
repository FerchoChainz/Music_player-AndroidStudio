package com.example.guiapractica4;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class video_view extends AppCompatActivity {

    protected VideoView videoView;
    protected MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);

        videoView = findViewById(R.id.activity_my_video);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        //Reproducir un video especifico
        Uri uri = Uri.parse("android.resource://" + getPackageName() +
                "/" + R.raw.hokage);

        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
        Toast.makeText(this, "Comienza Video", Toast.LENGTH_SHORT).show();
        videoView.setMediaController(mediaController);
    }
}