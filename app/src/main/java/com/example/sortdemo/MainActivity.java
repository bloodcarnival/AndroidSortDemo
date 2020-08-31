package com.example.sortdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Button sortButton;
    private EditText inputString;
    private TextView sortedString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sortButton = (Button) findViewById(R.id.sortButton);
        sortedString = (TextView) findViewById(R.id.sortedString);
        // Add button logic
        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputString = (EditText) findViewById(R.id.inputString);
                sort(inputString.getText().toString());
                //Toast.makeText(getApplicationContext(), "Sorted", Toast.LENGTH_LONG).show();
            }
        });

    }
    //TODO: Implement sort fucnction
    private void sort(String inputString) {
        sortedString.setText(inputString);
        
    }
}