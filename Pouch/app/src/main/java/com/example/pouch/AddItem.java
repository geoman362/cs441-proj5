package com.example.pouch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class AddItem extends AppCompatActivity {
    Spinner addItem;
    ArrayAdapter<String> itemAdapter;
    EquipmentParser ep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        ep = new EquipmentParser(this);
        ArrayList<String> items = ep.getItems(); //returns list of all items
        itemAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, items);
        addItem = findViewById(R.id.spinnerItems);
        addItem.setAdapter(itemAdapter);

        Button back2Pouch = findViewById(R.id.buttonReturn);
        back2Pouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(AddItem.this, Grid.class); // change when classes made
            String item = addItem.getSelectedItem().toString();
            int addID = ep.getID(item);
            Log.i("Add ID", Integer.toString(addID));
            intent.putExtra("new item", addID);
            }
        });
    }
}
