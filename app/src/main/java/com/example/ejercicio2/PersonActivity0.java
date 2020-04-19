package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PersonActivity0 extends AppCompatActivity {

    Button back_button;
    public static final String SHARED_PREF = "sharedPrefs";
    public static  final String TAG = PersonActivity0.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person0);

        back_button=(Button)findViewById(R.id.atras_btn0);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent atras=new Intent(PersonActivity0.this,MainActivity.class);
                startActivity(atras);
            }
        });

        Persona persona0 = new Persona();
        persona0.setNombrePersona("Pedro");
        persona0.setImg2(R.drawable.usuario);
        persona0.setCiudad_de_nacimiento("Cualquiera");
        persona0.setMatricula("DC-0000");
        persona0.setExpresion("No se lo que va aqui");

        TextView tv_nombre = (TextView)findViewById(R.id.id_nombre0);
        tv_nombre.setText(persona0.getNombrePersona());

        TextView tv_Ciudad_de_nacmiento = (TextView)findViewById(R.id.tvNacimiento0);
        tv_Ciudad_de_nacmiento.setText(persona0.getCiudad_de_nacimiento());

        TextView tv_Matricula = (TextView)findViewById(R.id.tvMatricula0);
        tv_Matricula.setText(persona0.getMatricula());

        TextView tv_Expresion = (TextView)findViewById(R.id.tvExpresion0);
        tv_Expresion.setText(persona0.getExpresion());

        ImageView imageView = (ImageView)findViewById(R.id.id_img0);
        LinearLayout layout = (LinearLayout)findViewById(R.id.layout0);

        SharedPreferences p = getSharedPreferences("sharedPrefs",MODE_PRIVATE);
        String imagen = p.getString("Paulusimg",null);
        //Log.i(TAG,imagen);
        if(imagen != null) {
            imageView.setImageURI(Uri.parse(imagen));
        }

        int bg_color = p.getInt("Pauluscolor",0);
        layout.setBackgroundColor(bg_color);
    }
}
