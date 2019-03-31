package mra.com.tastyfoodcafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        Button feed=(Button)findViewById(R.id.FeedSend);


        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Feedback.this,"Feed Sended Thankyou For Feed Back",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
