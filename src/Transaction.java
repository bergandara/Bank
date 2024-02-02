public class Transaction {
    private int customerId;
    private int tellerId;

    public Transaction(int customerId, int tellerId){
        this.customerId = customerId;
        this.tellerId = tellerId;

    }

    public int getCustomerId(){
        return customerId;
    }

    public int getTellerId(){
        return tellerId;
    }

    public String getTransactionDescription(){
        return "";
    }
}
