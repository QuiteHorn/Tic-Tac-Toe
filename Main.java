import java.util.Scanner;

public class Main {

    static String updatedField (String[] positions, String field) {
        field = "|---|---|---|\n";
        field += "| " + positions[0] + " | " + positions[1] + " | " + positions[2] + " |\n";
        field += "|---|---|---|\n";
        field += "| " + positions[3] + " | " + positions[4] + " | " + positions[5] + " |\n";
        field += "|---|---|---|\n";
        field += "| " + positions[6] + " | " + positions[7] + " | " + positions[8] + " |\n";
        field += "|---|---|---|\n";
        return field;
    }

    static String updatedField (String[] positions) {
        String field = "|---|---|---|\n";
        field += "| " + positions[0] + " | " + positions[1] + " | " + positions[2] + " |\n";
        field += "|---|---|---|\n";
        field += "| " + positions[3] + " | " + positions[4] + " | " + positions[5] + " |\n";
        field += "|---|---|---|\n";
        field += "| " + positions[6] + " | " + positions[7] + " | " + positions[8] + " |\n";
        field += "|---|---|---|\n";
        return field;
    }

    static boolean isXWinner (String[] positions) {

        if (positions[0] == "X" && positions[1] == "X" && positions[2] == "X") {
            return true;
        } else if (positions[0] == "X" && positions[3] == "X" && positions[6] == "X") {
            return true;
        } else if (positions[3] == "X" && positions[4] == "X" && positions[5] == "X") {
            return true;
        } else if (positions[1] == "X" && positions[4] == "X" && positions[7] == "X") {
            return true;
        } else if (positions[6] == "X" && positions[7] == "X" && positions[8] == "X") {
            return true;
        } else if (positions[2] == "X" && positions[5] == "X" && positions[8] == "X") {
            return true;
        } else if (positions[0] == "X" && positions[4] == "X" && positions[8] == "X") {
            return true;
        } else if (positions[2] == "X" && positions[4] == "X" && positions[6] == "X") {
            return true;
        } else return false;
    }

    static boolean isOWinner (String[] positions) {

        if (positions[0] == "O" && positions[1] == "O" && positions[2] == "O") {
            return true;
        } else if (positions[0] == "O" && positions[3] == "O" && positions[6] == "O") {
            return true;
        } else if (positions[3] == "O" && positions[4] == "O" && positions[5] == "O") {
            return true;
        } else if (positions[1] == "O" && positions[4] == "O" && positions[7] == "O") {
            return true;
        } else if (positions[6] == "O" && positions[7] == "O" && positions[8] == "O") {
            return true;
        } else if (positions[2] == "O" && positions[5] == "O" && positions[8] == "O") {
            return true;
        } else if (positions[0] == "O" && positions[4] == "O" && positions[8] == "O") {
            return true;
        } else if (positions[2] == "O" && positions[4] == "O" && positions[6] == "O") {
            return true;
        } else return false;
    }

    public static void main(String[] args) {

        String[] positions = new String[9];

        for (int i = 0; i < 9; i++) {
            int num = i + 1;
            positions[i] = Integer.toString(num);
        }

        Scanner input = new Scanner(System.in);

        String field = updatedField(positions);

        System.out.println(field);

        boolean finished = false;

        String winner = "";

        boolean isXTurn = true;

        while (finished != true) {

            if (isXTurn) {
                System.out.println("X Turn");
                System.out.print("Type in a number of cell: ");
                int cell = input.nextInt();
                if (positions[cell-1] != "X" && positions[cell-1] != "O") {
                    positions[cell - 1] = "X";
                    System.out.println(updatedField(positions, field));
                    if (isXWinner(positions)) {
                        winner += "X";
                        finished = true;
                    }
                    isXTurn = false;
                } else {
                    System.out.println("Wrong number!\n");
                }
            } else {
                System.out.println("O Turn");
                System.out.print("Type in a number of cell: ");
                int cell = input.nextInt();
                if (positions[cell-1] != "O" && positions[cell-1] != "X") {
                    positions[cell - 1] = "O";
                    System.out.println(updatedField(positions, field));
                    if (isOWinner(positions)) {
                        winner += "O";
                        finished = true;
                    }
                    isXTurn = true;
                } else {
                    System.out.println("Wrong number!\n");
                }
            }

        }

        System.out.println(winner + " won!");

    }

}
