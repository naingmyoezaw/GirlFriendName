package com.naingmyo.girlfriendname;

import android.app.ActionBar;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class TabHostActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host);

        ActionBar actionBar =getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(R.drawable.btn_background));
        actionBar.setIcon(R.drawable.actionbar_icon);

        final TabHost tabHost= getTabHost();

        tabHost.addTab(tabHost.newTabSpec("activity_home")
                .setIndicator("",getResources().getDrawable(R.drawable.home))
                .setContent(new Intent(this,HomeActivity.class)));

        tabHost.addTab(tabHost.newTabSpec("activity_song")
                .setIndicator("",getResources().getDrawable(R.drawable.music))
                .setContent(new Intent(this,SongActivity.class)));

        tabHost.addTab(tabHost.newTabSpec("activity_video")
                .setIndicator("",getResources().getDrawable(R.drawable.video))
                .setContent(new Intent(this,VideoActivity.class)));
    }
}
