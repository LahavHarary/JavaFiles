public class ExtensionGetter {


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



}
