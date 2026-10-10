import tdd.Cbn;

import java.util.Scanner;

public class ATM_V2 {
    private static Cbn cbn = new Cbn();
    void main(){
        gotoMainMenu();
    }

    private static void gotoMainMenu(){
        cbn.addAllBanks();
        print("""
            [1] Create An Account
            [2] Deposit
            [3] Withdraw
            [4] Transfer
            [5] Check Balance
            [6] Exit
            """);
        char userChoice = input("Enter your option: ").charAt(0);
        switch (userChoice){
            case '1' -> createAccount();
//            case '2' -> deposit();
//            case '3' -> withdraw();
//            case '4' -> transfer();
//            case '5' -> checkBalance();
//            case '6' -> exit();
            default -> print("Invalid choice");
        }
    }
    private static void createAccount(){
        print("""
            ====================================
                        SELECT A BANK
            ====================================
            [1] ACCESS BANK
            [2] AFRI-BANK
            [3] CITIBANK
            [4] DIAMOND BANK
            [5] ECO BANK
            [6] EQUITORIAL TRUST BANK
            [7] FIRST BANK
            [8] FCMB
            [9] FIDELITY BANK
            [10] FIN-BANK
            [11] GUARANTY TRUST BANK
            [12] INTERCONTINENTAL BANK
            [13] OCEANIC BANK
            [14] BANK PHB
            [15] SKYE BANK
            [16] SPRING BANK
            [17] STANBIC-IBTC
            [18] STANDARD CHARTERED BANK
            [19] STERLING BANK
            [20] UNITED BANK FOR AFRICA
            [21] UNION BANK
            [22] WEMA BANK
            [23] ZENITH BANK
            [24] UNITY BANK
            ========================================
            ========================================
            """);
        int userChoice = Character.getNumericValue((input("Enter between 1 to 24: ").charAt(0)));
        try{
            String accountName = input("Enter your preferably account name: ");
            String pin = input("Enter your pin");
            String accountNumber = cbn.getBank(userChoice).createAccount(accountName, pin);
            print("Your account number is : " + accountNumber +  "\nAccount created Successfully>>>>>>");
        }catch (IllegalArgumentException ex){
            print(ex.getMessage());
        }
        finally{
            gotoMainMenu();
        }


    }
    private static void print(String message){
        System.out.println(message);
    }
    private static String input(String message){
        Scanner input = new Scanner(System.in);
        print(message);
        return input.nextLine();
    }
    private static int convertToNumbers(String numbers){
        validate(numbers);
        return Integer.parseInt(numbers);
    }
    private static String validate(String numbers){
        for(int index = 0; index < numbers.length(); index++){
            if(!Character.isDigit(numbers.charAt(index))) throw new IllegalArgumentException("Please enter only numbers");
        }
        return numbers;
    }
}
