package com.challenge.code;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.challenge.code.Util.recurseForMinimumPacks;

public class Main {

    public static void main(String[] args) {
        List<Request> requests = processArgs(args);
        Basket basket = new Basket();
        for (Request request : requests) {
            List<Integer> packSizes = recurseForMinimumPacks(request.getQuantity(), request.getItemcode().getAvailability());
            for (Integer packSize : packSizes) {
                String itemCode = request.getItemcode().name();
                Double[] prices = Inventory.ITEM_PRICES.valueOf(itemCode).getPrice();
                Integer[] availability = Inventory.ITEM_CODES.valueOf(itemCode).getAvailability();
                Integer index = IntStream
                        .range(0, availability.length)
                        .filter(i -> packSize == availability[i])
                        .findFirst()
                        .orElse(-1);
                Item item = new Item(packSize, itemCode, prices[index]);
                basket.addItem(item, 1);
            }
        }
        basket.print();
    }

    private static List<Request> processArgs(String[] args) {
        List<Request> requests = new ArrayList<>();
        if (args != null) {
            int index = 0;
            String itemCode;
            int quantity = 0;
            for (String arg : args) {
                if (index % 2 != 0) {
                    itemCode = arg;
                    Request request = new Request(quantity, Inventory.ITEM_CODES.valueOf(itemCode));
                    requests.add(request);
                } else {
                    quantity = Integer.parseInt(arg);
                }
                index++;
            }
        }
        return requests;
    }
}
