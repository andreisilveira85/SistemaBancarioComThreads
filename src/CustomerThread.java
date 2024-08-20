public class CustomerThread extends Thread {
    private final Bank bank;
    private final int accountNumber;
    private final double amount;
    private final boolean isDeposit;

    public CustomerThread(Bank bank, int accountNumber, double amount, boolean isDeposit, String name) {
        super(name);
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.isDeposit = isDeposit;
    }

    @Override
    public void run() {
        if (isDeposit) {
            bank.deposit(accountNumber, amount);
        } else {
            bank.withdraw(accountNumber, amount);
        }
    }
}
