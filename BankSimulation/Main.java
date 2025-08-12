public class Main {
    public static void main(String[] args) {
        Account myAccount = new Account("Alice");

        myAccount.deposit(500);
        myAccount.withdraw(200);
        myAccount.withdraw(1000); // Should show error
        myAccount.deposit(300);

        System.out.println("\nCurrent Balance: $" + myAccount.getBalance());

        myAccount.printTransactionHistory();
    }
}
