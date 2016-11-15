package banking.domain;

/**
 * Created by bigger on 11/10/16.
 */
public class CheckingAccount extends Account {
    private boolean canOverdraft;
    double maxOverdraft;        //剩余透支余额
    double limitOverdraft;      //最大透支额度

    public CheckingAccount(double initBalance) {
        super(initBalance);
        canOverdraft = false;
        maxOverdraft = 0.0;
        limitOverdraft = 0.0;
    }

    public CheckingAccount(double initBalance, boolean canOverdraft, double maxOverdraft) {
        super(initBalance);
        this.canOverdraft = canOverdraft;
        this.maxOverdraft = maxOverdraft;
        this.limitOverdraft = maxOverdraft;
    }

    @Override
    public void deposit(double amount) {
        //limitOverdraft-maxOverdraft 是透支的钱

        if (maxOverdraft != limitOverdraft) {   //发生过透支的情况需要先补充透支额度再存款
            if(amount <= (limitOverdraft-maxOverdraft)) {   //存款不够偿还透支
                maxOverdraft += amount;
            } else {    //存款足够偿还透支
                super.deposit(amount-(limitOverdraft-maxOverdraft));
                maxOverdraft = limitOverdraft;
            }

        }
    }

    @Override
    public void withdraw(double amount) throws OverdraftException {
        if (amount <= super.getBalance()) {
            super.withdraw(amount);
        } else {                        //透支
            if (canOverdraft == false)  //不能透支的帐户
                throw new OverdraftException("当前帐户不能透支！");
            else {                      //支持透支的帐户
                if(amount > maxOverdraft)
                    throw new OverdraftException("透支额度超限！");
                else {
                    maxOverdraft -= (amount-super.getBalance());
                    super.withdraw(super.getBalance());
                }

            }
        }


    }

    @Override
    public String toString() {
        return("Checking Account：当前余额是￥"+super.getBalance());
    }
}
