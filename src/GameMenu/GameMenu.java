package GameMenu;
import constants.Constants;

import minmenu.Items;
import minmenu.Levelsframe;
import minmenu.optionsframe;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
public class GameMenu extends Items{
Font newFont = new Font("",Font.ITALIC,40);
protected JLabel Title=new JLabel(" ...m_A-I_n m_E-N_u...");
protected JLabel Title2=new JLabel(" .A R k A N O I D.");
Font newFont2 = new Font("",Font.BOLD,30);
private JButton b1 = new JButton("Play");
private JButton b2 = new JButton("Scores");
private JButton b3 = new JButton("Option");
private JButton b4 = new JButton("Exit");  
public GameMenu()
{
	Start();
	Starting();
}
@Override
protected void Starting() {
	 background2.setBounds(0,0,600,700);
	 Title.setBounds(140,-50,370,200);
     Title.setForeground(Color.yellow);
     Title.setFont(newFont2);
     Title2.setBounds(270,50,370,200);
     Title2.setForeground(Color.black);
     Title2.setFont(newFont2);
	 b1.setBackground(Color.yellow);
	    b2.setBackground(Color.yellow);
	    b3.setBackground(Color.yellow);
	    b4.setBackground(Color.yellow);
	    b1.setForeground(Color.black);
	    b2.setForeground(Color.black);
	    b3.setForeground(Color.black);
	    b4.setForeground(Color.black);
	    b1.setFont(newFont);
	    b2.setFont(newFont);
	    b3.setFont(newFont);
	    b4.setFont(newFont);
	    b1.setBounds(50,150,200,80); 
	    b2.setBounds(150,250,200,80);
	    b3.setBounds(250,350,200,80); 
	    b4.setBounds(350,450,200,80);
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
	    b4.addActionListener(this);
	    b1.setFocusable(false);
	    b2.setFocusable(false);
	    b3.setFocusable(false);
	    b4.setFocusable(false);		
}
@Override
protected void Start() {
	 setTitle("Main Menu");
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 setLayout(null);
	 setIconImage(imageicon2.getImage());
	 setSize(600,700);
	 setLocationRelativeTo(null);
	 setResizable(false);
	 setVisible(true);	
	 add(Title);
	 add(Title2);
	 add(b1);
	 add(b2);
	 add(b3);
	 add(b4);
	 add(background2); 		
}
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b1)  
	{
		this.dispose();
		new Levelsframe();
		
	}
	else if(e.getSource()==b2)
	{
		// Scores
	}
	else if(e.getSource()==b3)
	{
		this.dispose();
		new optionsframe();
	}
	else
	{
		this.dispose();
	}
		
}
}
