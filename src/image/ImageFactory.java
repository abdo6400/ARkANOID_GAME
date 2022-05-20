package image;
import javax.swing.ImageIcon;

import constants.Constants;

public class ImageFactory {

	public static ImageIcon createImage(Image image) {
		
		ImageIcon imageIcon = null;
		
		switch (image) {
		case BACKGROUND:
			imageIcon = new ImageIcon(Constants.BACKGROUND_IMAGE_URL);
			break;
		case BACKGROUND4:
			imageIcon = new ImageIcon(Constants.BACKGROUND_IMAGE_URL2);
			break;
		case BACKGROUND5:
            imageIcon =new ImageIcon(Constants.UFO_IMAGE_URL);
            break;
		case BackGround:
            imageIcon =new ImageIcon(Constants.BACKGROUND_IMAGE_URL1);
          break;
		case BACKGROUND2:
             imageIcon =new ImageIcon(Constants.BACKGROUNDMESSAGE_IMAGE_URL);
            break;
		case SHAPE:
			imageIcon = new ImageIcon(Constants.SHAPE);
			break;
		case SHAPE1:
			imageIcon = new ImageIcon(Constants.SHAPE1);
			break;
		case SHAPE3:
			imageIcon = new ImageIcon(Constants.SHAPE3);
			break;
		case MONSTER:
			imageIcon = new ImageIcon(Constants.MONSTER);
			break;
        case gif1:
             imageIcon =new ImageIcon(Constants.GIF1_IMAGE_URL);
            break;
        case LASER:
            imageIcon =new ImageIcon(Constants.LASER);
           break;
        case BOMB:
            imageIcon =new ImageIcon(Constants.BOMB);
           break;
        case PADDLE:
            imageIcon =new ImageIcon(Constants.PADDLE);
           break;
        case BALL:
            imageIcon =new ImageIcon(Constants.BALL);
           break;
         default:
			return null;
		}
		
		return imageIcon;
	}
}
