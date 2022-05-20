package minmenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import GameMenu.GameMenu;
import minmenu.Items;
public class optionsframe  extends Items{
private JRadioButton box1,box2;
private ButtonGroup GROUP = new ButtonGroup();
public optionsframe() {
	  Start();
	  Starting();
}
//to install Variables
protected void Start() {
	//backgroundsound(Check(i));
	background1.setBounds(0,0,750,750);
	backbutton = new JButton("B");
	backbutton.setBounds(0,0,50,30);
	backbutton.addActionListener(this);
	box1=Drawing(box1,90,50,"Sound On");
	box1.setSelected(true);
	box2=Drawing(box2,90,150,"Sound Off");
}
//to install Layout
protected void Starting() {
	  ButtonGroup GROUP = new ButtonGroup();
	  GROUP.add(box1);
	  GROUP.add(box2);
	  setTitle("Options Menu");
	  setIconImage(imageicon1.getImage());
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  setLayout(null);
	  setSize(300,300);
	  setLocationRelativeTo(null);
	  setResizable(false);
	  setVisible(true);	
	  add(box1);
	  add(box2);
	  add(backbutton);
	  add(background1);
	}	
//Drawing items
private JRadioButton Drawing(JRadioButton box,int x, int y,String name)
{
	Font font=new  Font("Helvetica",Font.BOLD,15);
	box = new JRadioButton(name);
	box.setBounds(x,y,100,50);
	box.setFocusable(false);
	box.setFont(font);
	box.setForeground(Color.BLACK);
	box.setBackground(null);
	box.addActionListener(this);
	return box; 
}
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==box2)  
	{
		// the action : close the sound
		i=0;
	}
	else if(e.getSource()==backbutton)
	{
		// set here Menu page
		this.dispose();
	    new GameMenu();
	}
	else
	{
		// the action : open the sound
		i=1;
		
	}
	
	
}
}
