package model;

import javax.swing.ImageIcon;

import constants.Constants;
import image.Image;
import image.ImageFactory;

public class Bomb extends Sprite{
	private boolean visible = true;
	private ImageIcon imageicon = ImageFactory.createImage(Image.BOMB);
	public Bomb(){}
	public Bomb(int x,int y){
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
		    int dy=2;
		    setDy(dy);
		    setX(this.x);
			setY(this.y);
	        setImage(imageicon.getImage());
	}
	@Override
	public void move() {
		y +=dy;
		if(this.y>650)
		{
		  die();
		}
		
	}

}
