package Game;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.Timer;
import callbacks.GameEvent;
import constants.Constants;
import image.Image;
import image.ImageFactory;
import model.Bomb;
import model.EnemyShip;
import model.Gift;
import model.Laser;
import model.Monster;
import model.ball;
import model.paddl;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
public class GamePanel extends JPanel {
// Start declare Variables //
private ImageIcon backgroundImage ;
private ImageIcon backgroundImageMessage ;
private Random generator;
private boolean play=true;
private boolean work=false;
private int score;
private int PaddleX =240 , PaddleY =630 , paddlewidth=137;
private int newpositionpaddlex = 0, newwidthpaddle =600;
private int choicelevel;
private int alldead;
private int delay=5;
private int hitpaddle=0;
private String message;
private String messagebutton;
private String levelmessage;
private Timer timer;
private paddl paddle;
private ball Ball;
private List<Monster> monsters;
private Monster monster;
private Laser laser1;
private Laser laser2;
private List<Bomb> bombs;
private Bomb bomb;
private List<Gift> gifts;
private List<EnemyShip> enemyships;
private EnemyShip enemyship;
//End declare Variables //
// Constractor //
public GamePanel(int choicelevel){
	    this.choicelevel=choicelevel;
        initializeLayout();
        initializeVariables();
        initializeGame();  
}
// function to initializeVariables which we declare //
private void initializeVariables() {      
	    this.laser1 = new Laser();
	    this.laser2 = new Laser();
	    this.monster=new Monster();
    	this.paddle= new paddl(PaddleX, PaddleY , paddlewidth);
    	this.Ball=new ball(); 	
        this.backgroundImageMessage=ImageFactory.createImage(Image.BACKGROUND2);
        this.timer=new Timer(delay,new GameLoop(this));  
        this.generator=new Random();
        this.monsters = new ArrayList();
        this.enemyships = new ArrayList<>();
        this.bombs=new ArrayList<>();
        this.gifts = new ArrayList<>();
}
// function to initialize screen //
private void initializeLayout() {
        this.setPreferredSize(new Dimension(Constants.BOARD_WIDTH,Constants.BOARD_HEIGHT));
        addKeyListener(new GameEvent(this));
  	    setFocusable(true);
  	    setFocusTraversalKeysEnabled(false);	
}
// function to initialize each level //
private void initializeGame() {
	switch(choicelevel)
	{
	case 1:
		//level1//
		this.backgroundImage = ImageFactory.createImage(Image.BACKGROUND4);
		levelmessage="LEVEL1";
		 for(int i = 0 ; i<4 ; i++)
	        {
	        
	            for(int j = 0 ; j<6 ; j++)
	            {
	               enemyship = new EnemyShip(Constants.ENEMY_INIT_X+80*j ,Constants.ENEMY_INIT_Y+45*i , ImageFactory.createImage(Image.SHAPE));
	                this.enemyships.add(enemyship);
	               
	            }
	        }
		break;
	case 2:
		//level2//
		this.backgroundImage = ImageFactory.createImage(Image.BACKGROUND2);
		levelmessage="LEVEL2";
		 for(int i = 0 ; i<4 ; i++)
	        {
	        
	            for(int j = 0 ; j<6 ; j++)
	            {
	            	 if( j == 2  || j == 3  )
	             		continue;
	                enemyship = new EnemyShip(Constants.ENEMY_INIT_X+80*j ,Constants.ENEMY_INIT_Y+45*i ,ImageFactory.createImage(Image.SHAPE1));
	                this.enemyships.add(enemyship);
	               
	            }
	        }
		break;
	case 3:
		//level3//
		this.backgroundImage = ImageFactory.createImage(Image.BACKGROUND);
		levelmessage="LEVEL3";
		 for(int i = 0 ; i<5 ; i++)
	        {
			 if( i == 1  || i == 3  )
          		continue;
	        
	            for(int j = 0 ; j<6 ; j++)
	            {
	              if( j == 1  || j == 4  )
	               		continue;
	                enemyship = new EnemyShip(Constants.ENEMY_INIT_X+80*j ,Constants.ENEMY_INIT_Y+45*i ,ImageFactory.createImage(Image.SHAPE3));
	                this.enemyships.add(enemyship);
	               
	            }
	        }
		break;
	default:
		//level the monster//
		this.backgroundImage = ImageFactory.createImage(Image.BACKGROUND5);
		levelmessage="LEVEL4";
		for(int j = 1 ; j<3 ; j++)
        {
			monster =new Monster(200*j,100,ImageFactory.createImage(Image.MONSTER));
			this.monsters.add(monster);
			this.monster.setVisible(true);
        }	
		break;
	}
}
// Start functions to draw the objects on the screen//
@Override
protected void paintComponent(Graphics g)
{
        super.paintComponent(g);
        g.drawImage(backgroundImage.getImage(), 0, 0, null);
        drawitems(g); 
}
private void drawitems(Graphics g) {
		if(play)
		{
		  if(choicelevel==1 ||choicelevel==2 ||choicelevel==3)
		  {
			drawscore(g);
			drawEnemy_1(g);
			draw_paddl(g);
			draw_ball(g);
			draw_gifts(g);
		  }
		  else if(choicelevel==4)
		  {
		    drawscore(g);
		    drawMonster(g); 
			draw_paddl(g);
		    draw_ball(g);
			draw_Laser(g,laser1);
			draw_Laser(g,laser2);
			draw_bomb(g);
			
		  }
		}
		else
		{
			if(timer.isRunning())
			{
				timer.stop();
			}
			drawMessage(g);
		}
		Toolkit.getDefaultToolkit().sync();
		
	}
private void draw_gifts(Graphics g) {
	for(Gift gift: this.gifts)
	 if(!gift.isDead())
	 {
	    g.drawImage(gift.getImage(),gift.getX(),gift.getY(), this);
	 }
	
}
private void draw_bomb(Graphics g) {
	for(Bomb bomb : this.bombs)
	 if(!bomb.isDead())
	 {
	    g.drawImage(bomb.getImage(), bomb.getX(), bomb.getY(), this);
	 }
}
private void drawscore(Graphics g) {
		  g.setColor(Color.white);
		  g.setFont(new Font("serif",Font.BOLD,20));
		  g.drawString("Score : " + score,30, 30);	
		  g.drawString(levelmessage,270,30);
}
private void draw_paddl(Graphics g) {
	g.drawImage(paddle.getImage(),paddle.getX(),paddle.getY(), paddlewidth, 23, this);
}
private void draw_ball(Graphics g) {
	 	g.drawImage(Ball.getImage(),Ball.getX(),Ball.getY(),this);
	}
private void drawEnemy_1(Graphics g)
{
    for(EnemyShip enemy : this.enemyships)
        if(enemy.isVisible())
            g.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);
}       
private void drawMonster(Graphics g)
{    
	for(Monster monster : this.monsters)
	 if(monster.isVisible())
         g.drawImage(monster.getImage(), monster.getX(), monster.getY(), this);
}
private void draw_Laser(Graphics g,Laser laser)
{
	   if(!laser.isDead())
        g.drawImage(laser.getImage(), laser.getX(), laser.getY(), this);
}
private void drawMessage(Graphics g) {
	 g.drawImage(backgroundImageMessage.getImage(),0,0,null);
	 g.setColor(Color.white);
	 g.setFont(new Font("serif",Font.BOLD,30));
	 g.drawString(message,250, 300);
	 g.drawString(" Score : "+score,220, 340);
}
// End functions to draw the objects on the screen//
// Start functions to make sure that every event on the screen work well //
public void doOneloop() {    
    	update();
    	repaint();
}
private void update() {
	  this.paddle.move();
	  End_Game_when();
	  if(monster.isVisible())
	       monster_things();
	   Enemyship_things();
	   ball_things(); 
}
private void End_Game_when()
{   
	if( choicelevel==1 || choicelevel== 2 ||choicelevel==3)
    {
      if(alldead==this.enemyships.size())
      {
       play=false;
       message="Win";
      }
    }
    else 
    {
      if(score==5000)
      {
        play=false;
        message="Win";
      }
    } 
	if(Ball.isDead())
  	{
  	   play=false;
       message="LOSE";
  	}
}
private void Enemyship_things()
{
    for(EnemyShip alien : this.enemyships)
    {
        int alienx =alien.getX();
        int alieny =alien.getY();
     if(!alien.isVisible())continue;
     else if(new Rectangle(alienx,alieny,Constants.ENEMY_WIDTH,
   	 Constants.ENEMY_HEIGHT).intersects(new Rectangle(Ball.getX()+15,Ball.getY()+16,30,32))||new Rectangle(alienx+10,alieny+5,Constants.ENEMY_WIDTH,
   		   	 Constants.ENEMY_HEIGHT).intersects(new Rectangle(Ball.getX(),Ball.getY(),30,32)))
     {
          if(generator.nextDouble() < 0.5)
          {
        	 Gift gift=new Gift(alienx,alieny);
       	     this.gifts.add(gift);
          }
   	 alien.setVisible(false);
    if(Ball.getDy()<0)
   	{
   	   Ball.setDy((generator.nextInt(2)+2));
   	}
   	else if(Ball.getDy()>0)
   	{
   	   Ball.setDy(-(generator.nextInt(2)+2));
   	}
   	if(Ball.getDx()<0)
   	{
   	   Ball.setDx((generator.nextInt(1)+1));
   	}
   	else if(Ball.getDx()>0)
   	{
   	   Ball.setDx(-(generator.nextInt(1)+1));
   	}		
   	    alldead++;
   	    score+=100;	
    }	
   }
}
private void ball_things()
{
	 get_Gift();
    if(!Ball.isDead())
	 {
		this.Ball.move();	  
	 }
    if(new Rectangle(Ball.getX(),Ball.getY(),20,20).intersects(new Rectangle(paddle.getX(),630,paddlewidth,25))) {
	    Ball.setDy(-(generator.nextInt(2)+2));
        Ball.setDx(generator.nextInt(2));
    }
}
private void get_Gift()
{ 
	for(Gift gift : this.gifts)
	  {
	     if(new Rectangle(gift.getX(),gift.getY(),40,20).intersects(new Rectangle(paddle.getX(),630,paddlewidth,21))&&paddlewidth!=600) {
	    	  /*PaddleX=swap(PaddleX,newpositionpaddlex);
	    	  paddle.setX(PaddleX);
	    	  paddlewidth=swap(paddlewidth,newwidthpaddle);
	    	  paddle.setWidth(paddlewidth);
	    	  work=true;*/
	    	  gift.die();  
	    } 
	 }  
  for(Gift gift: gifts)
  {
   if(!gift.isDead())
   {
  	gift.move();
   }
  }
 /* if(generator.nextBoolean()==true&&work)
  {
 	     PaddleX=240; //swap(newpositionpaddlex,PaddleX);
	     paddle.setX(PaddleX);
	     paddlewidth=137;// swap(newwidthpaddle,paddlewidth);
	     paddle.setWidth(paddlewidth);
	     work=false;
	     hitpaddle=0;
  }*/
}
private int swap(int value, int newvalue)
{
	int temp ;
	temp=value;
	value=newvalue;
	newvalue=temp;
	return value;
	
}
private void monster_things()
{
   laser(monster.getX(),monster.getY()+80);
   get_bombs();
   for(Monster monster : this.monsters)
 	{
       monster.move();
       if(new Rectangle(monster.getX(),monster.getY(),150,127).intersects(new Rectangle(Ball.getX()+30,Ball.getY()+31,30,32)) ||
        new Rectangle(monster.getX()+70,monster.getY(),150,127).intersects(new Rectangle(Ball.getX(),Ball.getY(),30,32)) ) {
     	if(Ball.getDy()<0)
    	{
    	 Ball.setDy((generator.nextInt(2)+2));
    	}
		 score+=50;
	   }
    }
}	 
private void laser(int x,int y)
{

	if(!laser1.isDead()||!laser2.isDead())
	  {
		  this.laser1.move();
		  this.laser2.move();
	  }
	if(!laser1.isDead())
	 {
	if(new Rectangle(x,y,81,124).intersects(new Rectangle(laser1.getX(),laser1.getY(),1,5))) {	
	     	 laser1.die();
	  		 score+=100;
	  			
	 	 }
	 }
	 if(!laser2.isDead())
	 {
	  if(new Rectangle(x,y,81,124).intersects(new Rectangle(laser2.getX(),laser2.getY(),1,5))) {	
	     	laser2.die();
	  	    score+=100;
	 	 }
	 }
}
private void get_bombs()
{
	for(Bomb bomb: this.bombs)
    {
      if(new Rectangle(bomb.getX(),bomb.getY(),35,26).intersects(new Rectangle(paddle.getX(),630,paddlewidth,21))) {
   	       bomb.die();
    	   play=false;
      	   message="LOSE";
	  }
 
    }
   for(Monster monster: this.monsters)
    {
    	if(!monster.isDead())
    	{	
    	  if(generator.nextDouble() < 0.001)
         {
           Bomb bomb=new Bomb(monster.getX()+50,monster.getY()+100);
         	this.bombs.add(bomb);
         }        
    	}
    }
   for(Bomb bomb: this.bombs)
   {
   	if(!bomb.isDead())
   	{
   		bomb.move();
   	}
   }
}
public void keyReleased(KeyEvent e) {
  		this.paddle.KeyReleased(e);
  	}
public void keyPressed(KeyEvent e) {
	int key =e.getKeyCode();
  	this.paddle.keyPressed(e);	 
  	if(key == KeyEvent.VK_SPACE)
  	{
  		this.timer.start();
  		laser1.setVisible(true);
  		int Laserx=paddle.getX();
  		int Lasery=paddle.getY();
  	    if(play && laser1.isDead() &&laser2.isDead())
  	    {
  		 laser1 = new Laser(Laserx+10,Lasery);
  		 laser2 = new Laser(Laserx+120,Lasery);
  	    }
  	}
}	
}
