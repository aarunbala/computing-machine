package com.challenge.code;

public class Inventory {

    public enum ITEM_PRICES {
        VS5(6.99, 8.99), CF(5.95, 9.95, 16.99), MB11(9.95, 16.95, 24.95);
        Double[] price;

        ITEM_PRICES(Double... price) {
            this.price = price;
        }

        Double[] getPrice() {
            return price;
        }
    }

    public enum ITEM_CODES {
        VS5(3, 5), CF(3, 5, 9), MB11(2, 5, 8);
        Integer[] availability;

        ITEM_CODES(Integer... availability) {
            this.availability = availability;
        }

        Integer[] getAvailability() {
            return availability;
        }
    }
}
