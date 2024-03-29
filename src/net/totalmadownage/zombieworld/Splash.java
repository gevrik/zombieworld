package net.totalmadownage.zombieworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class Splash extends Activity {

     // ===========================================================
     // Fields
     // ===========================================================
     
     private final int SPLASH_DISPLAY_LENGHT = 1500;

     // ===========================================================
     // "Constructors"
     // ===========================================================

     /** Called when the activity is first created. */
     @Override
     public void onCreate(Bundle icicle) {
          super.onCreate(icicle);
          this.requestWindowFeature(Window.FEATURE_NO_TITLE);
          this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
          setContentView(R.layout.splashscreen);
          
          /* New Handler to start the Menu-Activity
           * and close this Splash-Screen after some seconds.*/
          new Handler().postDelayed(new Runnable(){
               @Override
               public void run() {
                    /* Create an Intent that will start the Menu-Activity. */
                    Intent mainIntent = new Intent(Splash.this,Zombieworld.class);
                    Splash.this.startActivity(mainIntent);
                    Splash.this.finish();
               }
          }, SPLASH_DISPLAY_LENGHT);
     }
}