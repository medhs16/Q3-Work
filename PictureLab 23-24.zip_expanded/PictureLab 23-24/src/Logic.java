
import java.awt.Color;

public class Logic {
	
	/**
	 * Alters the picture so that each pixel's blue channel has been zeroed out.
	 * All other channels remain the same 
	 * @param picture the image to be altered
	 */
	//commenting complete
	public static void zeroBlue(DigitalPicture picture) {
		//obtain the 2D array rep. of the picture
		Pixel[][] pixel2D = picture.getPixels2D();
		
		//traverse the pixels and alter their values per filter spec
		for (int r = 0; r < pixel2D.length; r++) {
			for (int c = 0; c < pixel2D[r].length; c++) {
				pixel2D[r][c].setBlue(0);//sets every pixel's blue value to zero				
			}
		}
		
	}
	//commenting complete
	public static void blackAndWhite(DigitalPicture pic) {
		//1) obtain a 2D rep of the pixels that we can traverse
		Pixel[][] pixel2D = pic.getPixels2D();
		
		//traverse the pixels and alter their values per filter spec
		for (int r = 0; r < pixel2D.length; r++) {
			for (int c = 0; c < pixel2D[r].length; c++) {//calls by each row and column
				//get the black and white value by averaging the pixel's RGB values
				int avg = (int) pixel2D[r][c].getAverage();
				//set the average as all of the pixel's RGB values
				pixel2D[r][c].setRed(avg);
				pixel2D[r][c].setGreen(avg);
				pixel2D[r][c].setBlue(avg);	
			}
		}
	}
	//commenting complete
	public static void negative (DigitalPicture pic) {
		//1) obtain a 2D rep of the pixels that we can traverse
		Pixel[][] pixel2D = pic.getPixels2D();
			
		//traverse the pixels and alter their values per filter spec
		for (int r = 0; r < pixel2D.length; r++) {
			for (int c = 0; c < pixel2D[r].length; c++) {//calls by each row and column
				//to get the negative, just subtract the current value from the maximum of 255
				pixel2D[r][c].setRed(255-pixel2D[r][c].getRed());
				pixel2D[r][c].setGreen(255-pixel2D[r][c].getGreen());	
				pixel2D[r][c].setBlue(255-pixel2D[r][c].getBlue());		
			}
		}
	}
	//commenting complete
	public static void makeSunset (DigitalPicture pic, double rrr, double gb) {
			//1) obtain a 2D rep of the pixels that we can traverse
			Pixel[][] pixel2D = pic.getPixels2D();
			/*
			 * the two conditions are multipliers to change the image's original RGB values to turn more reddish
			 * they are double inputs, so they need to be changed when the RGB color values are set
			 */
			//traverse the pixels and alter their values per filter spec
			for (int r = 0; r < pixel2D.length; r++) {
				for (int c = 0; c < pixel2D[r].length; c++) {//calls by each row and column
					//set the new RGB values by using the multiplier
					int rr = (int) ((int) pixel2D[r][c].getRed()*rrr);
					int gg = (int) ((int) pixel2D[r][c].getGreen()*gb);
					int bb = (int) ((int) pixel2D[r][c].getBlue()*gb);
					//assign the values to the pixel
					pixel2D[r][c].setRed(rr);
					pixel2D[r][c].setGreen(gg);	
					pixel2D[r][c].setBlue(bb);		
				}
			}
	}
	//commenting complete
	public static void mirrorHorizontal (DigitalPicture pic) {
		//1) obtain a 2D rep of the pixels that we can traverse
		Pixel[][] pixel2D = pic.getPixels2D();
		int red = 0;
		int green = 0;
		int blue = 0;
		//traverse the pixels and alter their values per filter spec
		for (int r = 0; r < pixel2D.length; r++) {
			for (int c = 0; c < pixel2D[r].length/2; c++) {//calls by each row and column; the swap is folded over the c values, so it is halved
				//save the initial values of the first pixel in order to assign it to the swap pixel
				red = pixel2D[r][c].getRed();	
				green = pixel2D[r][c].getGreen();	
				blue = pixel2D[r][c].getBlue();
				//assign the swap pixel's RGB to the initial pixel
				pixel2D[r][c].setRed(pixel2D[r][pixel2D[r].length-1-c].getRed());
				pixel2D[r][c].setGreen(pixel2D[r][pixel2D[r].length-1-c].getGreen());	
				pixel2D[r][c].setBlue(pixel2D[r][pixel2D[r].length-1-c].getBlue());
				//assign the swap pixel's RGB value to the initial pixel's RGB values
				pixel2D[r][pixel2D[r].length-1-c].setRed(red);
				pixel2D[r][pixel2D[r].length-1-c].setGreen(green);	
				pixel2D[r][pixel2D[r].length-1-c].setBlue(blue);	
			}
		}
	}
	//commenting complete
	public static void mirrorVertical (DigitalPicture pic) {
		//1) obtain a 2D rep of the pixels that we can traverse
		Pixel[][] pixel2D = pic.getPixels2D();
		int red = 0;
		int green = 0;
		int blue = 0;
		//traverse the pixels and alter their values per filter spec
		for (int r = 0; r < pixel2D.length/2; r++) {//the swap is folded over the r values, so it is halved
			for (int c = 0; c < pixel2D[r].length; c++) {//calls by each row and column
				//save the initial values of the first pixel in order to assign it to the swap pixel
				red = pixel2D[r][c].getRed();	
				green = pixel2D[r][c].getGreen();	
				blue = pixel2D[r][c].getBlue();
				//assign the swap pixel's RGB to the initial pixel
				pixel2D[r][c].setRed(pixel2D[pixel2D.length -1 -r][c].getRed());
				pixel2D[r][c].setGreen(pixel2D[pixel2D.length -1 -r][c].getGreen());	
				pixel2D[r][c].setBlue(pixel2D[pixel2D.length -1 -r][c].getBlue());	
				//assign the swap pixel's RGB value to the initial pixel's RGB values
				pixel2D[pixel2D.length -1 -r][c].setRed(red);
				pixel2D[pixel2D.length -1 -r][c].setGreen(green);	
				pixel2D[pixel2D.length -1 -r][c].setBlue(blue);	
			}
		}
	}
	
	//commenting complete
	public static void blur (DigitalPicture pic) {
		//1) obtain a 2D rep of the pixels that we can traverse
		Pixel[][] pixel2D = pic.getPixels2D();
		/*this uses a 2 x 2 grid system to create the blur effect; the average of all the pixels' red values makes the red,
		 * the average of all the greens makes the green value used, and the same for the blue
		 */
		double avgRed = 0;
		double avgGreen = 0;
		double avgBlue = 0;
		//traverse the pixels and alter their values per filter spec
		for (int r = 0; r < pixel2D.length-1; r++) {
			for (int c = 0; c < pixel2D[r].length-1; c++) {//calls by each row and column
				//take the average of each of the RGB values of the four pixel grid selected by each position
				avgRed = (pixel2D[r][c].getRed() + pixel2D[r][c+1].getRed() + pixel2D[r+1][c].getRed() + pixel2D[r+1][c+1].getRed())/4;
				avgGreen = (pixel2D[r][c].getGreen() + pixel2D[r][c+1].getGreen() + pixel2D[r+1][c].getGreen() + pixel2D[r+1][c+1].getGreen())/4;
				avgBlue = (pixel2D[r][c].getBlue() + pixel2D[r][c+1].getBlue() + pixel2D[r+1][c].getBlue() + pixel2D[r+1][c+1].getBlue())/4;
				//assign the average value of each RGB to the respective values of each pixel in the 2 x 2 grid
				pixel2D[r][c].setRed((int) avgRed);//upperLeft
				pixel2D[r][c].setGreen((int) avgGreen);	
				pixel2D[r][c].setBlue((int) avgBlue);	
				pixel2D[r+1][c].setRed((int) avgRed);//upperRight	
				pixel2D[r+1][c].setGreen((int) avgGreen);	
				pixel2D[r+1][c].setBlue((int) avgBlue);
				pixel2D[r+1][c+1].setRed((int) avgRed);//bottomRight
				pixel2D[r+1][c+1].setGreen((int) avgGreen);	
				pixel2D[r+1][c+1].setBlue((int) avgBlue);	
				pixel2D[r][c+1].setRed((int) avgRed);//bottomLeft
				pixel2D[r][c+1].setGreen((int) avgGreen);	
				pixel2D[r][c+1].setBlue((int) avgBlue);	
				
			}
		}
	}

	


}
