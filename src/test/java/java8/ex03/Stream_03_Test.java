package java8.ex03;

import java8.data.Data;
import java8.data.domain.Customer;
import java8.data.domain.Gender;
import java8.data.domain.Order;
import java8.data.domain.Pizza;
import org.junit.Test;
import org.omg.Messaging.SyncScopeHelper;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 03 - Collectors
 */
public class Stream_03_Test {

    @Test
    public void test_joining() throws Exception {

        List<Customer> customers = new Data().getCustomers();

        // TODO construire une chaîne contenant les prénoms des clients triés et séparé par le caractère "|"
        String result = customers.stream().map(c -> c.getFirstname()).sorted().collect(joining("|"));

        assertThat(result, is("Alexandra|Cyril|Johnny|Marion|Sophie"));
    }

    @Test
    public void test_grouping() throws Exception {

        List<Order> orders = new Data().getOrders();

        // TODO construire une Map <Client, Commandes effectuées par le client
        Map<Customer, List<Order>> result = orders.stream().collect(groupingBy(o -> o.getCustomer()));

        assertThat(result.size(), is(2));
        assertThat(result.get(new Customer(1)), hasSize(4));
        assertThat(result.get(new Customer(2)), hasSize(4));
    }

    @Test
    public void test_partitionning() throws Exception {
        List<Pizza> pizzas = new Data().getPizzas();

        // TODO Séparer la liste des pizzas en 2 ensembles :
        // TODO true -> les pizzas dont le nom commence par "L"
        // TODO false -> les autres
        Map<Boolean, List<Pizza>> result = pizzas.stream().collect(partitioningBy(p -> p.getName().startsWith("L")));

        assertThat(result.get(true), hasSize(6));
        assertThat(result.get(false), hasSize(2));
    }

    @Test
    public void test_mapping() throws Exception {

        List<Customer> customers = new Data().getCustomers();

        // TODO Construire la map Sexe -> Chaîne représentant les prénoms des clients
        Map<Gender, String> result = null;
//        customers.stream()
//        		.sorted(Comparator.comparing(c -> c.getFirstname())).collect(toList())
//        		.collect(Collectors.toMap(c -> c.getGender(), c -> c.getFirstname().stream().collect(joining("|"))));
//		
System.out.println(customers.stream()
		.sorted(Comparator.comparing(c -> c.getFirstname())).collect(toList()));



        assertThat(result.get(Gender.F), is("Alexandra|Marion|Sophie"));
        assertThat(result.get(Gender.M), is("Cyril|Johnny"));
    }
}
