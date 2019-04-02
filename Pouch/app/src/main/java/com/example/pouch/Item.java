package com.example.pouch;


public class Item {
    private String name, weight, cost, content;
    //private Shape shape;

    public Item(String name, String weight, String cost, String content){
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.content = content;
        //shape = selectShape();
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }

    public String getCost() {
        return cost;
    }

    public String getContent() {
        return content;
    }

    public String toString(){
        return name + "\n\tWeight: " + weight + "\n\tCost: " + cost + "\n\t" + content;
    }
}

