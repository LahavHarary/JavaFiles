import java.io.IOException;
import java.nio.file.*;


public class FileSender {

    private String _destination;
    private String _fileSrc;

    public FileSender(String fileSrc){
        _fileSrc = fileSrc;
    }

    public void send(String fileName , String extension){

        Path pathSrc = Paths.get(_fileSrc + "\\" +fileName);
        setDestinationPath(extension);
        _destination += fileName;
        Path dest = Paths.get(_destination);

        // SEND

        try {
            Files.move(pathSrc,dest,StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void setDestinationPath(String extension){ //Get folder
        _destination = "C:\\Users\\lahav\\OneDrive\\Desktop\\Development\\Java files project" +"\\" +extension +"\\";
    }



}
