package com.naingmyo.girlfriendname;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class SongActivity extends Activity {

    private ListView mainList;
    private MediaPlayer mp;
    Button btn;
    private final String[] listContent = { "ၾကင္နာခြင့္မရွိတဲ႔ခ်စ္သူ", "လြမ္းေနရင္ဖုန္းဆက္ပါ", "ထားခဲ႔ျပီလား","တစ္ေယာက္ထဲသတ္ခ်င္တယ္","တံခါးဖြင့္ထားပါတယ္","အသဲကြဲအရပ္သမား","နင္ထက္"};

    private final int[] resID = { R.raw.mc1, R.raw.mc2, R.raw.mc3,R.raw.mc4,R.raw.mc1,R.raw.mc2,R.raw.mc3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        btn=(Button)findViewById(R.id.pause);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
            }
        });

        mp = new MediaPlayer();
        mainList = (ListView) findViewById(R.id.lv);

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade);
        mainList.startAnimation(animation1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, listContent);
        mainList.setAdapter(adapter);

        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                playSong(position);

            }
        });

    }

    public void playSong(int songIndex) {
// Play song
        mp.reset();// stops any current playing song
        mp = MediaPlayer.create(getApplicationContext(), resID[songIndex]);// create's
// new
// mediaplayer
// with
// song.

        mp.start();


// starting mediaplayer

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.release();



    }
}
