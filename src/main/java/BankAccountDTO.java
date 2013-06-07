/**
 * Created with IntelliJ IDEA.
 * User: sqv-nbt
 * Date: 6/7/13
 * Time: 2:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountDTO {
    double balance;
    String accountNumber;

    public BankAccountDTO (String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return this.balance;  //To change body of created methods use File | Settings | File Templates.
    }

    public String getAccountNumber() {
        return this.accountNumber;  //To change body of created methods use File | Settings | File Templates.
    }

    public void setBalance(double sBalance) {
        this.balance = sBalance;
    }

    public void setAccountNumber (String sAccountNumber) {
        this.accountNumber = sAccountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BankAccountDTO) {
            BankAccountDTO bankAccountDTOFromObj = (BankAccountDTO) o;
            if ((bankAccountDTOFromObj.getBalance() == this.balance) && (bankAccountDTOFromObj.getAccountNumber().equals(this.accountNumber))) {
                return true;
            }
        }
        return false;
    }
}
