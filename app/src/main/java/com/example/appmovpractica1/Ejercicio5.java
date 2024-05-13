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

import org.w3c.dom.Text;

import java.util.Locale;

public class Ejercicio5 extends AppCompatActivity {

    //Declarar variables
    EditText id_clado_a, id_clado_b;
    TextView id_ctexto_resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejercicio5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Asignar variables por id
        id_clado_a = findViewById(R.id.id_lado_a);
        id_clado_b = findViewById(R.id.id_lado_b);
        id_ctexto_resultado = findViewById(R.id.id_texto_resultado);
    }
    //Función Calcular hipotenusa
    public void calcular_hipotenusa (View view){
        //Verificar si los campos están vacíos
        String lado_a_str = id_clado_a.getText().toString();
        String lado_b_str = id_clado_b.getText().toString();
        if (lado_a_str.isEmpty() || lado_b_str.isEmpty()) {
            Toast.makeText(this, "Ingrese los catetos A y B", Toast.LENGTH_SHORT).show();
            return;
        }
        double lado_a = Double.parseDouble(lado_a_str);
        double lado_b = Double.parseDouble(lado_b_str);
        //Verificar si los campos son cero
        if (lado_a == 0 && lado_b == 0) {
            Toast.makeText(this, "El cateto A y B no pueden ser cero", Toast.LENGTH_SHORT).show();
            return;
        }
        double teorema = Math.sqrt(Math.pow(lado_a, 2) + Math.pow(lado_b, 2));
        String hipotenusa = String.format(Locale.US, "%.2f", teorema);
        id_ctexto_resultado.setText(hipotenusa);

    }
}