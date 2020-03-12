package com.cdioDnD.dataTypes;

public class ItemDTO implements IItemDTO {
    String name;
    String description;
    double weight;

    public ItemDTO(String name, String description, double weight){
        this.name = name;
        this.description = description;
        this.weight= weight;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getWeight() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void setDescription(String description) {

    }
}
