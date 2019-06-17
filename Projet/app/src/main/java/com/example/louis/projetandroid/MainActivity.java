package com.example.louis.projetandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Connect(View v)
    {
        EditText edtTxt1 = (EditText) findViewById(R.id.edtTxt1);
        EditText edtTxt2 = (EditText) findViewById(R.id.edtTxt2);

        String monNom = edtTxt1.getText().toString();
        String monMdp = edtTxt2.getText().toString();

        if((monNom.equals("Louis")) && (monMdp.equals("abc")))
        {
            startActivity(new Intent(this, Vue2.class));
        }
        else
        {
            Toast.makeText(this, "Erreur de connexion...", Toast.LENGTH_LONG).show();
        }

    }
}
