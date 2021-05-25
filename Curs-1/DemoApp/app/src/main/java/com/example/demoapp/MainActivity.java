package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String ANDROID_URL = "https://developer.android.com/";

    private WebView webView;

    private Spinner spinnerAndroidVersions;
    private List<String> androidVersions;
    private ArrayAdapter<String> spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.webview_sample);
        setContentView(R.layout.spinner_layout);

        loadAndroidVersions();
        loadSpinnerAdapter();
        setSpinnerAdapter();
        handlingSpinnerListener();
    }

    // step 1: data source for our spinner
    private void loadAndroidVersions() {
        androidVersions = new ArrayList<>();
        androidVersions.add("Cupcake");
        androidVersions.add("Donut");
        androidVersions.add("Eclair");
        androidVersions.add("Pie");
        androidVersions.add("KitKat");
    }

    // step 2: setup adapter for our spinner
    private void loadSpinnerAdapter() {
        spinnerAdapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_spinner_item,
                androidVersions
        );
    }

    // step 3:
    private void setSpinnerAdapter() {
        spinnerAndroidVersions = findViewById(R.id.spinnerAndroidVersions);
        spinnerAndroidVersions.setAdapter(spinnerAdapter);
    }

    private void handlingSpinnerListener() {
        spinnerAndroidVersions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedAndroidVersion = androidVersions.get(position);
                Toast.makeText(MainActivity.this, selectedAndroidVersion, Toast.LENGTH_LONG)
                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}