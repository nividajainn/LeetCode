package zProject1;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    //DecimalFormate is a class used for formating or parsing number in a locale-sensitive manner
    //means kitne numbers tak kya dikhana h # represent digits if abs it shows invalid.
    DecimalFormat moneyFormate = new DecimalFormat("'\u20B9'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    /* Validate login information customer number and pin number */

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(942486547, 9171);
                data.put(810754451, 9893);

                System.out.println("WELCOME to the ATM mini Project!");

                System.out.println("Enter Your Customer Number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter Your Pin Number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid character(s). Only numbers." + "\n");
                x = 2;
            }
            for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    getAccountType();
                }
            }
            System.out.println("Wrong Customer Number or Pin Number" + "\n");
        } while (x == 1);
    }

    // Display Account Type Menu with Selection

    public void getAccountType() {
        System.out.println("Select the Account you want to access");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Savings Account");
        System.out.println("Type 3 - Exit");
        System.out.println("Choice: ");
        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank you for using this ATM. Bye!");
                break;
            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice: ");
        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormate.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using this ATM. Bye!");
                break;
            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getChecking();
        }
    }
    // Display Saving Account Menu with selections

    public void getSaving() {
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice: ");
        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormate.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using this ATM. Bye!");
                break;
            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getSaving();
        }
    }

    int selection;
}
