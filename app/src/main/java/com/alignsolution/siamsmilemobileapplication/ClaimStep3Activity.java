package com.alignsolution.siamsmilemobileapplication;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alignsolution.siamsmilemobileapplication.Adapter.ClaimStep2Activity_Adapter;
import com.alignsolution.siamsmilemobileapplication.Adapter.ClaimStep3Activity_Adapter;
import com.alignsolution.siamsmilemobileapplication.Biz.MenuMGR;

/**
 * Created by aligndev on 18-Apr-17.
 */

public class ClaimStep3Activity extends AppCompatActivity  implements AdapterView.OnItemClickListener {
    private DrawerLayout drawerLayout;
    private ListView listView;
    private   String[] planets;
    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    MenuMGR menuMGR = new MenuMGR();
    ListView list1;
    private FloatingActionButton fab;

    //calendate
    private TextView Output;
    private ImageButton changeDate;

    private int year;
    private int month;
    private int day;

    static final int DATE_PICKER_ID = 1111;


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


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claim_step_3);
        try{
        SetMenu();

        ClaimStep3Activity_Adapter adapter1=new ClaimStep3Activity_Adapter(ClaimStep3Activity.this,
                itemname, arrImg);
        list1=(ListView)findViewById(R.id.drawerList);
        list1.setAdapter(adapter1);

        //  Header  TooBar  image and icon
        getSupportActionBar().setDisplayOptions(getSupportActionBar().getDisplayOptions()
                | ActionBar.DISPLAY_SHOW_CUSTOM);
        ImageView imageView = new ImageView(getSupportActionBar().getThemedContext());
        getSupportActionBar().setCustomView(R.layout.activity_header);



        Button cmd = (Button) findViewById(R.id.button28);
        cmd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it2 = new Intent(getBaseContext(),ClaimCustomerAcitivity.class);
                startActivity(it2);
            }
        });
        Button cmd3 = (Button) findViewById(R.id.button53);
        cmd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it3 = new Intent(getBaseContext(),Activity_SignName_PopUp.class);
                startActivity(it3);
            }
        });

              // date pickers
            Output = (TextView) findViewById(R.id.Output2);
            changeDate = (ImageButton) findViewById(R.id.changcalendar);

            // Get current date by calender
            final Calendar c = Calendar.getInstance();
            year  = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day   = c.get(Calendar.DAY_OF_MONTH);

            // Show current date
            Output.setText(new StringBuilder()
                    // Month is 0 based, just add 1
                    .append(day).append("/").append(month + 1).append("/")
                    .append(year).append(" "));
            // ImageButton listener to show date picker dialog
            changeDate.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    // On button click show datepicker dialog
                    showDialog(DATE_PICKER_ID);

                }

            });



        }catch (Exception e){}
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_PICKER_ID:

                // open datepicker dialog.
                // set date picker for current date
                // add pickerListener listner to date picker
                return new DatePickerDialog(this, pickerListener, year, month,day);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        @Override
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {

            year  = selectedYear;
            month = selectedMonth;
            day   = selectedDay;

            // Show selected date
            Output.setText(new StringBuilder()
                    .append(day).append("/").append(month + 1).append("/").append(year)
                    .append(" "));

        }
    };



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
