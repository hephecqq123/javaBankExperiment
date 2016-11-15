package banking.domain;

import sun.util.resources.cldr.mas.CurrencyNames_mas;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by bigger on 11/10/16.
 */
public class Bank {
    private ArrayList<Customer> customers;

    public Bank() {
        customers = new ArrayList<Customer>();
    }

    public void addCustomer(String firstName, String lastName) {
        customers.add(new Customer(firstName, lastName));
    }

    public Customer getCustomer(int customer_index) {
        return customers.get(customer_index);
    }

    public int getNumOfCustomers() {
        return customers.size();
    }

    public Iterator<Customer> getCustomers() {
        Iterator it = customers.iterator();
        return it;
    }
}
