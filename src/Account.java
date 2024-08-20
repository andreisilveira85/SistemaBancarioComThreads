import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Account {
    private double balance;
    private List<Transaction> transactions;

    public Account(double initialBalance) {
        this.balance = Math.max(initialBalance, 0);
        this.transactions = new ArrayList<>();
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Depósito", amount, LocalDateTime.now()));
            System.out.println(Thread.currentThread().getName() + " - Depósito realizado com sucesso. Saldo atual: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " - O valor do depósito deve ser positivo.");
        }
    }

    public synchronized void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Retirada", amount, LocalDateTime.now()));
            System.out.println(Thread.currentThread().getName() + " - Retirada realizada com sucesso. Saldo atual: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " - Não foi possível realizar a retirada. Verifique o saldo e o valor da retirada.");
        }
    }

    public double getBalance() {
        synchronized (this) {
            return balance;
        }
    }

    public void printTransactions() {
        synchronized (this) {
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }
}


