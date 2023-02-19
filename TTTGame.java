public class TTTGame {
    
    TTTBoard tttUI = new TTTBoard();
    TTTState tttState = new TTTState();
    TTTListener tttListener = new TTTListener();

    public void actionPerformed(String message) {
        // Pass action to State

        if (message == "reset") {
            tttState.reset();
            tttUI.reset();
        }
        else {
            tttState.actionPassed(message);

            boolean changesMade = tttState.getChangesMade();
            //if changes made to tttState, need to update UI.
            if (changesMade) {
                int intIndex = Integer.parseInt(message);
                String prevPlayer = tttState.getPreviousPlayer();
                // Update board
                tttUI.updateTile(intIndex, prevPlayer);
                boolean gameEnded = tttState.getGameEnded();
                if (gameEnded) {
                    String winner = tttState.getWinner();
                    tttUI.gameEnded(winner);
                }
            }  
        }
    }

    public void exit(String...args) {
        System.exit(0);
    }

    public static void main(String...args) {

        TTTGame game = new TTTGame();
        game.tttListener.setGameInstance(game);
        game.tttUI.initialiseUI(args);
        game.tttUI.setListener(game.tttListener);

    }


}
