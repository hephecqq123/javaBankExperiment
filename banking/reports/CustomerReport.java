package banking.reports;

import banking.domain.Bank;
import banking.domain.Customer;

import java.util.Iterator;

/**
 * Created by bigger on 11/10/16.
 */
public class CustomerReport {
    public CustomerReport() {

    }

    public void generateReport(Bank bank) {
        System.out.println("CUSTOMERS REPORT");
        System.out.println("==================");
        for(int i=0; i<bank.getNumOfCustomers(); i++) {
            Customer cus = bank.getCustomer(i);
            System.out.println("储户姓名："+cus.getName());
            for (int j=0; j<cus.getNumOfAccounts();j++) {
                System.out.println(cus.getAccount(j));
            }
            System.out.println();
        }
    }
}
