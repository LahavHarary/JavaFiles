package com.company;

public class ExtensionUtils {

    public static String getFileExtension(String fileName)
    {
        String fileExtension;
        fileExtension = null;

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            fileExtension = fileName.substring(i+1);
        }

        return fileExtension;
    }

    public static String setExtensionProperly(String fileExtension)
    {

        if(fileExtension.charAt(0) == '.')
        {
            fileExtension = fileExtension.substring(1);
        }

        return fileExtension;
    }

    public static boolean isImg(String fileExtension)
    {
        if(fileExtension.equalsIgnoreCase("png") || fileExtension.equalsIgnoreCase(".png")
        || fileExtension.equalsIgnoreCase("jpg") || fileExtension.equalsIgnoreCase(".jpg"))
        {
            return true;
        }

        return false;
    }


}
