package com.company;

import java.awt.*;

public class ImageFilter implements IImageFilter {

    private String _listeningPath;

    public ImageFilter(String listeningPath) {
        _listeningPath = listeningPath;
    }

    //	Method to make image grayscale

    public static Color[][] processGrayscale(Color[][] img) {
//	Clone matrix to not replace original
        Color[][] tmp = ImageFilterUtils.cloneArray(img);

//	Runs through entire matrix
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {


//					fetches values of each pixel
                Color pixel = tmp[i][j];
                int r = pixel.getRed();
                int g = pixel.getGreen();
                int b = pixel.getBlue();

//					takes average of color values
                int grayNum = (r + g + b) / 3;
//					outputs average into picture to make grayscale
                tmp[i][j] = new Color(grayNum, grayNum, grayNum);


            }
        }
        return tmp;
    }

    public static Color[][] processRed(Color[][] img) {
//	Clone matrix to not replace original
        Color[][] tmp = ImageFilterUtils.cloneArray(img);

//	Runs through entire matrix
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {


//					fetches values of each pixel
                Color pixel = tmp[i][j];
                int r = pixel.getRed();
                int g = pixel.getGreen();
                int b = pixel.getBlue();

//					adds 50 to red value
                int rNew = r + 50;

//					if rNew > 255, make 255

                if (rNew > 255) {
                    rNew = 255;
                }
                tmp[i][j] = new Color(rNew, g, b);


            }
        }
        return tmp;
    }

    public static Color[][] processGreen(Color[][] img) {
//Clone matrix to not replace original
        Color[][] tmp = ImageFilterUtils.cloneArray(img);

//Runs through entire matrix
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {


//				fetches values of each pixel
                Color pixel = tmp[i][j];
                int r = pixel.getRed();
                int g = pixel.getGreen();
                int b = pixel.getBlue();

//				adds 50 to green value
                int gNew = g + 50;

//				if gNew > 255, make 255

                if (gNew > 255) {
                    gNew = 255;
                }
                tmp[i][j] = new Color(r, gNew, b);


            }
        }
        return tmp;
    }

    public static Color[][] processBlue(Color[][] img) {
//Clone matrix to not replace original
        Color[][] tmp = ImageFilterUtils.cloneArray(img);

//Runs through entire matrix
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {


//				fetches values of each pixel
                Color pixel = tmp[i][j];
                int r = pixel.getRed();
                int g = pixel.getGreen();
                int b = pixel.getBlue();

//				adds 50 to blue value
                int bNew = g + 50;

//				if bNew > 255, make 255

                if (bNew > 255) {
                    bNew = 255;
                }
                tmp[i][j] = new Color(r, g, bNew);


            }
        }
        return tmp;
    }

    @Override
    public void filterImage(String filePath, String filterColor) {

        String extension = ExtensionUtils.getFileExtension(filePath);
        extension = ExtensionUtils.setExtensionProperly(extension);
        Color[][] colorMatrix = ImageFilterUtils.loadImage(_listeningPath + "\\" + filePath);

        Colors color = Colors.valueOf(filterColor);

        switch (color) {

            case red:
                colorMatrix = processRed(colorMatrix);
            break;

            case blue:
                colorMatrix = processBlue(colorMatrix);
            break;

            case green:
                colorMatrix = processGreen(colorMatrix);
            break;

            case gray:
                colorMatrix = processGrayscale(colorMatrix);
            break;

            default:

                break;

        }


        // Save the new picture on the old path (REPLACE)
        ImageFilterUtils.writeImage(_listeningPath + "\\" + filePath, colorMatrix, extension);

    }
}
