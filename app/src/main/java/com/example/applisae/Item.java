package com.example.applisae;

import com.google.gson.annotations.SerializedName;

public class Item{

    @SerializedName("itemName")
    private String itemName;

    @SerializedName("itemDescription")
    private String itemDescription;

    // Constructeur, getters, setters, etc.

    // Exemple de constructeur
    public Item(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    // Exemple de getters et setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    // D'autres méthodes, si nécessaire
}
