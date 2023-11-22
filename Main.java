import java.util.List;
import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Insert Log\n2. Search Logs\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter log level: ");
                    String level = scanner.nextLine();
                    System.out.print("Enter log message: ");
                    String message = scanner.nextLine();
                    System.out.print("Enter resourceId: ");
                    String resourceId = scanner.nextLine();

                    logIngestion.insertLog(level, message, resourceId);
                    System.out.println("Log inserted successfully!");
                    break;

                case 2:
                    System.out.print("Enter log level (or leave empty): ");
                    level = scanner.nextLine();
                    System.out.print("Enter log message (or leave empty): ");
                    message = scanner.nextLine();
                    System.out.print("Enter resourceId (or leave empty): ");
                    resourceId = scanner.nextLine();

                    List<String> searchResults = logSearch.searchLogs(level, message, resourceId);
                    System.out.println("Search Results:");
                    for (String result : searchResults) {
                        System.out.println(result);
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
