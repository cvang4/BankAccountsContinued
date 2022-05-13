package BankAccountsContinued;

import java.util.ArrayList;
import java.util.Scanner;

public class BankMain {

    static ArrayList<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);

        accounts.add(new BankAccount("Joe", 101, 500));
        accounts.add(new BankAccount("Sal", 107, 6500));
        accounts.add(new BankAccount("Murr", 145, 800));
    
        System.out.println("Hello world! Welcome to the coolest bank!");
        System.out.println("Are you an existing customer? (-1 to exit) \n 1. Yes\n 2. No");

        int response = Integer.valueOf(scanner.nextLine());

        while(response != -1) {
        if (response ==1) {
            System.out.println("Great! What is your account number?");
            int accountNum = Integer.valueOf(scanner.nextLine());

            boolean isAccountHolder = false;
            int index = -1;

            for (int i = 0; i < accounts.size(); i ++) {
                BankAccount acc = accounts.get(i);
                if (accountNum == acc.getAccountNumber()) {
                    isAccountHolder = true;
                    index = i;
                }
            }

            if (isAccountHolder) {
                mainMenu(accounts.get(index));
            } else {
                System.out.println("Sorry, we couln't find your account number. Please try again.");
            }


        } else if (response == 2) {
            BankAccount newAccount = new BankAccount();

            System.out.println("Let's make an account!");
            System.out.println("What is the name of the account?");
            String responseName = scanner.nextLine();
            newAccount.setAccountHolder(responseName);

            double responseAmount = Double.valueOf(scanner.nextLine());
            newAccount.setBalance(responseAmount);

            accounts.add(newAccount);

            mainMenu(accounts.get(accounts.size() -1));

        } else if (response == -1) {
            System.out.println("Good bye!");
            break;

        }

    }
    }

    public static void mainMenu(BankAccount acc) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello " + acc.getAccountHolder());

        System.out.println("Welcome to the main menu, what would you like to do today?");
        System.out.println(" 1. To check account balance \n 2. To make a withdraw \n 3. To make a deposit \n 4. To make a transfer to another account \n 0. To exit");
        
        int response = Integer.valueOf(scanner.nextLine());

        while(response != 0) {
        if (response ==1) {
            acc.getAccountHolder();

        } else if (response == 2) {
            System.out.println("Enter amount to withdraw.");
            double withdrawAmount = Double.valueOf(scanner.nextLine());
            acc.withdrawal(withdrawAmount);
            System.out.println("The amount: " + withdrawAmount + " has been taken out.");

        } else if (response == 3) {
            System.out.println("Enter amount to deposit.");
            double depositAmount = Double.valueOf(scanner.nextLine());
            acc.deposit(depositAmount);
            System.out.println("The amount: " + depositAmount + " has been aded to your account.");

        } else if (response == 4){
            System.out.println("Please entet the account number to transfer to ");
            int accountToTransferTo = Integer.valueOf(scanner.nextLine());

            BankAccount toTransferTo = new BankAccount();
                boolean isAccountHolder = false;
                int index = -1;

                for (int i = 0; i < accounts.size(); i++) {
                    BankAccount accs = accounts.get(i);
                    if (accountToTransferTo == accs.getAccountNumber()) {
                        toTransferTo = accs;
                        isAccountHolder = true;
                        index = i;
                    }
                }

                if (isAccountHolder) {
                    System.out.println("How much would you like to transfer ");
                    double transferAmount = Double.valueOf(scanner.nextLine());

                    acc.transfer(toTransferTo, transferAmount);
                    System.out.println(acc.getAccountHolder() + " moved " + transferAmount + " and now has " + acc.getBalance());
                    System.out.println(toTransferTo.getAccountHolder() + " was given " + transferAmount + " and now has " + toTransferTo.getBalance());
                    break;
                } else {
                    System.out.println("Sorry, we couldn't find your account number, try again");
                }
                break;

        }else if (response == 0) {
            System.out.println("Good bye!");
            break;
        }
        
        }

    }

    }

