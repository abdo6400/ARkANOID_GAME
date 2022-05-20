package Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
public class GameLoop implements ActionListener {
private GamePanel gamepanel;
public GameLoop(GamePanel gamepanel) {
	 this.gamepanel=gamepanel;
}
public void actionPerformed(ActionEvent arg0) {
	 this.gamepanel.doOneloop();
}
}
