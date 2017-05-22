package com.alignsolution.siamsmilemobileapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.alignsolution.siamsmilemobileapplication.Adapter.OpportunityProductStep2Activity_Adapter;
import com.alignsolution.siamsmilemobileapplication.Biz.MenuMGR;

import java.util.ArrayList;

/**
 * Created by aligndev on 4/11/2017.
 */


public class OpportunityProductStep2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private   String[] planets;
    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    MenuMGR menuMGR = new MenuMGR();
    ListView list1;
    String itemNo;

    final Integer[] arrImg = {
            R.drawable.tl1,
            R.drawable.tl2,
            R.drawable.tl3,
            R.drawable.tl4,
            R.drawable.tl5,
            R.drawable.tl6,
            R.drawable.tl7,
            R.drawable.tl8
    };
    String[] itemname ={
            "ผู้มุ่งหวัง/ปิดการขาย",
            "บริการเคลมสุขภาพ",
            "จัดเก็บเบี้ยค้างชำระ",
            "ประกาศ/ข้อมูลการแข่งขัน",
            "สอบถามข้อมูลเพิ่มเติม",
            "ข้อเสนอแนะ/ร้องเรียน",
            "แก้ไข  Password",
            "Log Out"};

    private Spinner dataProduct;
    private ArrayList<String> textlistproduct = new ArrayList<String>();
    public   int[] imgs = {R.drawable.person,R.drawable.group,R.drawable.car,R.drawable.person,R.drawable.group,R.drawable.car};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opportunity_product_step2);
        try {


        SetMenu();



        //menu slide
        OpportunityProductStep2Activity_Adapter adapter1=new OpportunityProductStep2Activity_Adapter(OpportunityProductStep2Activity.this,
                itemname, arrImg);
        list1=(ListView)findViewById(R.id.drawerList);
        list1.setAdapter(adapter1);


        //  Header  TooBar  image and icon
        getSupportActionBar().setDisplayOptions(getSupportActionBar().getDisplayOptions()
                | ActionBar.DISPLAY_SHOW_CUSTOM);
        ImageView imageView = new ImageView(getSupportActionBar().getThemedContext());
        getSupportActionBar().setCustomView(R.layout.activity_header);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Snackbar.make(view, "Test On Click", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
//                Intent intent = new Intent(getBaseContext(),OppurunityProductStep1Activity.class);
//                startActivity(intent);
//
//            }
//        });



        dataProduct = (Spinner) findViewById(R.id.spinner);
        datalistProduct();
        // Adapter ตัวแรก
        ArrayAdapter<String> adapterProduct = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, textlistproduct);
        dataProduct.setAdapter(adapterProduct);
        

        android.util.Log.i(" group ",getIntent().getExtras().getString("itemNo"));
        itemNo = getIntent().getExtras().getString("itemNo");
        TextView textView42 = (TextView)findViewById(R.id.textView42);
        textView42.setText(itemNo);
        final ImageView img =(ImageView)findViewById(R.id.imageView6);
        img.setImageResource(imgs[Integer.parseInt(itemNo)]);
        if ( Integer.parseInt(itemNo) == 0) {
            textView42.setText("ประกันบุคคล");
        } else if (Integer.parseInt(itemNo) == 1) {
            textView42.setText("ประกันกลุ่ม");
        } else if (Integer.parseInt(itemNo) == 2) {
            textView42.setText("ประกันรถยนต์");
        } else if (Integer.parseInt(itemNo) == 3) {
            textView42.setText("ประกันบุคคล");
        } else if (Integer.parseInt(itemNo) == 4) {
            textView42.setText("ประกันกลุ่ม");
        } else if (Integer.parseInt(itemNo) == 5) {
            textView42.setText("ประกันรถยนต์");
        }


        Button button12 = (Button)findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),OppurunityProductStep2ActivityPopup.class);
                intent.putExtra("itemNo",itemNo.toString());
                startActivity(intent);
            }
        });

        Button button11 = (Button)findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),OpportunityProductSuccess_PopUp.class);
                intent.putExtra("itemNo",itemNo.toString());
                startActivity(intent);
            }
        });

        }catch (Exception e){}


    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this,planets[position]+ "   was selected ", Toast.LENGTH_SHORT).show();
        selectItem(position);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void selectItem(int position) {
        menuMGR.CustomerMenuSelect(position,this);
    }
    public void  SetMenu(){

        drawerLayout=(DrawerLayout) findViewById(R.id.drawerLayout);
        planets=getResources().getStringArray(R.array.CustomerMenu);
        listView=(ListView) findViewById(R.id.drawerList);
        listView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,planets));
        listView.setOnItemClickListener(this);

        //Close and open sideBar
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    private void datalistProduct() {
        textlistproduct.add("SELECT PRODUCT");
        textlistproduct.add("SilVer  1+");
        textlistproduct.add("SilVer  2+");
        textlistproduct.add("SilVer  3+");
        textlistproduct.add("SilVer  4+");
        textlistproduct.add("SilVer ");


    }
}
