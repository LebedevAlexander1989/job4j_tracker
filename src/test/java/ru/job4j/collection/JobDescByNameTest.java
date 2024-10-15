package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JobDescByNameTest {

    @Test
    public void testJobDescByName() {
        Job a = new Job("a", 1);
        Job b = new Job("b", 1);
        int rsl = new JobDescByName().compare(a, b);
        assertThat(rsl).isGreaterThan(0);
    }
}
