import java.io.*;
import java.nio.file.*;

public class Functions {

    public void moveImg(String name){

        Path src = Paths.get("C:\\Users\\lahav\\OneDrive\\Desktop\\source\\" + name);
        Path dst = Paths.get("C:\\Users\\lahav\\OneDrive\\Desktop\\imgOnly\\" + name);

        try {
            Path temp = Files.move(src,dst,StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void moveNotImg(String name){

        Path src = Paths.get("C:\\Users\\lahav\\OneDrive\\Desktop\\source\\" + name);
        Path dst = Paths.get("C:\\Users\\lahav\\OneDrive\\Desktop\\else\\" + name);

        try {
            Path temp = Files.move(src,dst,StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public boolean checkIfImg(String name)
    {

        //Algo part - Making a substring from original string

       int len = name.length();
       int startOfNewString = 0;
        String newStr;
       for(int i=0;i<len;i++)
       {
           if(name.charAt(i) == '.')
           {
               startOfNewString = i;
               i = len;
           }
       }
       newStr = name.substring(startOfNewString+1);

        //After the making of the String we are checking if the substring is .png

       if(newStr.equals("PNG") || newStr.equals("png"))
       {
           return true;
       }


       return false;

    }

}
