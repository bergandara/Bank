import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BankSystem bankSystem = new BankSystem(new ArrayList<BankAccount>(), new ArrayList<Transaction>());
        Bank bank = new Bank(new ArrayList<BankBranch>(), bankSystem, 10000);

        BankBranch branch1 = bank.addBranch("123 Grafton Street", 1000);
        BankBranch branch2 = bank.addBranch("456 Dame Street", 1000);

        branch1.addTeller(new BankTeller(1));
        branch1.addTeller(new BankTeller(2));
        branch2.addTeller(new BankTeller(3));
        branch2.addTeller(new BankTeller(4));

        int customerId1 = branch1.openAccount("John Doe");
        int customerId2 = branch1.openAccount("Bob Smith");
        int customerId3 = branch2.openAccount("Jane Doe");

        branch1.deposit(customerId1, 100);
        branch1.deposit(customerId2, 200);
        branch2.deposit(customerId3, 300);

        branch1.withdraw(customerId1, 50);
        bank.printTransactions();

        bank.collectCash(0.5);

    }
}