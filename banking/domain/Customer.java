package banking.domain;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by bigger on 11/10/16.
 */
public class Customer {
    private String firstName;
    private String lastName;
    private ArrayList<Account> accounts;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        accounts = new ArrayList<Account>();
    }

    public String getName() {
        return firstName + ' ' + lastName;
    }

    public void addAccount(Account acct) {
        accounts.add(acct);
    }

    public Account getAccount(int account_index) {
        return accounts.get(account_index);
    }

    public int getNumOfAccounts() {
        return accounts.size();
    }

    public Iterator<Account> getAccounts() {
        Iterator it = accounts.iterator();
        return it;
    }
}
