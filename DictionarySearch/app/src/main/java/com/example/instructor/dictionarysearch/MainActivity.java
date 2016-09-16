package com.example.instructor.dictionarysearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private EditText edittext;
    private Button searchButton;
    private TextView definitionText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext = (EditText) findViewById(R.id.editText);
        searchButton = (Button) findViewById(R.id.searchButton);
        definitionText = (TextView) findViewById(R.id.definitionText);

    }

    public void searchButtonClick(View view) {
        String word = edittext.getText().toString();

        String definition = searchDictionary(word);

        definitionText.setText(definition);
    }

    public String searchDictionary(String word){
        Scanner scan = new Scanner(getResources().openRawResource(R.raw.grewords));

        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] pieces = line.split("\t");
            if(pieces[0].equalsIgnoreCase(word.trim())){
                return pieces[1];

            }
        }


        return "No word found!";
    }
}
