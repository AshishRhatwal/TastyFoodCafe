package mra.com.tastyfoodcafe;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private int Splash_Screen=3200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent h=new Intent(MainActivity.this,
                        LoginPage.class);
                startActivity(h);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();

            }
        },Splash_Screen);
    }
}
