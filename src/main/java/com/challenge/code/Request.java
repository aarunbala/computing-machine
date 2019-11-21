package com.challenge.code;

public class Request {
    private int quantity;
    private Inventory.ITEM_CODES itemcode;

    public Request(int quantity, Inventory.ITEM_CODES itemcode) {
        this.quantity = quantity;
        this.itemcode = itemcode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Inventory.ITEM_CODES getItemcode() {
        return itemcode;
    }

    public void setItemcode(Inventory.ITEM_CODES itemcode) {
        this.itemcode = itemcode;
    }
}
