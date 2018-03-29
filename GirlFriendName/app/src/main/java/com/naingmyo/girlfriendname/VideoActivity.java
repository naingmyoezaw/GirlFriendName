package com.naingmyo.girlfriendname;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        VideoView vd=(VideoView)findViewById(R.id.videoView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.vdo;
        vd.setVideoURI(Uri.parse(path));
        MediaController mc = new MediaController(this);
        vd.setMediaController(mc);
        vd.requestFocus();
    }
}

