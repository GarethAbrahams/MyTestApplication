package com.garethabrahams.mytestapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    private TextView Act3textView;
    private String Act3resultPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Act3textView = (TextView) findViewById(R.id.Act3textView);
        setTitle("Activity 3");

        Intent intent = getIntent();
        String result = intent.getStringExtra("act2result");
        Act3resultPass = "Activity 3 read message:\n" + result;
        Act3textView.setText(Act3resultPass);

        Button Act3button = findViewById(R.id.act3button);

        Act3button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act3Intent = new Intent(Activity3.this,Activity4.class);
                act3Intent.putExtra("act3result",Act3resultPass);
                startActivity(act3Intent);

            }
        });
    }
}
