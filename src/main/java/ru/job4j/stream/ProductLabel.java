package ru.job4j.stream;

import java.util.List;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(p -> Math.abs(p.getActual() - p.getStandard()) >= 0
                        && Math.abs(p.getActual() - p.getStandard()) <= 3)
                .map(p -> new Label(p.getName(), p.getPrice() / 2))
                .map(Label::toString)
                .toList();
    }
}
