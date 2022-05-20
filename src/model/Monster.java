package model;

import javax.swing.ImageIcon;

public class Monster extends Sprite{
private boolean visible = false;
private ImageIcon imageicon;
public boolean isVisible() {
	     return visible;
}
public void setVisible(boolean visible) {
	     this.visible = visible;
}
public Monster() {}
public Monster(int x,int y , ImageIcon imageicon){
		this.imageicon = imageicon;
		 int dx=1;
		 setDx(dx);
	    this.x = x;
	    this.y = y;
	    initialize();
}
private void initialize() {
	  setImage(imageicon.getImage());
}
@Override
public void move() {
	 x +=dx;
	if(x<10)
	 dx+=1;
	if(x>=520)
	 dx-=1;	
		
}

}
