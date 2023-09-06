package com.example.guiapractica4;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class media_player extends AppCompatActivity {

    Button play, stop;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        play = findViewById(R.id.btnReproducir);
        stop = findViewById(R.id.btnDetener);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                Uri uri = Uri.parse("android.resource://" + getPackageName()
                + "/" + R.raw.elhokage); //

                try {
                    mediaPlayer.setDataSource(media_player.this,uri);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    Toast.makeText(media_player.this, "Comienza la reproduccion", Toast.LENGTH_SHORT).show();
                }catch (IOException e){
                    Toast.makeText(media_player.this, "Error al reproducir", Toast.LENGTH_SHORT).show();

                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer != null && mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    mediaPlayer = null;
                    Toast.makeText(media_player.this, "Se detiene reproduccion", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}