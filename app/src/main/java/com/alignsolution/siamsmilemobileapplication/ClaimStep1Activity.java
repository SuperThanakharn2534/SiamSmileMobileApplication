package com.alignsolution.siamsmilemobileapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.alignsolution.siamsmilemobileapplication.Adapter.ClaimStep1Activity_Adapter;
import com.alignsolution.siamsmilemobileapplication.Biz.MenuMGR;

/**
 * Created by aligndev on 04-May-17.
 */

public class ClaimStep1Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private DrawerLayout drawerLayout;
    private ListView listView;
    private   String[] planets;
    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    MenuMGR menuMGR = new MenuMGR();
    ListView list1;
    private FloatingActionButton fab;

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
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claim_step_1);
        try{
        SetMenu();
        ClaimStep1Activity_Adapter adapter1=new ClaimStep1Activity_Adapter(ClaimStep1Activity.this,
                itemname, arrImg);
        list1=(ListView)findViewById(R.id.drawerList);
        list1.setAdapter(adapter1);

        // header
        getSupportActionBar().setDisplayOptions(getSupportActionBar().getDisplayOptions()
                | ActionBar.DISPLAY_SHOW_CUSTOM);
        ImageView imageView = new ImageView(getSupportActionBar().getThemedContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(R.drawable.user);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(
                Gravity.RIGHT );
        imageView.setLayoutParams(layoutParams);
        getSupportActionBar().setCustomView(R.layout.activity_header);

        Button cmd = (Button) findViewById(R.id.button34);
        cmd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it2 = new Intent(getBaseContext(),ClaimStep2Activity.class);
                startActivity(it2);
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
}
