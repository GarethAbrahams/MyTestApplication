package com.garethabrahams.mytestapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    private TextView Act2textView, Act2MsgView;
    private String result, resultPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Act2MsgView = (TextView) findViewById(R.id.Act2MsgView);
        Act2textView = (TextView) findViewById(R.id.Act2textView);

        setTitle("Activity 2");

        Intent intent = getIntent();
        result = intent.getStringExtra("textString");
        Act2MsgView.setText("Activity 2 reads: "+ result);
        resultPass = "Activity 2 read message:\n" + "*** "+result+" ***";
        Act2textView.setText("Conformation results: "+resultPass);

        Button Act2button = findViewById(R.id.Act2button);

        Act2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act2Intent = new Intent(Activity2.this,Activity3.class);
                act2Intent.putExtra("result",result);
                act2Intent.putExtra("act2result",resultPass);
                startActivity(act2Intent);

            }
        });
    }
}
