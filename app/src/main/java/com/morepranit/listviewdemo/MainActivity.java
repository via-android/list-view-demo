package com.morepranit.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /*private String[] fruits = {
            "Apple", "Banana", "Mango", "Guava"
    };*/

    private ArrayList<String> fruits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Guava");

        ListView listView = findViewById(R.id.lv_fruits);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, fruits);
        listView.setAdapter(adapter);

        final EditText edtFruit = findViewById(R.id.edt_fruit);

        Button btnAddFruit = findViewById(R.id.btn_add);
        btnAddFruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fruit = edtFruit.getText().toString();
                fruits.add(fruit);
                adapter.notifyDataSetChanged();
                edtFruit.setText("");
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "You chose " + fruits.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
