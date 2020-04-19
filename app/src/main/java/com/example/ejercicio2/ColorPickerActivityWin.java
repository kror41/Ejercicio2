package com.example.ejercicio2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.Charset;
import java.util.ArrayList;

import petrov.kristiyan.colorpicker.ColorPicker;

public class ColorPickerActivityWin extends AppCompatActivity {


    AlertDialog alertDialog;
    LinearLayout layout;
    Button button_select_bg;
    Button atras_id;
    TextView txt_nombre;
    TextView txt_matric;
    TextView txt_dec;
    TextView txt_ciudad;
    TextView txt_creative;
    ImageView imageView;
    ListView listaLV;

    ListAdapterPersona lista;
    ArrayList<Persona> arrayList = new ArrayList<>();
    Persona objPersona = new Persona();
    public static final String SHARED_PREF = "sharedPrefs";
    public static final String FOTO = "foto";
    public static final String COLOR = "color";

    public String idPreferencia = "";

    Uri uriF;
    String codigo;
    String resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker_win);

        layout = (LinearLayout)findViewById(R.id.layoutColor);
        button_select_bg=(Button)findViewById(R.id.color_id_select);
        atras_id=(Button)findViewById(R.id.atras_id);
        listaLV = (ListView)findViewById(R.id.lv_config);
        button_select_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //optionMenu();
            }
        });



        this.lista = new ListAdapterPersona(this,this.getArrayListPerson());

        listaLV.setAdapter(this.lista);



        listaLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                switch (position){

                    case 0:
                        optionMenu("Paulus");
                        //selectPColor("Paulus");
                        break;
                    case 1:



                        optionMenu("Julio");
                        //selectPColor("Julio");

                        break;
                    case 2:

                        optionMenu("Kirlian");
                        //selectPColor("Kirlian");
                        break;
                    default:
                }


            }
        });

        atras_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent atras = new Intent(ColorPickerActivityWin.this, MainActivity.class);
                startActivity(atras);
            }
        });
    }

    public void selectPColor(final String idPersona){


        final ColorPicker colorPicker = new ColorPicker(this);
        ArrayList<String> color = new ArrayList<>();

        color.add("#D32F2F");
        color.add("#FF4081");
        color.add("#03A9F4");
        color.add("#536dfe");

        colorPicker.setColors(color).setColumns(5).setRoundColorButton(true).setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
            @Override
            public void onChooseColor(int position, int color) {


                SharedPreferences preferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putInt(idPreferencia+"color",color);
                editor.commit();

            }

            @Override
            public void onCancel() {

            }
        }).show();

    }


    public void optionMenu(String idPersona){
        idPreferencia = idPersona;
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final CharSequence[] optionUsuario = {"Tomar Foto","Cargar Foto","Cambiar bgcolor"};

        builder.setTitle("Usuario").setItems(optionUsuario, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if(optionUsuario[i].equals("Tomar Foto")){
                    Toast.makeText(ColorPickerActivityWin.this,optionUsuario[i].toString(),Toast.LENGTH_SHORT).show();
                }else if(optionUsuario[i].equals("Cargar Foto")){

                    loadImage();


                    Toast.makeText(ColorPickerActivityWin.this,optionUsuario[i].toString(),Toast.LENGTH_SHORT).show();
                }else if(optionUsuario[i].equals("Cambiar bgcolor")){
                    selectPColor(idPreferencia);
                }

            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }
    public void loadImage(){

        Intent intentImg = new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intentImg.setType("image/");
        startActivityForResult(intentImg.createChooser(intentImg,"Seleccionar imagen"),10);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);


        if(resultCode==RESULT_OK){

            Uri uriImg = data.getData();
            SharedPreferences preferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();

            editor.putString(idPreferencia+"img",String.valueOf(uriImg));
            editor.commit();

        }

    }
    private ArrayList<Persona> getArrayListPerson(){

        ArrayList<Persona> arrayList = new ArrayList<>();

        SharedPreferences p = getSharedPreferences("sharedPrefs",MODE_PRIVATE);
        String imagen0 = p.getString("Paulusimg",null);
        String imagen1 = p.getString("Julioimg",null);
        String imagen2 = p.getString("Kirlianimg",null);

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

        return arrayList;
    }

}
