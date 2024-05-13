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

public class Ejercicio7 extends AppCompatActivity {
    //Declarar variables
    EditText id_cnumero1, id_cnumero2, id_cnumero3, id_cnumero4;
    TextView id_ctexto_resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejercicio7);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Asignar variables por id
        id_cnumero1 = findViewById(R.id.id_numero1);
        id_cnumero2 = findViewById(R.id.id_numero2);
        id_cnumero3 = findViewById(R.id.id_numero3);
        id_cnumero4 = findViewById(R.id.id_numero4);
        id_ctexto_resultado = findViewById(R.id.id_texto_resultado);
    }

    //Función ordenar numeros de forma ascendente
    public void ordenar (View view){
        //Verificar si los campos están vacíos
        String num1_str = id_cnumero1.getText().toString();
        String num2_str = id_cnumero2.getText().toString();
        String num3_str = id_cnumero3.getText().toString();
        String num4_str = id_cnumero4.getText().toString();
        if (num1_str.isEmpty() || num2_str.isEmpty() || num3_str.isEmpty() || num4_str.isEmpty()) {
            Toast.makeText(this, "Ingrese los 4 números", Toast.LENGTH_SHORT).show();
            return;
        }
        int num1 = Integer.parseInt(num1_str);
        int num2 = Integer.parseInt(num2_str);
        int num3 = Integer.parseInt(num3_str);
        int num4 = Integer.parseInt(num4_str);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 - i; j++) {
                if (num1 > num2) {
                    int temp = num1;
                    num1 = num2;
                    num2 = temp;
                }
                if (num2 > num3) {
                    int temp = num2;
                    num2 = num3;
                    num3 = temp;
                }
                if (num3 > num4) {
                    int temp = num3;
                    num3 = num4;
                    num4 = temp;
                }
            }
        }
        String ordenados = num1 + ", " + num2 + ", " + num3 + ", " + num4;
        id_ctexto_resultado.setText(ordenados);
    }
}