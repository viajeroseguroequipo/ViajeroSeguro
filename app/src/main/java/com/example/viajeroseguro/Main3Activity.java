package com.example.viajeroseguro;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private TextView tvi1;
    private ListView tvv1;


    private  String  lista  [] = {"Cedula de Extranjeria "+
            " " ,
            "Duplicado de Cedula Extranjeria " +
                    " " ,
            "Registro  de  Extranjero Menor a 7 Años " +
                    " " };
    private  String  opciones  [] = {"Documento de Identificación expedido por Migración Colombia, que se otorga a los extranjeros titulares " +
            " \n" + " de una visa superior a 3 meses.\n" +
            "\n" +
            "Requisitos:\n" +
            "\n" +
            "Pasaporte original.\n" +
            "Fotocopia de la página con los datos biográficos del pasaporte.\n" +
            "Original de la visa vigente.\n" +
            "Diligenciar el Formulario Único de Trámites a través de la página web de Migración Colombia.\n" +
            "Recibo del Pago por expedición de Cédula de extranjería.", "Requisitos:\n" +
            "\n" +
            "• Pasaporte original.\n" +
            "• Fotocopia de la página con los datos biográficos del pasaporte. \n" +
            "• Original de la visa vigente.\n" +
            "• Diligenciar el Formulario Único de Trámites a través de la página web de Migración Colombia.\n" +
            "• Recibo del Pago por Duplicado de Cédula.","Requisitos:\n" +
            "\n" +
            "Original del pasaporte y visa del titular de la Cédula de Extranjería.\n" +
            "Diligenciar el Formulario Único de Trámites a través de la página web de Migración Colombia."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvi1=(TextView)findViewById(R.id.tvi1);
        tvv1=(ListView)findViewById(R.id.tvv1);

        ArrayAdapter <String>  adapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, lista);
        tvv1.setAdapter(adapter);


        tvv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                tvi1.setText(tvv1.getItemAtPosition(i)  +opciones[i] );
            }
        });

    }




    //Método para el botón Anterior
    public void Anterior(View view){
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }
}
