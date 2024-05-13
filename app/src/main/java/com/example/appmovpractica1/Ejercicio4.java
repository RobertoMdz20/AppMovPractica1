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

public class Ejercicio4 extends AppCompatActivity {
    //Declarar variables
    EditText id_cvalor_dolar;
    TextView id_ctexto_resultado1, id_ctexto_resultado2, id_ctexto_resultado3, id_ctexto_resultado4,
            id_ctexto_resultado5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejercicio4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        id_cvalor_dolar = findViewById(R.id.id_valor_dolar);
        id_ctexto_resultado1 = findViewById(R.id.id_texto_resultado1);
        id_ctexto_resultado2 = findViewById(R.id.id_texto_resultado2);
        id_ctexto_resultado3 = findViewById(R.id.id_texto_resultado3);
        id_ctexto_resultado4 = findViewById(R.id.id_texto_resultado4);
        id_ctexto_resultado5 = findViewById(R.id.id_texto_resultado5);
    }
    //Función Calcular conversión
    public void calcular_conversion (View view){
        //Verificar si los campos están vacíos
        String valor_dolar_str = id_cvalor_dolar.getText().toString();
        if (valor_dolar_str.isEmpty()) {
            Toast.makeText(this, "Ingrese el valor a convertir", Toast.LENGTH_SHORT).show();
            return;
        }

        double valor_dolar = Double.parseDouble(valor_dolar_str);
        //Verificar si el campo es cero
        if (valor_dolar == 0) {
            Toast.makeText(this, "El valor a convertir no puede ser cero", Toast.LENGTH_SHORT).show();
            return;
        }
        double euro = (valor_dolar*0.92);
        double libra =(valor_dolar*0.79);
        double peso_arg =(valor_dolar*882.50);
        double peso_mx = (valor_dolar*16.77);
        double peso_col = (valor_dolar*3887.62);
        String conv_euro = String.format(Locale.US, "%.2f", euro);
        String conv_libra = String.format(Locale.US, "%.2f", libra);
        String conv_peso_arg = String.format(Locale.US, "%.2f", peso_arg);
        String conv_peso_mx = String.format(Locale.US, "%.2f", peso_mx);
        String conv_peso_col = String.format(Locale.US, "%.2f", peso_col);
        id_ctexto_resultado1.setText(conv_euro);
        id_ctexto_resultado2.setText(conv_libra);
        id_ctexto_resultado3.setText(conv_peso_arg);
        id_ctexto_resultado4.setText(conv_peso_mx);
        id_ctexto_resultado5.setText(conv_peso_col);
    }
}