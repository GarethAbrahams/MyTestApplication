package com.garethabrahams.mytestapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LastActivity extends AppCompatActivity {

    private TextView LastActtextView;
    private String Act5resultPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        LastActtextView = (TextView) findViewById(R.id.act5textView);
        setTitle("Last Activity");

        Intent intent = getIntent();
        String result = intent.getStringExtra("act4result");

        Act5resultPass = "Activity 5 read message:\n" + result;
        LastActtextView.setText(Act5resultPass);

        Button Act5button = findViewById(R.id.act5button);

        Act5button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent LastIntent = new Intent(LastActivity.this, MainActivity.class);
                LastIntent.putExtra("lastResult",Act5resultPass);
                setResult(RESULT_OK,LastIntent);
                startActivity(LastIntent);
            }
        });
    }
}
