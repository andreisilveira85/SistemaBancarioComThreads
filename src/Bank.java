import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addAccount(int accountNumber, Account account) {
        if (!accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, account);
            System.out.println("Conta adicionada com sucesso. Número da conta: " + accountNumber);
            System.out.println("----------------------------------------------------------------------------");
        } else {
            System.out.println("Uma conta com esse número já existe.");
            System.out.println("----------------------------------------------------------------------------");
        }
    }

    public Account getAccount(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber);
        } else {
            System.out.println("Conta não encontrada.");
            return null;
        }
    }

    public void deposit(int accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        }
    }

    public void withdraw(int accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        }
    }
}

