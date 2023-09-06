package com.example.guiapractica4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        Intent intent = null;
        if(view.getId() == R.id.btnMusic){
            intent = new Intent(this, Music_player.class);
        } else if (view.getId() == R.id.btnMedia) {
            intent = new Intent(this, media_player.class);
        } else if (view.getId() == R.id.btnVideo) {
            intent = new Intent(this, video_view.class);
        }
        startActivity(intent);
    }
}

