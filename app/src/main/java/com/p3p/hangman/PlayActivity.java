package com.p3p.hangman;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PlayActivity extends Activity {

    Button btn_play_ok;
    EditText et_play;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_play);

        Intent intent = getIntent();

        btn_play_ok = (Button)findViewById(R.id.btn_play_ok);
        et_play = (EditText)findViewById(R.id.et_play);

    }

    public void me_btn_play_ok(View view){
        name = et_play.getText().toString();
        if(name.isEmpty()){
            Toast.makeText(this, "Please enter name first", Toast.LENGTH_SHORT).show();
        }else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Proceed?");
            alertDialogBuilder
                    .setMessage("Movie name:" + name)
                    .setCancelable(false)
                    .setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(PlayActivity.this, GuessActivity.class);
                                    intent.putExtra("Movie Name", name);
                                    startActivity(intent);
                                    et_play.setText("");
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
    }


}
