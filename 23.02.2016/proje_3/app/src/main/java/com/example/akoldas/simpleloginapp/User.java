package com.example.akoldas.simpleloginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class User extends AppCompatActivity {

    private TextView myText = null;
    private static Button basa_don_btn ;
    private static Button exit_button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        BasaDonButton();
        ExitButton() ;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String id = extras.getString("id");
            String pass = extras.getString("pass");
            String katar = id+" "+pass ;
            LinearLayout lView = (LinearLayout)findViewById(R.id.mylinearlayout);

            myText = new TextView(this);
            myText.setText(katar);

            lView.addView(myText);


        }


    }

    public void BasaDonButton() {

        basa_don_btn = (Button) findViewById(R.id.button_bas);
        basa_don_btn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View arg0) {
                        finish();
                    }

                }
        );
    }

    public  void ExitButton() {
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
