package hscard.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.UUID;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import hscard.controller.SearchCardController;

public class HsUtil {
	
	//Method
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
	public static String saveImageFile(File imgFile){
		try {
			BufferedImage image = ImageIO.read(imgFile);
			String filePath = imgFile.getAbsolutePath();
			String suffix = "";
			String changeFileName = UUID.randomUUID().toString();
			final String savePath = "C:\\Users\\KISSCO-PC82\\git\\hscard\\hscard\\src\\saveImg\\";
			StringTokenizer stz = new StringTokenizer(filePath, ".");
			while(stz.hasMoreTokens()){
				suffix = stz.nextToken();
			}
			File saveImg = new File(savePath + changeFileName + "." + suffix);
			ImageIO.write(image, suffix, saveImg);
			
			return saveImg.getAbsolutePath();
			
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
	}
	
}
