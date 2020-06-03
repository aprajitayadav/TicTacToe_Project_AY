package TicTacToeProject;

import java.util.Scanner;

public class TicTacToeRunner {

    public static void main(String[] args) {

        TicTacToeClass tttboard = new TicTacToeClass();
        tttboard.greeting();

        Scanner in = new Scanner(System.in);

        char p = 'X';
        int r, c;

        while (!(tttboard.isWinner('X') || tttboard.isWinner('O') || tttboard.isFull())) {

            tttboard.displayBoard();
            System.out.print("'" + p + "', choose your location (row, column): ");
            r = in.nextInt();
            c = in.nextInt();

            while (tttboard.isValid(r, c) == false || tttboard.playerAt(r, c) != ' ') {

                if (tttboard.isValid(r, c) == false)
                    System.out.println("That is not a valid location. Try again.");
                else if (tttboard.playerAt(r, c) != ' ')
                    System.out.println("That location is already full. Try again.");

                System.out.print("Choose your location (row, column): ");
                r = in.nextInt();
                c = in.nextInt();
            }

            tttboard.playMove(p, r, c);

            if (p == 'X')
                p = 'O';
            else
                p = 'X';

        }

        tttboard.displayBoard();

        if (tttboard.isWinner('X'))
            System.out.println("X is the winner!");
        if (tttboard.isWinner('O'))
            System.out.println("O is the winner!");
        if (tttboard.isCat())
            System.out.println("The game is a tie.");

    }

}
