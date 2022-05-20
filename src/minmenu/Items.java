package minmenu;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public abstract class Items extends JFrame implements ActionListener{
  public static int i;
  private Clip clip;
  protected JButton backbutton;
  protected ImageIcon imageicon1=new ImageIcon("image/background3.jpg");
  protected JLabel background1= new JLabel("",imageicon1,JLabel.CENTER);
  protected ImageIcon imageicon2= new ImageIcon("image/Background6.jpg");
  protected JLabel background2=new JLabel("",imageicon2,JLabel.CENTER);
  protected abstract void Start();
  protected abstract void Starting();
  public boolean Check(int x) {
		if(x == 1)
			return true;
		else
		  return false;
	}
  /*public void backgroundsound(boolean check)
  {
	 try {
		  AudioInputStream sound = AudioSystem.getAudioInputStream(new File("sound/"));
		  clip= AudioSystem.getClip();
		  clip.open(sound);
		  if(check == true)
		  clip.start();
		  else
		  clip.close();
		  
	  } catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }*/
}
