import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountHolder;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
        System.out.println("Deposited $" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }
        balance -= amount;
        transactionHistory.add(new Transaction("Withdrawal", amount));
        System.out.println("Withdrew $" + amount);
    }

    public double getBalance() {
        return balance;
    }

    public void printTransactionHistory() {
        System.out.println("\nTransaction history for " + accountHolder + ":");
        for (Transaction t : transactionHistory) {
            System.out.println(t);
        }
    }
}
