package com.peilei.fooddiet1;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //btn_bf = (ImageButton) findViewById(R.id.btn_bf);

        /*
        //find four btns
        ImageButton btn_bf = (ImageButton) findViewById(R.id.btn_main_bf);
        ImageButton btn_lunch = (ImageButton) findViewById(R.id.btn_main_lunch);
        ImageButton btn_dinner = (ImageButton) findViewById(R.id.btn_main_dinner);
        ImageButton btn_exe = (ImageButton) findViewById(R.id.btn_main_exe);

        // set onclick events
        btn_bf.setOnClickListener(this);
        btn_lunch.setOnClickListener(this);
        btn_dinner.setOnClickListener(this);
        btn_exe.setOnClickListener(this);
        */
    }


    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();

        // which btn is clicked
        switch (view.getId()) {
            case R.id.btn_main_bf :
                beginTransaction.replace(R.id.ll_layout, new Breakfast_Fragment());
                break;

            case R.id.btn_main_lunch :
                beginTransaction.replace(R.id.ll_layout, new Lunch_Fragment());
                break;

            case R.id.btn_main_dinner :
                beginTransaction.replace(R.id.ll_layout, new Dinner_Fragment());
                break;

            case R.id.btn_main_exe :
                beginTransaction.replace(R.id.ll_layout, new Exercise_Fragment());
                break;
        }

        beginTransaction.commit();
    }
}
