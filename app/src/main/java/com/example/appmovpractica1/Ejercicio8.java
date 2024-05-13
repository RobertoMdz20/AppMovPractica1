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

public class Ejercicio8 extends AppCompatActivity {
    //Declarar variables
    EditText id_cnumero_ingreso;
    TextView id_ctexto_resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejercicio8);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Asignar variables por id
        id_cnumero_ingreso = findViewById(R.id.id_numero_ingreso);
        id_ctexto_resultado = findViewById(R.id.id_texto_resultado);
    }
    public void calcular_cubo(View view){
        //Verificar si los campos están vacíos
        String numero_ingreso_str = id_cnumero_ingreso.getText().toString();
        if (numero_ingreso_str.isEmpty()) {
            Toast.makeText(this, "Ingrese un numero", Toast.LENGTH_SHORT).show();
            return;
        }

        double numero_elevar = Double.parseDouble(numero_ingreso_str);
        double al_cubo = Math.pow(numero_elevar, 3);

        String numero_al_cubo = String.format(Locale.US, "%.2f", al_cubo);
        id_ctexto_resultado.setText(numero_al_cubo);
    }
}