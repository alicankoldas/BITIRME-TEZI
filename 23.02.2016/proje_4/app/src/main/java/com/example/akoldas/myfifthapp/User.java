package com.example.akoldas.myfifthapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class User extends AppCompatActivity {

    private TextView myText = null;
    private static Button experiment_button;
    private static Button logout_button ;
    private static Button exit_button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ExperimentButton();
        LogoutButton();
        ExitButton();



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String id = extras.getString("username");
            String katar_1 = id ;
            LinearLayout lView = (LinearLayout)findViewById(R.id.mylinearlayout);

            myText = new TextView(this);
            myText.setText(katar_1);

            lView.addView(myText);


        }
    }

    public void ExperimentButton() {
        experiment_button = (Button) findViewById(R.id.button_experiment);
        experiment_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent_1 = new Intent("com.example.akoldas.myfifthapp.Experiment");
                        startActivity(intent_1);
                    }
                }

        );
        }
    public void LogoutButton()
    {
        logout_button = (Button) findViewById(R.id.button_logout);
        logout_button.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View arg0) {
                        Intent intent = new Intent(User.this, Login.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }

                }
        );
                }
    public void ExitButton()
    {
        exit_button = (Button) findViewById(R.id.button_exit);
        exit_button.setOnClickListener(new View.OnClickListener() {


            public void onClick(View arg0) {

                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(startMain);
                finish();
            }

        });

    }



}
