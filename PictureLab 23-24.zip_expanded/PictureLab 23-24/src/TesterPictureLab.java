

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

public class TesterPictureLab {

	/**
	 * Check to see if the blue value of each pixel in an image has been set to 0
	 */
	@Test
	void testZeroBlue() {
		
		/* Create two identical Picture objects from the same picture */
		Picture p = new Picture("bees.PNG");
		Picture p2 = new Picture("bees.PNG");
		
		/* apply the zeroBlue filter */
		Logic.zeroBlue(p);
  		
		/* obtain the 2D Pixel array representation for both objects */
		Pixel[][] pixels = p.getPixels2D();		//student code	

		
		//the blue value of the pixels should be 0
		assertTrue(pixels[0][0].getBlue()==0);
		assertTrue(pixels[pixels.length/2][0].getBlue()==0);
		assertTrue(pixels[pixels.length-1][0].getBlue()==0);

		//the other channels should not be changed
		assertTrue(pixels[0][0].getRed()!=0);
		assertTrue(pixels[pixels.length/2][0].getRed()!=0);
		assertTrue(pixels[pixels.length-1][0].getRed()!=0);
		
		//the other channels should not be changed
		assertTrue(pixels[0][0].getGreen()!=0);
		assertTrue(pixels[pixels.length/2][0].getGreen()!=0);
		assertTrue(pixels[pixels.length-1][0].getGreen()!=0);
		
	}
	
//	/*
//	 * Checks to see if BW is applied to image by taking the average of all the pixels colors (red, green, blue) 
//	 * and see it that to be the value of each color channel
//	 */
//	@Test
//	void testBW(){
//		
//		//Create two Picture image objects using the same image file
//		Picture p = new Picture("bees.PNG");
// 		
//		//Apply the student code and solution code
//		Logic.blackAndWhite(p);
//		
// 		
//		//obtain the 2D Pixel array representation for both objects
//		Pixel[][] pixels = p.getPixels2D();
//		
//		
//		//The red value of pixel should be the same as the average if BW has been applied properly
//		assertTrue(pixels[0][0].getRed() == pixels[0][0].getAverage());
//		
//		//The red value of pixel should be the same as the average if BW has been applied properly
//		assertTrue(pixels[pixels.length/2][0].getRed() == pixels[pixels.length/2][0].getAverage());
//		
//		//The red value of pixel should be the same as the average if BW has been applied properly
//		assertTrue(pixels[pixels.length-1][0].getRed() == pixels[pixels.length-1][0].getAverage());

//	}
	
//	/* 
//	 * Check to see if student code creates a negative of the original image
//	 */
//	@Test
//	void testNegative(){
//		
//		//Create two Picture image objects using the same image file
//		Picture p = new Picture("bees.PNG");
// 		
//		//Apply the student code and solution code
//		Logic.negative(p);
//  		
//		//obtain the 2D Pixel array representation for both objects
//		Pixel[][] pixels = p.getPixels2D();
// 		
//
//		//check value values of a couple of pixels - check red
//		assertTrue(pixels[0][0].getRed()==59);
//		assertTrue(pixels[pixels.length/2][0].getRed()==98);
//		assertTrue(pixels[pixels.length-1][0].getRed()==110);
//		
//		//check green
//		assertTrue(pixels[0][0].getGreen()==123);
//		assertTrue(pixels[pixels.length/2][0].getGreen()==132);
//		assertTrue(pixels[pixels.length-1][0].getGreen()==114);
//		
//		
//		//check blue
//		assertTrue(pixels[0][0].getBlue()==58);
//		assertTrue(pixels[pixels.length/2][0].getBlue()==91);
//		assertTrue(pixels[pixels.length-1][0].getBlue()==199);
//		
//		
//	}
	
//	/*
//	 * See canvas for more details on applying sunset tone to a picture
//	 */
//	@Test
//	void testSunset(){
//		//Create two Picture image objects using the same image file
//		Picture p = new Picture("bees.PNG");
// 		
//		//Apply the student code and solution code
//		Logic.makeSunset(p, 1.5, .9 );
//  		
//		//obtain the 2D Pixel array representation for both objects
//		Pixel[][] pixels = p.getPixels2D();
// 
//		//check value values of a couple of pixels - check red
//		assertTrue(pixels[0][0].getRed()==255);
//		assertTrue(pixels[pixels.length/2][0].getRed()==235);
//		assertTrue(pixels[pixels.length-1][0].getRed()==217);
//		
//		//check green
//		assertTrue(pixels[0][0].getGreen()==118);
//		assertTrue(pixels[pixels.length/2][0].getGreen()==110);
//		assertTrue(pixels[pixels.length-1][0].getGreen()==126);
//		
//		
//		//check blue
//		assertTrue(pixels[0][0].getBlue()==177);
//		assertTrue(pixels[pixels.length/2][0].getBlue()==147);
//		assertTrue(pixels[pixels.length-1][0].getBlue()==50);
//		
//		
//	}
	

//	/*
//	 * Checks to see if the image was flipped horizontally
//	 */
//	@Test
//	void testFlipHor(){
//		//	  |  __ \              | |
//		//	  | |__) |___  __ _  __| |
//		//	  |  _  // _ \/ _` |/ _` |
//		//	  | | \ \  __/ (_| | (_| |
//		//	  |_|  \_\___|\__,_|\__,_|
//		//	                          
//		//	  The method name should be mirrorHorizontal and will Flip the image Horizontally or from left to right.
//	 
//	
//		//Create two Picture image objects using the same image file
//		Picture p = new Picture("bees.PNG");
// 		
//		//Apply the student code and solution code
//		Logic.mirrorHorizontal(p);
//  		
//		Pixel[][] pixels = p.getPixels2D();
//		
//		//check value values of a couple of pixels - check red
//		assertTrue(pixels[0][0].getRed()==101);
//		assertTrue(pixels[pixels.length/2][0].getRed()==100);
//		assertTrue(pixels[pixels.length-1][0].getRed()==164);
//		
//		//check green
//		assertTrue(pixels[0][0].getGreen()==85);
//		assertTrue(pixels[pixels.length/2][0].getGreen()==75);
//		assertTrue(pixels[pixels.length-1][0].getGreen()==110);
//		
//		
//		//check blue
//		assertTrue(pixels[0][0].getBlue()==109);
//		assertTrue(pixels[pixels.length/2][0].getBlue()==150);
//		assertTrue(pixels[pixels.length-1][0].getBlue()==207);
//		
//		
//		
//	}
	
//	/*
//	 * Checks to see if the image was flipped vertically
//	 */
//	@Test
//	void testFlipVer(){
//	
//		//	  _____                _ 
//		//	  |  __ \              | |
//		//	  | |__) |___  __ _  __| |
//		//	  |  _  // _ \/ _` |/ _` |
//		//	  | | \ \  __/ (_| | (_| |
//		//	  |_|  \_\___|\__,_|\__,_|
//		//	                          
//		//	  The method name should be mirrorVertical and will Flip the image Vertically (from top to bottom).
//	                          
//		//Create two Picture image objects using the same image file
//		Picture p = new Picture("bees.PNG");
// 		
//		//Apply the student code and solution code
//		Logic.mirrorVertical(p);
//  		
//		Pixel[][] pixels = p.getPixels2D();
//		
//		
//		//check value values of a couple of pixels - check red
//		System.out.println(pixels[pixels.length-1][0]);
// 		assertTrue(pixels[0][0].getRed()==145);
//		assertTrue(pixels[pixels.length/2][0].getRed()==157);
//		assertTrue(pixels[pixels.length-1][0].getRed()==196);
//		
//		//check green
//		assertTrue(pixels[0][0].getGreen()==141);
//		assertTrue(pixels[pixels.length/2][0].getGreen()==123);
//		assertTrue(pixels[pixels.length-1][0].getGreen()==132);
//		
//		
//		//check blue
//		assertTrue(pixels[0][0].getBlue()==56);
//		assertTrue(pixels[pixels.length/2][0].getBlue()==164);
//		assertTrue(pixels[pixels.length-1][0].getBlue()==197);
//		
//	}
	
//	/*
//	 * Tests to see if blurring works for a 2x2 rectangular window.
//	 */
//	@Test
//	void testBlur(){
//		//Create two Picture image objects using the same image file
//		Picture p = new Picture("bees.PNG");
//		Picture p2 = new Picture("bees.PNG");
//		
//		//Apply the student code and solution code
//		Logic.blur(p);
// 		
//		//obtain the 2D Pixel array representation for both objects
//		Pixel[][] pixels = p.getPixels2D();
//		Pixel[][] pixels2 = p2.getPixels2D();
//
//		//last row of pixels should be skipped to prevent out of bound issues and
//		//algorithm does not account for it
//		assertEquals( pixels[pixels.length-1][0].getRed(), pixels2[pixels.length-1][0].getRed() );
//
//		//last column is also skipped
//		assertEquals( pixels[0][pixels[0].length-1].getRed(), pixels2[0][pixels[0].length-1].getRed() );
//
//		
//		//first pixel (top-left corner) red value should be the average of the four pixels
//		//the first 2x2 red values are: 196, 195, 194, 193
//		assertEquals(pixels[0][0].getRed(), 194);
//		 
//		//check blue just in case for pixel at [0][0]
//		assertEquals(pixels[0][0].getBlue(), 195);
//		
//		
//		//check middle pixel
//		assertEquals(pixels[pixels.length/2][pixels[0].length/2].getRed(), 63);
//		assertEquals(pixels[pixels.length/2][pixels[0].length/2].getBlue(), 78);
//		assertEquals(pixels[pixels.length/2][pixels[0].length/2].getGreen(), 33);
//		
//	}
	
	
	
	
	/** 
	 * Helper method to check that the red, green, and blue channel values of two pixels are the same
	 * @param a, the first Pixel object to check
	 * @param b, the second Pixel object to check
	 * @return true if two Pixel objects' red, green, and blue values are the same
	 */
	public boolean compPixelColors(Pixel a, Pixel b) {
		return a.getBlue()!=b.getBlue() 
				&& a.getRed()!=b.getRed() 
					&& a.getGreen()!=b.getGreen();
	}

}
