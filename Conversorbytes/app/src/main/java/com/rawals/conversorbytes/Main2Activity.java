package com.rawals.conversorbytes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Conversor Bytes 2/2");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Recoger el dato que nos llega en el Intent
        double dato = 0;
        int valor = 0;
        int valor2 = 0;
        double total = 0;
        String texto1 = "";
        String texto2 = "";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {   // Hay que asegurarse de que existe
            dato = extras.getInt("DATO");
            valor = extras.getInt("VALOR");
            valor2 = extras.getInt("VALOR2");
        }

        if (valor == 0 && valor2==0) {
            total = dato;
            texto1 = " bytes";
            texto2 = " bytes";

        }else if (valor == 0 && valor2==1) {
            total = dato / 1024;
            texto1 = " bytes";
            texto2 = " kilobytes";

        }else if (valor == 0 && valor2==2) {
            total = (dato / 1024) / 1024;
            texto1 = " bytes";
            texto2 = " megabytes";

        }else if (valor == 1 && valor2==0) {
            total = dato * 1024;
            texto1 = " kilobytes";
            texto2 = " bytes";

        }else if (valor == 1 && valor2==1) {
            total = dato;
            texto1 = " kilobytes";
            texto2 = " kilobytes";

        }else if (valor == 1 && valor2==2) {
            total = dato / 1024;
            texto1 = " kilobytes";
            texto2 = " megabytes";

        }else if (valor == 2 && valor2==0) {
            total = dato * 1024 * 1024;
            texto1 = " megabytes";
            texto2 = " bytes";

        }else if (valor == 2 && valor2==1) {
            total = dato * 1024;
            texto1 = " megabytes";
            texto2 = " kilobytes";

        }else if (valor == 2 && valor2==2) {
            total = dato;
            texto1 = " megabytes";
            texto2 = " megabytes";

        }

        // Mostramos el dato en el interfaz
        TextView tv = (TextView) findViewById(R.id.textView4);
        tv.setText(dato + " " +texto1 +" son " + total + " " + texto2);


    }
}


