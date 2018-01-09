package java8.ex03;

import org.junit.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Exercice 03 - LocalTime
 */
public class DateAndTime_03_Test {

    @Test
    public void test_localTime_of() {

        // TODO créer un objet LocalTime à l'heure 15h24m02s
        LocalTime result = LocalTime.of(15, 24, 2);

        // TODO valoriser les différentes variables afin de rendre le test passant
        int hour = result.getHour();
        int minutes = result.getMinute();
        int second = result.getSecond();

        assertThat(hour, is(15));
        assertThat(minutes, is(24));
        assertThat(second, is(2));
    }

    @Test
    public void test_localTime_parse() {

        // TODO créer un objet LocalTime à l'heure 09h30m00s à l'aide de la méthode parse
        LocalTime result = LocalTime.parse("09:30:00");


        // TODO valoriser les différentes variables afin de rendre le test passant
        int hour = result.getHour();
        int minutes = result.getMinute();
        int second = result.getSecond();

        assertThat(hour, is(9));
        assertThat(minutes, is(30));
        assertThat(second, is(0));
    }

    @Test
    public void test_localTime_format() {

        // TODO créer un objet localTime à l'heure 12h00m00s
        // TODO utiliser la méthode of
        LocalTime localTime = LocalTime.of(12, 0, 0);

        // TODO Formatter l'heure pour que le test soit passant
        String result = localTime.format(DateTimeFormatter.ofPattern("hh:mm"));

        assertThat(result, is("12:00"));
    }
}
