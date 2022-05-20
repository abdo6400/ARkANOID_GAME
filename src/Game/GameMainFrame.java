package Game;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import constants.Constants;
import image.Image;
import image.ImageFactory;
public class GameMainFrame extends JFrame {
private final int choicelevel;
private ImageIcon imageicon = ImageFactory.createImage(Image.MONSTER);
public GameMainFrame(int choicelevel) {
	this.choicelevel=choicelevel;
	initializeLayout();
}
private void initializeLayout() {
        add(new GamePanel(choicelevel));
        setTitle(Constants.TITLE);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(imageicon.getImage());
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);   
}
}
