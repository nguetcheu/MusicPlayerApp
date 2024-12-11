package com.example.musicplayerapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class MyCustomService extends Service {

    MediaPlayer player;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        // The will play the audio of default ringtone in the device
        player = MediaPlayer.create(getApplicationContext(), Settings.System.DEFAULT_RINGTONE_URI);

        // Play the ringtone audio on loop (continuously)
        player.setLooping(true);

        player.start();

        // START_STICKY le service doit etre relancer automatiquement par le systéme et START_NOT_STICKY l'inverse
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        player.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
