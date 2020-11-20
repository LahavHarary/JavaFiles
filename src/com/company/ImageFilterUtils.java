package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFilterUtils {

    /**
     * Clone an array into a new one. This is done because if you do
     * Color[][] tmp = orig;
     * and then edit tmp, the edits persist in orig as well. Thus, need to go
     * value by value to get a true clone of an array.
     *
     * NOTE: this is a static method, not an instance method.
     *
     * @param orig the array to copy from.
     * @return the new array that was copied.
     */
    public static Color[][] cloneArray(Color[][] orig) {
        // Create array that is the copy
        Color[][] copy = new Color[orig.length][orig[0].length];
        // Go through each value copying it over.
        for (int i = 0; i < orig.length; i++) {
            for (int j = 0; j < orig[i].length; j++) {
                copy[i][j] = orig[i][j];
            }

        }
        // Return the copy.
        return copy;
    }

    /**
     * Loads in a 2D Color array (an image) from the specified filepath.
     * @param filepath to the image.
     * @return the 2D Color array.
     */
     public static Color[][] loadImage(String filepath) {
        // Load in the image.
        BufferedImage buffImg = loadBufferedImage(filepath);
        // Convert that image to the 2D array of colors and return it.
        Color[][] colorImg = convertTo2DFromBuffered(buffImg);
        return colorImg;
    }

    /**
     * Loads in a BufferedImage from the specified path to be processed.
     * @param filepath The path to the file to read.
     * @return a BufferedImage if able to be read, NULL otherwise.
     */
    private static BufferedImage loadBufferedImage(String filepath) {
        // A BufferedImage initialization.
        BufferedImage img = null;

        // Try to read an image from the specified path.
        try {
            // Read the (image) File the path directs to.
            img = ImageIO.read(new File(filepath));
        } catch (IOException e) {
            System.out.println("Could not load the image, please ensure the filepath"
                    + " was properly specified.");
            e.printStackTrace();
            System.exit(1);
        }

        // Return the BufferedImage. If nothing was read, img contains NULL.
        return img;
    }

    /**
     * Converts a 2D array of Colors into a BufferedImage to display
     * @param img the 2d array of Colors
     * @return the BufferedImage capable of being displayed
     */
    private static BufferedImage convertToBufferedFrom2D(Color[][] img) {
        // Create new BufferedImage of specified width and height
        int width = img.length;
        int height = img[0].length;
        BufferedImage bufImg = new BufferedImage(width, height, 1);

        // Set the RGB value of each pixel in the BufferedImage
        for (int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                bufImg.setRGB(x,  y, img[x][y].getRGB());
            }
        }

        // Return the BufferedImage
        return bufImg;
    }

    /**
     * Converts a BufferedImage to a multidem array of Colors
     * @param img the BufferedImage to convert
     * @return the 2d array of Colors
     */
    private static Color[][] convertTo2DFromBuffered(BufferedImage img) {
        // Get width and height to make new 2d array
        int width = img.getWidth();
        int height = img.getHeight();
        Color[][] result = new Color[width][height];

        // Iterate through the array, adding new Colors from the intRGB values.
        for (int row = 0; row < width; row++) {
            for (int col = 0; col < height; col++) {
                // Get the integer RGB, and separate it into individual components.
                // (BufferedImage saves RGB as a single integer value).
                int intRGB = img.getRGB(row, col);
                int red = (intRGB >> 16)&255;
                int green = (intRGB >> 8)&255;
                int blue = intRGB&255;
                // Set the pixel to the Color.
                result[row][col] = new Color(red, green, blue);
            }
        }

        // Return array
        return result;
    }

    /**
     * Takes a 2d array and converts it to Buffered image
     * Creates a "new file" on the old file
     *
     * **/
    public static void writeImage(String path , Color[][] colorMatrix, String extension) {

        BufferedImage image = convertToBufferedFrom2D(colorMatrix);

        File ImageFile = new File(path);

        try {
            ImageIO.write(image, extension, ImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
