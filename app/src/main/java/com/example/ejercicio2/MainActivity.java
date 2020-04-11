package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   Persona objPersona = new Persona();
   TextView personatxt;
   ListView listaLV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        objPersona.setNombrePersona("Pen");
        objPersona.setDescripcion("Es un contrador");
        objPersona.setImg("no imagen");

        //personatxt = (TextView)findViewById(R.id.personaid);
        listaLV = (ListView)findViewById(R.id.list_id);
        String n = objPersona.getNombrePersona();
        String d = objPersona.getDescripcion();
        String i = objPersona.getImg();

        final ArrayList<Persona> arrayList = new ArrayList<Persona>();

        arrayList.add(objPersona);
        arrayList.add(new Persona("Pen2","Contable", "No imagen"));

        ArrayAdapter<Persona> arrayAdapter = new ArrayAdapter<Persona>(MainActivity.this,android.R.layout.simple_list_item_1,arrayList);
        listaLV.setAdapter(arrayAdapter);
        //personatxt.setText("Hola "+n+" Cargo: "+d+" imagen: "+i);

        listaLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Persona persona = arrayList.get(position);

                Toast.makeText(MainActivity.this," Nombre: "+persona.getNombrePersona()+"\n Descipcion:"+persona.getDescripcion()+" imagen:"+persona.getImg(),Toast.LENGTH_SHORT).show();


            }
        });
    }
}
