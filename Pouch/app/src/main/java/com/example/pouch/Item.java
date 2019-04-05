package com.example.pouch;


public class Item {
    private int id;
    private String name, weight, cost, content;
    //private Shape shape;

    public Item(int id, String name, String weight, String cost, String content){
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.content = content;
        //shape = selectShape();
    }

    public int getId(){
        return id;
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
        return name + " - ID: " + id + "\n\tWeight: " + weight + "\n\tCost: " + cost + "\n\t" + content;
    }
}

