import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class My_transaction {
    private String transtype;
    private double enter_amount;

    public My_transaction(String transtype, double enter_amount) {
        this.transtype = transtype;
        this.enter_amount = enter_amount;
    }

    public String acquire_Type() {
        return transtype;
    }

    public double acquire_Amount() {
        return enter_amount;
    }
}

class CustomerAcc {
    
    private String acc_num;
    private double yourBalance;
    private List<My_transaction> transHistory;

    public CustomerAcc(String acc_num, double yourBalance) {
        this.acc_num = acc_num;
        this.yourBalance = yourBalance;
        this.transHistory = new ArrayList<>();
    }

    public String acquireAccNum() {
        return acc_num;
    }

    public double acquireBalance() {
        return yourBalance;
    }

    public List<My_transaction> acquiretransHistory() {
        return transHistory;
    }

    public void enter_deposit_amt(double enter_amount) {
        yourBalance = yourBalance + enter_amount;
        My_transaction trans = new My_transaction("Deposit", enter_amount);
        transHistory.add(trans);
        System.out.println("Deposit of " + enter_amount + " successful.");
    }

    public void withdraw_amt(double enter_amount) {
        if (yourBalance >= enter_amount) {
            yourBalance = yourBalance-enter_amount;
            My_transaction trans = new My_transaction("Withdrawal", enter_amount);
            transHistory.add(trans);
            System.out.println("Withdrawal of " + enter_amount + " successful.");
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public void transferring_amt(CustomerAcc destiAcc, double enter_amount) {
        if (yourBalance >= enter_amount) {
            yourBalance =yourBalance - enter_amount;
            destiAcc.enter_deposit_amt(enter_amount);
            My_transaction trans = new My_transaction("Transfer", enter_amount);
            transHistory.add(trans);
            System.out.println("Transfer of " + enter_amount + " successful to account number " + destiAcc.acquireAccNum());
        } else {
            System.out.println("Insufficient funds. Transfer failed.");
        }
    }
}

class ATMinterfacetask {
    public static void main(String[] args) {
        CustomerAcc acc = new CustomerAcc("120520028", 2500.0);
        Scanner sc = new Scanner(System.in);

        System.out.println("** WELCOME!! **");
        while (true) {
            System.out.println("\nPlease choose :");
            System.out.println("1. Transaction History");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");

            int options = sc.nextInt();

            switch (options) {
                case 1:
                    displayTransHistory(acc);
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double deposit_amt = sc.nextDouble();
                    acc.enter_deposit_amt(deposit_amt);
                    break;
                case 3:
                    System.out.print("Enter the amount to be withdrawn: ");
                    double withdrawal_amt = sc.nextDouble();
                    acc.withdraw_amt(withdrawal_amt);
                    break;
                case 4:
                    System.out.print("Enter the account number: ");
                    String dest_AccNum = sc.next();
                    System.out.print("Enter the amount to transfer: ");
                    double trans_amt = sc.nextDouble();
                    CustomerAcc destiAcc = new CustomerAcc(dest_AccNum, 0.0);
                    acc.transferring_amt(destiAcc, trans_amt);
                    break;
                case 5:
                    System.out.println("Thank you for your cooperation! Goodbye!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect option. Please try again.");
            }
        }
    }

    public static void displayTransHistory(CustomerAcc acc) {
        System.out.println("\nYour ATM Transaction History:");
        List<My_transaction> transHistory = acc.acquiretransHistory();
        for (My_transaction trans : transHistory) {
            System.out.println(trans.acquire_Type() + ": " + trans.acquire_Amount());
        }
    }
}
