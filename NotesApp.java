import java.io.*;
import java.util.Scanner;

public class NotesApp {
    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("=== Simple Notes App ===");

        do {
            System.out.println("\n1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addNote(scanner);
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);

        scanner.close();
    }

    // Write note to file
    private static void addNote(Scanner scanner) {
        System.out.print("Enter your note: ");
        String note = scanner.nextLine();

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(note + System.lineSeparator());
            System.out.println("Note saved!");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }

    // Read notes from file
    private static void viewNotes() {
        System.out.println("\n--- Your Notes ---");

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean isEmpty = true;
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
                isEmpty = false;
            }
            if (isEmpty) {
                System.out.println("(No notes found.)");
            }
        } catch (FileNotFoundException e) {
            System.out.println("(No notes found.)");
        } catch (IOException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
    }
}
