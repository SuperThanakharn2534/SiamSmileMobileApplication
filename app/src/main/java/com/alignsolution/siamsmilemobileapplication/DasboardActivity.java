package com.alignsolution.siamsmilemobileapplication;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.alignsolution.siamsmilemobileapplication.Adapter.DasboardActivity_Adapter;
import com.alignsolution.siamsmilemobileapplication.Biz.MenuMGR;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by aligndev on 4/4/2017.
 */

public class DasboardActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener{

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
        setContentView(R.layout.activity_dasboard);

        try {

        SetMenu();
        SetHeader("Dasboard",false,false);

        // ข่าาวสาร siamsmile Get ListView object from xml
        final ListView listView = (ListView) findViewById(R.id.listview);
            ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;
            /*** Rows 1 ***/
            map = new HashMap<String, String>();
            map.put("์Name", "คุณสมชาย ศรีสุข");
            map.put("Id card", "1234567890123");
            map.put("PhoneNumber", "0899911234");
            map.put("Province", "อยุธยา");
            map.put("E-Mail", "test1@gmail.com");
            MyArrList.add(map);
            /*** Rows 2 ***/
            map = new HashMap<String, String>();
            map.put("์Name", "คุณสมนึก รักดี");
            map.put("Id card", "1654987635259");
            map.put("PhoneNumber", "0814556699");
            map.put("Province", "เชียงใหม่");
            map.put("E-Mail", "test2@gmail.com");
            MyArrList.add(map);
            /*** Rows 3 ***/
            map = new HashMap<String, String>();
            map.put("์Name", "คุณสมหญิง น่ารัก");
            map.put("Id card", "1123665987896");
            map.put("PhoneNumber", "0877611122");
            map.put("Province", "กรุงเทพฯ");
            map.put("E-Mail", "test3@gmail.com");
            MyArrList.add(map);
            /*** Rows 4 ***/
            map = new HashMap<String, String>();
            map.put("์Name", "คุณสมรัก ดำดี");
            map.put("Id card", "1369966998959");
            map.put("PhoneNumber", "0899211123");
            map.put("Province", "ขอนแก่น");
            map.put("E-Mail", "test4@gmail.com");
            MyArrList.add(map);
            /*** Rows 5 ***/
            map = new HashMap<String, String>();
            map.put("์Name", "คุณสมชาติ สีดา");
            map.put("Id card", "1977788554449");
            map.put("PhoneNumber", "0899911234");
            map.put("Province", "สกลนคร");
            map.put("E-Mail", "test5@gmail.com");
            MyArrList.add(map);
            /*** Rows 6 ***/
            map = new HashMap<String, String>();
            map.put("์Name", "คุณสมชาย ทำนา");
            map.put("Id card", "1498852001369");
            map.put("PhoneNumber", "0899911234");
            map.put("Province", "สงขลา");
            map.put("E-Mail", "test6@gmail.com");
            MyArrList.add(map);

            SimpleAdapter sAdap;
            sAdap = new SimpleAdapter(DasboardActivity.this, MyArrList, R.layout.activity_column_dasboard,
            new String[] {"์Name", "Id card", "PhoneNumber","Province","E-Mail"}, new int[] {R.id.Name, R.id.Id_card, R.id.PhoneNumber,R.id.Province,R.id.E_Mail})
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

        DasboardActivity_Adapter MenuAdapter=new DasboardActivity_Adapter(DasboardActivity.this,
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


