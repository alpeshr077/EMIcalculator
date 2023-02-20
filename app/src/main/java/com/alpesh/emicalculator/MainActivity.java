package com.alpesh.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.time.Month;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText Amount = findViewById(R.id.Amt);
        EditText Interest = findViewById(R.id.interest);
        EditText Months = findViewById(R.id.months);
        Button cal = findViewById(R.id.cal);
        TextView Emi = findViewById(R.id.Emi);
        TextView TotalAmount = findViewById(R.id.TotalAmount);
        TextView TotalInterest = findViewById(R.id.TotalInterest);


        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Amt = Integer.parseInt(Amount.getText().toString());
                double interest = Double.parseDouble(Interest.getText().toString());
                int months = Integer.parseInt(Months.getText().toString());

                double r = interest / (12 * 100);
                double cal = 1;
                for (int i = 0; i < months; i++) {
                    cal *= (1 + r);
                }
                double ans = Amt * r * (cal / (cal - 1));
                Emi.setText("EMI = " + ans);
                double total = ans * months;
                TotalAmount.setText("Total Amount =" + total);
                double irate = total - Amt;
                TotalInterest.setText("Interest Amount = " + irate);

            }
        });
    }
}