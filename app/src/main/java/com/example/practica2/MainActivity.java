package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btEnviar(View view){
        //Creamos el Intent
        Intent intent = new Intent(MainActivity.this, actBienvenida.class);
        EditText txtNombre = (EditText)findViewById(R.id.txtUser);
        EditText txtPass = (EditText)findViewById(R.id.txtPass);
        //Creamos la información a pasar entre actividades - Pares Key-Value
        Bundle b = new Bundle();
        b.putString("usr", txtNombre.getText().toString());
        b.putString("pass", txtPass.getText().toString());
        //Añadimos la información al intent
        intent.putExtras(b);
        // Iniciamos la nueva actividad
        startActivity(intent);
    }

}