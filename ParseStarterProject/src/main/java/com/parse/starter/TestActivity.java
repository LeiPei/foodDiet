package com.parse.starter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseUser;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        TextView tv = (TextView)findViewById(R.id.tv_name);
        if(ParseUser.getCurrentUser() != null) {  // which means the user is logged in
            // Log.i("currentUser", "User logged in " + ParseUser.getCurrentUser().getUsername());
            tv.setText("User logged in as " + ParseUser.getCurrentUser().getUsername());
        } else {
            Toast.makeText(this, "Fail to login", Toast.LENGTH_LONG).show();
        }
    }
}
