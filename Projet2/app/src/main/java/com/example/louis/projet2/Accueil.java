package com.example.louis.projet2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.louis.projet2.R;

public class Accueil extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);
    }

    public void Connect(View v)
    {
        EditText edtTxt1 = (EditText) findViewById(R.id.edtTxt1);
        EditText edtTxt2 = (EditText) findViewById(R.id.edtTxt2);

        String monNom = edtTxt1.getText().toString();
        String monMdp = edtTxt2.getText().toString();

        if((monNom.equals("Louis")) && (monMdp.equals("abc")) ||
                (monNom.equals("Jerem")) && (monMdp.equals("abc")) ||
                (monNom.equals("Clement")) && (monMdp.equals("abc")) ||
                (monNom.equals("Anthony")) && (monMdp.equals("abc")))
        {
            startActivity(new Intent(this, MapsActivity.class));
        }
        else
        {
            Toast.makeText(this, "Erreur de connexion...", Toast.LENGTH_LONG).show();
        }

    }
}
