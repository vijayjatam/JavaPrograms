package com.kali.kali.streams.lambda;

public class OrderItem {
    private final int id;
    private final double price;
    public OrderItem(int id,double price){
        this.id = id;
        this.price = price;
    }
    public int getId(){return this.id;}
    public double getPrice(){return this.price;}
    @Override
    public String toString(){
        return String.format("Id: %d and Price: %s",id,price);
    }

    public static void main(String[] args) {
        System.out.println(new OrderItem(10,11.11).toString());
    }
}
