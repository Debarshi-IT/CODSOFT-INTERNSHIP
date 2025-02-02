import java.util.Scanner;

public class CodSoft_Task3{
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
class BankAccount {
    private double balance;
    
    public BankAccount(double iBalance) {
        this.balance = iBalance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: $" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Transaction failed.");
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        }
    }
}
class ATM {
    private BankAccount account;
    private Scanner scanner;
    
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }
    
    public void start() {
        while (true) {
            System.out.println("\nWelcome to the ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Your current balance: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}