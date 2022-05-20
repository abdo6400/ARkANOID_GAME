package minmenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Game.GameMainFrame;
import  minmenu.Items;
import GameMenu.GameMenu;
public class Levelsframe extends Items {
private JButton[] button=new JButton[9];
protected JLabel Title=new JLabel(" ...L_E-V_E-L_s M_E-N_u...");
Font newFont = new Font("",Font.ITALIC,30);
public Levelsframe() {
         Start();
         Starting();
      }
//to install Variables
protected void Start() {
	   //  backgroundsound(Check(i));
	     background1.setBounds(0,0,600,700);
	     Title.setBounds(110,15,370,200);
	     Title.setForeground(Color.WHITE);
	     Title.setFont(newFont);
	     backbutton = new JButton("B");
	 	 backbutton.setBounds(0,0,50,30);
	 	 backbutton.addActionListener(this);
 	     button[0]=Drawing(button[0],100,200,"image/level1.png",1);
 	     button[1]=Drawing(button[1],250,200,"image/level2.png",1);
 	     button[2]=Drawing(button[2],400,200,"image/level3.png",1);
	     button[3]=Drawing(button[3],100,350,"image/level4.png",1);
	     button[4]=Drawing(button[4],250,350,"image/level5.png",0);
	     button[5]=Drawing(button[5],400,350,"image/level6.png",0);
 	     button[6]=Drawing(button[6],100,500,"image/level7.png",0);
 	     button[7]=Drawing(button[7],250,500,"image/level8.png",0);
 	     button[8]=Drawing(button[8],400,500,"image/level9.png",0);    
	}
//to install Layout
protected void Starting() {
    	 setTitle("Levels Menu");
     	 setDefaultCloseOperation(EXIT_ON_CLOSE);
     	 setLayout(null);
     	 setIconImage(imageicon1.getImage());
     	 setSize(600,700);
     	 setLocationRelativeTo(null);
     	 setResizable(false);
     	 setVisible(true);
     	 for(int i=0;i<9;i++)
     		 add(button[i]);
     	 add(Title);
     	 add(background1); 
     	 add(backbutton);
}
// Drawing items
private JButton Drawing(JButton button,int x,int y,String source,int i) {
    	 Font font=new  Font("Helvetica",Font.BOLD,20);
 		 button = new JButton(new ImageIcon(source));
 		 button.setBounds(x,y,100,100);
 	 	 button.setFont(font);
 	 	 button.setEnabled(Check(i));
 	 	 button.addActionListener(this);
 		 return button;
}
public void actionPerformed(ActionEvent e) {
    	if(e.getSource()==button[0])  
    	{
    		// setLevel
    		this.dispose();
    		new GameMainFrame(1);
    		
    	}
    	else if(e.getSource()==button[1])  
    	{
    		// setLevel
    		this.dispose();
    		new GameMainFrame(2);
    		
    	}
    	else if(e.getSource()==button[2])  
    	{
    		// setLevel
    		this.dispose();
    		new GameMainFrame(3);
    		
    	}
    	else if(e.getSource()==backbutton)
    	{
    		// set here Menu page
    		this.dispose();
    		new GameMenu();
    	}
    	else
    	{
    		// set level 
    		this.dispose();
    		new GameMainFrame(4);
    			
    	}
  }
}
