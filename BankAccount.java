public class BankAccount {
   String ownerName;
   String accountNumber;
   double balance;


   public void deposit(double amount) {
       balance += amount;
       System.out.println("Deposited: " + amount);
   }
}
  public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
