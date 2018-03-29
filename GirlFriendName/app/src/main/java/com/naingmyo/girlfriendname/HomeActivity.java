package com.naingmyo.girlfriendname;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class HomeActivity extends Activity {

    String test="💘ခ်စ္ဆံုး💘 \n\n"+
            "အခ်စ္စစ္မွာ မတရားတာမရွိဘူးတဲ႔\n"+
            "နာက်င္ေနတဲ႔ႏွလံုးသားေလး \n"+
            "တစ္စံုကလြဲလို႔ေပါ႔ 💔\n\n"+

            "ခ်စ္ခဲ႔တာမုန္းဖို႔မဟုတ္ဘူးတဲ႔ \n"+
            "နာက်ည္းမူေတြကို မ်က္ကြယ္ျပဳႏိုင္ရင္ေပါ႔😪 \n\n"+

            "ခ်စ္ျခင္းအစမုန္းျခင္းကတဲ႔ \n"+
            "အမုန္းစာ အခ်စ္ရဲ့ မူလဇာစ္ျမစ္ျဖစ္ႏိုင္ေပမဲ႔ \n"+
            "အဆံုးသတ္ေတာ႔မဟုတ္ပါဘူး 😍😘\n\n"+

            "အခ်စ္ၾကီးရင္အမ်က္ၾကီးတယ္တဲ႔ \n"+
            "နားလည္ေပးႏိုင္မူနဲ႔ \n"+
            "ယံုၾကည္ကိုးစားမူေတြ ကြယ္ေပ်ာက္သြားရင္ေပါ့😊\n\n"+

            "အခ်စ္စစ္မွာ မ်က္စိမရွိဘူးတဲ႔\n"+
            "မဟုတ္ပါဘူး \n"+
            " ခ်စ္တက္လြန္းတဲ႔ႏွလံုးသားေလးက \n"+
            "အခ်စ္မ်က္စိျဖစ္ေနတာပါ 😚😍\n\n"+

            "ဟုတ္ကဲ႔ ကြ်န္ေတာ္႔အတြက္ေတာ႔  \n"+
            "အခ်စ္ဆိုတာ ႏွလံုးသားကာရန္တစ္ခုျဖစ္ေနခဲ႔တာပါ\n"+
            "😍😘😍😘\n\n";

    int charlength=0;
    TextView textV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textV = (TextView)findViewById(R.id.Text);
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

        },100);

    }
}

