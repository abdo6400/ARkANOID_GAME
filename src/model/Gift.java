package model;

import javax.swing.ImageIcon;

import image.Image;
import image.ImageFactory;

public class Gift extends Sprite {
	private boolean visible = false ;
	private ImageIcon imageicon = ImageFactory.createImage(Image.gif1);
	public Gift(int x,int y){
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
		this.y++;
		if(this.y>=660)
		{
			die();
		}
	}

}
