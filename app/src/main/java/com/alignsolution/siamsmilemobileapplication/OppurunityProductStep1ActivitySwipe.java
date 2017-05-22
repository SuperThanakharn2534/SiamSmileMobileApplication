package com.alignsolution.siamsmilemobileapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by aligndev on 4/10/2017.
 */

public class OppurunityProductStep1ActivitySwipe extends AppCompatActivity {

    TextView textView31;
    OppurunityProductStep1ActivityAdapter adapter = new OppurunityProductStep1ActivityAdapter(getApplicationContext());
    public Button button;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opportunity_product_step1_swipe);
        textView31 = (TextView)findViewById(R.id.textView31);
        button = (Button)findViewById(R.id.btswipe);


//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getBaseContext(),LoginActivity.class);
//                startActivity(intent);
//
//            }
//        });




    }



    }


