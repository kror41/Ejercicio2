package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PersonActivity2 extends AppCompatActivity {
    Button atras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person2);
        atras=(Button)findViewById(R.id.atras_btn2);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent atras=new Intent(PersonActivity2.this,MainActivity.class);
                startActivity(atras);
            }
        });



        Persona persona2 = new Persona();
        persona2.setNombrePersona("Kirlian Ortiz");
        persona2.setImg2(R.drawable.usuario);
        persona2.setCiudad_de_nacimiento("Santo Domingo, Rep. Dom.");
        persona2.setMatricula("CG4780");
        persona2.setExpresion("Lic. En Informatica");

        TextView tv_nombre = (TextView)findViewById(R.id.id_nombre2);
        tv_nombre.setText(persona2.getNombrePersona());

        TextView tv_Ciudad_de_nacmiento = (TextView)findViewById(R.id.tvNacimiento2);
        tv_Ciudad_de_nacmiento.setText(persona2.getCiudad_de_nacimiento());

        TextView tv_Matricula = (TextView)findViewById(R.id.tvMatricula2);
        tv_Matricula.setText(persona2.getMatricula());

        TextView tv_Expresion = (TextView)findViewById(R.id.tvExpresion2);
        tv_Expresion.setText(persona2.getExpresion());

        ImageView imageView = (ImageView)findViewById(R.id.id_img2);
        LinearLayout layout = (LinearLayout)findViewById(R.id.layout2);

        SharedPreferences p = getSharedPreferences("sharedPrefs",MODE_PRIVATE);
        String imagen = p.getString("Kirlianimg",null);
        //Log.i(TAG,imagen);
        if(imagen != null) {
            imageView.setImageURI(Uri.parse(imagen));
        }

        int bg_color = p.getInt("Kirliancolor",0);
        layout.setBackgroundColor(bg_color);
    }
}
