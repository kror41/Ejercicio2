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

public class PersonActivity1 extends AppCompatActivity {

    Button atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person1);

        atras=(Button)findViewById(R.id.atras_btn1);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent atras=new Intent(PersonActivity1.this,MainActivity.class);
                startActivity(atras);
            }
        });

        Persona persona1 = new Persona();
        persona1.setNombrePersona("Pedro");
        persona1.setImg2(R.drawable.usuario);
        persona1.setCiudad_de_nacimiento("Cualquiera");
        persona1.setMatricula("DC-0000");
        persona1.setExpresion("No se lo que va aqui");

        TextView tv_nombre = (TextView)findViewById(R.id.id_nombre1);
        tv_nombre.setText(persona1.getNombrePersona());

        TextView tv_Ciudad_de_nacmiento = (TextView)findViewById(R.id.tvNacimiento1);
        tv_Ciudad_de_nacmiento.setText(persona1.getCiudad_de_nacimiento());

        TextView tv_Matricula = (TextView)findViewById(R.id.tvMatricula1);
        tv_Matricula.setText(persona1.getMatricula());

        TextView tv_Expresion = (TextView)findViewById(R.id.tvExpresion1);
        tv_Expresion.setText(persona1.getExpresion());

        ImageView imageView = (ImageView)findViewById(R.id.id_img1);
        LinearLayout layout = (LinearLayout)findViewById(R.id.layout1);

        SharedPreferences p = getSharedPreferences("sharedPrefs",MODE_PRIVATE);
        String imagen = p.getString("Julioimg",null);
        //Log.i(TAG,imagen);
        if(imagen != null) {
            imageView.setImageURI(Uri.parse(imagen));
        }

        int bg_color = p.getInt("Juliocolor",0);
        layout.setBackgroundColor(bg_color);
    }
}
