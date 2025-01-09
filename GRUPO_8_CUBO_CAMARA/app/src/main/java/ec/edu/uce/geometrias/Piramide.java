package ec.edu.uce.geometrias;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Piramide {

    private FloatBuffer bufferVertices;
    private FloatBuffer bufferColores;
    private ByteBuffer bufferIndice;

    private ByteBuffer bufferIndice2;

    private ByteBuffer bufferColor;

    private static final int byteFlotante = 4;
    private static final int compPorVertice = 3;
    private static final int compPorColor = 4;

    private float rotationX;
    private float rotationY;

    public void setRotationX(float rotationX) { this.rotationX = rotationX; }

    public void setRotationY(float rotationY) {
        this.rotationY = rotationY;
    }

    public Piramide(){
        float[]vertices = {

                0.0f,  1.0f,  0.0f,  // Vértice superior
                -1.0f, -1.0f,  1.0f,  // Vértice frontal izquierdo
                1.0f, -1.0f,  1.0f,  // Vértice frontal derecho
                1.0f, -1.0f, -1.0f,  // Vértice trasero derecho
                -1.0f, -1.0f, -1.0f


        };



        float[]colores = {
                //
                1.0f, 0.0f, 0.0f, 1.0f, // Rojo para el vértice superior
                0.0f, 1.0f, 0.0f, 1.0f, // Verde para el vértice frontal izquierdo
                0.0f, 0.0f, 1.0f, 1.0f, // Azul para el vértice frontal derecho
                1.0f, 1.0f, 0.0f, 1.0f, // Amarillo para el vértice trasero derecho
                1.0f, 0.0f, 1.0f, 1.0f // Magenta para el vértice trasero izquierdo
        };

        byte[] indices={
                1, 2, 3, 4, 1,
                0, 1, 4, // Base frontal
                0, 4, 3, // Base derecha
                0, 3, 2, // Base trasera
                0, 2, 1 // Base izquierda

        };



        ByteBuffer buffer = ByteBuffer.allocateDirect(vertices.length*byteFlotante);
        buffer.order(ByteOrder.nativeOrder());
        bufferVertices = buffer.asFloatBuffer();
        bufferVertices.put(vertices);
        bufferVertices.position(0);

        buffer = ByteBuffer.allocateDirect(colores.length*byteFlotante);
        buffer.order(ByteOrder.nativeOrder());
        bufferColores = buffer.asFloatBuffer();
        bufferColores.put(colores);

        bufferIndice = ByteBuffer.allocateDirect(indices.length);
        bufferIndice.order(ByteOrder.nativeOrder());
        bufferIndice.put(indices);
        bufferIndice.position(0);


    }

    public void dibujar(GL10 gl){

        gl.glFrontFace(gl.GL_CW);

        bufferVertices.position(0);
        gl.glVertexPointer(compPorVertice, gl.GL_FLOAT,0,bufferVertices);
        gl.glEnableClientState(gl.GL_VERTEX_ARRAY);


        bufferColores.position(0);
        gl.glColorPointer(compPorColor,gl.GL_FLOAT,0,bufferColores);
        gl.glEnableClientState(gl.GL_COLOR_ARRAY);

        //el mod es el tipo de primitiva
        gl.glDrawElements(gl.GL_TRIANGLE_FAN,17,gl.GL_UNSIGNED_BYTE,bufferIndice);

        gl.glFrontFace(gl.GL_CCW);
        gl.glDisableClientState(gl.GL_VERTEX_ARRAY);
        gl.glDisableClientState(gl.GL_COLOR_ARRAY);

    }
}
