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

public class Ejercicio9 extends AppCompatActivity {

    //Declarar variables
    EditText id_cingreso1, id_cingreso2, id_cingreso3;
    TextView id_ctexto_resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejercicio9);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Asignar variables por id
        id_cingreso1 = findViewById(R.id.id_ingreso1);
        id_cingreso2 = findViewById(R.id.id_ingreso2);
        id_cingreso3 = findViewById(R.id.id_ingreso3);
        id_ctexto_resultado = findViewById(R.id.id_texto_resultado);
    }
    //Función Calcular pago
    public void calcular_promedio (View view){
        //Verificar si los campos están vacíos
        String id_ingreso1_str = id_cingreso1.getText().toString();
        String id_ingreso2_str = id_cingreso2.getText().toString();
        String id_ingreso3_str = id_cingreso3.getText().toString();
        if (id_ingreso1_str.isEmpty() || id_ingreso2_str.isEmpty() || id_ingreso3_str.isEmpty()) {
            Toast.makeText(this, "Ingrese los números", Toast.LENGTH_SHORT).show();
            return;
        }
        double ingreso1 = Double.parseDouble(id_ingreso1_str);
        double ingreso2 = Double.parseDouble(id_ingreso2_str);
        double ingreso3 = Double.parseDouble(id_ingreso3_str);
        double calculo_promedio = (ingreso1+ingreso2+ingreso3)/3;
        String promedio = String.format(Locale.US, "%.2f", calculo_promedio);
        id_ctexto_resultado.setText(promedio);

    }
}