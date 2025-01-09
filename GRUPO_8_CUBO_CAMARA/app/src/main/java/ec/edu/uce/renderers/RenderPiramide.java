package ec.edu.uce.renderers;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import ec.edu.uce.geometrias.Piramide;

public class RenderPiramide implements GLSurfaceView.Renderer{

    private float vincremento = 0.0f;
    private float figX=0;
    private float figY=0;

    /*public float getFigX() {
        return figX;
    }

    public void setFigX(float figX) {
        this.figX = figX;
    }

    public float getFigY() {
        return figY;
    }

    public void setFigY(float figY) {
        this.figY = figY;
    }*/
    public void moveObjectLeft() {
        figX -= 1.1f;
    }

    public void moveObjectRight() {
        figX += 1.1f;
    }

    public void moveObjectUp() {
        figY -= 1.1f;
    }

    public void moveObjectDown() {figY += 1.1f; }


    private Piramide piramide;
    private float r;



    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {

        gl.glClearColor(0.5f,0.5f,0.5f,1.0f);
        gl.glEnable(gl.GL_DEPTH_TEST);
        // gl.glEnable(gl.GL_CULL_FACE);
        // gl.glCullFace(gl.GL_BACK);
        piramide = new Piramide();

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int ancho, int alto) {

        float relacionAspecto=(float)ancho/(float) alto;
        gl.glViewport(0,0,ancho,alto);
        gl.glMatrixMode(gl.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glFrustumf(-relacionAspecto,relacionAspecto,-1,1,1,30);
        //gl.glOrthof(-5,5,-5,5,1,30);

        /*
//lateral der
        GLU.gluLookAt(gl,0,0,5,
                0,0,0,
                0,1,0);
//lateral izqui
        GLU.gluLookAt(gl,0,0,5,
                0,0,0,
                0,1,0);
//posterior
        GLU.gluLookAt(gl,0,0,5,
                0,0,0,
                0,1,0);*/

        //superior
       /* GLU.gluLookAt(gl,0,5,0,
                0,0,0,
                1,0,0);
        //inferior
        GLU.gluLookAt(gl,0,-5,0,
                0,0,0,
                1,0,0);*/
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(gl.GL_COLOR_BUFFER_BIT | gl.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(gl.GL_MODELVIEW);
        gl.glLoadIdentity();

        /*GLU.gluLookAt(gl,5,0,0,
               0,0,0,
               0,1,0);*/
        //gl.glTranslatef(figX, figY, 0.0f);
        gl.glTranslatef(0.0f,0.0f,-5.0f);
        //gl.glRotatef(vincremento,0,1,0);
        //gl.glScalef(0.5f,0.5f,0.5f);
        //gl.glRotatef(vincremento,0.5f,0.5f,0);

        GLU.gluLookAt(gl,
                (float)Math.sin(figX/10)*(float)Math.cos(figY/10), (float)Math.sin(figY/10),(float)Math.cos(figY/10)*(float)Math.cos(figX/10) ,
                0,0,0,
                0, (float)Math.cos(figY/10),0);
//        gl.glRotatef(figX,1,0,0);
//        gl.glRotatef(figY,0,1,0);
        piramide.dibujar(gl);

        // gl.glTranslatef(0,0,2);

        // gl.glScalef(0.5f,0.5f,0.5f);
        // cubo.dibujar(gl);
        vincremento+=0.3f;
       /* figX+=0.3f;
        figY+=0.3f;*/


    }

}
