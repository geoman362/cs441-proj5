package com.example.pouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class AddItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        EquipmentParser ep = new EquipmentParser(this);
        ep.printEquipment(); //prints equipment in the list
        ArrayList<Item> items = ep.getItems(); //returns list of all items
    }
}
