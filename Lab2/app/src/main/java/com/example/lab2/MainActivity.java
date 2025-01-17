package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // Variables
    Button addButton, deleteButton, confrimButton;
    ListView cityList;
    EditText cityInput;
    LinearLayout inputLayout;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    String itemSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //access views using it's ID
        cityList = findViewById(R.id.city_list);
        addButton = findViewById(R.id.addButtonId);
        deleteButton = findViewById(R.id.deleteButtonId);
        cityInput = findViewById(R.id.textInput);
        confrimButton = findViewById(R.id.confirmButtonId);
        inputLayout = findViewById(R.id.inputLayout);

        //define some data
        String [] cities = {"Edmonton","Calgary","Vancouver","Montreal","Sydney"};
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        //initialize adapter with data from cities
        //gets the layout from content.xml
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        //on add city button click make the input layout visible
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputLayout.setVisibility(View.VISIBLE);
            }
        });

        // on confirm button click, add the city in text input to our city list
        confrimButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text inputted and add to list if input is not empty
                String input = String.valueOf((cityInput.getText()));
                if (!input.isEmpty()) {
                    dataList.add(input);
                    cityAdapter.notifyDataSetChanged();
                }
                // make layout invisible again
                inputLayout.setVisibility(View.GONE);
                // reset text in edit text
                cityInput.setText("");
            }
        });

        // on item click on list, select the item clicked
        // Set item click listener to select an item
        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                itemSelected = dataList.get(position);
            }
        });

        //on delete button click delete a city
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataList.remove(itemSelected);
                cityAdapter.notifyDataSetChanged();
            }
        });
    }
}