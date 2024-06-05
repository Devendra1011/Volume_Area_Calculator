package com.example.volumeareacalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Sphere_Activity extends AppCompatActivity {
    EditText etRadius;
    TextView tvResult;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sphere);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        tvResult = findViewById(R.id.tv_result);
        etRadius = findViewById(R.id.et_radius);
        btnCalculate = findViewById(R.id.btn_calculate);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius = etRadius.getText().toString();
                int r = Integer.parseInt(radius);
                double volume = (4/3) * 3.1415 * r*r*r;
                tvResult.setText("V = "+volume+"m^3");
            }
        });
    }
}