package com.example.fyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MilkMansList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk_mans_list);
        TableLayout tableLayout=(TableLayout)findViewById(R.id.tablelayout1);
        LinearLayout linearLayout=new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        tableLayout.setStretchAllColumns(true);
        tableLayout.setShrinkAllColumns(true);

        TableRow rowTile=new TableRow(this);
        rowTile.setGravity(Gravity.CENTER);

        TableRow trow=new TableRow(this);


        TextView textView=new TextView(this);
        textView.setText("Milk Mans");
        textView.setTypeface(Typeface.SERIF);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,30);
        textView.setTextColor(Color.parseColor("#050505"));
        textView.setGravity(Gravity.CENTER);
        textView.setTypeface(Typeface.SERIF,Typeface.BOLD);
        rowTile.addView(textView);


        TextView t1=new TextView(this);
        TextView t2=new TextView(this);



        t1.setText("Name");
        t2.setText("Location");



        t1.setPadding(8,0,8,0);
        t2.setPadding(8,0,8,0);
        t1.setTextSize(20);
        t2.setTextSize(20);
        t1.setTextColor(Color.parseColor("#050505"));
        t2.setTextColor(Color.parseColor("#050505"));

        linearLayout.addView(t1);
        linearLayout.addView(t2);
        trow.addView(linearLayout);

        tableLayout.addView(rowTile);
        tableLayout.addView(trow);


        MyDbHandler myDbHandler=temp.getMyDbHandler();
        ArrayList<user> arrayList=myDbHandler.ViewUser();

        for (final user u:arrayList)
        {
            LinearLayout linearLayout1=new LinearLayout(this);
            TableRow tableRow1=new TableRow(this);
            linearLayout1.setOrientation(LinearLayout.HORIZONTAL);
            TextView t6=new TextView(this);
            TextView t7=new TextView(this);
            t6.setText(u.getName());
            t7.setText(u.getLocation());


            t6.setPadding(10,5,10,5);
            t7.setPadding(50,5,10,5);
            t6.setTextSize(20);
            t7.setTextSize(20);


            linearLayout1.addView(t6);
            linearLayout1.addView(t7);

            tableRow1.addView(linearLayout1);
            tableLayout.addView(tableRow1);

            linearLayout1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   String name;
                   name=u.getName();
                   /* Intent intent = new Intent(MilkMansList.this, MilkManDetails.class);
                    intent.putExtra("message", name);
                    startActivity(intent);*/
                    Toast.makeText(MilkMansList.this, "You Selected "+name+" Milk Man", Toast.LENGTH_SHORT).show();


                }
            });



        }


    }
}