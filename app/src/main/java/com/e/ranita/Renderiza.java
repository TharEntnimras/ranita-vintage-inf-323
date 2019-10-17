package com.e.ranita;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.Toast;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class Renderiza extends GLSurfaceView implements Renderer {
	private int alto;
	private int ancho;
	private boolean bandera1 = true, bandera2 = true, bandera3 = true, bandera4 = true,bandera5 = true;
	int cont =0;
	int contf = 1;

	private CirculoGrafico c1_g;
	private Circulo c1;
	private RectanguloGrafico r1_g, r2_g, r3_g,r4_g,r5_g,r6_g;
	private Rectangulo r1, r2, r3,r4,r5,r6;

	private float x_c1 = 0, y_c1 = 2;

	private float x_r1 = 0, y_r1 = 5;
	private float x_r2 = 0, y_r2 = 8;
	private float x_r3 = 0, y_r3 = 3;
	private float x_r4 = 0, y_r4 = 10;
	private float x_r5 = 0, y_r5 = 12;
	private float x_r6 = 0, y_r6 = 5;

	private Triangulo triangulo;
	private Triangulo triangulo2;
	private Triangulo triangulo3;

	private Aviso aviso;


	private CirculoGrafico circulo;
	private CirculoGrafico circulo2;
	private CirculoGrafico circulo3;
	Context contexto;
	SonidoSoundPool sonido1;
	SonidoSoundPool sonido2;
	SonidoSoundPool sonido3;
	SonidoSoundPool sonido4;
	SonidoSoundPool sonido5;
	SonidoSoundPool sonido6;
	boolean sw1 = false;
	boolean  flag = false;

	float ty, tx, incy, incx;
	float ty2, tx2, incy2, incx2;

	float ty3, tx3, incy3, incx3;
	float ty4, tx4, incy4, incx4;
	private float xVelocidad_r1 =(float) Math.random()*0.1f,
			      xVelocidad_r2 =(float) Math.random()*0.3f,
	xVelocidad_r3 =0.05f,
	xVelocidad_r4 =(float) Math.random()*0.5f,
	xVelocidad_r5 =(float) Math.random()*0.5f;



	public Renderiza(Context contexto) {
		super(contexto);
		this.contexto = contexto;
		sonido1 = new SonidoSoundPool(contexto, "idiota.ogg");
		sonido2 = new SonidoSoundPool(contexto, "callate.ogg");
		sonido3 = new SonidoSoundPool(contexto, "vete.ogg");
		sonido4 = new SonidoSoundPool(contexto, "bum.ogg");
		sonido5 = new SonidoSoundPool(contexto, "gano.ogg");


		this.setRenderer(this);
		this.requestFocus();
		this.setFocusableInTouchMode(true);

		this.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);

	}



	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {



		circulo = new CirculoGrafico(1f, 360, true);
		circulo2 = new CirculoGrafico(0.7f, 360, true);
		circulo3 = new CirculoGrafico(0.6f, 360, true);

		c1_g = new CirculoGrafico(0.3f, 360, true);
		c1 = new Circulo(0, 0, 0.3f);

		r1_g = new RectanguloGrafico(0, 0, 2, 1);
		r1 = new Rectangulo(0, 0, 2, 1);
		r2_g = new RectanguloGrafico(0, 0, 2, 1);
		r2 = new Rectangulo(0, 0, 2, 1);
		r3_g = new RectanguloGrafico(0, 0, 2, 1);
		r3 = new Rectangulo(0, 0, 2, 1);

		r4_g = new RectanguloGrafico(0, 0, 2, 1);
		r4 = new Rectangulo(0, 0, 2, 1);
		r5_g = new RectanguloGrafico(0, 0, 2, 1);
		r5 = new Rectangulo(0, 0, 2, 1);
		r6_g = new RectanguloGrafico(0, 0, 2, 1);
		r6 = new Rectangulo(0, 0, 2, 1);
		/* Color de fondo */
		aviso = new Aviso();
		gl.glClearColor(0, 0, 0, 0);



	}
	public void dibujaCirculo1(GL10 gl){
		gl.glPushMatrix();
		gl.glTranslatef(x_c1, y_c1, 0);
		c1.x = x_c1;
		c1.y = y_c1;
		gl.glColor4f(0.5f, 0.5f, 0.5f, 1);
		c1_g.dibuja(gl);
		gl.glPopMatrix();
	}
	public void dibujaRectangulo1(GL10 gl){
		gl.glPushMatrix();
		gl.glTranslatef(x_r1, 5, 0);
		r1.x = x_r1;
		r1.y = y_r1;
		gl.glColor4f(1, 0.53f, 0.30f, 1);
		r1_g.dibuja(gl);
		gl.glPopMatrix();
	}

	public void dibujaRectangulo2(GL10 gl){
		gl.glPushMatrix();
		gl.glTranslatef(x_r2, 8, 0);
		r2.x = x_r2;
		r2.y = y_r2;
		gl.glColor4f(1, 0.53f, 0.30f, 1);
		r2_g.dibuja(gl);
		gl.glPopMatrix();
	}

	public void dibujaRectangulo3(GL10 gl){
		gl.glPushMatrix();
		gl.glTranslatef(x_r3, 3, 0);
		r3.x = x_r3;
		r3.y = y_r3;
		gl.glColor4f(1, 0.53f, 0.30f, 1);
		r3_g.dibuja(gl);
		gl.glPopMatrix();
	}
	public void dibujaRectangulo4(GL10 gl){
		gl.glPushMatrix();
		gl.glTranslatef(x_r4, 10, 0);
		r4.x = x_r4;
		r4.y = y_r4;
		gl.glColor4f(1, 0.53f, 0.30f, 1);
		r4_g.dibuja(gl);
		gl.glPopMatrix();
	}
	public void dibujaRectangulo5(GL10 gl){
		gl.glPushMatrix();
		gl.glTranslatef(x_r5, 12, 0);
		r5.x = x_r5;
		r5.y = y_r5;
		gl.glColor4f(1, 0.53f, 0.30f, 1);
		r5_g.dibuja(gl);
		gl.glPopMatrix();
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);


		dibujaRectangulo1(gl);
		dibujaRectangulo2(gl);
		dibujaRectangulo3(gl);
		dibujaRectangulo4(gl);
		dibujaRectangulo5(gl);

		if (sw1){

			gl.glLoadIdentity();
			gl.glColor4f(1, 1, 1, 1);
			aviso.dibuja(gl);


		}



		if (seSobreponen(c1, r1) && bandera1) {

			sonido4.play(10);
			bandera1 = false;
			sw1=true;
			flag=true;
		}else{

			if (bandera1){

				if (seSobreponen(c1, r2) && bandera2) {

					sonido4.play(10);
					bandera2 = false;
					sw1=true;
					flag=true;

				}else{
					if (bandera2)


					if (seSobreponen(c1, r3) && bandera3) {

						sonido4.play(10);
						bandera3 = false;
						sw1=true;
						flag=true;

					}else{
						if (bandera3)


						if (seSobreponen(c1, r4) && bandera4) {

							sonido4.play(10);
							bandera4 = false;
							sw1=true;
							flag=true;
						}else{
							if (bandera4)
								//gl.glLoadIdentity();

							if (seSobreponen(c1, r5) && bandera5) {

								sonido4.play(10);
								bandera5 = false;
								sw1=true;
								flag=true;
							}else{
								if (bandera5)
									//gl.glLoadIdentity();
									dibujaCirculo1(gl);

							}

						}

					}

				}
			}




		}





		// boton izquierdo
		gl.glLoadIdentity();
		gl.glTranslatef(-2, -5, 0);
		gl.glColor4f(0.81f, 0.81f, 0.81f, 0);
		circulo.dibuja(gl);


		gl.glLoadIdentity();
		gl.glTranslatef(-2, -5, 0);
		gl.glColor4f(0, 0, 0, 0);
		circulo2.dibuja(gl);

		gl.glLoadIdentity();
		gl.glTranslatef(-2, -5, 0);
		gl.glColor4f(0.81f, 0.81f, 0.81f, 0);
		circulo3.dibuja(gl);

		//boton derecho
		gl.glLoadIdentity();
		gl.glTranslatef(2, -5, 0);
		gl.glColor4f(0.81f, 0.81f, 0.81f, 0);
		circulo.dibuja(gl);


		gl.glLoadIdentity();
		gl.glTranslatef(2, -5, 0);
		gl.glColor4f(0, 0, 0, 0);
		circulo2.dibuja(gl);

		gl.glLoadIdentity();
		gl.glTranslatef(2, -5, 0);
		gl.glColor4f(0.81f, 0.81f, 0.81f, 0);
		circulo3.dibuja(gl);

		//boton abajo
		gl.glLoadIdentity();
		gl.glTranslatef(0, -6.5f, 0);
		gl.glColor4f(0.81f, 0.81f, 0.81f, 0);
		circulo.dibuja(gl);


		gl.glLoadIdentity();
		gl.glTranslatef(0, -6.5f, 0);
		gl.glColor4f(0, 0, 0, 0);
		circulo2.dibuja(gl);

		gl.glLoadIdentity();
		gl.glTranslatef(0, -6.5f, 0);
		gl.glColor4f(0.81f, 0.81f, 0.81f, 0);
		circulo3.dibuja(gl);



		// control de mov de rectangulos
		x_r1 = x_r1 + xVelocidad_r1;
		if(x_r1 > 2 || x_r1 <= -4)
			xVelocidad_r1 = -xVelocidad_r1;

		x_r2 = x_r2 + xVelocidad_r2;
		if (x_r2 < -4 || x_r2 > 2) // izq y der
			xVelocidad_r2 = -xVelocidad_r2;

		x_r3 = x_r3 + xVelocidad_r3;
		if (x_r3 < -4 || x_r3 > 2) // izq y der
			xVelocidad_r3 = -xVelocidad_r3;
		x_r4 = x_r4 + xVelocidad_r4;
		if (x_r4 < -4 || x_r4 > 2) // izq y der
			xVelocidad_r4 = -xVelocidad_r4;
		x_r5 = x_r5 + xVelocidad_r5;
		if (x_r5 < -4 || x_r5 > 2) // izq y der
			xVelocidad_r5 = -xVelocidad_r5;


		gl.glFlush();

	}

	@Override
	public void onSurfaceChanged(GL10 gl, int w, int h) {
		/* Obtiene el ancho y el alto de la pantalla */
		ancho = w;
		alto = h;
		/* Ventana de despliegue */
		gl.glViewport(0, 0, ancho, alto);
		/* Matriz de Proyecci�n */
		gl.glMatrixMode(GL10.GL_PROJECTION);
		/* Inicializa la Matriz de Proyecci�n */
		gl.glLoadIdentity();
		/* Proyecci�n paralela */

		GLU.gluOrtho2D(gl, -4, 4, -8, 8);
		/* Matriz del Modelo-Vista */
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		/* Inicializa la Matriz del Modelo-Vista */
		gl.glLoadIdentity();
	}

	/**
	 * Maneja los eventos de la pantalla t�ctil.
	 */
	@Override
	public boolean onTouchEvent(MotionEvent e) {
		/* Obtiene la coordenada de la pantalla */

		float posx = e.getX();
		float posy = e.getY();
		/* Se considera cuando se levanta el dedo de la pantalla. */
		if (e.getAction() == MotionEvent.ACTION_DOWN) {

			/* En coordenadas del OpenGL */
			posx = ((posx / (float) ancho) * 8) - 4;
			posy = ((1 - posy / (float) alto) * 16) - 8;
			/* Verifica �rea elegida */
			// BOTON IZQUIERDO
			if (puntoEstaDentroDelCirculo(posx, posy, -2, -5, 1f)) {
				sonido1.play(1);
				x_c1 = x_c1 -1;


				Toast toast = Toast.makeText(contexto.getApplicationContext(), ">:V ",
						Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.TOP, 0, 0);
				toast.show();
				if(flag){
					 toast = Toast.makeText(contexto.getApplicationContext(), " PERDISTE! ",
							Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER| Gravity.CENTER_HORIZONTAL, -2, 0);
					toast.show();
				}
			}  // BOTON DEBAJO
			else if (puntoEstaDentroDelCirculo(posx, posy, 0, -6.5f, 1f)) {
				sonido2.play(1);
				y_c1 = y_c1 +1;
				Toast toast = Toast.makeText(contexto.getApplicationContext(), ">:V ",
						Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.TOP, 0, 0);
				toast.show();
				if(y_c1>13 ){
					if(flag){
						toast = Toast.makeText(contexto.getApplicationContext(), " Ya no intentes :v ! ",
								Toast.LENGTH_LONG);
						toast.setGravity(Gravity.CENTER| Gravity.CENTER_HORIZONTAL, -2, 0);
						toast.show();
					}
					else {
						sonido5.play(30);
						sw1=true;
						toast = Toast.makeText(contexto.getApplicationContext(), " GANASTE! ",
								Toast.LENGTH_LONG);
						toast.setGravity(Gravity.CENTER| Gravity.CENTER_HORIZONTAL, -2, 0);
						toast.show();
					}


				}
				if(flag){
					 toast = Toast.makeText(contexto.getApplicationContext(), " PERDISTE! ",
							Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER| Gravity.CENTER_HORIZONTAL, -2, 0);
					toast.show();
				}


			} // BOTON DERECHO
			else if (puntoEstaDentroDelCirculo(posx, posy, 2, -5f, 1f)) {
				sonido3.play(1);
				x_c1 = x_c1 + 1;

				Toast toast = Toast.makeText(contexto.getApplicationContext(), ">:V ",
						Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.TOP, 0, 0);
				toast.show();

				if(flag){
					toast = Toast.makeText(contexto.getApplicationContext(), " PERDISTE! ",
							Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER| Gravity.CENTER_HORIZONTAL, -2, 0);
					toast.show();
				}
			}
			// requestRender(); // Llama por defecto
		}
		return true;
	}

	private boolean puntoEstaDentroDelRectangulo(float posx, float posy, int x,
												 int y, int ancho, int alto) {
		return (x < posx && posx < x + ancho && y < posy && posy < y + alto);
	}

	private boolean puntoEstaDentroDelCirculo(float posx, float posy, float x,
											  float y, float radio) {
		return (distancia2(posx, posy, x, y) < radio * radio);
	}



	public boolean seSobreponen(Rectangulo r1, Rectangulo r2) {
		return (r1.x < r2.x + r2.ancho && r1.x + r1.ancho >  r2.x  &&
				r1.y < r2.y + r2.alto && r1.y	+ r1.alto > r2.y);
	}

	public float distancia2(float x1, float y1, float x2, float y2) {
		//La idea que estamos utilizando es que en vez de sacar la reiz cuadrada estamos
		//multiplicando por si mismo. Etonces esto lo hace más rápido. Lo de la colisión.
		return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
	}
	public boolean seSobreponen(Circulo c, Rectangulo r) {
		float x0 = c.x;
		float y0 = c.y;

		if (c.x < r.x) {
			x0 = r.x;
		} else if (c.x > r.x + r.ancho) {
			x0 = r.x + r.ancho;
		}

		if (c.y < r.y) {
			y0 = r.y;
		} else if (c.y > r.y + r.alto) {
			y0 = r.y + r.alto;
		}

		float d2 = distancia2(c.x, c.y, x0, y0);
		return  d2 < c.radio * c.radio;
	}
	public void playost(int x) {
		 sonido6.play(x);
	}
	/*
	public boolean seSobreponen(Circulo c1, Circulo c2) {
		float distanciaCentros2 = distancia2(c1.x, c1.y, c2.x, c2.y);
		float sumaRadios2 =(c1.radio + c2.radio) * (c1.radio + c2.radio);
		return distanciaCentros2 <= sumaRadios2;
	}*/


}
