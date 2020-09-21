import java.io.*;
import java.nio.file.*;


public class fForFiles {

    public static void main (String[]args)
    {

        // Make a string array called path names that will contain the names of every file inside my folder.
        String[] pathNames;
        // Create a file variable that will "point" into source Folder.
        File f = new File("C:\\Users\\lahav\\OneDrive\\Desktop\\source");
        // connecting f Strings to pathNames.
        pathNames = f.list();
        //Getting the amount of files saving in inside a variable
        int amountOfFiles = pathNames.length;
        // Flag variable = 1 means that it is an img ELSE it means it is not an img!
        boolean flag = false;
        Functions helper = new Functions();

        for (int i = 0; i<amountOfFiles; i++)
        {
            flag = helper.checkIfImg(pathNames[i]);

            if(flag == true)
            {
                helper.moveImg(pathNames[i]);
            }
            else
            {
                helper.moveNotImg(pathNames[i]);
            }
        }



    }
}
