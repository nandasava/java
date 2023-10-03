import java.util.Scanner;

public class LoginProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxAttempts = 3;
        String correctUsername = "martin";
        String correctPassword = "12345";

        for (int attempts = 1; attempts <= maxAttempts; attempts++) {
            System.out.print("Enter username: ");
            String enteredUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String enteredPassword = getPasswordInput(scanner);

            if (enteredUsername.equals(correctUsername) && enteredPassword.equals(correctPassword)) {
                System.out.println("Login successful!");
                break;
            } else {
                System.out.println("Login failed. Please try again. Attempts left: " + (maxAttempts - attempts));
            }

            if (attempts == maxAttempts) {
                System.out.println("Maximum login attempts reached. Account locked.");
            }
        }

        scanner.close();
    }

    private static String getPasswordInput(Scanner scanner) {
        String password = scanner.nextLine();
        return password;
    }
}
