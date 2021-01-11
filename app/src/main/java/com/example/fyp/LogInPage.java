package com.example.fyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInPage extends AppCompatActivity {
Button createaccount;
EditText name,password;
    MyDbHandler myDbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);

        createaccount=findViewById(R.id.createaccount);
        name=findViewById(R.id.name);
        password=findViewById(R.id.password);



        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogInPage.this,CreateAccount.class));
                finish();
            }
        });

    }
    public void login(View view)
    {
        if(name.equals("") || password.equals(""))
        {
            Toast.makeText(LogInPage.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        }
        else
        {
            myDbHandler=temp.getMyDbHandler();
            SQLiteDatabase db=myDbHandler.getReadableDatabase();
            String[] columns= {"Name","Password"};
            String[] values={name.getText().toString(),password.getText().toString()};
            Cursor cursor=db.query("MilkMan",columns,"Name=? AND Password=?",values,null,null,null);
            if (cursor != null)
            {
                if(cursor.moveToFirst())
                {
                    startActivity(new Intent(LogInPage.this,AddMilkInfo.class));
                    finish();
                }
                else {
                    Toast.makeText(LogInPage.this, "Wrong email or password", Toast.LENGTH_SHORT).show();
                }
            }

        }
    }


}