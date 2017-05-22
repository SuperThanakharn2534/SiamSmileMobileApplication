package com.alignsolution.siamsmilemobileapplication.Biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.alignsolution.siamsmilemobileapplication.DataBase;

/**
 * Created by aligndev on 08-May-17.
 */

public class OpportunityMGR {

    public boolean InsertData(Opportunity opportunity,Context context) {

        DataBase database = new DataBase(context);
          Boolean aBoolean = true;
        SQLiteDatabase db  = database.getWritableDatabase();
        ContentValues Val= new ContentValues();
        Val.put("FirstName",opportunity.getFirstName().toString());
        Val.put("LastName", opportunity.getLastName().toString());
        Val.put("OpportunityNo",opportunity.getOpportunityNo());
        Val.put("CardNo",opportunity.getCardNo());
        Val.put("OpportunityNo",opportunity.getOpportunityNo());
        Val.put("PhoneNumber1",opportunity.getPhoneNumber1());
        Val.put("PhoneNumber2",opportunity.getPhoneNumber2());
        Val.put("Email",opportunity.getEmail());
        Val.put("LineId",opportunity.getLineId());
        Val.put("Address",opportunity.getAddress());
        Val.put("Province",opportunity.getProvince());
        Val.put("Remark",opportunity.getRemark());
        Val.put("Picture",opportunity.getPicture());
        Val.put("GPS",opportunity.getGPS());
        Val.put("AgentNo",opportunity.getAgentNo());
        Val.put("CreatedOn",opportunity.getCreatedOn());
        Val.put("ModifiedOn",opportunity.getModifiedOn());
        Val.put("SyncDate",opportunity.getSyncDate());
        Val.put("SyncStatus",opportunity.getSyncStatus());

         long rows ;
             Log.i("long","InsertLong");
        rows  = db.insert("Opportunity", null, Val);
         if (rows == -1 ){
             aBoolean = false;
         }
          return  aBoolean;





    }
}
