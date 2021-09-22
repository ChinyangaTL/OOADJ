package practice_exam;

public class BankAccount {
    private String owner = "James";
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public BankAccount() {
        this("unknown", 0.00);
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
        }
    }

    public void withdrawal(double amount) {
        if(amount > 0) {
            balance = balance- amount;
        }
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }
}
