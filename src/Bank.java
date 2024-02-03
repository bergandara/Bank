import java.util.List;

public class Bank {
    private List<BankBranch> branches;
    private BankSystem bankSystem;
    private int totalCash;

    public Bank(List<BankBranch> branches, BankSystem bankSystem, int totalCash){
        this.branches = branches;
        this.bankSystem = bankSystem;
        this.totalCash = totalCash;
    }

    public BankBranch addBranch(String address, int initialFunds){
        BankBranch branch = new BankBranch(address, initialFunds, this.bankSystem);
        this.branches.add(branch);
        return branch;
    }

    public void collectCash(double ratio){
        for(BankBranch branch : this.branches){
            int cashCollected = branch.collectCash(ratio);
            this.totalCash += cashCollected;
        }
    }

    public void printTransactions(){
        for(Transaction transaction : this.bankSystem.getTransactions()){
            System.out.println(transaction.getTransactionDescription());
        }
    }

}
