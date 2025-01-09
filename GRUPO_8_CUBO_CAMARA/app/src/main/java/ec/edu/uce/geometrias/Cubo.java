package ec.edu.uce.geometrias;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Cubo {
    private FloatBuffer bufferVertices;
    private FloatBuffer bufferColores;
    private ByteBuffer bufferIndice;
    private final static int byteFlotante = 4;
    private final static int comPorVertice = 3;
    private final static int comPorColores = 4;

    private float rotationX;
    private float rotationY;

    public void setRotationX(float rotationX) {
        this.rotationX = rotationX;
    }

    public void setRotationY(float rotationY) {
        this.rotationY = rotationY;
    }

    public Cubo() {
        float[] vertices = {
                // CARA SUPERIOR
                -1.0f,  1.0f,  1.0f,  // 0
                1.0f,  1.0f,  1.0f,  // 1
                1.0f,  1.0f, -1.0f,  // 2
                -1.0f,  1.0f, -1.0f,  // 3

                // CARA INFERIOR
                -1.0f, -1.0f,  1.0f,   // 4
                1.0f, -1.0f,  1.0f,    // 5
                1.0f, -1.0f, -1.0f,   // 6
                -1.0f, -1.0f, -1.0f,  //7

                // CARA FRONTAL
                -1.0f, -1.0f,  1.0f,  // 8
                1.0f, -1.0f,  1.0f,   // 9
                1.0f,  1.0f,  1.0f,   // 10
                -1.0f,  1.0f,  1.0f,  // 11

                // CARA POSTERIOR
                -1.0f, -1.0f, -1.0f,  // 12
                1.0f, -1.0f, -1.0f,   // 13
                1.0f,  1.0f, -1.0f,   // 14
                -1.0f,  1.0f, -1.0f,  // 15

                // CARA DERECHA
                1.0f, -1.0f,  1.0f,  // 16
                1.0f, -1.0f, -1.0f,  // 17
                1.0f,  1.0f, -1.0f,  // 18
                1.0f,  1.0f,  1.0f,  // 19

                // CARA IZQUIERDA
                -1.0f, -1.0f,  1.0f,  // 20
                -1.0f, -1.0f, -1.0f,  // 21
                -1.0f,  1.0f, -1.0f,  // 22
                -1.0f,  1.0f,  1.0f  // 23
        };
                /*CUBO
                -1.0f, 1.0f, 1.0f, //0
                1.0f, 1.0f, 1.0f, //1
                1.0f, -1.0f, 1.0f, //2
                -1.0f, -1.0f, 1.0f, //3
                -1.0f, 1.0f, -1.0f, //4
                1.0f, 1.0f, -1.0f, //5
                1.0f, -1.0f, -1.0f, // 6
                -1.0f, -1.0f, -1.0f //7*/

        float[] colores = {
                /*COLOR CUBO
                0.5f, 0,4f, 0.0f, 1.0f,
                0.5f, 0,2f, 0.0f, 1.0f,
                0.5f, 0,0f, 0.3f, 1.0f,
                0.5f, 0,1f, 0.0f, 1.0f,
                0.5f, 0,2f, 0.0f, 1.0f,
                0.5f, 0,0f, 0.2f, 1.0f,
                0.5f, 0,5f, 0.0f, 1.0f*/
                //azul
                0.3f, 0.0f, 0.3f, 1.0f,
                0.3f, 0.0f, 0.3f, 1.0f,
                0.3f, 0.0f, 0.3f, 1.0f,
                0.3f, 0.0f, 0.3f, 1.0f,
                //amarillo
                1.0f, 1.0f, 0.0f, 1.0f,
                1.0f, 1.0f, 0.0f, 1.0f,
                1.0f, 1.0f, 0.0f, 1.0f,
                1.0f, 1.0f, 0.0f, 1.0f,
                //rosado
                0.4f, 1.0f, 0.3f, 1.0f,
                0.4f, 1.0f, 0.3f, 1.0f,
                0.4f, 1.0f, 0.3f, 1.0f,
                0.4f, 1.0f, 0.3f, 1.0f,
                //morado
                1.0f, 0.0f, 0.4f, 1.0f,
                1.0f, 0.0f, 0.4f, 1.0f,
                1.0f, 0.0f, 0.4f, 1.0f,
                1.0f, 0.0f, 0.4f, 1.0f,

                1.0f, 0.0f, 0.2f, 1.0f,
                1.0f, 0.0f, 0.2f, 1.0f,
                1.0f, 0.0f, 0.2f, 1.0f,
                1.0f, 0.0f, 0.2f, 1.0f,

                0.2f, 0.0f, 1.0f, 1.0f,
                0.2f, 0.0f, 1.0f, 1.0f,
                0.2f, 0.0f, 1.0f, 1.0f,
                0.2f, 0.0f, 1.0f, 1.0f

        };
        byte [] indices ={
                /*CUBO
                0,2,3,
                0,1,2,
                0,5,1,
                0,4,5,
                0,7,3,
                0,4,7,
                6,2,3,
                6,3,7,
                6,2,1,
                6,1,5,
                6,7,4,
                6,4,5*/

                0,2,1,
                0,3,2,

                4,6,5,
                4,7,6,

                8,10,9,
                8,11,10,

                12,14,13,
                12,15,14,

                16,18,17,
                16,19,18,

                20,22,21,
                20,23,22

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
    public void dibujar (GL10 gl){
        gl.glFrontFace(gl.GL_CW);

        bufferVertices.position(0);
        gl.glVertexPointer(comPorVertice, gl.GL_FLOAT, 0, bufferVertices);
        gl.glEnableClientState(gl.GL_VERTEX_ARRAY);

        bufferColores.position(0);
        gl.glColorPointer(comPorColores, gl.GL_FLOAT, 0, bufferColores);
        gl.glEnableClientState(gl.GL_COLOR_ARRAY);

        //gl.glDrawElements(gl.GL_TRIANGLE_FAN, 36,gl.GL_UNSIGNED_BYTE, bufferIndice);
        gl.glDrawElements(gl.GL_TRIANGLES, 36,gl.GL_UNSIGNED_BYTE, bufferIndice);


        gl.glFrontFace(gl.GL_CCW);
        gl.glDisableClientState(gl.GL_VERTEX_ARRAY);
        gl.glDisableClientState(gl.GL_COLOR_ARRAY);


    }

}
