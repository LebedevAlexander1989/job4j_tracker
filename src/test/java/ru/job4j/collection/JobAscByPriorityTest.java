package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JobAscByPriorityTest {

    @Test
    public void testJobAscByName() {
        Job a = new Job("a", 1);
        Job b = new Job("b", 2);
        int rsl = new JobAscByPriority().compare(a, b);
        assertThat(rsl).isLessThan(0);
    }
}
