package banking.domain;

/**
 * Created by bigger on 11/10/16.
 */
public abstract class Account {
    private double balance;

    public Account(double initBalance) {
        this.balance = initBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws OverdraftException{
        if (amount <= balance)
            balance -= amount;
        else {
            throw new OverdraftException("当前余额不足！");
        }
    }
}
