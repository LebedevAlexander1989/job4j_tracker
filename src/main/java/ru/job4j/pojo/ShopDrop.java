package ru.job4j.pojo;

public class ShopDrop {

    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int i = index; i < products.length && i + 1 < products.length; i++) {
            products[i] = products[i + 1];
        }
        products[products.length - 1] = null;
        return products;
    }
}
