package com.example.fyp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class MyDbHandler extends SQLiteOpenHelper {
private static String key_NAME ="Name";
    private static String key_CONTACT ="Contact";
    private static String key_LOCATION ="Location";
    private static String key_EMAIL ="Email";
    private static String key_PASSWORD ="Password";
    private static String key_QUANTITY ="Quantity";
    private static String key_QUALITY ="Quality";
    private static String key_Price ="Price";

    private static String key_TABLE ="MilkMan";
    public MyDbHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override

    public void onCreate(SQLiteDatabase db)
    {
        String create_user="CREATE TABLE "+key_TABLE+"("+key_NAME+" TEXT PRIMARY KEY,"+key_CONTACT+" TEXT,"
                +key_LOCATION+" TEXT," +key_EMAIL+" TEXT ," +key_PASSWORD+" TEXT ,"+key_QUANTITY+" TEXT ,"+key_QUALITY+" TEXT,"+key_Price+" TEXT"+")";
        db.execSQL(create_user);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public  void insertmilkman (user user)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(key_NAME,user.getName());
        contentValues.put(key_CONTACT,user.getContactnumber());
        contentValues.put(key_LOCATION,user.getLocation());
        contentValues.put(key_EMAIL,user.getEmail());
        contentValues.put(key_PASSWORD,user.getPassword());

        db.insert(key_TABLE,null,contentValues);

    }

    public Boolean updatemilkinfo(user user)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(key_Price,user.getPrice());
        contentValues.put(key_QUANTITY,user.getQuantity());
        contentValues.put(key_QUALITY,user.getQuality());
        db.update(key_TABLE,contentValues,"Name=?",new String[]{user.getName()});
        return  true;


    }

    public ArrayList<user> ViewUser()
    {
        String st= "SELECT * FROM "+key_TABLE;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(st,null);
        ArrayList<user> arrayList= new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do {
                user user = new user();
                user.setName(cursor.getString(0));
                user.setLocation(cursor.getString(1));


                arrayList.add(user);
            } while (cursor.moveToNext());


        }
        return  arrayList;

    }



}

