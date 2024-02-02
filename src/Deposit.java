public class Deposit extends Transaction {
    private int amount;

    public Deposit(int customerId, int tellerId, int amount) {
        super(customerId, tellerId);
        this.amount = amount;
    }



    @Override
    public String getTransactionDescription(){
        return "Teller  " + getTellerId() + " deposited " + amount + " to account " + getCustomerId();
    }
}
