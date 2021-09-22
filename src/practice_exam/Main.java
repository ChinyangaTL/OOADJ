package practice_exam;

public class Main {
    public static void main(String[] args) {
        //BankAccount account = new BankAccount("Les", 1200.00);
        BankAccount account = new BankAccount("Thabang", 800);
        BankAccount account1 = new BankAccount("Les", 1200);

        System.out.println(account.getOwner());
        System.out.println(account1.getOwner());
    }
}
