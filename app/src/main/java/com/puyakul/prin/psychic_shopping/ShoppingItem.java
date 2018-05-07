
package com.puyakul.prin.psychic_shopping;

public class ShoppingItem {
    private int id;
    private String name, category, image;
    private int list_id, quantity, price;

    //getter
    public int getID(){
        return id;
    }

    public String getName(){
        return this.name;
    }

    public String getCatagory(){
        return this.category;
    }

    public String getImage(){
        return this.image;
    }

    public int getList_id(){
        return this.list_id;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public int getPrice(){
        return this.price;
    }

    //setter
    public void setID(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCatagory(String catagory){
        this.category = catagory;
    }

    public void setImage(String image){
        this.image = image;
    }

    public void setList_id(int list_id){
        this.list_id = list_id;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setPrice(int price){
        this.price = price;
    }
}
