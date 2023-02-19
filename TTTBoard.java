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

    static JButton resetButton;

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
        fields[index].setEnabled(false);
        if (currentPlayer == "x") {
            labels[1].setText("Current Player: o");
        }
        else {
            labels[1].setText("Current Player: x");
        }
    }

    public void initialiseUI(String[] args) {
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
        // labels[2] = new JLabel("");
        resetButton = new JButton("Reset");
        resetButton.setName("reset");

        for (int j = 0; j < 2; j++) {
            frame.add(labels[j]);
        }
        frame.add(resetButton);

        for (int i = 0; i < 9; i++){
            //I hate this line so much
            fields[i] = new JButton(Integer.toString(i)); 
            fields[i].setName(Integer.toString(i));
            // System.out.println(fields[i].getText());
            frame.add(fields[i]);
        }

        // sets size of window based on the size of the components
        // frame.pack(); 
        
        frame.setSize(600, 800);
        frame.setVisible(true);
    }

    public void reset(String...args) {
        labels[1].setText("Current Player: x");
        for (int i = 0; i < 9; i++){
            fields[i].setEnabled(true);
            fields[i].setText(Integer.toString(i));
        }
    }

    public void setListener(TTTListener listener) {
        for (int i = 0; i < 9; i++){
            fields[i].addActionListener(listener);
        }
        resetButton.addActionListener(listener);
    }

    public static void main(String[] args) {

        TTTBoard tttUI = new TTTBoard();
        tttUI.initialiseUI(args);

    }
}
