import banking.domain.Bank;
import banking.domain.CheckingAccount;
import banking.domain.OverdraftException;
import banking.domain.SavingsAccount;
import banking.reports.CustomerReport;

/**
 * Created by bigger on 11/10/16.
 */
public class TestBanking {
    public static void main(String[] argvs) {
        Bank bank = new Bank();

        bank.addCustomer("Jane", "Simms");
        bank.getCustomer(0).addAccount(new SavingsAccount(500.00, 0.05));
        bank.getCustomer(0).addAccount(new CheckingAccount(200.00, true,400.00));

        bank.addCustomer("Owen", "Bryant");
        bank.getCustomer(1).addAccount(new CheckingAccount(200.00));

        bank.addCustomer("Tim", "Soley");
        bank.getCustomer(2).addAccount(new SavingsAccount(1500.00,0.05));
        bank.getCustomer(2).addAccount(new CheckingAccount(300));

        bank.addCustomer("Maria", "Soley");
        bank.getCustomer(3).addAccount(new SavingsAccount(150.00,0.05));
        bank.getCustomer(3).addAccount(bank.getCustomer(2).getAccount(1));

        CustomerReport report = new CustomerReport();
        report.generateReport(bank);

        /*
         * 模拟取款
         */
        try {
            System.out.println(bank.getCustomer(0).getName()+" 正在从信用帐户中取款...");
            bank.getCustomer(0).getAccount(1).withdraw(401);
            System.out.println("取款成功！");
            System.out.println();
        } catch (OverdraftException e) {
            System.out.println(e);
            System.out.println();
        }
        try {
            System.out.println(bank.getCustomer(3).getName()+" 正在从信用帐户中取款...");
            bank.getCustomer(3).getAccount(1).withdraw(150);
            System.out.println("取款成功！");
            System.out.println();
        } catch (OverdraftException e) {
            System.out.println(e);
            System.out.println();
        }
        report.generateReport(bank);
    }
}
