package com.example.registrationform;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPhone, etPassword, etDOB;
    RadioGroup radioGroup;
    Button btnSubmit;
    TextView tvResult;

    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);
        etDOB = findViewById(R.id.etDOB);
        radioGroup = findViewById(R.id.radioGroupGender);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);

        calendar = Calendar.getInstance();

        // 📅 DOB Date Picker
        etDOB.setOnClickListener(v -> {
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    MainActivity.this,
                    (view, year1, month1, dayOfMonth) -> {
                        String dob = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
                        etDOB.setText(dob);
                    },
                    year, month, day
            );
            datePickerDialog.show();
        });

        // 🚀 Submit Button
        btnSubmit.setOnClickListener(v -> {

            String name = etName.getText().toString();
            String email = etEmail.getText().toString();
            String phone = etPhone.getText().toString();
            String password = etPassword.getText().toString();
            String dob = etDOB.getText().toString();

            // 🔒 Mask password
            String maskedPassword = password.replaceAll(".", "*");

            int selectedId = radioGroup.getCheckedRadioButtonId();
            RadioButton selectedGender = findViewById(selectedId);
            String gender = (selectedGender != null)
                    ? selectedGender.getText().toString()
                    : "Not selected";

            // ⏰ Current time of submission
            String currentTime = new SimpleDateFormat(
                    "dd-MM-yyyy HH:mm:ss",
                    Locale.getDefault()
            ).format(new Date());

            // 📄 Final Output
            String result = "Name: " + name +
                    "\nEmail: " + email +
                    "\nPhone: " + phone +
                    "\nPassword: " + maskedPassword +
                    "\nDOB: " + dob +
                    "\nGender: " + gender +
                    "\nSubmitted at: " + currentTime;

            tvResult.setText(result);
        });
    }
}