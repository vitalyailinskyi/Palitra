package Main;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageInsert implements ImageObserver {
	
	public static Image visibleImage;
	
	public Image getImage(String path) throws IOException{
		visibleImage = (Image) ImageIO.read(new File(path));
		return visibleImage;
	}
	
	public static void Image(Graphics g) throws IOException{
		ImageInsert i = new ImageInsert();
		g.drawImage(i.getImage("D://eclipse/palitra.jpg"), 23, 72, null);
	}

	public boolean imageUpdate(java.awt.Image img, int infoflags, int x, int y,	int width, int height) {
		return false;
	}
}
