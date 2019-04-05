package com.example.pouch;

import android.content.Context;
import android.util.Log;

import java.io.InputStream;
import java.util.ArrayList;

import org.json.*;

public class EquipmentParser {
    private static ArrayList<Item> equipment = new ArrayList<Item>();
    private int id;
    public EquipmentParser(Context context){
        id = 0;
        String json = readJSON(context);
        try {
            JSONObject obj = new JSONObject(json);
            JSONObject weapons = obj.getJSONObject("Equipment").getJSONObject("Weapons").getJSONObject("Weapons List");
            parseWeapons(weapons);
            JSONObject armor = obj.getJSONObject("Equipment").getJSONObject("Armor");
            parseArmor(armor);
            JSONObject items = obj.getJSONObject("Equipment").getJSONObject("Adventuring Gear");
            parseItems(items);
            JSONArray toolsJson = obj.getJSONObject("Equipment").getJSONObject("Tools").getJSONObject("Tools").getJSONArray("content");
            JSONObject tools = toolsJson.getJSONObject(0).getJSONObject("table");
            parseTools(tools);
        }catch(Exception e){}
    }

    public void printEquipment(){
        for(Item a: equipment){
            Log.i("Item", a.toString());
        }
        Log.i("Item Count","There are " + equipment.size() + " items.");
    }

    public ArrayList<String> getItems(){
        ArrayList<String> itemNames = new ArrayList<>();
        for(Item a: equipment){
            itemNames.add(a.getText());
        }
        return itemNames;
    }

    public int getID(String item){
        String name = item.split(" ")[0];
        for(Item a: equipment){
            if(name.equals(a.getName()))
                return a.getId();
        }
        return -1;
    }

    public void parseTools(JSONObject items){
        try {
            JSONArray names = items.getJSONArray("Item");
            JSONArray costs = items.getJSONArray("Cost");
            JSONArray weights = items.getJSONArray("Weight");


            for(int i = 0; i < names.length(); i++){
                equipment.add(new Item(id, names.getString(i), weights.getString(i).isEmpty() ? "-" : weights.getString(i), costs.getString(i).isEmpty() ? "-" : costs.getString(i), ""));
                id++;
            }
        }catch(Exception e){}
    }

    public void parseItems(JSONObject items){
        try {
            JSONArray contents = items.getJSONArray("content");
            items = items.getJSONObject("Adventuring Gear").getJSONObject("table");

            JSONArray names = items.getJSONArray("Item");
            JSONArray costs = items.getJSONArray("Cost");
            JSONArray weights = items.getJSONArray("Weight");

            for (int i = 0; i < names.length(); i++) {
                equipment.add(new Item(id, names.getString(i), weights.getString(i), costs.getString(i), contents.getString(i)));
                id++;
            }
        }catch (Exception e){}
    }


    public void parseArmor(JSONObject armor){
        try {
            JSONObject lightTable = armor.getJSONObject("Armor List").getJSONObject("Light Armor").getJSONObject("table");
            JSONObject mediumTable = armor.getJSONObject("Armor List").getJSONObject("Medium Armor").getJSONObject("table");
            JSONObject heavyTable = armor.getJSONObject("Armor List").getJSONObject("Heavy Armor").getJSONObject("table");

            JSONArray content = armor.getJSONObject("Light Armor").getJSONArray("content");
            parseArmorTable(lightTable, Armor.ArmorType.LIGHT, content);
            content = armor.getJSONObject("Medium Armor").getJSONArray("content");
            parseArmorTable(mediumTable, Armor.ArmorType.MEDIUM, content);
            content = armor.getJSONObject("Heavy Armor").getJSONArray("content");
            parseArmorTable(heavyTable, Armor.ArmorType.HEAVY, content);

        }catch(Exception e){}
    }

    public void parseArmorTable(JSONObject table, Armor.ArmorType type, JSONArray contents){
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> acs = new ArrayList<String>();
        ArrayList<String> strReqs = new ArrayList<String>();
        ArrayList<Boolean> stealthy = new ArrayList<Boolean>();

        try {
            JSONArray armorNames = table.getJSONArray("Armor");
            JSONArray armorAC = table.getJSONArray("Armor Class (AC)");
            JSONArray armorStealthy = table.getJSONArray("Stealth");
            JSONArray strengths = table.getJSONArray("Strength");
            JSONArray costs = table.getJSONArray("Cost");
            JSONArray weights = table.getJSONArray("Weight");

            for (int i = 0; i < armorNames.length(); i++) {
                acs.add(armorAC.getString(i));
                names.add(armorNames.getString(i));
                if (armorStealthy.getString(i).equals("-"))
                    stealthy.add(true);
                else
                    stealthy.add(false);
                if (strengths.getString(i).equals("â€”"))
                    strReqs.add("None");
                else
                    strReqs.add(strengths.getString(i));

                equipment.add(new Armor(id, names.get(i), acs.get(i), strReqs.get(i), costs.getString(i), weights.getString(i), contents.getString(i), stealthy.get(i), type));
                id++;
            }
            equipment.add(new Armor(id,"Shield", "+2 AC", "-", "10 gp", "6 lb.", "***Shield*** It's a shield", true, Armor.ArmorType.SHIELD));
            id++;
            names.clear();
            acs.clear();
            strReqs.clear();
            stealthy.clear();
        }catch (Exception e){}
    }

    public void parseWeapons(JSONObject weapons){
        try {
            parseWeaponTable(weapons.getJSONObject("Simple Melee Weapons").getJSONObject("table"), Weapon.WeaponType.SIMPLE_MELEE);
            parseWeaponTable(weapons.getJSONObject("Simple Ranged Weapons").getJSONObject("table"), Weapon.WeaponType.SIMPLE_RANGED);
            parseWeaponTable(weapons.getJSONObject("Martial Melee Weapons").getJSONObject("table"), Weapon.WeaponType.MARTIAL_MELEE);
            parseWeaponTable(weapons.getJSONObject("Martial Ranged Weapons").getJSONObject("table"), Weapon.WeaponType.MARTIAL_RANGED);
        }catch(Exception e){}
    }

    public void parseWeaponTable(JSONObject table, Weapon.WeaponType type){
        try {
            JSONArray names = table.getJSONArray("Name");
            JSONArray costs = table.getJSONArray("Cost");
            JSONArray damages = table.getJSONArray("Damage");
            JSONArray weights = table.getJSONArray("Weight");
            JSONArray properties = table.getJSONArray("Properties");

            for (int i = 0; i < names.length(); i++) {
                String name = names.getString(i);
                String damage = damages.getString(i);
                String property = properties.getString(i);
                String weight = weights.getString(i);
                String cost = costs.getString(i);
                if (damage.equals("â€”"))
                    damage = "None";
                if (property.equals("â€”"))
                    property = "None";
                equipment.add(new Weapon(id, name, damage, property, weight, cost, type));
                id++;
            }
        }catch(Exception e){}
    }

    public String readJSON(Context context){
        String json = null;
        try {
            InputStream is = context.getAssets().open("equipment.json");

            int size = is.available();
            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
