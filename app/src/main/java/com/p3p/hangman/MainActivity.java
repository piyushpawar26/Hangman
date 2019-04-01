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

public class MainActivity extends Activity {

    Button btn_main_exit;
    Button btn_main_theme;
    Button btn_main_play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        btn_main_exit = (Button)findViewById(R.id.btn_main_exit);
        btn_main_theme = (Button)findViewById(R.id.btn_main_theme);
        btn_main_play = (Button)findViewById(R.id.btn_main_play);

    }

    public void me_btn_main_exit(View v){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Exit Application?");
        alertDialogBuilder
                .setMessage("Click yes to exit!")
                .setCancelable(false)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void me_btn_main_theme(View v){
        Intent intent = new Intent(this, ThemeActivity.class);
        startActivity(intent);
    }

    public void me_btn_main_play(View v){
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }

}
