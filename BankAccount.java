package BankAccountsContinued;

public class BankAccount {
    private String accountHolder;
    private int accountNumber;
    private double balance;
    public double moneyDeposit;
    public double moneyWithdraw;

    // Class constructor
    public BankAccount (String accountHolder, int accountNumber, double balance) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }

    // Constructor that takes no parameters
    public BankAccount () {

    }

    public void deposit(double moneyDeposit){
        this.balance = balance + moneyDeposit;
    }

    public void withdrawal(double moneyWithdraw){
        this.balance = this.balance - moneyWithdraw;
    }

    public String getAccountHolder() {
        return this.accountHolder;
    }

    public void setAccountHolder(String name) {
        this.accountHolder = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void transfer(BankAccount acc, double amount) {
        withdrawal(amount);
        acc.deposit(amount);

        // Alternative
        this.balance -= amount;
        acc.balance += amount;
    }

    public void printDetails() {
        System.out.println(this.accountHolder + " Account balance: " + this.balance);
    }

}