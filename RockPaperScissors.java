import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numChances = 3;
        int playerPoints = 0;
        int computerPoints = 0;

        System.out.println("Welcome to Rock-Paper-Scissors!!");
        System.out.print("Please enter your name: ");
        String playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "! You have " + numChances + " chances to play.");

        for (int i = 0; i < numChances; i++) {
            System.out.println("Round " + (i + 1) + ": Choose rock, paper, or scissors:");
            String playerChoice = scanner.nextLine().toLowerCase();

            // Generate computer's choice
            String[] choices = {"rock", "paper", "scissors"};
            String computerChoice = choices[(int) (Math.random() * choices.length)];

            // Determine winner
            String result = "";
            if (playerChoice.equals(computerChoice)) {
                result = "Tie!";
            } else if (playerChoice.equals("rock")) {
                if (computerChoice.equals("paper")) {
                    result = "Computer wins!";
                    computerPoints++;
                } else {
                    result = playerName + " wins!";
                    playerPoints++;
                }
            } else if (playerChoice.equals("paper")) {
                if (computerChoice.equals("scissors")) {
                    result = "Computer wins!";
                    computerPoints++;
                } else {
                    result = playerName + " wins!";
                    playerPoints++;
                }
            } else if (playerChoice.equals("scissors")) {
                if (computerChoice.equals("rock")) {
                    result = "Computer wins!";
                    computerPoints++;
                } else {
                    result = playerName + " wins!";
                    playerPoints++;
                }
            } else {
                result = "Invalid choice. Try again.";
                i--; // Player did not use up a chance with invalid input
                continue; // Skip to the next iteration
            }

            System.out.println("You chose " + playerChoice + ", computer chose " + computerChoice + ". " + result);
            System.out.println("Current score: " + playerName + " " + playerPoints + ", Computer " + computerPoints + "\n");
        }

        // Determine overall winner
        String overallResult = "";
        if (playerPoints > computerPoints) {
            overallResult = "Congratulations, " + playerName + "! You win!";
        } else if (computerPoints > playerPoints) {
            overallResult = "Sorry, " + playerName + ", you lose. Better luck next time.";
        } else {
            overallResult = "Tie game!";
        }

        System.out.println("Final score: " + playerName + " " + playerPoints + ", Computer " + computerPoints);
        System.out.println(overallResult);
    }
}
