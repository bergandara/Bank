import java.util.ArrayList;
import java.util.List;

public class BankBranch {
    private String address;
    private int cashOnHand;
    private BankSystem bankSystem;
    private List<BankTeller> tellers;

    public BankBranch(String address, int cashOnHand, BankSystem bankSystem, List<BankTeller> tellers) {
        this.address = address;
        this.cashOnHand = cashOnHand;
        this.bankSystem = bankSystem;
        this.tellers = new ArrayList<>();
    }

    public void addTeller(BankTeller teller){
        this.tellers.add(teller);
    }

    private BankTeller getAvailableTeller(){
        int index = (int) Math.round(Math.random() * (this.tellers.size() - 1));
        return this.tellers.get(index);
    }

    public int openAccount(String customerName){
        if(this.tellers.size() == 0){
            throw new Error("Branch does not have any tellers");
        }
       BankTeller teller = this.getAvailableTeller();
        return this.bankSystem.openAccount(customerName, teller.getId());
    }

    public void deposit(int customerId, int amount){
        if (this.tellers.size() == 0){
            throw new Error("Branch does not have any tellers");
        }
        BankTeller teller = this.getAvailableTeller();
        this.bankSystem.deposit(customerId, teller.getId(), amount);
    }
}
