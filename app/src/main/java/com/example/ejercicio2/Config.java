package com.example.ejercicio2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Config extends AppCompatActivity {

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
                            Intent newActivity = new Intent(Config.this,PersonActivity1.class);
                            startActivity(newActivity);

                            //Toast.makeText(MainActivity.this,"imagen: "
                              //      +p.getImg2()+" "+" Nombre "+p.getNombrePersona()+" \n imagen: "+p.getImg(),Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            p.getNombrePersona();
                            p.getImg();
                            p.getImg2();
                            p.getDescripcion();

                            Bundle enviarDato= new Bundle();
                            enviarDato.putString("Nombre",p.getNombrePersona());
                            enviarDato.putString("Img",p.getImg());
                            enviarDato.putString("Desc",p.getDescripcion());
                            enviarDato.putInt("img2",p.getImg2());

                            Intent newActivity2 = new Intent(Config.this,ColorPickerActivityWin.class);
                            newActivity2.putExtras(enviarDato);

                            startActivity(newActivity2);
                            break;
                        case 2:
                            Intent newActivity3 = new Intent(Config.this,PersonActivity0.class);
                            startActivity(newActivity3);
                            break;
                        case 3:
                            Intent newActivityConfigura = new Intent(Config.this, ColorPickerActivityWin.class);
                            startActivity(newActivityConfigura);
                            break;
                        default:
                    }
                //}

            }
        });
    }
    private ArrayList<Persona> getArrayListPerson(){

        ArrayList<Persona> arrayList = new ArrayList<>();

        objPersona.setNombrePersona("Pen");
        objPersona.setDescripcion("Es un contrador");
        objPersona.setImg("no imagen");
        objPersona.setImg2(R.mipmap.usuario);

        arrayList.add(objPersona);
        arrayList.add(new Persona(R.mipmap.usuario,"Pen2","Contable", "No imagen"));
        arrayList.add(new Persona(R.mipmap.usuario,"Persons","Jefe","no imagen"));
        arrayList.add(new Persona(R.mipmap.usuario,"Config","usuario","configuracion"));
        return arrayList;
    }
}
