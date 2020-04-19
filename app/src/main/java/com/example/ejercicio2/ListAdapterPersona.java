package com.example.ejercicio2;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListAdapterPersona extends BaseAdapter {

    private Context context;
    private ArrayList<Persona> list;
    //public Activity activity;


    public ListAdapterPersona(Context context, ArrayList<Persona> lista) {
        this.context = context;
        this.list = lista;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Persona persona = (Persona)getItem(position);


        convertView = LayoutInflater.from(context).inflate(R.layout.item,null);
        //LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //convertView = inflater.inflate(R.layout.item,parent,false);
        ImageView imag = (ImageView) convertView.findViewById(R.id.imagen_01);
        //TextView txtnombre = (TextView) convertView.findViewById(R.id.id_nombre);
        //TextView txtdescripcion = (TextView) convertView.findViewById(R.id.id_desc);
        if(persona.getImg2() != 0){
            imag.setImageResource(persona.getImg2());
        }
       // imag.setImageResource(R.mipmap.usuario);
        Log.i("Img2",""+persona.getImg2());
        Log.i("Img",""+persona.getImg());
        Log.i("Nombre",""+persona.getNombrePersona());

        if(persona.getImg() != null) {
            Log.i("ImgDesdeConfig",persona.getImg());
            imag.setImageURI(Uri.parse(persona.getImg()));
        }

        //txtnombre.setText(persona.getNombrePersona());
        //txtdescripcion.setText(persona.getDescripcion());

        return convertView;
    }
}
