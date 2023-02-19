import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 
import javax.swing.JButton;

public class TTTListener implements ActionListener {
    
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

}
