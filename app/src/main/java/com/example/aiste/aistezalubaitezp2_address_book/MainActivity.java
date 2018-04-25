package com.example.aiste.aistezalubaitezp2_address_book;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;

       EditText inputFirstName;
      EditText inputLastName;
       EditText inputPhone;
       EditText inputEmail;
       Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHelper(this);

        inputFirstName = (EditText) findViewById(R.id.inputFirstName);
        inputLastName = (EditText) findViewById(R.id.inputLastName);
        inputPhone = (EditText) findViewById(R.id.inputPhone);
        inputEmail = (EditText) findViewById(R.id.inputEmail);
        addButton = (Button) findViewById(R.id.addButton);


        addContacts();

            }


    public void addContacts() {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDB.insertData(inputFirstName.getText().toString(), inputLastName.getText().toString(),
                                                     inputPhone.getText().toString(), inputEmail.getText().toString());
                if (isInserted == true)
                    Toast.makeText(MainActivity.this, "Contact inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Contact NOT inserted", Toast.LENGTH_LONG).show();

                }


                }
        );

    }
}