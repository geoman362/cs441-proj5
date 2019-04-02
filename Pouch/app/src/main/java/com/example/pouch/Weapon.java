package com.example.pouch;

public class Weapon extends Item {
    private String name, damage, properties, weight, cost;
    public enum WeaponType{SIMPLE_MELEE, SIMPLE_RANGED, MARTIAL_MELEE, MARTIAL_RANGED};
    private WeaponType type;

    public Weapon(String name, String damage, String properties, String weight, String cost, WeaponType wt){
        super(name, weight, cost, "");
        this.weight = weight;
        this.cost = cost;
        this.name = name;
        this.damage = damage;
        this.properties = properties;
        this.type = wt;
    }

    @Override
    public String toString(){
        return name +  " - " + getType() +"\n\tDamage: " + damage + "\n\tProperties: " + properties +
                "\n\tWeight: " + weight + "\n\tCost: " + cost;
    }

    public String getDamage() {
        return damage;
    }

    public String getProperties() {
        return properties;
    }

    public String getType(){
        switch(type){
            case SIMPLE_MELEE: return "Simple Melee";
            case SIMPLE_RANGED: return "Simple Ranged";
            case MARTIAL_MELEE: return "Martial Melee";
            case MARTIAL_RANGED: return "Martial Ranged";
        }
        return "No type";
    }
}
