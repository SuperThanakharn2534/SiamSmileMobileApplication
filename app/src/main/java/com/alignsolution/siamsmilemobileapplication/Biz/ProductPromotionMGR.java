package com.alignsolution.siamsmilemobileapplication.Biz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.alignsolution.siamsmilemobileapplication.DataBase;

/**
 * Created by aligndev on 08-May-17.
 */

public class ProductPromotionMGR  {
    private SQLiteDatabase database;

    public ProductPromotion SelectDataProductPromotion( Context context) {
        ProductPromotion oProductPromotion = new ProductPromotion();


        // Database
        DataBase database = new DataBase(context);
        String selectQuery = "SELECT  * FROM  ProductPromotion";
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                oProductPromotion.setRowId(cursor.getString(cursor.getColumnIndexOrThrow("RowId")));
                oProductPromotion.setProductNo(cursor.getString(cursor.getColumnIndexOrThrow("ProductNo")));
                oProductPromotion.setProductName(cursor.getString(cursor.getColumnIndexOrThrow("ProductName")));
                oProductPromotion.setProductType(cursor.getString(cursor.getColumnIndexOrThrow("ProductType")));
                oProductPromotion.setDescription(cursor.getString(cursor.getColumnIndexOrThrow("Description")));
                oProductPromotion.setBenefit(cursor.getString(cursor.getColumnIndexOrThrow("Benefit")));
                oProductPromotion.setCreatedOn(cursor.getString(cursor.getColumnIndexOrThrow("CreatedOn")));
                oProductPromotion.setModifiedOn(cursor.getString(cursor.getColumnIndexOrThrow("ModifiedOn")));
                oProductPromotion.setSyncDate(cursor.getString(cursor.getColumnIndexOrThrow("SyncDate")));
                oProductPromotion.setSyncStatus(cursor.getString(cursor.getColumnIndexOrThrow("SyncStatus")));

                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();
        return oProductPromotion;
    }

    }
