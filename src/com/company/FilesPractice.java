package com.company;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import org.apache.poi.*;

public class FilesPractice {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        ConfigObject config = ConfigParsingUtils.getConfig();
        IFileSender fileSender = new FileSender(config.get_listeningPath(), config.get_destPath());
        IFilesExtractor filesExtractor = new FilesExtractor(config.get_listeningPath());
        IImageFilter imageFilter = new ImageFilter(config.get_listeningPath());
        IReporter reporter = new WordReporter();

        FlowManager flowManager = new FlowManager(fileSender, filesExtractor,
                config.get_sleepTime(),imageFilter, config.get_color(),reporter);


        flowManager.start();
        int stop = input.nextInt();
        flowManager.stop();

    }

    /*  Notes:

          ConfigObject:
          {
                An object that has listeningPath and destPath.
                private String _listeningPath;
                private String _destPath;

          }

          ConfigParsingUtils:
          {
            Utility class that has

            getConfig() // calls a method named "readJSON"

            inputStreamToString(InputStream is)

            serialize()

            writeJSON(ConfigObject confingObject) // writes a JSON file

            ConfigObject readJSON() // reads a JSON file.
          }

          IFileSender:
          {
            an Interface that has:

                public void send(String fileName , String extension);
          }

          FileSender
          {

                public void send(String fileName , String extension){

                    private void setDestinationPath(String extension){ //Get folder

          }

           IFilesExtractor:
           {
            an Interface that has:

                public String[] returnFiles();

           }

           FilesExtractor:
           {
               public String[] returnFiles()
           }





     */


}

