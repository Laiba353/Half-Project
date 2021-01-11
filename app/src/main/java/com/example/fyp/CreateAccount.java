package com.example.fyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {
    EditText name,location,email,password,contact;
    MyDbHandler myDbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        myDbHandler=temp.getMyDbHandler();
        name=findViewById(R.id.name);
        location=findViewById(R.id.location);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        contact=findViewById(R.id.contactnumber);


    }

    public void SaveDetails (View view) {

        String Name=name.getText().toString();
        String Location=location.getText().toString();
        String Email=email.getText().toString();
        String Password=password.getText().toString();
        String ContactNumber=contact.getText().toString();

        if(Name.equals("") || Location.equals("") ||Email.equals("") ||Password.equals("") ||ContactNumber.equals(""))
        {
            Toast.makeText(this, "Please Fill All Fields", Toast.LENGTH_SHORT).show();
        }
        else
        {
            user user=new user();

            user.setName(Name);
            user.setLocation(Location);
            user.setEmail(Email);
            user.setPassword(Password);
            user.setContactnumber(ContactNumber);
            myDbHandler.insertmilkman(user);
            startActivity(new Intent(CreateAccount.this,AddMilkInfo.class));
            finish();

        }


    }

}