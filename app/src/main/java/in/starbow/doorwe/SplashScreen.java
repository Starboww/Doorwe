package in.starbow.doorwe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    ImageView bg,logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        bg =findViewById(R.id.background);
        logo=findViewById(R.id.logo);
        //bg.animate().translationY(800).setDuration(1000).setStartDelay(1500);
        logo.animate().setStartDelay(500).scaleX(2).scaleY(2).setDuration(2000);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash =new Intent(SplashScreen.this,UserCredential.class);
                startActivity(splash);
                finish();
            }
        },1890);
    }
}