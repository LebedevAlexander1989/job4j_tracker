package ru.job4j.stream;

public class Card {

    private final Suit suit;
    private final Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public enum Suit {
        DIAMONDS, HEARTS, SPADES, CLUBS
    }

    public enum Value {
        V_6, V_7, V_8
    }

    @Override
    public String toString() {
        return "Card{" + "suit=" + suit + ", value=" + value + '}';
    }
}
