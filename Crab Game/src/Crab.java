import java.util.Random;
import java.util.Scanner;

public class Crab {
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int player = 0;
        int obstacle = random.nextInt(10);

        System.out.println("Welcome to the Crab Game");

        while (true) {
            for (int i = 0; i < 10; i++) {
                if (i == player) {
                    System.out.print("X");
                } else if (i == obstacle) {
                    System.out.print("Y");
                } else {
                    System.out.print("_");
                }
            }
            System.out.println("\n\n Move the crab (A or D): ");
            String move = scanner.next();

            if (move.equalsIgnoreCase("A")) {
                player = Math.max(0, player - 1);
            } else if (move.equalsIgnoreCase("D")) {
                player = Math.min(9, player + 1);
            } else {
                System.out.println("Invalid move. Use A or D.");
            }

            obstacle = (obstacle - 1 + 10) % 10;

            if (player == obstacle) {
                System.out.println("Game Over!");
                break;
            }
        }

        scanner.close();
    }
}
