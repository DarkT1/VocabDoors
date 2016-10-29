package src;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageGetter {
	public static Image getImage(String File) {
		Image Img = null;

		try {
			Img = ImageIO.read(new File("bin\\Images\\" + File));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Img;

	}
}
