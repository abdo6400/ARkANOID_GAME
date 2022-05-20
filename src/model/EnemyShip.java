package model;
import image.Image;
import image.ImageFactory;
import javax.swing.ImageIcon;
public class EnemyShip extends Sprite {
private boolean visible = true ;
private final ImageIcon imageicon;
public boolean isVisible() {
        return visible;
  }
public void setVisible(boolean visible) {
        this.visible = visible;
  }
public EnemyShip(int x,int y , ImageIcon imageicon){
	    this.imageicon = imageicon;
        this.x = x;
        this.y = y;
        initialize();
  }
private void initialize() {   
        setImage(imageicon.getImage());
}
@Override
public void move(){}
}
