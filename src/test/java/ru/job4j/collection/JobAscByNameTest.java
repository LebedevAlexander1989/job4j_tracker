package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JobAscByNameTest {

    @Test
    public void testJobAscByName() {
        Job a = new Job("a", 1);
        Job b = new Job("b", 1);
        int rsl = new JobAscByName().compare(a, b);
        assertThat(rsl).isLessThan(0);
    }
}
