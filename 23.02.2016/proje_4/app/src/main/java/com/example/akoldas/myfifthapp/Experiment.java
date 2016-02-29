package com.example.akoldas.myfifthapp;

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

import java.util.Random;

public class Experiment extends AppCompatActivity {

    private static TextView display_text ;
    private static Button stop_button;
    private static Button back_button ;
    int sayi ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment);
        StopButton();
        BackButton();

    }

    public void StopButton() {

        stop_button = (Button) findViewById(R.id.button_stop);
        display_text = (TextView) findViewById(R.id.textView_123);

        stop_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int x  = 0 ;
                        while (x == 0 ) {
                            Random rand = new Random();
                            int pickedNumber = rand.nextInt(100);
                            String katar_12 = String.valueOf(pickedNumber);
                            String katar_14 = "";
                            katar_14 = katar_12 + katar_14;
                            display_text.setText(katar_14);
                        }
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

                    }
                }
        );
    }



    public void DisplayNumbers(int sayi)
    {
        display_text = (TextView) findViewById(R.id.textView_123);
        sayi = 0 ;
        String katar_24 = "" ;
        while (sayi == 0 )
        {
            Random rand = new Random();
            int pickedNumber = rand.nextInt(100);
            String katar_23 = String.valueOf(pickedNumber);
            katar_24 = katar_24 + katar_23 ;
            Toast.makeText(getApplicationContext(), katar_24, Toast.LENGTH_LONG).show();
            //display_text.setText(katar_24);

        }


    }


}
