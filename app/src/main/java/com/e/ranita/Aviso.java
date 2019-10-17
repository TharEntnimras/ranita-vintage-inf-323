package com.e.ranita;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Aviso {
	private float vertices[] = new float[] {
		-2.5f, -2, // 0
		-2.5f, 2, // 1
		2.5f, 2, // 2
		2.5f, -2, // 3
	};
	
	FloatBuffer bufVertices;
	public Aviso() {
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder());
		bufVertices = bufByte.asFloatBuffer();
		bufVertices.put(vertices);
		bufVertices.rewind();
	}

	public void dibuja(GL10 gl) {

		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

		gl.glVertexPointer(2, GL10.GL_FLOAT, 0, bufVertices);
		gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 4);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
	}
}