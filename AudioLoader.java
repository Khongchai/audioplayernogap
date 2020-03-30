package com.example.loopnogaptest;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioLoader
{
    private MediaPlayer curPlayer;
    private MediaPlayer nextPlayer;

    Context context = null;
    int ResID = 0;

    AudioLoader(Context context, int ID)
    {
        this.context = context;
        ResID = ID;
        curPlayer = MediaPlayer.create(this.context, ResID);
    }

    public void PlayAudio()
    {
        curPlayer.start();
        nextPlayer = MediaPlayer.create(context, ResID);
        curPlayer.setNextMediaPlayer(nextPlayer);
        curPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            @Override
            public void onCompletion(MediaPlayer mp)
            {
                curPlayer.release();
                curPlayer = nextPlayer;

                PlayAudio();
            }
        });
    }

    public void StopSound()
    {
        //if cur is playing, next is also playing
        if (curPlayer.isPlaying())
        {
            curPlayer.stop();
            curPlayer.release();
            curPlayer = null;

            nextPlayer.stop();
            nextPlayer.release();
            nextPlayer = null;
        }

    }
}
