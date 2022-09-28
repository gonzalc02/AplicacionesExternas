package com.example.aplicacionesexternas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnlanzar, btnmapa, btnWsp;
    EditText editTextweb;
    String coordenadas = "38.7220308,-5.2212916";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlanzar = findViewById(R.id.lanzarweb);
        editTextweb = findViewById(R.id.editTextTextPersonName);
        btnmapa = findViewById(R.id.button2);
        btnWsp = findViewById(R.id.button3);

        btnWsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "buenos dias");
                intent.setPackage("com.whatsapp");
                try{
                    startActivity(intent);
                }catch (ActivityNotFoundException e){
                    Toast.makeText(MainActivity.this, "Debes instalar whatsapp", Toast.LENGTH_LONG);
                }

            }
        });

        btnmapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(Intent.ACTION_VIEW);
                intento.setData(Uri.parse("geo:"+coordenadas));
                startActivity(intento);
            }
        });


        btnlanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(editTextweb.getText().toString()));
                Intent seleccionar = Intent.createChooser(intent, "Felipe tu navegador favorito");

                startActivity(seleccionar);
            }
        });
    }
}