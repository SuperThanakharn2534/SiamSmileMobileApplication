package com.alignsolution.siamsmilemobileapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by aligndev on 22-Apr-17.
 */

public class OpportunityProductSuccess_PopUp extends AppCompatActivity {

     String itemNo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_opportunity_product_successpopup);
        itemNo = getIntent().getExtras().getString("itemNo");


        Button button =(Button)findViewById(R.id.button41);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),OpportunityProductSuccess.class);
                startActivity(intent);

            }
        });

        Button button2 =(Button)findViewById(R.id.button42);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),OpportunityProductStep2Activity.class);
                intent.putExtra("itemNo",itemNo.toString());
                startActivity(intent);

            }
        });

        //PopUp Page
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.5));



    }
}
