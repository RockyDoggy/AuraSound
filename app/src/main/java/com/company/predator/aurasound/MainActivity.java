package com.company.predator.aurasound;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer currentSound;
    int[] sounds = new int[] {R.raw.rain, R.raw.sea, R.raw.birds};;
    int[] soundsNames = new int[] {R.string.soundNameRain,
                                   R.string.soundNameSea,
                                   R.string.soundNameBirds};
    int currentIndex = 0;
    int currentNameIndex = 0;
    private static String TAG = "LOGGIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentSound = MediaPlayer.create(this, sounds[currentIndex]);

        Button nextButton = (Button) findViewById(R.id.nextButton);
        Button prevButton = (Button) findViewById(R.id.prevButton);
        final Button playButton = (Button) findViewById(R.id.playStopButton);
        final TextView playNow = (TextView) findViewById(R.id.playingNow);

        final View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.nextButton:
                        if (currentNameIndex<soundsNames.length - 1){currentNameIndex++;}
                        else currentNameIndex = 0;

                        playNow.setText(soundsNames[currentNameIndex]);

                        if (currentIndex<sounds.length-1){currentIndex++;}
                        else currentIndex = 0;
                        currentSound.reset();

                        if (currentSound.isPlaying()) {
                            currentSound.stop();
                            currentSound.release();
                            currentSound = null;
                            playButton.setText(R.string.playStopButton);
                        }
                        currentSound = MediaPlayer.create(MainActivity.this, sounds[currentIndex]);
                        currentSound.start();
                        playButton.setText(R.string.playStop);
                        break;

                    case R.id.prevButton:
                        if (currentNameIndex>0){currentNameIndex--;}
                        else currentNameIndex = soundsNames.length - 1;
                        playNow.setText(soundsNames[currentNameIndex]);

                        if (currentIndex>0){currentIndex--;}
                        else currentIndex = sounds.length-1;
                        currentSound.reset();

                        if (currentSound.isPlaying()) {
                            currentSound.stop();
                            currentSound.release();
                            currentSound = null;
                            playButton.setText(R.string.playStopButton);
                        }
                        currentSound = MediaPlayer.create(MainActivity.this, sounds[currentIndex]);
                        currentSound.start();
                        playButton.setText(R.string.playStop);
                        break;

                    case R.id.playStopButton:
                        if(currentSound.isPlaying()){
                            currentSound.pause();
                            playButton.setText(R.string.playStopButton);
                        }
                        else{
                            currentSound.start();
                            currentSound.setLooping(true);
                            playButton.setText(R.string.playStop);
                        }
                        break;
                }
            }

        };

    playNow.setText(soundsNames[currentNameIndex]);
    Log.i(TAG, "App ready");
    nextButton.setOnClickListener(listener);
    prevButton.setOnClickListener(listener);
    playButton.setOnClickListener(listener);
    }

    protected void onPause(){
        //currentSound.start();
        super.onPause();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.list_sounds:
                Log.i(TAG, "Sounds list launch");
                startActivity(new Intent(MainActivity.this, ListActivity.class));
                return true;
            case R.id.settings:
                Toast toast = Toast.makeText(getApplicationContext(), "Settings will be avalible soon", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case R.id.about:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
