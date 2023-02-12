import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;

public class TicTacToe {

    static Scanner myScanner = new Scanner(System.in);

    public static int[][] winConfigs = {{0, 4, 8}, {2, 4, 6}, {0, 1, 2}, 
                                         {3, 4, 5}, {6, 7, 8}, {0, 3, 6},
                                         {1, 4, 7}, {2, 5, 8}};

    static String[] indicesArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
    public static HashSet<String> legitimateIndices =
                                 new HashSet<String>(Arrays.asList(indicesArray));

    public static TTTBoard tttGUI = new TTTBoard();

    public static int[] indexConverter(int number) {
        // converts number from win config to a column, row index.
        int i = number % 3, j = number / 3;
        return new int[] {j, i};
    }

    public String[][] gameLoop(String[][] board, String currentPlayer) {
        
        Boolean legitimateMove = false;

        do {
            //Ask for user input on the board.
            System.out.println("Next move");
            String nextIndexString = myScanner.nextLine();

            // check if the passed string is even a number thats allowed
            if (legitimateIndices.contains(nextIndexString)) {
                    //Converts number string input into an integer
                int nextIndex = Integer.parseInt(nextIndexString);

                //Gets the index on the board
                int[] index = indexConverter(nextIndex);
                int column = index[0], row = index[1];

                if ((board[column][row] == "o") || board[column][row] == "x") {
                    System.out.println("Illegitimate Move");
                }
                else {
                    board[column][row] = currentPlayer;
                    legitimateMove = true;
                }
            }
            else {
                System.out.println("Illegitimate Move");
            }
            
        }
        while (!legitimateMove);

        //Have to return the board as Java is pass by value only.
        return board;
    }

    public String gameWinCheck(String[][] board) {

        //Checks for a win

        // for array of integers called i in winConfigs
        for (int[] i: winConfigs) {
            // initialises empty array of strings
            String[] currentConfig = new String[3];
            // equivalent of for j in range(len(i)) - j++ increments by 1. 
            for (int j = 0; j < i.length; j++) {
                int[] index = indexConverter(i[j]);
                int column = index[0], row = index[1];
                currentConfig[j] = board[column][row];
            }
            //returns the winner ("x" or "o") if all tiles in win 
            //configuration are the same characters.
            if ((currentConfig[0] == currentConfig[1]) & 
                (currentConfig[1] == currentConfig[2]))
                return currentConfig[0];
        }
        //returns empty string if no winner found.
        return new String();
    }

    public static void main(String[] args) {

        // Makes a new instance of the TicTacToe class.
        TicTacToe daGame = new TicTacToe();

        boolean gameEnded = false;
        String[][] board = {{"0","1","2"}, {"3","4","5"}, {"6","7","8"}};
        String currentPlayer = "x";
        int moves = 0;

        do {
            for (String[] row: board) {
                System.out.println(Arrays.toString(row));
            }
            board = daGame.gameLoop(board, currentPlayer);
            String winner = daGame.gameWinCheck(board);

            if ((winner == "o") || (winner == "x")) {
                System.out.println(winner + " wins!");
                gameEnded = true;
            }
            
            moves++; //increment the number of moves
            if (moves % 2 == 1) {
                currentPlayer = "o";
            }
            else {
                currentPlayer = "x";
            }
                
            // System.out.println(moves);

            if (moves == 9) {
                if (!gameEnded) {
                    gameEnded = true;
                    System.out.println("tis a draw");
                }  
            }

            // System.out.println("Fuck");

        }
        while (!gameEnded);

        myScanner.close();

    }

}