package com.example.souma.vedamagic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(Context context) {
        super(context, "usrdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
       db.execSQL("create table users(EMAIL TEXT PRIMARY KEY,FNAME TEXT,LNAME TEXT,PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP IF EXISTS users");

    }
    public boolean insert(String email,String pass,String fname,String lname)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues con=new ContentValues();
        con.put("EMAIL",email);
        con.put("FNAME",fname);
        con.put("LNAME",lname);
        con.put("PASSWORD",pass);
        long l=db.insert("users",null,con);
        if(l<0)
            return false;
        return true;
    }
    public Cursor executeQueries() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from users", null);
        return c;
    }
    public boolean updateQuery(String email,String pass)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues val=new ContentValues();
        val.put("PASSWORD",pass);
        long l=db.update("users",val,"EMAIL ='"+email+"'",null);
        if(l<0)
            return false;
       return true;
    }
}
