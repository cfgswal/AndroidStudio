package com.rawals.conversorbytes;




import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import android.widget.ArrayAdapter;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    Spinner sp1;
    Spinner sp2;

    ArrayAdapter<String> adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
setTitle("Conversor Bytes 1/2");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
// XML
        // ----------------------------------------------------------------------------------------

        // Creamos el adaptador partiendo de un archivo de recursos
        final ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this
                ,R.array.bytes_array
                , android.R.layout.simple_spinner_item
        );
        //adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Conectamos el adaptador al control
        sp1 = (Spinner) findViewById(R.id.spinner1);
        sp1.setAdapter(adapter1);

        // Evento del Spinner
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(view, "Has seleccionado el " + position, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // ArrayAdapter
        // ----------------------------------------------------------------------------------------

        // Array de String que contiene los datos
        String[] bytes = { "Bytes","Kilobytes","Megabytes" };

        // Creamos el adaptador partiendo del array
        adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bytes);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Conectamos el adaptador al control
        sp2 = (Spinner) findViewById(R.id.spinner2);
        sp2.setAdapter(adapter2);



        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /*//Recogemos valor del radiogroup1
                RadioGroup grupo = (RadioGroup) findViewById(R.id.radioGroup);
                int valor = grupo.indexOfChild(grupo.findViewById(grupo.getCheckedRadioButtonId()));

                //Recogemos valor del radiogroup2
                RadioGroup grupo2 = (RadioGroup) findViewById(R.id.radioGroup2);
                int valor2 = grupo2.indexOfChild(grupo2.findViewById(grupo2.getCheckedRadioButtonId()));
*/
                EditText et1 = (EditText) findViewById(R.id.editText);
                int n = 0;

                try{
                    //Recogemos valor del texto
                    n = Integer.parseInt(et1.getText().toString());
                }catch (NumberFormatException e){


                }
                // Creamos el Intent
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);

                // Cargamos los datos en el Intent
                i.putExtra("DATO", n);
               // i.putExtra("VALOR", valor);
                //i.putExtra("VALOR2", valor2);
                i.putExtra("VALOR", sp1.getSelectedItemPosition());
                i.putExtra("VALOR2", sp2.getSelectedItemPosition());

                // Arrancar la actividad
                startActivity(i);
            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.rawals.conversorbytes/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.rawals.conversorbytes/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
