package ec.edu.uce.activities;

import android.app.Activity;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.KeyEvent;

import androidx.annotation.Nullable;

import ec.edu.uce.renderers.RenderCubo;
import ec.edu.uce.renderers.RenderCuboMundo;
import ec.edu.uce.renderers.RenderPiramide;

public class Activity_Cubo_Mundo extends Activity {

    public void onBackPressed() {

        Intent intent = new Intent(this, Activity_Fig.class);
        startActivity(intent);
        finish();

    }
    private GLSurfaceView glSurfaceView;
    private RenderCuboMundo renderCubo;
    private RenderPiramide renderPiramide;


    private  float cuboRotX = 0.0f;
    private  float cuboRotY = 0.0f;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView =new GLSurfaceView(this);
        /*renderCubo = new RenderCubo();
        glSurfaceView.setRenderer(renderCubo);*/
       renderCubo = new RenderCuboMundo();
        glSurfaceView.setRenderer(renderCubo);
        setContentView(glSurfaceView);

    }

    @Override
    protected void onResume() {
        super.onResume();
        glSurfaceView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        glSurfaceView.onPause();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                renderCubo.moveObjectLeft();

                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                renderCubo.moveObjectRight();

                return true;
            case KeyEvent.KEYCODE_DPAD_UP:
                renderCubo.moveObjectUp();

                return true;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                renderCubo.moveObjectDown();

                return true;
        }
        return super.onKeyDown(keyCode, event);
    }


   /* @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        // Aquí puedes manejar eventos de teclado cuando se suelta una tecla, si es necesario.
        return super.onKeyUp(keyCode, event);
    }*/

}
