package com.android.styl.resetserver.resettest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.styl.resetserver.ResetServiceManager;

public class MainActivity extends AppCompatActivity {

    Button reset_reader;
    Button program_reader;
    Button reset_can;
    Button program_can;
    TextView view;

    private ResetServiceManager resetService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reset_reader = findViewById(R.id.resR);
        program_reader = findViewById(R.id.proR);
        reset_can = findViewById(R.id.resC);
        program_can = findViewById(R.id.proC);

        view = findViewById(R.id.show);

        resetService = new ResetServiceManager(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        reset_reader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetService.reset_can();
                view.setText("Reset Reader");
            }
        });

        program_reader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetService.proram_reader();
                view.setText("Program Reader");
            }
        });

        reset_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetService.reset_can();
                view.setText("Reset CAN bus");
            }
        });

        program_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetService.program_can();
                view.setText("Program CAN bus");
            }
        });
    }
}
