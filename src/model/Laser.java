package model;

import javax.swing.ImageIcon;

import constants.Constants;
import image.Image;
import image.ImageFactory;

public class Laser extends Sprite{
private boolean visible = false ;
private ImageIcon imageicon = ImageFactory.createImage(Image.LASER);
public Laser(){}
public Laser(int x,int y){
        this.x = x;
        this.y = y;
        initialize();
  }
public boolean isVisible() {
        return visible;
  }
public void setVisible(boolean visible) {
        this.visible = visible;
  }
private void initialize() {
       
        setImage(imageicon.getImage());
        setX(x);
        setY(y);
}
@Override
public void move() {
	this.y -= Constants.SPEEDLASER;
	if(this.y<0)
	{
		this.die();
	}
}

}
