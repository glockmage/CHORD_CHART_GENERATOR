import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static class Chord {

        public String[] printLines;
        public char[] tuning = {'E', 'A', 'D', 'G', 'B', 'e'};
        public final int stringCount = 6;

        public Chord() {
            printLines = new String[stringCount];
            for (int curr = 0; curr < stringCount; curr++) {
                String result = "";
                result += tuning[curr];
                result += "|";
                printLines[curr] = result;
            }
        }

        private void addDash() {
            for (int curr = 0; curr < stringCount; curr++) {
                printLines[curr] += "-";
            }
        }

        public String toString() {
            StringBuilder result = new StringBuilder();
            System.out.println("Here are some voicings for the current chord: ???");
            for (int curr = stringCount - 1; curr > -1; curr--) {
                result.append(printLines[curr]);
                result.append("\n");
            }
            return result.toString();
        }
    }

    /**
     *
     * @param input a string value, likely a Scanner Input.
     * @return boolean false if user's input was End. Otherwise, always return true.
     */
    private static boolean parseInputCommand(String input, Scanner sc, Chord curr) {
        input = input.toLowerCase();
        if (input.compareTo("end") == 0) {
            boolean end = false; // this never really gets changed
            while (!end) {
                System.out.println("Are you sure you wish to exit the program? Y/N?");
                String inputB = sc.nextLine();
                inputB = inputB.toLowerCase();
                if (inputB.compareTo("y") == 0 || inputB.compareTo("yes") == 0) {
                    System.out.println("Terminating Program. Goodbye!");
                    System.out.println("---------------------------------------------------------------------------------------------");
                    return false;
                } else if (inputB.compareTo("n") == 0 || inputB.compareTo("no") == 0) {
                    System.out.println("Continuing Program.");
                    System.out.println("---------------------------------------------------------------------------------------------");
                    return true;
                } else {
                    System.out.println("Unexpected input. Expected either 'y' or 'n'. ");
                }
            }

            return false;
        }
        if (input.compareTo("help") == 0 || input.compareTo("commands") == 0) {
            System.out.println("Here's a list of system commands, listed in order of importance.");
            System.out.println(" - 'help': displays a list of all available commands, a.k.a expected inputs");
            System.out.println(" - 'commands': displays a list of all available commands, a.k.a expected inputs");
            System.out.println(" - 'end': stops the program from running.");
            System.out.println(" - 'info': displays the start-up welcome message.");
            System.out.println("Here's a list of commands regarding the Chord Generator, sorted alphabetically.");
            System.out.println(" - 'add': add additional chords to the list.");
            System.out.println(" - 'chords': view all current chords to be generated.");
            System.out.println(" - 'generate': prints all currently selected chords given the current criteria.");
            System.out.println(" - 'key': view or change the current key.");
            System.out.println(" - 'remove': removes a chord from the list.");
            System.out.println(" - 'reset': returns all settings back to defaults.");
            System.out.println(" - 'settings': view or change all current Generator settings.");
            System.out.println(" - 'tuning': view or change current string tuning");


            System.out.println("---------------------------------------------------------------------------------------------");
            return true;
        }
        if (input.compareTo("info") == 0) {
            System.out.println("=============================================================================================");
            System.out.println("Hello! Welcome to Spencer Pham's Chord Chart Generator!");
            System.out.println("This program is only intended to be used on six string guitars.");
            System.out.println("Some of the resulting chords may be physically impossible to play.");
            System.out.println("Please use this resource supplementary, not primarily.");
            System.out.println("=============================================================================================");
            return true;
        }
        if (input.compareTo("chords") == 0) {
            System.out.println("Here's a list of all the current chords: ");
            System.out.println("---------------------------------------------------------------------------------------------");
            return true;
        }
        if (input.compareTo("generate") == 0) {
            System.out.println("Generating Chords...");
            curr.addDash();
            System.out.println(curr.toString());
            System.out.println("---------------------------------------------------------------------------------------------");
            return true;
        }
        // if we make it here, the input was not detected by any of our statements above.
        // This must be an invalid input of some kind.
        System.out.print("Unexpected input. ");
        System.out.print("Enter 'help' for a full list of commands, or type 'end' to end the program.");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean takingInput = true;
        String currInput;
        Chord c = new Chord();

        parseInputCommand("info", sc, c); // start's the program with a welcome message.



        while (takingInput) {
            System.out.print("Please enter a command: ");
            currInput = sc.nextLine();
            takingInput = parseInputCommand(currInput, sc, c);
        }
    }
}