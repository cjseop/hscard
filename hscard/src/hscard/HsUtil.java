package hscard;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class HsUtil {
	
	public static ImageIcon resizeImage(String imagePath, int weidth, int height){
		BufferedImage imgBuffer;
		try {
			imgBuffer = ImageIO.read(new File(imagePath));
			Image resizeImg = imgBuffer.getScaledInstance(weidth, height, Image.SCALE_SMOOTH);
			ImageIcon img = new ImageIcon(resizeImg);
			return img;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
