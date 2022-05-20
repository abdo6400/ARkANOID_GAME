package model;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import image.Image;
import image.ImageFactory;   
public class ball extends Sprite {
private ImageIcon ball=ImageFactory.createImage(Image.BALL);
public ball() {
		start();
}
private void start() {
     setImage(ball.getImage());
	 int ballX=290;
	 int ballY=590;
	 int dx=1;
	 int dy=-2;
	 setDy(dy);
	 setDx(dx);
	 setX(ballX);
	 setY(ballY);	
}
@Override
public void move() {
	x +=dx;
	y +=dy;	
	if(x<0)
	 dx+=1;
	if(y>=650)
	 die();
	if(y<20)
	 dy+=2;
	if(x>=570)
	 dx-=1;	
}
}
