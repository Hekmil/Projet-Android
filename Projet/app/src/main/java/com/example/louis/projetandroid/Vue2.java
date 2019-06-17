package com.example.louis.projetandroid;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Vue2 extends AppCompatActivity
{


    public void Refresh(View v)
    {
        TextView txtv3 = (TextView)findViewById(R.id.txtv3);

        String maPosition = "";



        txtv3.setText(maPosition);

    }
}