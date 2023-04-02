package com.example.android_tut_8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class Email extends Activity implements View.OnClickListener {

    //Declaring Views variables
    EditText email,intro,name,hobby,outro,summary;

    //string is going to get the text from our edit text and converting it into a string
    //then it stores in the String variable
    String emailAdd,beginning, Name,action,Act,out;

    //creating button object
    Button sendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Calling Function
        IntializeVariables();

        //using onclicklister and passing context class
        sendEmail.setOnClickListener(this);

    }

    //initializing variable
    private void IntializeVariables(){
        email=(EditText) findViewById(R.id.e_et);
        intro=(EditText) findViewById(R.id.Intro_et);
        name=(EditText) findViewById(R.id.name_et);
        hobby=(EditText) findViewById(R.id.hobby_et);
        outro=(EditText) findViewById(R.id.outro_et);
        summary=(EditText) findViewById(R.id.sum_et);
    }


    //flow
    //when button is clicked it will send the below message
    //then emailIntent executed

    @Override
    public void onClick(View view) {

        EditTextIntoStrings();

        //string array for sending the email
        String emailaddress[]={emailAdd};

        //Message we want to send
        String message= "Hello"
                +Name
                +"I just wanted to say"
                +beginning
                +". I like coding in the following languages:"
                +action
                +" C++, Java, Xml"
                +Act
                +". This is all i want to say"
                +outro
                +" Thanks so much..... " ;


        //creating Intent to send email
        Intent emailIntent=new Intent(Intent.ACTION_SEND);

        //Adding stuff in Intent to make it unique
        //using putExtra bcz we are putting some extra stuff in emailIntent
        //android.content.Intent.EXTRA_EMAIL this will refer what email we are going to sending to
        //emailaddress String array that is storing emailAdd
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,emailaddress);

        //Setting subject for email
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Wassup dude");

        //setting type of Intent
        emailIntent.setType("plain/text");

        //Setting up the actual message
        emailIntent.putExtra(Intent.EXTRA_TEXT,message);

        //starting the activity
        startActivity(emailIntent);


    }

    private void EditTextIntoStrings(){

        //storing what is inside the edit text into string variables
        emailAdd=email.getText().toString();
        beginning=intro.getText().toString();
        Name=name.getText().toString();
        action=hobby.getText().toString();
        Act=summary.getText().toString();
        out=outro.getText().toString();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
