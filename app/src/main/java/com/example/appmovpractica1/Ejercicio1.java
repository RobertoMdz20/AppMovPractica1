package com.example.appmovpractica1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ejercicio1 extends AppCompatActivity {

    //Declarar variables
    EditText id_ctemp_celsius;
    TextView id_ctexto_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejercicio1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Asignar variables por id
        id_ctemp_celsius = findViewById(R.id.id_temp_celsius);
        id_ctexto_resultado = findViewById(R.id.id_texto_resultado);
    }
    //Funcion calcular temperatura
    public void calcular_temp (View view){

        //Verificar si los campos están vacíos
        String temp_celsius_str = id_ctemp_celsius.getText().toString();
        if (temp_celsius_str.isEmpty()) {
            Toast.makeText(this, "Ingrese la temperatura en grados Celsius", Toast.LENGTH_SHORT).show();
            return;
        }
        int celsius = Integer.parseInt(temp_celsius_str);
        int conversion = (celsius * 9/5)+32;
        String farenheit = String.valueOf(conversion);
        id_ctexto_resultado.setText(farenheit);
    }
}