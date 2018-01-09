package java8.ex04;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 04 - LocalDateTime
 */
public class DateAndTime_04_Test {

    @Test
    public void test_localDateTime_of() {

        // TODO créer un objet LocalDateTime à la date heure 12h00m00s 01/01/2018
        LocalDateTime result = LocalDateTime.of(2018, 1, 1, 12, 0, 0);

        // TODO valoriser les différentes variables afin de rendre le test passant
        int hour = result.getHour();
        int minutes = result.getMinute();
        int second = result.getSecond();
        int year = result.getYear();
        Month month = result.getMonth();
        int dayOfMonth = result.getDayOfMonth();

        assertThat(hour, is(12));
        assertThat(minutes, is(0));
        assertThat(second, is(0));
        assertThat(year, is(2018));
        assertThat(month, is(Month.JANUARY));
        assertThat(dayOfMonth, is(1));
    }

    @Test
    public void test_localDateTime_parse() {

        // TODO créer un objet LocalTime à l'heure 2 mars 2009 à 09h30m00s à l'aide de la méthode parse
        LocalDateTime result = LocalDateTime.parse("2009-03-02 09:30:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // TODO valoriser les différentes variables afin de rendre le test passant
        int hour = result.getHour();
        int minutes = result.getMinute();
        int second = result.getSecond();

        int year = result.getYear();
        Month month = result.getMonth();
        int dayOfMonth = result.getDayOfMonth();

        assertThat(year, is(2009));
        assertThat(month, is(Month.MARCH));
        assertThat(dayOfMonth, is(2));

        assertThat(hour, is(9));
        assertThat(minutes, is(30));
        assertThat(second, is(0));
    }

    @Test
    public void test_localDateTime_format() {

        // TODO créer un objet LocalDateTime le 27/11/2017 à 12h00m00s
        // TODO utiliser la méthode of
        LocalDateTime localDateTime = LocalDateTime.of(2017, 11, 27, 12, 00, 00);

        // TODO Formatter l'heure pour que le test soit passant
        String result = localDateTime.format(DateTimeFormatter.ofPattern("yyyy - MM/dd hh:mm"));

        assertThat(result, is("2017 - 11/27 12:00"));
    }
}
