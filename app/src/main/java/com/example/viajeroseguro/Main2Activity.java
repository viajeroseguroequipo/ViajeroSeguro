package com.example.viajeroseguro;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.widget.Button;

//Main2Activity
public class Main2Activity extends AppCompatActivity implements View.OnClickListener, f1.OnFragmentInteractionListener, f2.OnFragmentInteractionListener, f3.OnFragmentInteractionListener, f4.OnFragmentInteractionListener{


    Button  fr1, fr2, fr3, fr4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //PONER LOGO//

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        f1 fragmento1 = new f1();
        f2 fragmento2 = new f2();
        f3 fragmento3 = new f3();
        f4 fragmento4 = new f4();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor, fragmento1);
        fr1 = (Button)findViewById(R.id.fr1);
        fr2 = (Button)findViewById(R.id.fr2);
        fr3 = (Button)findViewById(R.id.fr3);
         fr4 = (Button)findViewById(R.id.fr4);


        fr1.setOnClickListener(this);
        fr2.setOnClickListener(this);
        fr3.setOnClickListener(this);
        fr4.setOnClickListener(this);

    }




    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.fr1:
                f1 fragmento1 = new f1();
                FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
                transition.replace(R.id.contenedor, fragmento1);
                transition.commit();

                break;

            case R.id.fr2:
                f2 fragmento2 = new f2();
                FragmentTransaction transition1 = getSupportFragmentManager().beginTransaction();
                transition1.replace(R.id.contenedor, fragmento2);
                transition1.commit();

                break;

            case R.id.fr3:
                f3 fragmento3 = new f3();
                FragmentTransaction transition2 = getSupportFragmentManager().beginTransaction();
                transition2.replace(R.id.contenedor, fragmento3);
                transition2.commit();

                break;

            case R.id.fr4:
                f4 fragmento4 = new f4();
                FragmentTransaction transition3 = getSupportFragmentManager().beginTransaction();
                transition3.replace(R.id.contenedor, fragmento4);
                transition3.commit();

                break;

        }
    }


    //Método para el botón Anterior
    public void Anterior(View view){
        Intent anterior = new Intent(this, Main5Activity.class);
        startActivity(anterior);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
