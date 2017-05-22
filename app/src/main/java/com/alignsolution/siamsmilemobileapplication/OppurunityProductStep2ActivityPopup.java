package com.alignsolution.siamsmilemobileapplication;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aligndev on 4/11/2017.
 */

public class OppurunityProductStep2ActivityPopup extends AppCompatActivity {
    private Spinner textspinner;
    private ArrayList<String> spinner = new ArrayList<String>();
    String itemNo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_opportunity_product_step2_popup);
        itemNo = getIntent().getExtras().getString("itemNo");

        textspinner = (Spinner) findViewById(R.id.spinner4);
        textlistdata();

                Button button1 =(Button)findViewById(R.id.button16);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),OpportunityDetailActivity.class);
                startActivity(intent);

            }
        });
        Button button2 =(Button)findViewById(R.id.button39);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),OpportunityProductStep2Activity.class);
                intent.putExtra("itemNo",itemNo.toString());
                startActivity(intent);

            }
        });

// Adapter ตัวแรก
        ArrayAdapter<String> adapterThai = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, spinner);
        textspinner.setAdapter(adapterThai);



        //PopUp Page
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.99),(int)(height*.99));




    }

    private void textlistdata(){
        spinner.add("ระบุเปอร์เซ็นต์ความสนใจ");
        spinner.add("10%");
        spinner.add("20%");
        spinner.add("30%");
        spinner.add("40%");
        spinner.add("50%");
        spinner.add("60%");
        spinner.add("70%");
        spinner.add("80%");
        spinner.add("90%");
        spinner.add("100%");


    }
}
