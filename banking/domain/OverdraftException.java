package banking.domain;

/**
 * Created by bigger on 11/14/16.
 */
public class OverdraftException extends  Exception{
    private String msg;
    public OverdraftException(String msg) {
        this.msg = msg;
    }

    public OverdraftException() {

    }
    public String toString() {
        return(msg+"取款失败！");
    }
}
