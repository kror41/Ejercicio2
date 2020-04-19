package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String imgdefault = "C:\\Users\\Clara Elena Rivera\\AndroidStudioProjects\\Ejercicio2\\app\\src\\main\\res\\mipmap-hdpi\\usuario.jpg";
   Persona objPersona = new Persona();
   TextView personatxt;
   ListView listaLV;
   ImageView imgV;
   ListAdapterPersona lista;
   ArrayList<Persona> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //personatxt = (TextView)findViewById(R.id.personaid);
        listaLV = (ListView)findViewById(R.id.list_id);
        //imgV = (ImageView)findViewById(R.id.id_img);
        // String n = objPersona.getNombrePersona();
       // String d = objPersona.getDescripcion();
       // String i = objPersona.getImg();
        int imgusuario = R.drawable.usuario;

        //final ArrayList<Persona> arrayList = new ArrayList<Persona>();

        //arrayList.add(objPersona);
        //arrayList.add(new Persona(R.drawable.usuario,"Pen2","Contable", "No imagen"));

        //ArrayAdapter<Persona> arrayAdapter = new ArrayAdapter<Persona>(MainActivity.this,android.R.layout.simple_list_item_1,arrayList);
        //listaLV.setAdapter(arrayAdapter);
        //personatxt.setText("Hola "+n+" Cargo: "+d+" imagen: "+i);

        this.lista = new ListAdapterPersona(this,this.getArrayListPerson());
        //Persona p = new Persona(R.mipmap.usuario,"Pen","Contador","Si img");
        //arrayList.add(p);
        listaLV.setAdapter(this.lista);



        listaLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Persona p = getArrayListPerson().get(position);
                //Toast.makeText(MainActivity.this,"imagen: "+p.getImg2()+" "+" Nombre "+p.getNombrePersona()+" \n imagen: "+p.getImg(),Toast.LENGTH_SHORT).show();

                //switch (position){
                    switch (position){

                        case 0:
                            Intent newActivity = new Intent(MainActivity.this,PersonActivity0.class);
                            startActivity(newActivity);

                            //Toast.makeText(MainActivity.this,"imagen: "
                              //      +p.getImg2()+" "+" Nombre "+p.getNombrePersona()+" \n imagen: "+p.getImg(),Toast.LENGTH_SHORT).show();
                            break;
                        case 1:


                            Intent newActivity2 = new Intent(MainActivity.this,PersonActivity1.class);

                            startActivity(newActivity2);
                            break;
                        case 2:
                            Intent newActivity3 = new Intent(MainActivity.this,PersonActivity2.class);
                            startActivity(newActivity3);
                            break;
                        case 3:
                            Intent newActivityConfigura = new Intent(MainActivity.this, ColorPickerActivityWin.class);
                            startActivity(newActivityConfigura);
                        default:
                    }
                //}

            }
        });
    }
    private ArrayList<Persona> getArrayListPerson() {

        ArrayList<Persona> arrayList = new ArrayList<>();
        SharedPreferences p = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        String imagen0 = p.getString("Paulusimg", null);
        String imagen1 = p.getString("Julioimg",null);
        String imagen2 = p.getString("Kirlianimg", null);

        if (imagen0 != null){
            arrayList.add(new Persona(imagen0, "Pen2", "Contable"));
        }else{
            arrayList.add(new Persona(R.mipmap.usuario, "Pen2", "Contable"));
        }

        if (imagen1 != null){
            arrayList.add(new Persona(imagen1, "Pen2", "Contable"));
        }else{
            arrayList.add(new Persona(R.mipmap.usuario, "Pen2", "Contable"));
        }

        if (imagen2 != null){
            arrayList.add(new Persona(imagen2, "Pen2", "Contable"));
        }else{
            arrayList.add(new Persona(R.mipmap.usuario, "Pen2", "Contable"));
        }
        arrayList.add(new Persona(R.mipmap.config2, "Pen2", "Contable"));

        return arrayList;
    }



}
