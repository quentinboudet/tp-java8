package java8.ex02;

import java8.data.Account;
import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


/**
 * Exercice 02 - Map
 */
public class Lambda_02_Test {

    // tag::PersonToAccountMapper[]
    interface PersonToMapper<T> {
        T map(Person p);
    }
    // end::PersonToAccountMapper[]

    // tag::map[]
    private <T> List<T> map(List<Person> personList, PersonToMapper<T> mapper) {
        //  implémenter la méthode pour transformer une liste de personnes en liste de comptes
    	List<T> comptes = new ArrayList<T>();
    	for(Person person : personList) {
    		comptes.add(mapper.map(person));
    	}
        return comptes;
    }
    // end::map[]


    // tag::test_map_person_to_account[]
    @Test
    public void test_map_person_to_account() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        //  transformer la liste de personnes en liste de comptes
        //  tous les objets comptes ont un solde à 100 par défaut
        
        PersonToMapper<Account> solde100 = p -> {
        	Account account = new Account();
        	account.setOwner(p);
        	account.setBalance(100);
        	return account;
        }; 
        List<Account> result = map(personList, solde100);

        assert result.size() == personList.size();
        for (Account account : result) {
            assert account.getBalance().equals(100);
            assert account.getOwner() != null;
        }
    }
    // end::test_map_person_to_account[]

    // tag::test_map_person_to_firstname[]
    @Test
    public void test_map_person_to_firstname() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        // TODO transformer la liste de personnes en liste de prénoms
        PersonToMapper<String> personToFirstName = (Person p) -> p.getFirstname();
        List<String> result = map(personList, personToFirstName);

        assert result.size() == personList.size();
        for (String firstname : result) {
            assert firstname.startsWith("first");
        }
    }
    // end::test_map_person_to_firstname[]
}
