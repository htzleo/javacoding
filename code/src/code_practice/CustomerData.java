package code_practice;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * // TODO
 * // 1)
 * // Fix CustomerData so that the output is sorted
 * // [{Aladin, Smith}, {Doe, Jane}, {Doe, John}, {Smith, Adam}]
 * //
 * // See the javadocs of CustomerData
 *
 * System.out.println(customers.getCustomers());
 *
 * // TODO
 * // 2)
 * // Implement the getCustomerByName() method to return the Customer
 * // object from customerData matching the first and last name provided to
 * // the method as input parameters.
 * //
 * // See the javadocs of CustomerData
 *
 * System.out.println(customers.getCustomerByName("Adam", "Smith"));
 *
 * // TODO
 * // 3)
 * // Modify the inner Customer class so that its contents cannot be
 * // modified after object creation (a.k.a. immutability).
 *
 * // TODO
 * // 4)
 * // Assume that a singleton instance of CustomerData is deployed in an
 * // application server container where multiple threads may access its
 * // methods concurrently. How can you ensure that all threads see the
 * // most up-to-date value of the customerData field?
 */
public class CustomerData{
         //List<Customer> customers = new ArrayList<>();
    private static volatile CustomerData instance;
    public static CustomerData getInstance(){
        if (instance == null){
            synchronized(CustomerData.class){
                if (instance == null){
                    instance = new CustomerData();
                }
            }
        }
        return instance;
    }

    private CustomerData() {
    }

    List<Customer> customers = new CopyOnWriteArrayList<>();

        public synchronized List<Customer> getCustomers(List<Customer> customers){
        customers.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                int res = o1.getLastname().compareTo(o2.getLastname());
                if (res == 0)
                    res = o1.getFirstName().compareTo(o2.getFirstName());
                return res;
            }
        });
        List<Customer> res = customers.stream().sorted(Comparator.comparing(Customer::getLastname)
                .thenComparing(Customer::getFirstName)).collect(Collectors.toList());
        return res;

    }
        public synchronized List<Customer> getCustomerByname (List<Customer> customers,String fn, String ln){
        List<Customer> resname = customers.stream().filter(e ->
                e.getFirstName().equals(fn) && e.getLastname().equals(ln)).collect(Collectors.toList());
        if (resname.size() > 0) {
            return resname;
        } else {
            return null;
        }
    }
    @Test
    public void test(){

        CustomerData cd = getInstance();

        List<Customer> test = Arrays.asList(
                new Customer("Aladin", "Smith"),
                new Customer("Doe", "Jane"),
                new Customer("Smith", "Adam")
        );
        cd.getCustomers(test).stream().map(c->c.getFirstName()+" "+c.getLastname()).
                forEach(System.out::println);
        cd.getCustomerByname(test,"Doe","Jane").stream().map(c->c.getFirstName()+" "+c.getLastname()).
                forEach(System.out::println);
    }
}
class Customer {
    private final String firstName;
    private final String lastname;

    public Customer(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public String getFirstName() {
        return firstName;
    }



    public String getLastname() {
        return lastname;
    }

}
