package ec.edu.uce.renderers;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import ec.edu.uce.geometrias.Cubo;

public class RenderCubo implements GLSurfaceView.Renderer {
    private float vIncremento= 0.0f;
    private float rotationX = 0;
    private float rotationY= 0;

    private Cubo cubo;


    public void moveObjectLeft(){
        rotationX -= 1.1f;
    }

    public void moveObjectRight(){
        rotationX += 1.1f;
    }

    public void moveObjectUp(){
        rotationY -= 1.1f;
    }

    public void moveObjectDown(){
        rotationY += 1.1f;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {
        gl.glClearColor(0.5f, 0.5f,0.5f,0.0f);
        gl.glEnable(gl.GL_DEPTH_TEST);
        //gl.glEnable(gl.GL_CULL_FACE); // para eliminar la cara
        // gl.glCullFace(gl.GL_BACK); // eliminar una cara
        cubo = new Cubo();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int ancho, int alto) {
        //para cuando se de la vuelta al celular el tamaño quede bien en la pantalla
        float relacionAspecto = (float)ancho/ (float)alto;
        gl.glViewport(0,0,ancho, alto);
        gl.glMatrixMode(gl.GL_PROJECTION);
        gl.glFrustumf(-relacionAspecto, relacionAspecto, -1,1,1,30);
        //cara frontal
        /*GLU.gluLookAt(gl,
                0, 0, 5,
                0,0,0,
                0,1,0);*/

        //cara lateral
        /*GLU.gluLookAt(gl,
                -5, 0, 0,
                0,0,0,
                0,1,0);*/
        //cara trasera
       /* GLU.gluLookAt(gl,
                0, 0, -5,
                0,0,0,
                0,1,0);*/

    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(gl.GL_COLOR_BUFFER_BIT |gl.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(gl.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, 0.0f, -5.0f);
        /*GLU.gluLookAt(gl,
                (float)Math.sin(rotationX/10), (float)Math.sin(rotationY/10),(float)Math.cos(rotationX/10) ,
                0,0,0,
                0, 1,0);
        */


        GLU.gluLookAt(gl,
                (float)Math.sin(rotationX/10)*(float)Math.cos(rotationY/10), (float)Math.sin(rotationY/10),(float)Math.cos(rotationY/10)*(float)Math.cos(rotationX/10) ,
                0,0,0,
                0, (float)Math.cos(rotationY/10),0);



//        gl.glRotatef(rotationX, 0.0f, 1.0f, 0.0f);
//        gl.glRotatef(rotationY, 1.0f, 0.0f, 0.0f);

        // Establecer las rotaciones en el cubo
        // cubo.setRotationX(rotationX);
        // cubo.setRotationY(rotationY);

        //HACE QUE LA FIGURA SE MUEVA POCO PARA LOS LADOS SIN TOCAR LAS PAREDES
        // gl.glTranslatef((float) Math.cos(vIncremento), 0.0f, -4.0f);
//si la camara esta centralizada no es necesario el translate
        //gl.glTranslatef(0.0f, 0.0f, -4.0f);
        //gl.glRotatef(vIncremento,0, 1, 0);
        cubo.dibujar(gl);
// para que haga un cubo pequeño
        //gl.glTranslatef(0f, 0f, 2f);
        //gl.glScalef(0.3f, 0.3f, 0.3f);


// traslate se necesita porque no va haber ojo
        //CON ESTE TRANSLATEF SE PUEDE MOVER PARA LOS LADOS iz-dere
        //gl.glTranslatef((float) Math.cos(vIncremento), 0.0f, -3.0f) ;
        //CON ESTE TRANSLATEF SE PUEDA MOVER COMO CIRCULO
        //gl.glTranslatef((float) Math.cos(vIncremento),(float) Math.sin(vIncremento),-3.0f) ;
        //cubo.dibujar(gl);
        // para hacer dos imagenes iguales funciona con el translatef de arriba
        //gl.glTranslatef(1.5f, -0.5f, 0.0f);
        // gl.glScalef(0.5f, 0.5f, 0.0f);
        //triangulo.dibujar(gl);


        vIncremento +=0.05f;


    }
}
