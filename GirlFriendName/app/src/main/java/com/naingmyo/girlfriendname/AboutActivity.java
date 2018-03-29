package com.naingmyo.girlfriendname;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class AboutActivity extends Activity {

    String test="😍အေၾကာင္းအရာ😘\n\n"+
            "ၾကိဳက္ရဲ့လားဗ် ဒီ Software ေလးကို\n"+
            "အေကာင္းဆံုးျဖစ္ေအာင္ေတာ႔ \n"+
            "ေရးထားေပးတယ္ေနာ္ \n"+
            "အားလံုးကိုသိပ္ခ်စ္တယ္\n\n"+
            "❤💞 Naing Myo Zaw 💞\n\n";

    int charlength=0;
    TextView textV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ActionBar actionBar=getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(R.drawable.btn_background));
        actionBar.setIcon(R.drawable.actionbar_icon);

        textV = (TextView)findViewById(R.id.tv2);
        textV.setTextSize(18);
        AnimateText(test);
    }

    private void AnimateText(final CharSequence text)
    {
        if(charlength<text.length()){
            charlength+=1;
            CharSequence mtext=text.subSequence(0, charlength);
            textV.setText(mtext);
        }
        new Handler().postDelayed(new Runnable(){

            @Override
            public void run()
            {
                AnimateText(text);
            }

        },150);

    }
}

