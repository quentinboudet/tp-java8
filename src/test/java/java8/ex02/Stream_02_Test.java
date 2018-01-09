package java8.ex02;

import java8.data.Data;
import java8.data.domain.Customer;
import java8.data.domain.Order;
import java8.data.domain.Pizza;
import org.junit.Test;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 02 - Transformation
 */
public class Stream_02_Test {

    @Test
    public void test_map() throws Exception {

        List<Order> orders = new Data().getOrders();

        // Trouver la liste des clients ayant déjà passés une commande
        Set<Customer> result = orders.stream().map(o -> o.getCustomer()).collect(Collectors.toSet());

        assertThat(result, hasSize(2));
    }

    @Test
    public void test_flatmap() throws Exception {

        List<Order> orders = new Data().getOrders();

        // TODO calculer les statistiques sur les prix des pizzas vendues
        // TODO utiliser l'opération summaryStatistics
        IntSummaryStatistics result = orders.stream()
        		.flatMap(o -> o.getPizzas().stream())
        		.collect(Collectors.summarizingInt(p -> p.getPrice()));


        assertThat(result.getSum(), is(10900L));
        assertThat(result.getMin(), is(1000));
        assertThat(result.getMax(), is(1375));
        assertThat(result.getCount(), is(9L));
    }
}
