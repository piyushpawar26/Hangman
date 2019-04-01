package com.p3p.hangman;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Process;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class FinalActivity extends Activity {

    Button btn_final_playagain;
    Button btn_final_menu;
    String mname;
    TextView tv_final_mname;
    TextView tv_final_wish;
    Boolean result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_final);

        btn_final_menu = (Button)findViewById(R.id.btn_final_menu);
        btn_final_playagain = (Button)findViewById(R.id.btn_final_playagain);

        Intent intent = getIntent();
        mname = intent.getStringExtra("Movie Name");
        result = intent.getBooleanExtra("wish", true);
        tv_final_wish = (TextView)findViewById(R.id.tv_final_wish);
        tv_final_mname = (TextView)findViewById(R.id.tv_final_mname);
        tv_final_mname.setText(mname);

        if(result == true){
            tv_final_wish.setText("Congrats!" + " You Won!");
        }else{
            tv_final_wish.setText("Awwww!" + " You Lost!");
        }

    }

    public void me_btn_final_menu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void me_btn_final_playagain(View view){
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }

}
