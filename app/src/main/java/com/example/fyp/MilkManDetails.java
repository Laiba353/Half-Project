package com.example.fyp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MilkManDetails extends AppCompatActivity {
    EditText name,location,contactnumber,mikcategory,milkquantity,milkprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk_man_details);
        name=findViewById(R.id.name);
        location=findViewById(R.id.location);
        contactnumber=findViewById(R.id.contactnumber);
        mikcategory=findViewById(R.id.milkcategory);
        mikcategory.setEnabled(false);
        milkquantity=findViewById(R.id.milkquantitiy);
        milkprice=findViewById(R.id.milkprice);
        name.setEnabled(false);
        location.setEnabled(false);
        contactnumber.setEnabled(false);
        milkprice.setEnabled(false);
        milkquantity.setEnabled(false);

        /*Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");
        name.setText(message);*/



    }
}