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

public class Ejercicio6 extends AppCompatActivity {

    //Declarar variables
    EditText id_cnumero_verificar;
    TextView id_ctexto_resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejercicio6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Asignar variables por id
        id_cnumero_verificar = findViewById(R.id.id_numero_verificar);
        id_ctexto_resultado = findViewById(R.id.id_texto_resultado);
    }

    //Función Verificar número
    public void verificar_numero (View view){
        String numero_str = id_cnumero_verificar.getText().toString();
        if (!numero_str.isEmpty()) {
            int numero = Integer.parseInt(numero_str);
            if (numero > 0) {
                id_ctexto_resultado.setText("Positivo");
            } else if (numero < 0) {
                id_ctexto_resultado.setText("Negativo");
            } else {
                id_ctexto_resultado.setText("Cero");
            }
        } else {
            Toast.makeText(this, "Ingrese un número", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
