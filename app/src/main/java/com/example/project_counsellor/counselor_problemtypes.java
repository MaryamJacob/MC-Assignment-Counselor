package com.example.project_counsellor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class counselor_problemtypes extends AppCompatActivity {

    private RadioGroup rgProblemTypes;
    private Button btnSave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counselor_problemtypes);


        rgProblemTypes = findViewById(R.id.rgProblemTypes);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveProblemType();
                navigateToNextActivity();
            }
        });

    }
    private void saveProblemType() {
        String problemType = getSelectedProblemType();

//        code that needs to save problem types into the database that will be used to match user with counselor
        //example of code
//        UserDatabase userDatabase = UserDatabase.getInstance(this);
//        userDatabase.saveProblemType(problemType);
//        Toast.makeText(ProblemTypeActivity.this, "Problem type saved successfully", Toast.LENGTH_SHORT).show();
    }
    private String getSelectedProblemType() {
        int selectedId = rgProblemTypes.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        if (selectedRadioButton != null) {
            return selectedRadioButton.getText().toString();
        }
        return "";
    }
    private void navigateToNextActivity() {

        Intent intent = new Intent(counselor_problemtypes.this, counselor_dashboard.class);
        startActivity(intent);
    }


}