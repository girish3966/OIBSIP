import java.util.Scanner;

class BankAccount {
    Scanner sc = new Scanner(System.in);
    float balance = 100000f;
    String previousTransaction = " ";
    String customerName;
    String account_number;
    String customerId;
    int transactions = 0;
    int flag = 0;

    void bankaccount(String cName, String acno, String cId) {
        customerName = cName;
        account_number = acno;
        customerId = cId;
    }

    void clrscr() {
        try {
            try {
                String os = System.getProperty("os.name");

                if (os.contains("Windows")) {
                    Runtime.getRuntime().exec("cls");
                } else {
                    Runtime.getRuntime().exec("clear");
                }
            } catch (Exception e) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        } catch (Exception es) {
            // System.out.println("nothing here!");
        }
    }
}

class deposit1 extends BankAccount {
    void deposit() {
        System.out.print("\nEnter amount to deposit - ");
        float amount = sc.nextFloat();

        try {
            if (amount <= 100000f) {
                transactions++;
                balance += amount;
                System.out.println("\n*****************************************");
                System.out.println("\tSuccessfully Deposited !!");
                System.out.println("*****************************************");
                String str = amount + " Rs deposited\n";
                previousTransaction = previousTransaction.concat(str);
            } else {
                System.out.println("\n********** Sorry...Limit is 100000.00 **********");
            }
        } catch (Exception e) {
            // dp.nextLine();
        }
    }
}

class withdraw1 extends deposit1 {
    void withdraw() {
        System.out.print("\nEnter amount to withdraw - ");
        float amount = sc.nextFloat();
        try {
            if (balance >= amount) {
                transactions++;
                balance -= amount;
                System.out.println("\n*****************************************");
                System.out.println("\tSuccessfully Withdrawed !!");
                System.out.println("*****************************************");
                String str = amount + " Rs Withdrawed\n";
                previousTransaction = previousTransaction.concat(str);
            } else {
                System.out.println("\n*********** Insufficient Balance ***********");
            }
        } catch (Exception e) {
            // wd.nextLine();
        }
    }

    void getPrevTransaction() {
        if (transactions == 0) {
            System.out.println("\nNo Recent Transactions !!!");
        } else {
            System.out.println("\n" + previousTransaction);
        }
    }
}

class transfer extends withdraw1 {
    void transfer1() {
        System.out.println("\n*****************************************");
        System.out.println("\tMoney Transfer");
        System.out.println("*****************************************");
        System.out.print("\nEnter Receipent's Account Number - ");
        int receipent = sc.nextInt();
        System.out.print("\nEnter amount to transfer - ");
        float amount = sc.nextFloat();
        try {
            if (balance >= amount) {
                if (amount <= 50000f) {
                    transactions++;
                    balance -= amount;
                    System.out.println("\n**********************************************");
                    System.out.println("Successfully Transfered to Account no: " + receipent);
                    String str = amount + " Rs transfered to " + receipent + "\n";
                    System.out.println("*************************************************");
                    previousTransaction = previousTransaction.concat(str);
                } else {
                    System.out.println("\n************* Sorry...Limit is 50000.00 *************");
                }
            } else {
                System.out.println("\n************* Insufficient Balance *************");
            }
        } catch (Exception e) {
            // tf.nextLine();
        }
    }

    void verification() {
        System.out.println("\n\n****************************************************");
        System.out.println("\t=*= Welcome to Bank of Maharashtra =*=");
        System.out.println("****************************************************");
        System.out.print("\nPlease enter your customer id: ");
        String vfy = sc.nextLine();
        if (vfy.equals(customerId)) {
            clrscr();
            menu();
        } else {
            System.out.println("*****************************************");
            System.out.println("\tInvalid Id !!");
            System.out.println("*****************************************");
            if (flag < 2) {
                flag++;
                verification();
            }
        }
    }

    void menu() {
        System.out.println("*******************************");
        System.out.println("Welcome " + customerName);
        System.out.println("Your Account number is:  " + account_number);
        System.out.println("*******************************");
        boolean isFinished = false;
        while (!isFinished) {
            System.out.println("\n");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History");
            System.out.println("6. Quit");
            System.out.println("<><><><><><><><><><><><><><><><><>");
            System.out.println("\tSelect Any option ");
            System.out.println("<><><><><><><><><><><><><><><><><>");
            int c = sc.nextInt();

            switch (c) {
                case 1:
                    clrscr();
                    System.out.println("********************************");
                    System.out.println("\tBalance: " + balance);
                    System.out.println("********************************");
                    System.out.println("\n");
                    break;

                case 2:
                    clrscr();
                    System.out.println("*************************************************");
                    System.out.println("\tEnter the amount to be Deposited: ");
                    System.out.println("*************************************************");
                    deposit();
                    System.out.println("\n");
                    break;

                case 3:
                    clrscr();
                    System.out.println("*********************************************");
                    System.out.println("\tEnter the amount to Withdraw: ");
                    System.out.println("*********************************************");
                    withdraw();
                    System.out.println("\n");
                    break;

                case 4:
                    clrscr();
                    transfer1();
                    break;

                case 5:
                    clrscr();
                    System.out.println("==================================");
                    getPrevTransaction();
                    System.out.println("==================================");
                    System.out.println("\n");
                    break;

                case 6:
                    clrscr();
                    System.out.println("************************************************************");
                    System.out.println("\n------------ THANK YOU FOR USING OUR SERVICES ------------\n");
                    System.out.println("************************************************************");
                    System.exit(c);
                    return;

                default:
                    clrscr();
                    System.out.println("*****************************************************");
                    System.out.println("\tInvalid Option Selected !!! Please Enter Again");
                    System.out.println("*****************************************************\n\n");
                    menu();
                    isFinished = true;
            }
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        transfer c1 = new transfer();
        c1.bankaccount("Girish Vyawahare", "396643", "11223");
        c1.verification();
    }
}
