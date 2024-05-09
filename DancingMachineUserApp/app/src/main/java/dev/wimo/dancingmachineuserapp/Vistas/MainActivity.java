package dev.wimo.dancingmachineuserapp.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import dev.wimo.dancingmachineuserapp.Modelo.ModeloPartida;
import dev.wimo.dancingmachineuserapp.R;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<ModeloPartida> itemsAdapter;
//    applicationPartida app;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}