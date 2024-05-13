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

public class Ejercicio2 extends AppCompatActivity {

    //Declarar variables
    EditText id_caltura_cm, id_cpeso;
    TextView id_ctexto_resultado, id_ctexto_clasificacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejercicio2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Asignar variables por id
        id_caltura_cm = findViewById(R.id.id_altura_cm);
        id_cpeso = findViewById(R.id.id_peso);
        id_ctexto_resultado = findViewById(R.id.id_texto_resultado);
        id_ctexto_clasificacion = findViewById(R.id.id_texto_clasificacion);
    }

    //Función Calcular IMC
    public void calcular_imc (View view){
        //Verificar si los campos están vacíos
        String altura_cm_str = id_caltura_cm.getText().toString();
        String peso_str = id_cpeso.getText().toString();
        if (altura_cm_str.isEmpty() || peso_str.isEmpty()) {
            Toast.makeText(this, "Ingrese la altura y el peso", Toast.LENGTH_SHORT).show();
            return;
        }
        double altura_cm = Double.parseDouble(altura_cm_str);
        double peso_kg = Double.parseDouble(peso_str);
        //Verificar si los campos son cero
        if (altura_cm == 0 && peso_kg == 0) {
            Toast.makeText(this, "La altura y el peso no pueden ser cero", Toast.LENGTH_SHORT).show();
            return;
        }
        double altura_metro = (altura_cm/100);
        double calculo_imc = (peso_kg/(altura_metro*altura_metro));
        String clasificacion = "";

       if(calculo_imc < 18.5){
           clasificacion = "PESO BAJO";
       }else if (calculo_imc >= 18.5 && calculo_imc < 24.9){
           clasificacion = "PESO NORMAL";
       }else if (calculo_imc >= 24.9 && calculo_imc < 29.9){
           clasificacion = "SOBREPESO";
       }else {
           clasificacion = "OBESIDAD";
       }

        String imc = String.format(Locale.US, "%.1f", calculo_imc);
        id_ctexto_resultado.setText(imc);
        id_ctexto_clasificacion.setText(clasificacion);

    }
}