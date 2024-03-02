package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.*;

class JobTest {
    @Test
    public void whenComparatorDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int result = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int result = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorAscByName() {
        Comparator<Job> cmpAscName = new JobAscByName();
        int result = cmpAscName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscByPriority() {
        Comparator<Job> cmpAscPriority = new JobAscByPriority();
        int result = cmpAscPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> cmpDescName = new JobDescByName();
        int result = cmpDescName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> cmpDescPriority = new JobDescByPriority();
        int result = cmpDescPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result).isGreaterThan(0);
    }
}