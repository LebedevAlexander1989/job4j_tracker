package ru.job4j.tracker.comparator;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.model.Item;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    void testSortAscByName() {
        Item b = new Item("B");
        Item a = new Item("A");
        Item c = new Item("C");
        List<Item> in = Arrays.asList(b, a, c);
        List<Item> expected = Arrays.asList(a, b, c);
        in.sort(new ItemAscByName());
        assertThat(in).isEqualTo(expected);
    }
}
