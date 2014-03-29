package bestroomie.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

/**
 * This class we keep some basic utility functions, 
 * **/
public class BRUtil {

	public static boolean emailValidator(String email) {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static void main(String args[]) {
		//System.out.println(BRUtil.emailValidator("a@bcom"));
		
		BRUtil.generateCaptcha(120, 30);
	}
	
	/**
	 * To genreate a random 5-digit captcha
	 * width and height are the size of generated captcha image
	 * @param 	
	 * @param 
	 * */
	public static int generateCaptcha(int width,int height) {
		int res = 10000 + (int)(Math.random()*90000);
		
		String capStr = Integer.toString(res);
		
		BufferedImage bufferedImage = new BufferedImage(width, height,
	                BufferedImage.TYPE_INT_RGB);
	        Graphics graphics = bufferedImage.getGraphics();
	        graphics.setColor(Color.LIGHT_GRAY);
	        graphics.fillRect(0, 0, 200, 50);
	        graphics.setColor(Color.BLACK);
	        graphics.setFont(new Font("Arial Black", Font.BOLD, 20));
	        graphics.drawString(capStr, 10, 25);
	        int x1,x2,y1,y2;
	        
	        for (int i =0;i<10;i++) {
	        	Random rn = new Random();
	        	x1 = (int) (Math.random() * width);
	        	x2 = (int) (Math.random() * width);
	        	y1 = (int) (Math.random() * height);
	        	y2 = (int) (Math.random() * height);
	        	graphics.drawLine(x1,y1,x2,y2);
	        }
	        try {
	        	File f = new File(BRConst.CAPTCHA_FILE_PATH);
	        	ImageIO.write(bufferedImage, "jpg", f);
	        } catch (Exception e) {
	        	res = -1;
	        	e.printStackTrace();
	        }
		return res;
	}
}
