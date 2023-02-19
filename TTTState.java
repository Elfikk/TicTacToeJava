public class TTTState {

    public static int[][] winConfigs = {{0, 4, 8}, {2, 4, 6}, {0, 1, 2}, 
                                         {3, 4, 5}, {6, 7, 8}, {0, 3, 6},
                                         {1, 4, 7}, {2, 5, 8}};

    boolean gameEnded = false;
    String[][] board = {{"0","1","2"}, {"3","4","5"}, {"6","7","8"}};
    String currentPlayer = "x";
    int moves = 0;
    String winner = "draw";
    boolean changesMade = false; //whether UI needs updating

    public static int[] indexConverter(int number) {
        // converts number from win config to a column, row index.
        int i = number % 3, j = number / 3;
        return new int[] {j, i};
    }

    public void actionPassed(String index) {
        // Check if index is "x" or "o" (not legitimate move)
        changesMade = false;
        if ((index != "x") & (index != "o")) {
            // Convert to a integer index.
            int nextIndex = Integer.parseInt(index);
            int[] boardIndices = indexConverter(nextIndex);

            String currentTileState = board[boardIndices[0]][boardIndices[1]];

            // If the tile is still unoccupied by x or o.
            if ((currentTileState != "x") & (currentTileState != "o")) {
                // Update board
                board[boardIndices[0]][boardIndices[1]] = currentPlayer;
                // Increment moves made
                moves++;
                // Update next player
                if (currentPlayer == "x") {
                    currentPlayer = "o";
                }
                else {
                    currentPlayer = "x";
                }
                changesMade = true;
                checkGameFinished();
            }
        }
    }

    public void checkGameFinished(String... args) {

        for (int[] i: winConfigs) {
            // initialises empty array of strings
            String[] currentConfig = new String[3];
            // equivalent of for j in range(len(i)) - j++ increments by 1. 
            for (int j = 0; j < i.length; j++) {
                int[] index = indexConverter(i[j]);
                int column = index[0], row = index[1];
                currentConfig[j] = board[column][row];
            }
            //sets winner attribute to "x" or "o" if winner achieved.
            if ((currentConfig[0] == "x") || (currentConfig[0] == "o")) {
                if ((currentConfig[0] == currentConfig[1]) & 
                (currentConfig[1] == currentConfig[2])) {
                    winner = currentConfig[0];
                    gameEnded = true;
                }
            }
        }
        // Up to 9 moves can be done, so if we are there, set the game to 
        // have ended.
        if (moves == 9) {
            gameEnded = true;
        }
    }

    public void reset(String... args) {
        gameEnded = false;
        board = new String[][] {{"0","1","2"}, {"3","4","5"}, {"6","7","8"}};
        currentPlayer = "x";
        moves = 0;
        winner = "draw";
        changesMade = false;
    }

    public boolean getGameEnded(String...args) {
        return gameEnded;
    }

    public String getWinner(String...args) {
        return winner;
    }

    public String getBoardState(int index) {
        int[] boardIndices = indexConverter(index);
        String currentTileState = board[boardIndices[0]][boardIndices[1]];
        return currentTileState;
    }

    public String getBoardState(String index) {
        //Beautiful overloading.
        int intIndex = Integer.parseInt(index);
        int[] boardIndices = indexConverter(intIndex);
        String currentTileState = board[boardIndices[0]][boardIndices[1]];
        return currentTileState;
    }

    public String getPreviousPlayer(String...args) {
        if (currentPlayer == "x") {
            return "o";
        }
        return "x";
    }

    public boolean getChangesMade(String...args) {
        return changesMade;
    }

    public static void main(String... args) {
    }

}
