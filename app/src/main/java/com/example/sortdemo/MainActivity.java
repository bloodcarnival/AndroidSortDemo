package com.example.sortdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Html;
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
    private TextView duration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sortButton = (Button) findViewById(R.id.sortButton);
        sortedString = (TextView) findViewById(R.id.sortedString);
        warningMsg = (TextView) findViewById(R.id.warningMsg);
        duration = (TextView) findViewById(R.id.duration);

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

    /*public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }*/

    public void bubbleSort(int[] arr) {
        sortedString.setText("");
        int n = arr.length;
        boolean initial = true;
        boolean swapped = false;
        String newArray[] = new String[arr.length];
        for(int m=0; m<arr.length;m++){
            newArray[m] = String.valueOf(arr[m]);
        }
        for (int i = 0; i < n - 1; i++) {
            newArray[i] = String.valueOf(arr[i]);
            for (int j = 0; j < n - i - 1; j++) {
                if(initial == true) {
                    sortedString.append(Arrays.toString(arr) + "\n");
                    initial = false;
                }
                //sortedString.append(Html.fromHtml(Arrays.toString(arr) + "\n"));
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    newArray[j] = "<b>" + String.valueOf(arr[j+1]) + "</b>";

                    arr[j + 1] = temp;
                    newArray[j+1] = "<b>" + String.valueOf(temp) + "</b>";
                    swapped = true;
                }
                if(swapped == true) {
                    sortedString.append(Html.fromHtml(Arrays.toString(newArray)));
                    for (int l = 0; l < newArray.length; l++) {
                        String current = "";
                        if (newArray[l] != null) {
                            current = newArray[l];
                            if (current.contains("<b>")) {
                                current = current.replace("<b>", "");
                            } else if (current.contains("<b>")) {
                                current = current.replace("</b>", "");
                            }
                        }
                        newArray[l] = current;
                    }
                    sortedString.append("\n");
                }
                swapped = false;
            }
        }
        sortedString.append("Results: \n");
        sortedString.append(Arrays.toString(arr) + "\n");
    }
    //TODO: Implement sort function
    private void sort(String inputString) {
        sortedString.setText("");
        duration.setText("");

        long startTime = System.currentTimeMillis();
        int index = 0;
        String[] numberstr = inputString.split(",");
        int[] numbers = new int[numberstr.length];
        boolean warning = false;
        
        if(numberstr.length < 3 || numberstr.length > 8){
            warningMsg.setText("Invalid numbers. Try again!!");
            warning = true;
            return;
        } else {
            warningMsg.setText("");
            warning = false;
        }
        if(warning == false) {
            for (int i = 0; i < numberstr.length; i++) {
                try {
                    numbers[index] = Integer.parseInt(numberstr[i]);
                    index++;
                } catch (NumberFormatException nfe) {
                    System.out.println(nfe);
                }
            }
            //int[] numbersarr = bubbleSort(numbers);
        /*String[] arr = new String[numbersarr.length];
        for(int i=0; i< numbersarr.length; i++){
            arr[i] = String.valueOf(numbersarr[i]);
        }*/


            //String stuff = Arrays.toString(numbersarr);
            //sortedString.setText(stuff);
            bubbleSort(numbers);
            long endTime = System.currentTimeMillis();
            duration.setText(endTime + " milliseconds");
        }
    }
}

