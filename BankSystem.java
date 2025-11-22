import java.util.*;

public class BankSystem {
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, BankAccount> accounts = new HashMap<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== BANK ACCOUNT MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. View Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: depositMoney(); break;
                case 3: withdrawMoney(); break;
                case 4: checkBalance(); break;
                case 5: viewDetails(); break;
                case 6: System.out.println("Thank you for using the system."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    public static void createAccount() {
        sc.nextLine();
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        if (accounts.containsKey(accNo)) {
            System.out.println("Account already exists!");
            return;
        }

        System.out.print("Enter Holder Name: ");
        String holder = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        System.out.println("Select Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int type = sc.nextInt();

        BankAccount account = null;

        if (type == 1) account = new SavingsAccount(accNo, holder, balance);
        else if (type == 2) account = new CurrentAccount(accNo, holder, balance);
        else { System.out.println("Invalid type!"); return; }

        accounts.put(accNo, account);
        System.out.println("Account created successfully!");
    }

    public static void depositMoney() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        BankAccount account = accounts.get(accNo);
        if (account == null) { System.out.println("Account not found!"); return; }

        System.out.print("Enter Amount to Deposit: ");
        double amount = sc.nextDouble();

        account.deposit(amount);
    }

    public static void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        BankAccount account = accounts.get(accNo);
        if (account == null) { System.out.println("Account not found!"); return; }

        System.out.print("Enter Amount to Withdraw: ");
        double amount = sc.nextDouble();

        account.withdraw(amount);
    }

    public static void checkBalance() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        BankAccount account = accounts.get(accNo);
        if (account == null) { System.out.println("Account not found!"); return; }

        System.out.println("Current Balance: " + account.getBalance());
    }

    public static void viewDetails() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        BankAccount account = accounts.get(accNo);
        if (account == null) { System.out.println("Account not found!"); return; }

        System.out.println("\n---- ACCOUNT DETAILS ----");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Holder Name: " + account.getHolderName());
        System.out.println("Balance: " + account.getBalance());
    }
}
