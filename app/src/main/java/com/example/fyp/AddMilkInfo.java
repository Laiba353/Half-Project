package com.example.fyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddMilkInfo extends AppCompatActivity {
  RadioGroup RadioGroup;
  EditText Milkquantity, Milkprice;
    MyDbHandler myDbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_milk_info);
       RadioGroup=findViewById(R.id.radiogroup);
        Milkquantity=findViewById(R.id.milkquantitiy);
        Milkprice=findViewById(R.id.milkprice);
    }


    public void PostDetails (View view) {

        String quantity=Milkquantity.getText().toString();
        String price=Milkprice.getText().toString();
        int checkid=RadioGroup.getCheckedRadioButtonId();
        RadioButton radioButton=findViewById(checkid);
        String category= radioButton.getText().toString();

        if(quantity.equals("") || price.equals("") )
        {
            Toast.makeText(this, "Please Fill All Fields", Toast.LENGTH_SHORT).show();
        }
        else
        {
            user user=new user();
            user.setQuantity(quantity);
            user.setPrice(price);
            user.setQuality(category);
            myDbHandler.insertmilkman(user);

        }
    }
}