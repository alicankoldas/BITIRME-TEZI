package com.example.akoldas.mysixthapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    DatabaseHelper myDb ;

    private static EditText username ;
    private static EditText password ;
    private static Button SignUp ;
    private static TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        myDb = new DatabaseHelper(this) ;


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
                        boolean isInserted = myDb.insertData(username.getText().toString(), password.getText().toString());
                        if (isInserted == true) {
                            Toast.makeText(SignUp.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent("com.example.akoldas.mysixthapp.User");
                            intent.putExtra("username",username.getText().toString());
                            startActivity(intent);
                        } else {
                            Toast.makeText(SignUp.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );
    }


}
