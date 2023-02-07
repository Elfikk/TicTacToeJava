import java.util.Scanner;
import java.util.Arrays;

public class TicTacToe {

    static Scanner myScanner = new Scanner(System.in);

    public static int[][] win_configs = {{0, 4, 8}, {2, 4, 6}, {0, 1, 2}, 
                                         {3, 4, 5}, {6, 7, 8}, {0, 3, 6},
                                         {1, 4, 7}, {2, 5, 8}};

    public static int[] indexConverter(int number) {
        // converts number from win config to a column, row index.
        int i = number % 3, j = number / 3;
        return new int[] {j, i};
    }

    public String gameLoop(String[][] board, String currentPlayer) {
        
        //Ask for user input on the board.
        System.out.println("Next move");
        String nextIndexString = myScanner.nextLine();
        int nextIndex = Integer.parseInt(nextIndexString);


        //Checks for a win
        for (int[] i: win_configs) {
            String[] currentConfig = new String[3];
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

        return new String();
    }


    public static void main(String[] args) {

        boolean gameEnded = false;
        String[][] board = {{"0","1","2"}, {"3","4","5"}, {"6","7","8"}};
        String currentPlayer = "x";

        do {
            for (String[] row: board) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("Fuck");
            gameEnded = true;
        }
        while (!gameEnded);

        myScanner.close();

    }

}