import java.util.Scanner;
import java.util.Random;

public class Tomo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String action = null;
        int food = 5;
        int medicine = 5;
        int happiness = 5;
        String state = "alive";
        int day = 0;

        Random randomGen = new Random();
        int coinFlip = randomGen.nextInt(2);

        while (state.equals("alive")) {
            System.out.println("Stats          Day " + day);
            System.out.println("=====");
            System.out.println("Food: " + food + "     Medicine: " + medicine + "     Happiness: " + happiness);
            System.out.println("What should we do today? Eat, Drug, or Play?");
            action = input.nextLine();
            boolean validAns = false;
            while (validAns == false) {
                if (action.equalsIgnoreCase("eat")) {
                    food += 1;
                    validAns = true;
                } else if (action.equalsIgnoreCase("drug")) {
                    medicine += 2;
                    validAns = true;
                } else if (action.equalsIgnoreCase("play")) {
                    happiness += 1;
                    validAns = true;
                } else {
                    System.out.println("Incorrect Input, Try Again: Eat, Doctor, or Play?");
                    action = input.nextLine();
                }
            }

            int statPick = randomGen.nextInt(3);
            int medChance = randomGen.nextInt(11);

            if (statPick == 0) {
                food -= 1;
                if (coinFlip == 0) {
                    happiness -= 1;
                }
            }
            if (statPick == 1) {
                if (medChance == 10) {
                    medicine -= 3;
                }
            }
            if (statPick == 2) {
                happiness -= 1;
                if (coinFlip == 1) {
                    food -= 1;
                }
            }

            if (food < 0 || medicine < 0 || happiness < 0 || medicine > 7) {
                state = "dead";
                System.out.println("Your Tomo has passed on :/ Game over.");
                System.out.println("Your Tomo lasted " + day + " days! RIP");
                input.close();
            } else {
                day += 1;
            }
        }
    }
}
