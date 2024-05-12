package Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import Modelo.ModeloPartida;
import dev.wimo.dancingmachineuserapp.R;
import Application.applicationPartida;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<ModeloPartida> itemsAdapter;
    applicationPartida app;

    private static final int SHOW_SUBACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);
        app =(applicationPartida) getApplicationContext();
        itemsAdapter = new ArrayAdapter<ModeloPartida>(this,R.layout.row_layout,R.id.listText,app.getHistorico());
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                app.setActual(position);
                Intent intent = new Intent(getApplicationContext(), InfoPartida.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    public void onClick(View view){
        app.resetActual();
        Intent intent = new Intent(getApplicationContext(), CrearPartida.class);
        startActivityForResult(intent, 1);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        listView = (ListView) findViewById(R.id.list);
        app =(applicationPartida) getApplicationContext();
        itemsAdapter = new ArrayAdapter<ModeloPartida>(this,R.layout.row_layout,R.id.listText,app.getHistorico());
        listView.setAdapter(itemsAdapter);
    }
}