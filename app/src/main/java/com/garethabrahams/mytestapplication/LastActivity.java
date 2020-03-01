package com.garethabrahams.mytestapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LastActivity extends AppCompatActivity {

    private TextView act5textView, act5MsgView;
    private String result, act5resultPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        act5textView = (TextView) findViewById(R.id.act5textView);
        act5MsgView = (TextView) findViewById(R.id.act5MsgView);
        setTitle("Last Activity");

        Intent intent = getIntent();
        result = intent.getStringExtra("result");
        act5resultPass = intent.getStringExtra("act4result");
        act5MsgView.setText("Last Activity reads: "+ result);
        act5resultPass = "Final Conformation results: \nLast Activity read message:\n" + act5resultPass;
        act5textView.setText(act5resultPass);

        Button Act5button = findViewById(R.id.act5button);

        Act5button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent LastIntent = new Intent(LastActivity.this, MainActivity.class);
                LastIntent.putExtra("lastResult",act5resultPass);
                startActivity(LastIntent);
            }
        });
    }
}
