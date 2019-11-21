package com.challenge.code;

import java.util.*;

public class Basket {
    Map<Item, Integer> itemIntegerMap = new HashMap<>();
    Map<Request, Map.Entry>  requestMap = new HashMap<>();
    List<Request> requests = new ArrayList<>();
    Set<String> uniqueItems = new HashSet<>();

    public void addItem(Item item, Integer count) {
        if (isItemPresent(item)) {
            Integer cnt = this.itemIntegerMap.get(item);
            this.itemIntegerMap.put(item, count + cnt);
        } else {
            this.itemIntegerMap.put(item, count);
            this.uniqueItems.add(item.getItem());
        }
    }

    public void print() {
        for (Map.Entry<Item, Integer> entry : itemIntegerMap.entrySet()) {
            Item item = entry.getKey();

            System.out.println(entry.getValue() + " X " + item);
        }
    }

    public boolean isItemPresent(Item item) {
        return this.itemIntegerMap.containsKey(item);
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}