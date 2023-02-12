import javax.swing.*;
import java.awt.GridLayout;

public class TTTBoard extends JFrame {

    // Declare components
    static JFrame frame;

    // JButtons declaration - clickable fields for the players
    static JButton[] fields;

    // Grid Layout for 3x3 grid + labels
    static GridLayout layout;

    // Array of labels used at the top of the board, indicating winning
    // player/game result.
    static JLabel[] labels;

    public void gameEnded(String winner) {
        if (winner == "draw"){
            labels[1].setText("No winner, draw :(");
        }
        else {
            labels[1].setText(winner + " wins!");
        }
    }

    public void updateTile(int index, String currentPlayer) {

        fields[index].setText(currentPlayer);
        if (currentPlayer == "x") {
            labels[1].setText("Current Player: x");
        }
        else {
            labels[1].setText("Current Player: o");
        }
    }

    public static void main(String[] args) {

        // Make the JFrame, the window which holds all GUI components.
        frame = new JFrame("Frame");

        // All possible buttons
        fields = new JButton[9];

        // Labels, with dummy labels.
        labels = new JLabel[3];

        // Define 3x3 layout
        layout = new GridLayout(0, 3);

        frame.setLayout(layout);

        labels[0] = new JLabel("");
        labels[1] = new JLabel("Current Player: x", SwingConstants.CENTER);
        labels[2] = new JLabel("");

        for (int j = 0; j < 3; j++) {
            frame.add(labels[j]);
        }

        for (int i = 0; i < 9; i++){
            //I hate this line so much
            fields[i] = new JButton(Integer.toString(i)); 
            frame.add(fields[i]);
        }

        // sets size of window based on the size of the components
        // frame.pack(); 
        
        frame.setSize(600, 800);
        frame.setVisible(true);


    }
}
