package com.example.inputcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    CheckBox checkBox;
    Spinner spinner;
    ToggleButton toggleButton;
    Button btnSubmit;
    EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        checkBox = findViewById(R.id.checkBox);
        spinner = findViewById(R.id.spinner);
        toggleButton = findViewById(R.id.toggleButton);
        btnSubmit = findViewById(R.id.btnSubmit);
        editTextName = findViewById(R.id.editTextName);

        // Spinner Data
        ArrayList<String> courses = new ArrayList<>();
        courses.add("Batter");
        courses.add("Bowler");
        courses.add("All-Rounder");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                courses);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Button Click
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = editTextName.getText().toString();

                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectedId);
                String radioValue = (radioButton != null) ? radioButton.getText().toString() : "None";

                String checkValue = checkBox.isChecked() ? "Yes" : "No";
                String spinnerValue = spinner.getSelectedItem().toString();
                String toggleValue = toggleButton.isChecked() ? "ON" : "OFF";

                String result = "Name: " + name +
                        "\nRadio: " + radioValue +
                        "\nCheckbox: " + checkValue +
                        "\nSpinner: " + spinnerValue +
                        "\nToggle: " + toggleValue;

                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });
    }
}