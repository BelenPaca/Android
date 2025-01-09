package ec.edu.uce.activities;

import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ec.edu.uce.R;
import ec.edu.uce.renderers.RenderCubo;
import ec.edu.uce.renderers.RenderPiramide;

public class Activity_Fig extends AppCompatActivity {
    public void onBackPressed() {

        Intent intent = new Intent(this, Principal_Activity.class);
        startActivity(intent);
        finish();

    }

    private GLSurfaceView glSurfaceView;
    private RenderCubo renderCubo;
    //    private RenderCubo renderer;
    private GLSurfaceView.Renderer renderer;

    private float cubeRotationX = 0.0f;
    private float cubeRotationY = 0.0f;


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
        setContentView(R.layout.layout_figuras);

        Button btnCamara = findViewById(R.id.btnDibujarCamara);
        Button btnMundo = findViewById(R.id.btnDibujarMundo);
        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int opcionSet;
                RadioGroup rgOpciones= (RadioGroup) findViewById(R.id.rdGr);
                opcionSet = rgOpciones.getCheckedRadioButtonId();
                RadioButton rbCubo = findViewById(R.id.radioButton);

                if (opcionSet >0) {
                    if (opcionSet == R.id.radioButton){
                        Intent intent = new Intent(view.getContext(), Activity_Cubo.class);
                        startActivity(intent);
                        finish();

                    } else if (opcionSet == R.id.radioButton2) {
                        Intent intent = new Intent(view.getContext(), Activity_Piramide.class);
                        startActivity(intent);
                        finish();
                    }
                }

            }
        });

        btnMundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int opcionSet;
                RadioGroup rgOpciones= (RadioGroup) findViewById(R.id.rdGr);
                opcionSet = rgOpciones.getCheckedRadioButtonId();
                RadioButton rbCubo = findViewById(R.id.radioButton);

                if (opcionSet >0) {
                    if (opcionSet == R.id.radioButton){
                        Intent intent = new Intent(view.getContext(), Activity_Cubo_Mundo.class);
                        startActivity(intent);
                        finish();

                    } else if (opcionSet == R.id.radioButton2) {
                        Intent intent = new Intent(view.getContext(), Activity_Piramide_Mundo.class);
                        startActivity(intent);
                        finish();
                    }
                }


            }
        });
    }


}
