package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.practica2.WebService.Asynchtask;
import com.example.practica2.WebService.WebService;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class actBienvenida extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_bienvenida2);

        Bundle bundle = this.getIntent().getExtras();
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("http://uealecpeterson.net/ws/login.php?usr="+ bundle.getString("usr") + "&pass=" + bundle.getString("pass"),datos, actBienvenida.this, actBienvenida.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {
        TextView txtSaludo = (TextView)findViewById(R.id.lblMensaje);
        txtSaludo.setText("Respuesta del web service: "+result);
    }
}