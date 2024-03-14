public class BankAccount {
    private double balance;
    private double minimumbalance;
    private boolean isActive = true;
    private String holderName;

    public BankAccount(double balance, double minimumbalance){
        this.balance=balance;
        this.minimumbalance=minimumbalance;
    }

    public double getBalance(){
        return balance;
    }
    public double getMinimumbalance(){
        return minimumbalance;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double withdraw(double amount) {
        if (balance - amount > minimumbalance) {
            balance -= amount;
            return amount;
        } else {
            throw new RuntimeException();
        }
    }
    public double deposit(double amount){
        return balance+=amount;
        }
}
