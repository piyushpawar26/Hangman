package com.p3p.hangman;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

public class ThemeActivity extends Activity {

    Button btn_theme_light;
    Button btn_theme_none;
    Button btn_theme_default;
    RelativeLayout rl_final;
    RelativeLayout rl_play;
    RelativeLayout rl_guess;
    LinearLayout ll_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_theme);

        btn_theme_light = (Button) findViewById(R.id.btn_theme_light);
        btn_theme_none = (Button) findViewById(R.id.btn_theme_none);
        btn_theme_default = (Button) findViewById(R.id.btn_theme_dark);

        rl_final = (RelativeLayout) findViewById(R.id.rl_final);
        rl_play = (RelativeLayout) findViewById(R.id.rl_play);
        rl_guess = (RelativeLayout) findViewById(R.id.rl_guess);
        ll_main = (LinearLayout) findViewById(R.id.ll_main);

    }


}
