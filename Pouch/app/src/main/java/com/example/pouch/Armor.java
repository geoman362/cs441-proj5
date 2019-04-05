package com.example.pouch;

public class Armor extends Item {
    public enum ArmorType{LIGHT,MEDIUM,HEAVY,SHIELD};

    private ArmorType type;
    private boolean stealthy;
    private String name, ac, strReq, weight, cost, content;
    private int id;

    public Armor(int id, String name, String ac, String strReq, String cost, String weight, String content, boolean stealthy, ArmorType type){
        super(id, name, weight, cost, ""); //No content for Armor
        this.id = id;
        this.name = name;
        this.ac = ac;
        this.strReq = strReq;
        this.stealthy = stealthy;
        this.type = type;
        this.content = content;
        this.weight = weight;
        this.cost = cost;
    }

    @Override
    public String toString(){
        return name +  " - " + getType() + " - ID: " + id + "\n\t" + content + "\n\tArmor Class: " + ac + "\n\tStealth Disadvantage: " + stealthy +
                "\n\tStrength Requirement: " + strReq + "\n\tWeight: " + weight + "\n\tCost: " + cost;
    }

    public String getAc() {
        return ac;
    }

    public String getStrReq() {
        return strReq;
    }

    public boolean isStealthy() {
        return stealthy;
    }

    public String getName() {
        return name;
    }

    public String getType(){
        switch(type){
            case LIGHT: return "Light Armor";
            case MEDIUM: return "Medium Armor";
            case HEAVY: return "Heavy Armor";
            case SHIELD: return "Shield";
        }
        return "No Type";
    }
}
