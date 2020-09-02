package com.example.sortdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import android.os.Bundle;

import org.w3c.dom.Text;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private Button sortButton;
    private EditText inputString;
    private TextView sortedString;
    private TextView warningMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sortButton = (Button) findViewById(R.id.sortButton);
        sortedString = (TextView) findViewById(R.id.sortedString);
        warningMsg = (TextView) findViewById(R.id.warningMsg);
        

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

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }

        return arr;
    }
    //TODO: Implement sort fucnction
    private void sort(String inputString) {
        int index = 0;
        String[] numberstr = inputString.split(",");
        int[] numbers = new int[numberstr.length];

        
        if(numberstr.length < 2){
            warningMsg.setText("Invalid numbers. Try again!!");
            return;
        } else {
            warningMsg.setText("");
        }

        for(int i = 0; i < numberstr.length; i++){
            try{
                numbers[index] = Integer.parseInt(numberstr[i]);
                index++;
        ;
            }
            catch (NumberFormatException nfe)
            {
                System.out.println(nfe);
            }
        }
        int count = 0;
        int[] numbersarr = selectionSort(numbers);
        String[] arr = new String[numbersarr.length];
        for(int i=0; i< numbersarr.length; i++){
            arr[i] = String.valueOf(numbersarr[i]);
        }


        String stuff = Arrays.toString(arr);
        sortedString.setText(stuff);
    }
}

