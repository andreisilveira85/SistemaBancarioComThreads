public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addAccount(1, new Account(1000));
        bank.addAccount(2, new Account(2000));
        bank.addAccount(3, new Account(1500));
        bank.addAccount(4, new Account(1200));
        bank.addAccount(5, new Account(1800));

        CustomerThread t1 = new CustomerThread(bank, 1, 300, true, "Cliente 1 Depositando");
        CustomerThread t2 = new CustomerThread(bank, 1, 500, false, "Cliente 1 Retirando");
        CustomerThread t3 = new CustomerThread(bank, 1, 200, true, "Cliente 1 Depositando novamente");

        CustomerThread t4 = new CustomerThread(bank, 2, 400, true, "Cliente 2 Depositando");
        CustomerThread t5 = new CustomerThread(bank, 2, 600, false, "Cliente 2 Retirando");
        CustomerThread t6 = new CustomerThread(bank, 2, 300, true, "Cliente 2 Depositando novamente");

        CustomerThread t7 = new CustomerThread(bank, 3, 500, true, "Cliente 3 Depositando");
        CustomerThread t8 = new CustomerThread(bank, 3, 800, false, "Cliente 3 Retirando");
        CustomerThread t9 = new CustomerThread(bank, 3, 350, true, "Cliente 3 Depositando novamente");

        CustomerThread t10 = new CustomerThread(bank, 4, 450, true, "Cliente 4 Depositando");
        CustomerThread t11 = new CustomerThread(bank, 4, 300, false, "Cliente 4 Retirando");
        CustomerThread t12 = new CustomerThread(bank, 4, 400, true, "Cliente 4 Depositando novamente");

        CustomerThread t13 = new CustomerThread(bank, 5, 550, true, "Cliente 5 Depositando");
        CustomerThread t14 = new CustomerThread(bank, 5, 700, false, "Cliente 5 Retirando");
        CustomerThread t15 = new CustomerThread(bank, 5, 450, true, "Cliente 5 Depositando novamente");

        t1.start(); t2.start(); t3.start();
        t4.start(); t5.start(); t6.start();
        t7.start(); t8.start(); t9.start();
        t10.start(); t11.start(); t12.start();
        t13.start(); t14.start(); t15.start();

        try {
            t1.join(); t2.join(); t3.join();
            t4.join(); t5.join(); t6.join();
            t7.join(); t8.join(); t9.join();
            t10.join(); t11.join(); t12.join();
            t13.join(); t14.join(); t15.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupção da thread.");
        }

        System.out.println("Operações finalizadas.");
        for (int i = 1; i <= 5; i++) {
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("Saldo final da Conta " + i + ": " + bank.getAccount(i).getBalance());
            System.out.println("Histórico de Transações da Conta " + i + " após operações concorrentes:");
            bank.getAccount(i).printTransactions();
        }
    }
}
