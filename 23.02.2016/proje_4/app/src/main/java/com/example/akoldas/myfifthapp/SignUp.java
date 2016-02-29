package com.example.akoldas.myfifthapp;

import android.content.Context;
import android.content.Intent;
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SignUp extends AppCompatActivity {

    private static EditText username ;
    private static EditText password ;
    private static Button SignUp ;
    private static TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        SignUpButton();

    }

    public void SignUpButton(){
        username = (EditText) findViewById(R.id.editText_user);
        password = (EditText) findViewById(R.id.editText_password);
        SignUp = (Button)findViewById(R.id.button_signup) ;
        textView = (TextView)findViewById(R.id.textView_1);
        textView.setVisibility(View.GONE);




        SignUp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (username.getText().toString() != null && password.getText().toString() != null) {

                            writeMessage(v);
                            readMessage(v);
                            Intent intent = new Intent("com.example.akoldas.myfifthapp.User");
                            intent.putExtra("username",username.getText().toString());
                            startActivity(intent);

                        }

                    }
                }
        );
    }

    public void writeMessage(View view)
    {
        String Message_1 = username.getText().toString() ;
        String Message_2 = password.getText().toString() ;
        String katar_1 = Message_1+" "+Message_2 ;

        String file_name = "credential_file" ;
        try {
            FileOutputStream fileOutputStream = openFileOutput(file_name,  Context.MODE_APPEND );
            fileOutputStream.write(katar_1.getBytes());
            fileOutputStream.write(System.getProperty("line.separator").getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(),"Message Saved",Toast.LENGTH_LONG).show();


        }
         catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void readMessage ( View view) {
        try {
            String Message;
            FileInputStream fileInputStream = openFileInput("credential_file");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            while ((Message = bufferedReader.readLine()) != null) {
                stringBuffer.append(Message + "\n");

            }
            textView.setText(stringBuffer.toString());
            textView.setVisibility(View.VISIBLE);

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

}
