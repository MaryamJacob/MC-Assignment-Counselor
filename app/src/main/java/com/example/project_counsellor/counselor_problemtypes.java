package com.example.project_counsellor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class counselor_problemtypes extends AppCompatActivity {

    private CheckBox cbMentalhealth;
    private CheckBox cbGrief;
    private CheckBox cbCareer;
    private CheckBox cbEducation;
    private Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counselor_problemtypes);

        cbMentalhealth = findViewById(R.id.cbMentalhealth);
        cbGrief = findViewById(R.id.cbGrief);
        cbCareer = findViewById(R.id.cbCareer);
        cbEducation = findViewById(R.id.cbEducation);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProblemTypes();
                navigateToNextActivity();
            }
        });
    }

    private void saveProblemTypes() {
        List<String> selectedProblemTypes = getSelectedProblemTypes();

        //database code from zayd may go here
        if (!selectedProblemTypes.isEmpty()) {
            String message = "Selected Problem Types: " + selectedProblemTypes.toString();
            Toast.makeText(counselor_problemtypes.this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(counselor_problemtypes.this, "Please select at least one problem type.", Toast.LENGTH_SHORT).show();
        }
    }

    private List<String> getSelectedProblemTypes() {
        List<String> selectedProblemTypes = new ArrayList<>();

        if (cbMentalhealth.isChecked()) {
            selectedProblemTypes.add(cbMentalhealth.getText().toString());
        }
        if (cbGrief.isChecked()) {
            selectedProblemTypes.add(cbGrief.getText().toString());
        }
        if (cbCareer.isChecked()) {
            selectedProblemTypes.add(cbCareer.getText().toString());
        }
        if (cbEducation.isChecked()) {
            selectedProblemTypes.add(cbEducation.getText().toString());
        }

        return selectedProblemTypes;
    }

    private void navigateToNextActivity() {
        Intent intent = new Intent(counselor_problemtypes.this, counselor_dashboard.class);
        startActivity(intent);
    }
}

