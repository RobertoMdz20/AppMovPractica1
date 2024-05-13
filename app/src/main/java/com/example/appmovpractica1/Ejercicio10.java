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

import java.util.Locale;

public class Ejercicio10 extends AppCompatActivity {

    //Declarar variables
    private EditText id_ctiempo_recorrido, id_ctiempo_espera;
    private TextView id_ctexto_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejercicio10);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Asinar variables por id
        id_ctiempo_recorrido = findViewById(R.id.id_temp_celsius);
        id_ctiempo_espera = findViewById(R.id.id_tiempo_espera);
        id_ctexto_resultado = findViewById(R.id.id_texto_resultado);
    }
    //Función Calcular pago
    public void calcular_pago (View view){
        //Verificar si los campos están vacíos
        String tiempo_recorrido_str = id_ctiempo_recorrido.getText().toString();
        String tiempo_espera_str = id_ctiempo_espera.getText().toString();
        if (tiempo_recorrido_str.isEmpty() || tiempo_espera_str.isEmpty()) {
            Toast.makeText(this, "Ingrese el tiempo de recorrido y de espera", Toast.LENGTH_SHORT).show();
            return;
        }
        Double cm = Double.parseDouble(tiempo_recorrido_str);
        Double ce = Double.parseDouble(tiempo_espera_str);
        //Verificar si los campos son cero
        if (cm == 0 && ce == 0) {
            Toast.makeText(this, "El tiempo de recorrido y de espera no pueden ser cero", Toast.LENGTH_SHORT).show();
            return;
        }
        double arranque = 0.50;
        double valorminuto = 0.18;
        double valorespera = 0.12;
        double valortotal = (arranque + (cm * valorminuto) + (ce * valorespera));
        String totaltaxi = String.format(Locale.US, "%.2f", valortotal);
        id_ctexto_resultado.setText(totaltaxi);
    }
}