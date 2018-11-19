package erp.funcionario;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Imagem {

	public static byte[] imageToByte(Image image) {
		if (image == null) {
			return new byte[0];
		}
		ImageIcon icon = new ImageIcon(image);
		if (icon.getIconHeight() == -1 || icon.getIconWidth() == -1) {
			return new byte[0];
		}
		BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), 1);
		Graphics bg = bi.getGraphics();
		bg.drawImage(image, 0, 0, null);
		bg.dispose();
		ByteArrayOutputStream buff = new ByteArrayOutputStream();
		try {
			ImageIO.write(bi, "JPG", buff);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buff.toByteArray();
	}
}
