package com.challenge.code;

import java.util.Objects;

public class Item {
    private int packSize;
    private String item;
    private Double price;

    public Item(int packSize, String item, double price) {
        this.packSize = packSize;
        this.item = item;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getPackSize() {
        return packSize;
    }

    public void setPackSize(int packSize) {
        this.packSize = packSize;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "com.challenge.code.Item{" +
                "packSize=" + packSize +
                ", item='" + item + '\'' +
                ", price=$" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item1 = (Item) o;
        return packSize == item1.packSize &&
                Objects.equals(item, item1.item) &&
                Objects.equals(price, item1.price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(packSize, item, price);
    }
}
