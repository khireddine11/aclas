package com.example.aclas;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aclas.adapter.AlcasAdapter;
import com.example.aclas.daoimpl.DaoImplAlcas;
import com.example.aclas.model.Aclas;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final DaoImplAlcas daoService = new DaoImplAlcas();
    private AlcasAdapter adapter;

    private Spinner paymentSpinner;
    private EditText priceInput;
    private Button calculateBtn;
    private RecyclerView recyclerView;

    private final String[] options = {"1000", "2000", "3000", "4000", "5000", "6000", "7000", "8000"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. ربط العناصر بالواجهة
        paymentSpinner = findViewById(R.id.paymentSpinner);
        priceInput = findViewById(R.id.priceInput);
        calculateBtn = findViewById(R.id.calculateBtn);
        recyclerView = findViewById(R.id.recyclerView);

        // 2. إعداد الـ Spinner (الـ ComboBox)
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, options);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paymentSpinner.setAdapter(spinnerAdapter);

        // 3. إعداد الـ RecyclerView (الـ TableView)
        adapter = new AlcasAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // 4. برمجة زر الحساب (Calculate Button Event)
        calculateBtn.setOnClickListener(v -> {
            try {
                String selectedWeightStr = paymentSpinner.getSelectedItem().toString();
                double maxWeight = Double.parseDouble(selectedWeightStr);
                int basePrice = Integer.parseInt(priceInput.getText().toString());

                // تنفيذ العمليات وحساب الهوامش
                ArrayList<Aclas> results = daoService.calculateValidIncrements(maxWeight, basePrice);

                // تحديث الجدول بالنتائج
                adapter.setItems(results);

            } catch (NumberFormatException ex) {
                Toast.makeText(MainActivity.this, "Please enter valid numeric values.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}