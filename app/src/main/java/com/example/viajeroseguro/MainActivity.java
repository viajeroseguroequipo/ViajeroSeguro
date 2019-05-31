package com.example.viajeroseguro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //PONER LOGO//

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }


    public void Siguiente(View view)  {

        Intent siguiente = new Intent(this, Main2Activity.class);
        startActivity(siguiente);
    }

    public void Tramite(View viewt)  {

        Intent tramite = new Intent(this, Main3Activity.class);
        startActivity(tramite);
    }
}
