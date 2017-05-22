package com.alignsolution.siamsmilemobileapplication.Biz;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.alignsolution.siamsmilemobileapplication.DataBase;

/**
 * Created by aligndev on 08-May-17.
 */

public class UsersMGR {
    private SQLiteDatabase database;

    public  Users  SelectDataLogin(String Username ,String Password ,Context context) {
        Users oUsers=new Users();

        // Database
        DataBase database = new DataBase(context);
        String selectQuery = "SELECT  * FROM  Users  where  LOWER(UserLogin) = LOWER('"+Username+"') and Password = '"+Password+"'";

        Log.i("Log",selectQuery);
        SQLiteDatabase db  = database.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                oUsers.setRowID(cursor.getString(cursor.getColumnIndexOrThrow("RowId")));
                oUsers.setUserID(cursor.getString(cursor.getColumnIndexOrThrow("UserId")));
                oUsers.setUserLogin(cursor.getString(cursor.getColumnIndexOrThrow("UserLogin")));
                oUsers.setPassword(cursor.getString(cursor.getColumnIndexOrThrow("Password")));
                oUsers.setFirstName(cursor.getString(cursor.getColumnIndexOrThrow("FirstName")));
                oUsers.setLastName(cursor.getString(cursor.getColumnIndexOrThrow("LastName")));
                oUsers.setCardNo(cursor.getString(cursor.getColumnIndexOrThrow("CardNo")));
                oUsers.setBirthDate(cursor.getString(cursor.getColumnIndexOrThrow("BirthDate")));
                oUsers.setEmail(cursor.getString(cursor.getColumnIndexOrThrow("Email")));
                oUsers.setPhoneNumber1(cursor.getString(cursor.getColumnIndexOrThrow("PhoneNumber1")));
                oUsers.setPhoneNumber2(cursor.getString(cursor.getColumnIndexOrThrow("PhoneNumber2")));
                oUsers.setHomeAddress(cursor.getString(cursor.getColumnIndexOrThrow("HomeAddress")));
                oUsers.setWorkAddress(cursor.getString(cursor.getColumnIndexOrThrow("WorkAddress")));
                oUsers.setUserType(cursor.getString(cursor.getColumnIndexOrThrow("UserType")));
                oUsers.setPicture(cursor.getString(cursor.getColumnIndexOrThrow("Picture")));
                oUsers.setCreatedOn(cursor.getString(cursor.getColumnIndexOrThrow("CreatedOn")));
                oUsers.setModifiedOn(cursor.getString(cursor.getColumnIndexOrThrow("ModifiedOn")));
                oUsers.setSyncDate(cursor.getString(cursor.getColumnIndexOrThrow("SyncDate")));
                oUsers.setSyncSattus(cursor.getString(cursor.getColumnIndexOrThrow("SyncStatus")));


                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();
        return oUsers;
    }


    }





