package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // Variables
    Button addButton, deleteButton;
    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //access ListView using it's ID
        cityList = findViewById(R.id.city_list);

        //define some data
        String [] cities = {"Edmonton","Calgary","Vancouver","Montreal","Sydney"};
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        //initialize adapter with data from cities
        //gets the layout from content.xml
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        //access the buttons using their IDs
        addButton = findViewById(R.id.addButtonId);
        deleteButton = findViewById(R.id.deleteButtonId);

        //on button click add a city
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dataList.add("New city"); // Change later
                cityAdapter.notifyDataSetChanged();
            }
        });

        //on button click delete a city
        deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dataList.remove(dataList.size() - 1); // Change later
                cityAdapter.notifyDataSetChanged();
            }
        });

    }
}