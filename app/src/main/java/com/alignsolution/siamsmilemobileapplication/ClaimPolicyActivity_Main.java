package com.alignsolution.siamsmilemobileapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.alignsolution.siamsmilemobileapplication.Biz.MenuMGR;

/**
 * Created by aligndev on 23-Apr-17.
 */

public class ClaimPolicyActivity_Main extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private DrawerLayout drawerLayout;
    private ListView listView;
    private   String[] planets;
    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    MenuMGR menuMGR = new MenuMGR();
    ListView list1;

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
    String[] itemname1 ={
            "ผู้มุ่งหวัง/ปิดการขาย",
            "บริการเคลมสุขภาพ",
            "จัดเก็บเบี้ยค้างชำระ",
            "ประกาศ/ข้อมูลการแข่งขัน",
            "สอบถามข้อมูลเพิ่มเติม",
            "ข้อเสนอแนะ/ร้องเรียน",
            "แก้ไข  Password",
            "Log Out"};

        ListView list;
        String[] itemname ={" APP ID : 00000001 \n" +
                "ชื่อ-นามสกุล : ณเดช รักดี\n" +
                "รหัสเลข Co-band : 484800059888\n" +
                "แผนประกัน : 501 – Silver\n" +
                "        สถานะกรมธรรม์ : ปกติ"
                ,"APP ID : 00000002\n" +
                "ชื่อ-นามสกุล : ณเดช รักดี \n" +
                "รหัสเลข Co-band : 484800059888 \n" +
                "แผนประกัน : 502 – Gold\n" +
                "สถานะกรมธรรม์ : ยกเลิก\n"};

        Integer[] imgid={
                R.drawable.image1,
                R.drawable.image2,


        };
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_claim_policy_main);
            SetMenu();

            //  Header  TooBar  image and icon
            getSupportActionBar().setDisplayOptions(getSupportActionBar().getDisplayOptions()
                    | ActionBar.DISPLAY_SHOW_CUSTOM);
            ImageView imageView = new ImageView(getSupportActionBar().getThemedContext());
            getSupportActionBar().setCustomView(R.layout.activity_header);

            //menu slide
            com.alignsolution.siamsmilemobileapplication.Adapter.ClaimPolicyActivity_Adapter adapter0=new com.alignsolution.siamsmilemobileapplication.Adapter.ClaimPolicyActivity_Adapter(ClaimPolicyActivity_Main.this,
                    itemname1, arrImg);
            list1=(ListView)findViewById(R.id.drawerList);
            list1.setAdapter(adapter0);


            ClaimPolicyActivityAdapter_List adapter=new ClaimPolicyActivityAdapter_List(ClaimPolicyActivity_Main.this,
                    itemname, imgid);
            list=(ListView)findViewById(R.id.list);

            list.setAdapter(adapter);



            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override 
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    int itemPosition     = position;
                    switch (position){
                        case  0:
                            //Toast.makeText(activity," ข้อมูลผลิตภัณฑ์/โปรโมชั่น ", Toast.LENGTH_SHORT).show();
                            //myIntent =new Intent(activity,Activity_Opportunity2.class);
                            Intent myIntent = new Intent(getBaseContext(),ClaimPolicyDetailActivity.class);
                            startActivity(myIntent);
                            break;
                        case  1:
                            //Toast.makeText(activity," ข้อมูลผลิตภัณฑ์/โปรโมชั่น ", Toast.LENGTH_SHORT).show();
                            //myIntent =new Intent(activity,Activity_Opportunity2.class);
                            //Intent myIntent = new Intent(getBaseContext(),LoginActivity.class);
                            // activity.startActivity(myIntent);
                            Intent myIntent2 = new Intent(getBaseContext(),ClaimPolicyDetailActivity.class);
                            startActivity(myIntent2);

                            break;
                        default:
                            break;

                    }

                }


            });

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


}
