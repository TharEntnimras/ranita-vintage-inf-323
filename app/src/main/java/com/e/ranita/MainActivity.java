package com.e.ranita;



import android.app.Activity;
import android.media.MediaPlayer;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


public class MainActivity extends Activity {
    GLSurfaceView superficie;
    MediaPlayer player;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Ventana sin t�tulo */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        /* Establece las banderas de la ventana de esta Actividad */
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /* Se crea el objeto Renderiza */

        player = MediaPlayer.create(this,R.raw.ost);
        player.start();
        superficie = new Renderiza(this);
        

        /*
         * Activity <- GLSurfaceView : Coloca la Vista de la Superficie del
         * OpenGL como un Contexto de �sta Actividad.
         */
        setContentView(superficie);



        // setContentView(R.layout.activity_main);
    }


}