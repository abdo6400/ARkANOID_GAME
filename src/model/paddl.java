package model;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import image.Image;
import image.ImageFactory;
public class paddl extends Sprite{
private ImageIcon paddle = ImageFactory.createImage(Image.PADDLE);
private int width;
public paddl() {}
public paddl(int x,int y , int width) {
	 Start(x,y,width);
 }
private void Start(int x ,int y ,int width) {
	setImage(paddle.getImage());
	setWidth(width);
	setX(x);
	setY(y);
}
@Override
public void move()
{
	x +=dx;
	if(x<=0)
	 x=0;
	if(x>=465)
     x=460;
}
public int getWidth() {
	return width;
}
public void setWidth(int width) {
	this.width = width;
}
public void keyPressed(KeyEvent e) {
  if(e.getKeyCode()==KeyEvent.VK_RIGHT) 
		dx=2;	
  if(e.getKeyCode()==KeyEvent.VK_LEFT) 
		dx=-2;
}
public void KeyReleased(KeyEvent e) {
  if(e.getKeyCode()==KeyEvent.VK_RIGHT) 
		dx=0;
	if(e.getKeyCode()==KeyEvent.VK_LEFT) 
		dx=0;	
	}	
}
