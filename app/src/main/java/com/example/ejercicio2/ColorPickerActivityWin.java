package com.example.ejercicio2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker_win);

        layout = (LinearLayout)findViewById(R.id.layoutColor);
        button_select_bg=(Button)findViewById(R.id.color_id_select);
        atras_id=(Button)findViewById(R.id.atras_id);
        button_select_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionMenu();
            }
        });
        txt_nombre = (TextView)findViewById(R.id.nombre_id);
        txt_matric = (TextView)findViewById(R.id.matric_id);
        txt_ciudad = (TextView)findViewById(R.id.ciudad_id);
        txt_dec    = (TextView)findViewById(R.id.desc_id);
        txt_creative = (TextView)findViewById(R.id.creative_id);
        imageView = (ImageView)findViewById(R.id.img_details);

        Bundle details= this.getIntent().getExtras();

        txt_nombre.setText(details.getString("Nombre"));
        txt_dec.setText(details.getString("Desc"));
        imageView.setImageResource(details.getInt("img2"));


        atras_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent atras = new Intent(ColorPickerActivityWin.this, MainActivity.class);
                startActivity(atras);
            }
        });
    }

    public void selectPColor(){


        final ColorPicker colorPicker = new ColorPicker(this);
        ArrayList<String> color = new ArrayList<>();
        color.add("#D32F2F");
        color.add("#FF4081");
        color.add("#03A9F4");
        color.add("#536dfe");

        colorPicker.setColors(color).setColumns(5).setRoundColorButton(true).setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
            @Override
            public void onChooseColor(int position, int color) {
                layout.setBackgroundColor(color);
            }

            @Override
            public void onCancel() {

            }
        }).show();

    }
    public void optionMenu(){
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
                }else{
                    alertDialog.dismiss();
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
            Uri path = data.getData();
            imageView.setImageURI(path);
        }

    }
}
