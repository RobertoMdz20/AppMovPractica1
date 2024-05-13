package com.example.appmovpractica1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //Declarar variables
    TextView id_cheader, id_cfooter;
    Button id_cboton_ejer1, id_cboton_ejer2, id_cboton_ejer3, id_cboton_ejer4, id_cboton_ejer5, id_cboton_ejer6,
            id_cboton_ejer7, id_cboton_ejer8, id_cboton_ejer9, id_cboton_ejer10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Asignar variables por id
        id_cheader=findViewById(R.id.id_header);
        id_cfooter=findViewById(R.id.id_footer);
        id_cboton_ejer1=findViewById(R.id.id_boton_ejer_1);
        id_cboton_ejer2=findViewById(R.id.id_boton_ejer_2);
        id_cboton_ejer3=findViewById(R.id.id_boton_ejer_3);
        id_cboton_ejer4=findViewById(R.id.id_boton_ejer_4);
        id_cboton_ejer5=findViewById(R.id.id_boton_ejer_5);
        id_cboton_ejer6=findViewById(R.id.id_boton_ejer_6);
        id_cboton_ejer7=findViewById(R.id.id_boton_ejer_7);
        id_cboton_ejer8=findViewById(R.id.id_boton_ejer_8);
        id_cboton_ejer9=findViewById(R.id.id_boton_ejer_9);
        id_cboton_ejer10=findViewById(R.id.id_boton_ejer_10);

        //OnClick de los botones de navegación
        id_cboton_ejer1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Ejercicio1.class);
            startActivity(intent);
        });
        id_cboton_ejer2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Ejercicio2.class);
            startActivity(intent);
        });
        id_cboton_ejer3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Ejercicio3.class);
            startActivity(intent);
        });
        id_cboton_ejer4.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Ejercicio4.class);
            startActivity(intent);
        });
        id_cboton_ejer5.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Ejercicio5.class);
            startActivity(intent);
        });
        id_cboton_ejer6.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Ejercicio6.class);
            startActivity(intent);
        });
        id_cboton_ejer7.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Ejercicio7.class);
            startActivity(intent);
        });
        id_cboton_ejer8.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Ejercicio8.class);
            startActivity(intent);
        });
        id_cboton_ejer9.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Ejercicio9.class);
            startActivity(intent);
        });
        id_cboton_ejer10.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Ejercicio10.class);
            startActivity(intent);
        });


    }
}