import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter; 
import java.awt.event.ActionEvent; 
import java.awt.event.WindowEvent;
import javax.swing.JButton;

/* 
WindowListener is similar to WindowAdapter, but requires all window-event 
methods to be defined (tis an interface). WindowAdapter defaults them 
to nulls, so I  can only override windowClosing that I care about.
TTTListener inherits from WindowAdapter and implements the 
ActionListener interface.
*/
public class TTTListener extends WindowAdapter implements ActionListener {

    TTTGame game;

    public void setGameInstance(TTTGame daGame) {
        game = daGame;
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        // System.out.println(button);
        String index = button.getName();
        // System.out.println(index);
        game.actionPerformed(index);
    }

    public void windowClosing(WindowEvent e) {
        game.exit();
    }

}
