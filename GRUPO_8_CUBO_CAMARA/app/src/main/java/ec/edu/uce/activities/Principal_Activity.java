package ec.edu.uce.activities;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ec.edu.uce.R;

public class Principal_Activity extends AppCompatActivity {
    @Override
    public void onBackPressed() {

        super.onBackPressed();
        System.exit(0);
    }

    @Override
    protected void onPause() {

        super.onPause();
        Toast.makeText(this, "GRACIAS POR VISITAR LA APP ", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "BIENVENIDO", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_principal);
        Button btnEjercicios = findViewById(R.id.btnEjercicios);

        btnEjercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Activity_Fig.class);
                startActivity(intent);
                finish();
            }
        });

        Button btnSalir = findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });




    }

}
