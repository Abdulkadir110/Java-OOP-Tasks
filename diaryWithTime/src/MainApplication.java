import tdd.Diaries;
import tdd.Diary;
import tdd.Entry;

import java.util.Scanner;

private Diaries diaries = new Diaries();
void main(){
    Scanner inputCollector = new Scanner(System.in);
    boolean inApp = true;
    int id_generated = 1;

    String menuFunction = """
        === DIARY APP ===
        [1] Create diary
        [2] Log in to diary
        [3] Delete diary
        [4] Exit
    """;
    String diaryMenuFunction = """
        >>>>Diary Menu<<<<<
        [1] Create entry
        [2] View entry
        [3] Update entry
        [4] Delete entry
        [5] Lock & Exit
    """;
    while (inApp) {
        IO.println(menuFunction);
        System.out.print("Enter you option: ");
        String choice = inputCollector.nextLine();
        switch (choice) {
            case "1" -> {
                System.out.print("Username: ");
                String username = inputCollector.nextLine();
                System.out.print("Password: ");
                String password = inputCollector.nextLine();
                try {
                    diaries.add(username, password);
                    IO.println("Diary created");
                } catch (IllegalArgumentException e) {
                    IO.println("Error: " + e.getMessage());
                }
            }

            case "2" -> {
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

                boolean isOpen = true;
                while (isOpen) {
                    IO.println(diaryMenuFunction);
                    System.out.print("Enter your option: ");
                    String diaryMenuChoice = inputCollector.nextLine();
                    try {
                        switch (diaryMenuChoice) {
                            case "1" -> {
                                System.out.print("Title: ");
                                String title = inputCollector.nextLine();
                                System.out.print("Body: ");
                                String body = inputCollector.nextLine();
                                diary.createEntry(title, body);
                                IO.println("Your id is: " + id_generated + "\nEntry created successfully>>>>>>>>>>>");
                                id_generated++;
                            }

                            case "2" -> {
                                System.out.print("Entry ID: ");
                                String userId = inputCollector.nextLine();
                                validateDigit(userId);
                                int id = convertToNumbers(userId);
                                Entry entry = diary.findEntryById(id);
                                if(entry == null) {
                                    IO.println("ID doesnt Exist\n");
                                    break;
                                }
                                IO.println();
                                IO.println("Title : " + entry.getTitle() + "\nTime : " + entry.getDateCreated());
                                IO.println("Body: " + entry.getBody());
                            }

                            case "3" -> {
                                System.out.print("Entry ID: ");
                                String userId = inputCollector.nextLine();
                                validateDigit(userId);
                                int id = convertToNumbers(userId);
                                System.out.print("New title: ");
                                String title = inputCollector.nextLine();
                                System.out.print("New body: ");
                                String body = inputCollector.nextLine();
                                diary.updateEntry(id, title, body);
                                IO.println("Entry updated.");
                            }

                            case "4" -> {
                                System.out.print("Entry ID: ");
                                String userId = inputCollector.nextLine();
                                validateDigit(userId);
                                int id = convertToNumbers(userId);
                                diary.deleteEntry(id);
                                IO.println("Entry deleted successfully>>>>>>>>>>>.");
                            }

                            case "5" -> isOpen = false;

                            default -> IO.println("Invalid option");
                        }
                    } catch (IllegalArgumentException e) {
                        IO.println("Error: " + e.getMessage());
                    }
                }
                diary.lockDiary(password);
            }

            case "3" -> {
                System.out.print("Username: ");
                String username = inputCollector.nextLine();
                System.out.print("Password: ");
                String password = inputCollector.nextLine();
                try {
                    diaries.delete(username, password);
                    IO.println("Diary deleted successfully>>>>>>>>>>>>");
                } catch (IllegalArgumentException e) {
                    IO.println("Error: " + e.getMessage());
                }
            }

            case "4" -> inApp = false;

            default -> IO.println("Invalid option");
        }
    }
    IO.println("\n<><><><> GoodBye <><><><><>");
}
private void validateDigit(String numbers){
    for(int index = 0; index < numbers.length(); index++){
        if(!Character.isDigit(numbers.charAt(index))) throw new IllegalArgumentException("Please enter only numbers");
    }
}
private int convertToNumbers(String numbers){
    return Integer.parseInt(numbers);
}
