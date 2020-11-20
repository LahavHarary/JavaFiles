package com.company;

import java.io.IOException;
import java.nio.file.*;


public class FileSender implements IFileSender{

    private String _destination;
    private String _fileSrc;
    private String _rootDestPath;

    public FileSender(String fileSrc,String rootDestPath){
        _fileSrc = fileSrc;
        _rootDestPath = rootDestPath;
    }

    @Override
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

        _destination = _rootDestPath + "\\" +extension +"\\";
    }



}
