package com.garethabrahams.mytestapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity4 extends AppCompatActivity {

    private TextView Act4textView, Act4MsgView;
    private String result, act4resultPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        Act4textView = (TextView) findViewById(R.id.act4textView);
        Act4MsgView = (TextView) findViewById(R.id.act4MsgView);
        setTitle("Activity 4");

        Intent intent = getIntent();
        result = intent.getStringExtra("result");
        act4resultPass = intent.getStringExtra("act3result");
        Act4MsgView.setText("Activity 4 reads: "+ result);
        act4resultPass = "Activity 4 read message:\n" + act4resultPass;
        Act4textView.setText("Conformation results: "+act4resultPass);

        Button Act4button = findViewById(R.id.act4button);

        Act4button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act4Intent = new Intent(Activity4.this, LastActivity.class);
                act4Intent.putExtra("result",result);
                act4Intent.putExtra("act4result",act4resultPass);
                startActivity(act4Intent);
            }
        });

    }
}
