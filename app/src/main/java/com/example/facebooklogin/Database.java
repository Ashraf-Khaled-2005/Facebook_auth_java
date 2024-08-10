package com.example.facebooklogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database  extends SQLiteOpenHelper {
    private  SQLiteDatabase db;
    private   ContentValues values;
    private  Cursor cursor;
    public Database(@Nullable Context context) {
        super(context, "Users", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table user(id integer  primary key autoincrement,email text,username text ,password text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }



    public  Boolean insertData(User user){

        db=getWritableDatabase();
        values=new ContentValues();
        values.put("email",user.getEmail());
        values.put("username",user.getUsername());
        values.put("password",user.getPass());
        long result=db.insert("user",null,values);
        return  result>0;


    }
    public  Boolean UpdateData(User user){
        db=getWritableDatabase();
        values=new ContentValues();
        values.put("email",user.getEmail());
        values.put("username",user.getUsername());
        values.put("password",user.getPass());
        String []args={user.getUsername()};;
        long result=db.update("user",values,"username=?",args);
        return  result>0;


    }

   public boolean selectData(User user){

        db=getReadableDatabase();
        cursor=db.rawQuery("select * from user",null);

        if(cursor!=null&&cursor.moveToFirst()) {
            do {
                    String email=cursor.getString(1);
                    String pass=cursor.getString(3);
                        if(email.equals(user.getEmail())&&pass.equals(user.getPass())){
                                    cursor.close();
                                    return true;
                        }
            }while (cursor.moveToNext());

        }
        cursor.close();
        return false;


    }
    /*
 public boolean selectData(User user) {
     SQLiteDatabase db = getReadableDatabase();
     String query = "SELECT * FROM user WHERE email = ? AND password = ?";
     Cursor cursor = db.rawQuery(query, new String[]{user.getEmail(), user.getPass()});

     boolean result = cursor.moveToFirst();
     cursor.close();
     return result;
 }
*/






}
