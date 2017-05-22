package com.alignsolution.siamsmilemobileapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.alignsolution.siamsmilemobileapplication.Adapter.DasboardActivity_Adapter;
import com.alignsolution.siamsmilemobileapplication.Adapter.OpportunityListActivity_Adapter;
import com.alignsolution.siamsmilemobileapplication.Biz.MenuMGR;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by aligndev on 4/3/2017.
 */

public class OpportunityListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private DrawerLayout drawerLayout;
    private ListView listView;
    private   String[] planets;
    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    MenuMGR menuMGR = new MenuMGR();
    ListView MenuList;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opportunity_list);

        try {


        SetMenu();
        SetHeader("ผู้มุ่งหวัง/ปิดการขาย",true,false);

        ImageButton nextDetail =(ImageButton) findViewById(R.id.btnAdd);
         nextDetail.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getBaseContext(), OpportunityDetailActivity.class);
                   startActivity(intent);

             }
         });



        // ข่าาวสาร siamsmile Get ListView object from xml
        final ListView listView = (ListView) findViewById(R.id.listview);
        ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;
        /*** Rows 1 ***/
        map = new HashMap<String, String>();
        map.put("์Name", "คุณสมชาย ศรีสุข");
        map.put("Id_card", "1234567890123");
        map.put("PhoneNumber", "0899911234");
        map.put("Province", "อยุธยา");
        map.put("E_Mail", "test1@gmail.com");
        MyArrList.add(map);
        /*** Rows 2 ***/
        map = new HashMap<String, String>();
        map.put("์Name", "คุณสมนึก รักดี");
        map.put("Id_card", "1654987635259");
        map.put("PhoneNumber", "0814556699");
        map.put("Province", "เชียงใหม่");
        map.put("E_Mail", "test2@gmail.com");
        MyArrList.add(map);
        /*** Rows 3 ***/
        map = new HashMap<String, String>();
        map.put("์Name", "คุณสมหญิง น่ารัก");
        map.put("Id_card", "1123665987896");
        map.put("PhoneNumber", "0877611122");
        map.put("Province", "กรุงเทพฯ");
        map.put("E_Mail", "test3@gmail.com");
        MyArrList.add(map);
        /*** Rows 4 ***/
        map = new HashMap<String, String>();
        map.put("์Name", "คุณสมรัก ดำดี");
        map.put("Id_card", "1369966998959");
        map.put("PhoneNumber", "0899211123");
        map.put("Province", "ขอนแก่น");
        map.put("E_Mail", "test4@gmail.com");
        MyArrList.add(map);
        /*** Rows 5 ***/
        map = new HashMap<String, String>();
        map.put("์Name", "คุณสมชาติ สีดา");
        map.put("Id_card", "1977788554449");
        map.put("PhoneNumber", "0899911234");
        map.put("Province", "สกลนคร");
        map.put("E_Mail", "test5@gmail.com");
        MyArrList.add(map);
        /*** Rows 6 ***/
        map = new HashMap<String, String>();
        map.put("์Name", "คุณสมชาย ทำนา");
        map.put("Id_card", "1498852001369");
        map.put("PhoneNumber", "0899911234");
        map.put("Province", "สงขลา");
        map.put("E_Mail", "test6@gmail.com");
        MyArrList.add(map);

        SimpleAdapter sAdap;
        sAdap = new SimpleAdapter(OpportunityListActivity.this, MyArrList, R.layout.activity_opportunity_item,
                new String[] {"์Name", "Id_card", "PhoneNumber","Province","E_Mail"}, new int[] {R.id.Name, R.id.Id_card, R.id.PhoneNumber,R.id.Province,R.id.E_Mail})
        {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                /// Get the Item from ListView
                View view = super.getView(position, convertView, parent);


                // color ListView
                if (position % 2 == 0) {

                    view.setBackgroundResource(R.color.txtdata1);
                } else {
                    view.setBackgroundResource(R.color.txtdata2);
                }
                // Return the view
                return view;
            }
        };
        listView.setAdapter(sAdap);


        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;
                switch (position) {
                    case 0:
                        //Toast.makeText(activity," ข้อมูลผลิตภัณฑ์/โปรโมชั่น ", Toast.LENGTH_SHORT).show();
                        //myIntent =new Intent(activity,Activity_Opportunity2.class);
                        Intent myIntent = new Intent(getBaseContext(), OppurunityProductStep1Activity.class);
                        startActivity(myIntent);
                        break;
                    case 1:
                        //Toast.makeText(activity," ข้อมูลผลิตภัณฑ์/โปรโมชั่น ", Toast.LENGTH_SHORT).show();
                        //myIntent =new Intent(activity,Activity_Opportunity2.class);
                        //Intent myIntent = new Intent(getBaseContext(),LoginActivity.class);
                        // activity.startActivity(myIntent);
                        Intent myIntent1 = new Intent(getBaseContext(), OppurunityProductStep1Activity.class);
                        startActivity(myIntent1);
                        break;
                    case 2:
                        //Toast.makeText(activity," ข้อมูลผลิตภัณฑ์/โปรโมชั่น ", Toast.LENGTH_SHORT).show();
                        //myIntent =new Intent(activity,Activity_Opportunity2.class);
                        //Intent myIntent = new Intent(getBaseContext(),LoginActivity.class);
                        // activity.startActivity(myIntent);
                        Intent myIntent2 = new Intent(getBaseContext(), OppurunityProductStep1Activity.class);
                        startActivity(myIntent2);
                        break;
                    case 3:
                        //Toast.makeText(activity," ข้อมูลผลิตภัณฑ์/โปรโมชั่น ", Toast.LENGTH_SHORT).show();
                        //myIntent =new Intent(activity,Activity_Opportunity2.class);
                        //Intent myIntent = new Intent(getBaseContext(),LoginActivity.class);
                        // activity.startActivity(myIntent);
                        Intent myIntent3 = new Intent(getBaseContext(), OppurunityProductStep1Activity.class);
                        startActivity(myIntent3);
                        break;
                    case 4:
                        //Toast.makeText(activity," ข้อมูลผลิตภัณฑ์/โปรโมชั่น ", Toast.LENGTH_SHORT).show();
                        //myIntent =new Intent(activity,Activity_Opportunity2.class);
                        //Intent myIntent = new Intent(getBaseContext(),LoginActivity.class);
                        // activity.startActivity(myIntent);
                        Intent myIntent4 = new Intent(getBaseContext(), OppurunityProductStep1Activity.class);
                        startActivity(myIntent4);
                        break;
                    case 5:
                        //Toast.makeText(activity," ข้อมูลผลิตภัณฑ์/โปรโมชั่น ", Toast.LENGTH_SHORT).show();
                        //myIntent =new Intent(activity,Activity_Opportunity2.class);
                        //Intent myIntent = new Intent(getBaseContext(),LoginActivity.class);
                        // activity.startActivity(myIntent);
                        Intent myIntent5 = new Intent(getBaseContext(), OppurunityProductStep1Activity.class);
                        startActivity(myIntent5);
                        break;
                    default:
                        break;

                }


            }

        });

        }catch (Exception e){


        }

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

        OpportunityListActivity_Adapter MenuAdapter=new OpportunityListActivity_Adapter(OpportunityListActivity.this,
                menuMGR.MenuText(),menuMGR.MenuImg());
        MenuList =(ListView)findViewById(R.id.drawerList);
        MenuList.setAdapter(MenuAdapter);


    }

    public  void  SetHeader(String TextTitle,boolean ShowAddButton , boolean ShowNotify){

        getSupportActionBar().setDisplayOptions(getSupportActionBar().getDisplayOptions()
                | ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.activity_header);

        TextView Title =(TextView) getSupportActionBar().getCustomView().findViewById(R.id.txtTitle);
        Title.setText(TextTitle);


        if(!ShowAddButton){
            ImageButton btnAdd = (ImageButton)getSupportActionBar().getCustomView().findViewById(R.id.btnAdd);
            btnAdd.setVisibility(View.GONE);
        }

        if ( !ShowNotify){

            ImageView imgNotify =(ImageView)getSupportActionBar().getCustomView().findViewById(R.id.imgnotify);
            imgNotify.setVisibility(View.GONE);
        }



    }


}
