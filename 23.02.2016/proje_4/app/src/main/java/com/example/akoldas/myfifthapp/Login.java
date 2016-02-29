package com.example.akoldas.myfifthapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Login extends AppCompatActivity {

    private static EditText username_1 ;
    private static EditText password_1 ;
    private static Button account_button;
    private static Button submit_button ;
    public int flag_1 ;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SubmitButton() ;
        AccountButton();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void SubmitButton()
    {
        flag_1 = 0 ;
        username_1 = (EditText) findViewById(R.id.editText_user);
        password_1 = (EditText) findViewById(R.id.editText_password);
        submit_button = (Button) findViewById(R.id.button_submit);
        submit_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        flag_1 = readMessage(v);
                        if (flag_1 == 1) {
                            Toast.makeText(getApplicationContext(), "Correct Entry", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent("com.example.akoldas.myfifthapp.User");
                            intent.putExtra("username",username_1.getText().toString());
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Get an account", Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );

    }


    public void AccountButton() {


        account_button = (Button) findViewById(R.id.button_newaccount);
        account_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                            Intent intent = new Intent("com.example.akoldas.myfifthapp.SignUp");
                            startActivity(intent);
                    }
                }
                        );
                    }


    public int readMessage ( View view) {
        int flag = 0 ;
        try {

                String Message;
                FileInputStream fileInputStream = openFileInput("credential_file");
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer stringBuffer = new StringBuffer();

                while ((Message = bufferedReader.readLine()) != null) {

                    String[] tokens = Message.split(" ");
                    String isim = tokens[0];
                    String sifre = tokens[1];
                    Toast.makeText(getApplicationContext(), isim+" "+sifre, Toast.LENGTH_LONG).show();
                    if (isim.equals(username_1.getText().toString()) && sifre.equals(password_1.getText().toString())) {
                        flag = flag +  1;
                        //Toast.makeText(getApplicationContext(),  String.valueOf(flag), Toast.LENGTH_LONG).show();


                    }

                }

            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }

        return flag ;

    }

                    @Override
                    public boolean onCreateOptionsMenu(Menu menu) {
                        // Inflate the menu; this adds items to the action bar if it is present.
                        getMenuInflater().inflate(R.menu.menu_login, menu);
                        return true;
                    }

                    @Override
                    public boolean onOptionsItemSelected(MenuItem item) {
                        // Handle action bar item clicks here. The action bar will
                        // automatically handle clicks on the Home/Up button, so long
                        // as you specify a parent activity in AndroidManifest.xml.
                        int id = item.getItemId();

                        //noinspection SimplifiableIfStatement
                        if (id == R.id.action_settings) {
                            return true;
                        }

                        return super.onOptionsItemSelected(item);
                    }

                    @Override
                    public void onStart() {
                        super.onStart();

                        // ATTENTION: This was auto-generated to implement the App Indexing API.
                        // See https://g.co/AppIndexing/AndroidStudio for more information.
                        client.connect();
                        Action viewAction = Action.newAction(
                                Action.TYPE_VIEW, // TODO: choose an action type.
                                "Login Page", // TODO: Define a title for the content shown.
                                // TODO: If you have web page content that matches this app activity's content,
                                // make sure this auto-generated web page URL is correct.
                                // Otherwise, set the URL to null.
                                Uri.parse("http://host/path"),
                                // TODO: Make sure this auto-generated app deep link URI is correct.
                                Uri.parse("android-app://com.example.akoldas.myfifthapp/http/host/path")
                        );
                        AppIndex.AppIndexApi.start(client, viewAction);
                    }

                    @Override
                    public void onStop() {
                        super.onStop();

                        // ATTENTION: This was auto-generated to implement the App Indexing API.
                        // See https://g.co/AppIndexing/AndroidStudio for more information.
                        Action viewAction = Action.newAction(
                                Action.TYPE_VIEW, // TODO: choose an action type.
                                "Login Page", // TODO: Define a title for the content shown.
                                // TODO: If you have web page content that matches this app activity's content,
                                // make sure this auto-generated web page URL is correct.
                                // Otherwise, set the URL to null.
                                Uri.parse("http://host/path"),
                                // TODO: Make sure this auto-generated app deep link URI is correct.
                                Uri.parse("android-app://com.example.akoldas.myfifthapp/http/host/path")
                        );
                        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
