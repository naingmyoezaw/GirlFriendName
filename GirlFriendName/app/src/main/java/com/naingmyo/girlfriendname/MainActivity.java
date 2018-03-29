package com.naingmyo.girlfriendname;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    ImageView iv;
    int[] images= {
            R.drawable.background,
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5
    };

    int current=0;
    Button bt1,bt2,bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar=getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(R.drawable.btn_background));
        actionBar.setIcon(R.drawable.actionbar_icon);
        actionBar.setTitle("💘Girl Friend Name💘");

        iv=(ImageView)findViewById(R.id.iv);
        iv.setImageResource(images[current]);
        bt1=(Button)findViewById(R.id.bt1);
        bt2=(Button)findViewById(R.id.bt2);
        bt3=(Button)findViewById(R.id.bt3);
        bt1.setEnabled(false);
    }

    public void previousClick(View v){
        current--;
        if(current==0){
            bt1.setEnabled(false);
            bt1.setText("Disable");
            bt1.setTextColor(Color.RED);
        }
        if(current==3){
            bt2.setEnabled(true);
            bt2.setText("Next");
            bt2.setTextColor(Color.GREEN);
        }
        iv.setImageResource(images[current]);
    }

    public void nextClick(View v) {
        current++;
        if (current == 4) {
            bt2.setEnabled(false);
            bt2.setText("Disable");
            bt2.setTextColor(Color.RED);
        }
        if (current == 1) {
            bt1.setEnabled(true);
            bt1.setText("Previous");
            bt1.setTextColor(Color.GREEN);
        }
        iv.setImageResource(images[current]);

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TabHostActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id ==R.id.about) {

            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);

            Toast.makeText(getApplicationContext(), "Going To My Profile...", Toast.LENGTH_SHORT).show();


        }


        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        final View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_dialog, null);

        TextView title = (TextView) view.findViewById(R.id.title);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.image);

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade);
        imageButton.startAnimation(animation1);

        title.setText("ထြက္ေတာ႔မွာလား?");

        imageButton.setImageResource(R.drawable.splash_icon);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Bye Bye.. Naing Myo Zaw", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.setView(view);
        builder.show();
    }
}