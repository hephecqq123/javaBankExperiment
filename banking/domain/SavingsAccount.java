package banking.domain;

/**
 * Created by bigger on 11/10/16.
 */
public class SavingsAccount extends Account {
    double interestRate;

    public SavingsAccount(double initBalance, double interestRate) {
        super(initBalance);
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return("Saving Account：当前余额是￥" + super.getBalance());
    }
}
