package com.example.appmovpractica1;

import android.graphics.text.TextRunShaper;
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

public class Ejercicio3 extends AppCompatActivity {
    //Declarar variables
    EditText id_cprecio_og, id_cdescuento;
    TextView id_ctexto_resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejercicio3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Asignar variables por id
        id_cprecio_og = findViewById(R.id.id_precio_og);
        id_cdescuento = findViewById(R.id.id_descuento);
        id_ctexto_resultado = findViewById(R.id.id_texto_resultado);
    }
    //Función Calcular descuento
    public void calcular_descuento(View view){
        //Verificar si los campos están vacíos
        String precio_og_str = id_cprecio_og.getText().toString();
        String descuento_str = id_cdescuento.getText().toString();
        if (precio_og_str.isEmpty() || descuento_str.isEmpty()) {
            Toast.makeText(this, "Ingrese el precio del producto y el descuento", Toast.LENGTH_SHORT).show();
            return;
        }
        double precio_og = Double.parseDouble(precio_og_str);
        double descuento = Double.parseDouble(descuento_str);
        //Verificar si los campos son cero
        if (precio_og == 0 && descuento == 0) {
            Toast.makeText(this, "El precio y el descuento no pueden ser cero", Toast.LENGTH_SHORT).show();
            return;
        }
        double valor_descuento = ((descuento/100)*precio_og);
        double precio_final = precio_og-valor_descuento;
        String precio_descuento = String.format(Locale.US, "%.2f", precio_final);
        id_ctexto_resultado.setText(precio_descuento);
    }
}
