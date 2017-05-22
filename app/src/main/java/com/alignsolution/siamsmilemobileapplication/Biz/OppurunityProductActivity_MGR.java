package com.alignsolution.siamsmilemobileapplication.Biz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.alignsolution.siamsmilemobileapplication.OpportunityProductStep2Activity;

/**
 * Created by aligndev on 4/10/2017.
 */

public class OppurunityProductActivity_MGR extends AppCompatActivity {

    public  void  OpenPromotion(String itemNo , Activity activity){

         Intent intent = new Intent(activity,OpportunityProductStep2Activity.class);
        intent.putExtra("itemNo",itemNo.toString());
           activity.startActivity(intent);



    }

}
