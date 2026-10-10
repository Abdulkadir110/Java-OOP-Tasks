import tdd.Diaries;

import java.util.Scanner;
import tdd.Diary;
public class Application {
    private static Diaries diaries = new Diaries();

    private static void gotoMainMenu(){
        print("""
                === DIARY APP ===
        [1] Create diary
        [2] Log in to diary
        [3] Delete diary
        [4] Exit
        """);

        char userMenuChoice = input("Enter an option: ").charAt(0);
        switch (userMenuChoice) {
            case 1 -> createDiary();
            case 2 -> gotoLoginFunction();
            case 3 -> deleteDiary();
            case 4 -> exit();
            default -> print("Invalid option");
        }
    }
    private static void exit(){

    }
    private static void deleteDiary() {
        String username = input("Username: ");
        String password = input("Password: ");
        try {
            diaries.delete(username, password);
            print("Diary deleted successfully>>>>>>>>>>>>");
        } catch (IllegalArgumentException e) {
            print("Error: " + e.getMessage());
        }
        finally {
            gotoMainMenu();
        }
    }

    private static void createDiary() {
        String username = input("Username: ");
        String password = input("Password: ");
        try {
            diaries.add(username, password);
            print("Diary created");
        } catch (IllegalArgumentException e) {
            print("Error: " + e.getMessage());
        }
        finally {
            gotoMainMenu();
        }
    }

    private static void gotoLoginFunction(){
        System.out.print("Username: ");
        String username = inputCollector.nextLine();
        Diary diary = diaries.findByUsername(username);
        if (diary == null) {
            IO.println("Diary not found");
            break;
        }
        System.out.print("Password: ");
        String password = inputCollector.nextLine();
        try {
            diary.unlockDiary(password);
        } catch (IllegalArgumentException e) {
            IO.println("Error: " + e.getMessage());
            break;
        }
        print("""
        >>>>Diary Menu<<<<<
        [1] Create entry
        [2] View entry
        [3] Update entry
        [4] Delete entry
        [5] Lock & Exit
        """);
        char userLoginFunction = input("Enter your option: ").charAt(0);
        switch (userLoginFunction){
            case 1 -> createEntry();
            case 2 -> viewEntry();
            case 3 -> updateEntry();
            case 4 -> deleteEntry();
            case 5 -> exitDiary();
        }
    }

    private static void createEntry() {
        String title = input("Title: ");
        String body = input("Body: ");
        diaries.findByUsername().createEntry(title, body);
        IO.println("Your id is: " + id_generated + "\nEntry created successfully>>>>>>>>>>>");
        id_generated++;
    }


    private static void print(String message){
        System.out.println(message);
    }
    private static String input(String message){
        Scanner input = new Scanner(System.in);
        print(message);
        return input.nextLine();
    }
}
