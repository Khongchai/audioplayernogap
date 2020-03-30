package com.example.loopnogaptest;

import android.media.MediaPlayer;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button playAudio;
    int check = 0;
    AudioLoader audioUnit;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        playAudio = findViewById(R.id.mainButton);

        playAudio.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if (check == 0)
                {
                    audioUnit = new AudioLoader(getApplicationContext(), R.raw.mercury);
                    playAudio.setText(R.string.Play);
                    check++;
                }

                else if (check == 1)
                {
                    playAudio.setText(R.string.Stop);
                    audioUnit.PlayAudio();
                    check++;
                }

                else
                {
                    playAudio.setText(R.string.Load);
                    audioUnit.StopSound();
                    check = 0;
                }

            }
        });


    }



}

