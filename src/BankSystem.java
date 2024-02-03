import java.util.List;

public class BankSystem {
    private List<BankAccount> accounts;
    private List<Transaction> transactions;

    public BankSystem(List<BankAccount> accounts, List<Transaction> transactions){
        this.accounts = accounts;
        this.transactions = transactions;
    }

    public BankAccount getAccount(int customerId){
        return this.accounts.get(customerId);
    }

    public List<BankAccount> getAccounts(){
        return this.accounts;
    }

    public List<Transaction> getTransactions(){
        return this.transactions;
    }

    public int openAccount(String customerName, int tellerId){
        //Create account
        int customerId = this.accounts.size();
        BankAccount account = new BankAccount(customerId, customerName, 0);
        this.accounts.add(account);


        //Log transaction
        Transaction transaction = new OpenAccount(customerId, tellerId);
        this.transactions.add(transaction);
        return customerId;

    }

    public void withdraw(int customerId, int tellerId, int amount){
        if(amount > this.getAccount(customerId).getBalance()){
            throw new Error ("Insufficient funds");
        }
        BankAccount account = this.getAccount(customerId);
        account.withdraw(amount);

        Transaction transaction = new Withdrawal(customerId, tellerId, amount);
        this.transactions.add(transaction);
    }

    public void deposit(int customerId, int tellerId, int amount){
        BankAccount account = this.getAccount(customerId);
        account.deposit(amount);

        Transaction transaction = new Deposit(customerId, tellerId, amount);
        this.transactions.add(transaction);
    }

}
