/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  Boolean  signUpModeActive = true;
  TextView ev_changeSignUpMode;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // test if user has logged in
    /*
    ParseUser.logOut();

    if(ParseUser.getCurrentUser() != null) {  // which means the user is logged in
      Log.i("currentUser", "User logged in " + ParseUser.getCurrentUser().getUsername());
    } else {
      Log.i("currentUser", "User not logged in");
    }
    */

    ev_changeSignUpMode = (TextView)findViewById(R.id.tv_changeupToIn);
    ev_changeSignUpMode.setOnClickListener(this);

    // test for wrong password or username
    /*
    ParseUser.logInInBackground("LeiPei", "123456", new LogInCallback() {
      @Override
      public void done(ParseUser user, ParseException e) {
        if(user != null) {
          Log.i("Login", "Successful");
        } else {
          Log.i("Login", "Failed: " + e.toString());
        }

      }
    });
    */


    /*
    ParseUser user = new ParseUser();
    user.setUsername("LeiPei");
    user.setPassword("password");

    user.signUpInBackground(new SignUpCallback() {
      @Override
      public void done(ParseException e) {
        if(e == null) {
          Log.i("Sign Up", "Successful");
        } else {
          Log.i("Sign up", "Failed");
        }
      }
    });
    */
    
    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

  public void signUp(View v) {
    EditText et_username = (EditText)findViewById(R.id.et_username);
    EditText et_password = (EditText)findViewById(R.id.et_password);

    // check if they are blank
    if(TextUtils.isEmpty(et_username.getText().toString()) || TextUtils.isEmpty(et_password.getText().toString())) {
      Toast.makeText(this, "A username or password are required.", Toast.LENGTH_LONG).show();
    } else {
      // check if it is in sign up mode
      if(signUpModeActive) {
        // now sign user up
        ParseUser user = new ParseUser();
        user.setUsername(et_username.getText().toString());
        user.setPassword(et_password.getText().toString());
        user.signUpInBackground(new SignUpCallback() {
          @Override
          public void done(ParseException e) {
            if(e == null) {
              Log.i("Signup", "Successful");
            } else {
              Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
          }
        });
      } else {
        // now login our user
        ParseUser.logInInBackground(et_username.getText().toString(), et_password.getText().toString(), new LogInCallback() {
          @Override
          public void done(ParseUser user, ParseException e) {
            if(user != null) {
              Log.i("Login", "Login successful");
              Intent intent = new Intent(MainActivity.this, TestActivity.class);
              startActivity(intent);
            } else {
              Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }

          }
        });
      }
    }
  }

  @Override
  public void onClick(View v) {
    if(v.getId() == R.id.tv_changeupToIn) {
      Button btn_signup = (Button)findViewById(R.id.btn_signup);
      if(signUpModeActive) {
        signUpModeActive = false;
        btn_signup.setText("Log in");
        ev_changeSignUpMode.setText("Or, Signup");
      } else {
        signUpModeActive = true;
        btn_signup.setText("Sign up");
        ev_changeSignUpMode.setText("Or, Login");
      }
    }
  }
}