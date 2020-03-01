package com.garethabrahams.mytestapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    private TextView Act3textView,Act3MsgView;
    private String result, Act3resultPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Act3textView = (TextView) findViewById(R.id.Act3textView);
        Act3MsgView = (TextView) findViewById(R.id.Act3MsgView);
        setTitle("Activity 3");

        Intent intent = getIntent();
        result = intent.getStringExtra("result");
        Act3resultPass = intent.getStringExtra("act2result");
        Act3MsgView.setText("Activity 3 reads: "+ result);
        Act3resultPass = "Activity 3 read message:\n" + Act3resultPass;
        Act3textView.setText("Conformation results: " +Act3resultPass);

        Button Act3button = findViewById(R.id.Act3button);

        Act3button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act3Intent = new Intent(Activity3.this,Activity4.class);
                act3Intent.putExtra("result",result);
                act3Intent.putExtra("act3result",Act3resultPass);
                startActivity(act3Intent);

            }
        });
    }
}
