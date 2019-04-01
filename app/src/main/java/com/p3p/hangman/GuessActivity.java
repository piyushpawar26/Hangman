package com.p3p.hangman;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GuessActivity extends Activity {

    TextView tv_guess_movie;
    TextView tv_guess_guessed;
    TextView tv_guess_chancesnum;
    TextView mTextField;
    String mname;
    int length_movie;
    Button btn_guess_go = null;
    EditText et_guess;
    String getletter;
    char[] mnameArray;
    char[] chargetletter;
    StringBuilder sb;
    StringBuilder sb1;
    char[] usedletter;
    int z = 0;
    int chancesleft = 7;
    Intent intent1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guess);

        Intent intent = getIntent();
        mname = intent.getStringExtra("Movie Name").toLowerCase();
        mnameArray = mname.toCharArray();
        length_movie = mname.length();
        usedletter = new char[100];

        sb = new StringBuilder();
        sb1 = new StringBuilder();

        for(int i=0; i<length_movie; i++){
            if(mname.charAt(i) == ' '){
                sb.append(" ");
            }else{
                sb.append('*');
            }
        }

        tv_guess_movie = (TextView)findViewById(R.id.tv_guess_movie);
        tv_guess_movie.setText(sb.toString());

        tv_guess_guessed = (TextView)findViewById(R.id.tv_guess_guessed);
        mTextField = (TextView)findViewById(R.id.mTextField);
        tv_guess_chancesnum = (TextView) findViewById(R.id.tv_guess_chancesnum);
        btn_guess_go = (Button)findViewById(R.id.btn_guess_go);
        et_guess = (EditText)findViewById(R.id.et_guess);

        new CountDownTimer(150000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextField.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                finish();
                mTextField.setText("done");
                timesup();
                GuessActivity.this.finish();
                GuessActivity.this.onDestroy();
            }

        }.start();


        et_guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_guess.setText("");
            }
        });


    }

    public void timesup(){
        if(check_if_present_star()) {
            intent1 = new Intent(this, FinalActivity.class);
            intent1.putExtra("Movie Name", mname);
            intent1.putExtra("wish", false);
            startActivity(intent1);

        }
    }


    public void me_btn_guess_go(View view){


        getletter = et_guess.getText().toString().toLowerCase();
        chargetletter = getletter.toCharArray();

        if(getletter.isEmpty()){
            Toast.makeText(this, "Please enter letter first", Toast.LENGTH_SHORT).show();
        }else {


            if (check_if_present_usedletter()) {
                Toast.makeText(this, "You have already used that letter", Toast.LENGTH_SHORT).show();
            } else {
                if (check_if_present_mname()) {
                    for (int i = 0; i < length_movie; i++) {
                        if (chargetletter[0] == mnameArray[i]) {
                            sb.setCharAt(i, mnameArray[i]);
                        } else {
                            continue;
                        }
                    }
                } else {
                    Toast.makeText(this, "Letter is not present", Toast.LENGTH_SHORT).show();
                    chancesleft = chancesleft - 1;
                    tv_guess_chancesnum.setText(" " + chancesleft);
                }
                sb1.append(chargetletter[0] + ", ");
            }


            tv_guess_movie.setText(sb.toString());
            usedletter[z] = chargetletter[0];
            tv_guess_guessed.setText(sb1.toString());

            if (chancesleft == 1) {
                Toast.makeText(this, "Only one chance is left now!", Toast.LENGTH_LONG).show();
            }

            if (chancesleft <= 0) {
                intent1 = new Intent(this, FinalActivity.class);
                intent1.putExtra("Movie Name", mname);
                intent1.putExtra("wish", false);
                startActivity(intent1);
            } else if (!check_if_present_star()) {
                intent1 = new Intent(this, FinalActivity.class);
                intent1.putExtra("Movie Name", mname);
                intent1.putExtra("wish", true);
                startActivity(intent1);
            }

            ++z;
        }
    }

    public boolean check_if_present_usedletter(){
        for(char c : usedletter){
            if(c == chargetletter[0]){
                return true;
            }else{
                continue;
            }
        }
        return false;
    }

    public boolean check_if_present_mname(){
        for(char c : mnameArray){
            if(c == chargetletter[0]){
                return true;
            }else{
                continue;
            }
        }
        return false;
    }

    public boolean check_if_present_star(){
        for(char c : tv_guess_movie.getText().toString().toLowerCase().toCharArray()){
            if(c == '*'){
                return true;
            }else{
                continue;
            }
        }
        return false;
    }

}
