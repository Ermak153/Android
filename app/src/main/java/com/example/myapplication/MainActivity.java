package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String name = "неопределено";
    final static String nameVariableKey = "NAME_VAR";
    final static String textViewTexKey = "TEXT_VIEW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void restoreField(View view) {
        TextView nameView = findViewById(R.id.saveTextView);
        nameView.setText(name);
    }

    public void saveField(View view) {
        TextView nameBox = findViewById(R.id.editTextTextMultiLine);
        name = nameBox.getText().toString();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(nameVariableKey, name);

        TextView nameView = findViewById(R.id.saveTextView);
        outState.putString(textViewTexKey, nameView.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        name = savedInstanceState.getString(nameVariableKey);
        String textViewText = savedInstanceState.getString(textViewTexKey);

        TextView nameView = findViewById(R.id.saveTextView);
        nameView.setText(textViewText);
    }
}
