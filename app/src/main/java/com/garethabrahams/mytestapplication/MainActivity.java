package com.garethabrahams.mytestapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private EditText textField;
    private  TextView mainTextView;
    private String textString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textField = (EditText) findViewById(R.id.enterNameText);
        mainTextView = (TextView) findViewById(R.id.mainTextView);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textString = textField.getText().toString();
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.putExtra("textString",textString);
                startActivityForResult(intent,1);
            }
        });

        Intent finalintent = getIntent();
        String results = finalintent.getStringExtra("lastResult");
        mainTextView.setText(results);

    }

}
