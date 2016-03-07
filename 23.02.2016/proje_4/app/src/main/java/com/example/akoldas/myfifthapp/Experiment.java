package com.example.akoldas.myfifthapp;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;
import java.util.logging.LogRecord;

public class Experiment extends AppCompatActivity {

    private static TextView display_text;
    private static Button stop_button;
    private static Button back_button;
    int i = 0;
    final Handler myHandler = new Handler();
    final Timer myTimer = new Timer() ;
    String katar_3 = "" ;
    int sayi;
    boolean cancelled = false ;
    boolean activation = false ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment);
        display_text = (TextView) findViewById(R.id.textView_123);
        StopButton();
        BackButton();
        TimerTask myTask = new TimerTask(){
            public void run()
            {
                updateUI();
            }
        };
          myTimer.schedule(myTask,0,1000);


    }
    final Runnable myRunnable = new Runnable() {
        public void run() {
            display_text.setText(katar_3);
        }
    };

    private void updateUI() {
        if(!cancelled) {
            Random r = new Random();
            int i1 = r.nextInt(100);
            katar_3 = katar_3 + String.valueOf(i1) ;


            // num.setText(String.valueOf(i)); = avoid the RunTime error
            myHandler.post(myRunnable); // relate this to a Runnable
        } else {
            myTimer.cancel(); // stop the timer
            return;
        }
    }


    public void StopButton() {

        stop_button = (Button) findViewById(R.id.button_stop);


        stop_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                          cancelled = true ;
                          activation = true ;
                    }
                }
        );
    }


    public void BackButton() {
        back_button = (Button) findViewById(R.id.button_back);
        back_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (activation == true )
                        {
                            finish();
                            System.exit(0);
                        }
                    }
                }
        );
    }

}

