package ru.job4j.inharitance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class JSONReportTest {

    @Test
    void whenTestGenerateMethod() {
        String ln = System.lineSeparator();
        String expected = "{" + ln
                + "\t\"name\" : \"Report's name\"," + ln
                + "\t\"body\" : \"Report's body\"" + ln
                + "}";
        String name = "Report's name";
        String body = "Report's body";
        String result = new JSONReport().generate(name, body);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenNameIsDavidBodyIsNameSong() {
        String ln = System.lineSeparator();
        String expexted = "{" + ln
                + "\t\"name\" : \"David Gilmour\"," + ln
                + "\t\"body\" : \"Shine On You Crazy Diamond\"" + ln
                + "}";
        String name = "David Gilmour";
        String body = "Shine On You Crazy Diamond";
        String result = new JSONReport().generate(name, body);
        assertThat(result).isEqualTo(expexted);
    }
}