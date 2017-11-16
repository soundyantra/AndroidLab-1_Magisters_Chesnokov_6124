package com.example.sound.laba1;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.DrawerLayout;
import android.widget.*;
import android.view.*;
import java.util.ArrayList;
import java.util.List;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Color;


public class activity_test extends Activity {
    String name;
    String info;
    String img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String info = intent.getStringExtra("info");
        String img = intent.getStringExtra("img");

        //ImageView image = (ImageView) findViewById(R.id.imageView4);
        TextInputLayout nameview = (TextInputLayout) findViewById(R.id.textInputLayout2);
        TextInputLayout infoview = (TextInputLayout) findViewById(R.id.textInputLayout3);


        nameview.getEditText().setText(name);
        infoview.getEditText().setText(info);

        //int resID = getResources().getIdentifier(img , "drawable", getPackageName());

        //image.setImageResource(resID);


    }

    @Override
    public void onResume(){
        super.onResume();
        setContentView(R.layout.activity_test);
        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String info = intent.getStringExtra("info");
        String img = intent.getStringExtra("img");

        //ImageView image = (ImageView) findViewById(R.id.imageView4);
        TextInputLayout nameview = (TextInputLayout) findViewById(R.id.textInputLayout2);
        TextInputLayout infoview = (TextInputLayout) findViewById(R.id.textInputLayout3);


        nameview.getEditText().setText(name);
        infoview.getEditText().setText(info);

    }

    public void onMyButtonClick(View view)
    {
        // выводим сообщение
        //Toast.makeText(this, R.string.ChangesYes, Toast.LENGTH_SHORT).show();
        finish();
    }

}
